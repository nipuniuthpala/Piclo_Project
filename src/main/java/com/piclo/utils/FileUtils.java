package com.piclo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piclo.common.Constants;
import com.piclo.exceptions.CustomExceptions;
import com.piclo.models.Bids;
import com.piclo.models.Competitions;
import com.piclo.models.Sellers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    public static String readJson(String pathToFileFromResources) {
        try {
            return new String(Files.readAllBytes(Paths.get(Constants.pathToResources + pathToFileFromResources)));
        } catch (IOException e) {
            throw new CustomExceptions("Exception occurred during json read: " + e.getMessage());
        }
    }

    public static Object getObject(String response, TypeReference<?> c) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, c);
        } catch (IOException e) {
            throw new CustomExceptions("Exception occurred during object mapping: " + e.getMessage());
        }
    }

    public static Boolean validSellers(String seller) {
        List<Sellers> sellersList = (List<Sellers>) getObject(readJson("InputData/sellers.json"), new TypeReference<List<Sellers>>() {
        });
        for (int i = 0; i < sellersList.size(); i++) {
            Boolean verified = sellersList.get(i).getVerified();
            String id = sellersList.get(i).getId();
            if (verified == null || verified == false || !id.equals(seller)) {

                continue;
            } else {

                return true;
            }

        }


        return false;
    }


    public static List<Bids> getAcceptTrueBids(String competitionName, String sellerName) {
        List<Bids> bidsList = (List<Bids>) getObject(readJson("InputData/bids.json"), new TypeReference<List<Bids>>() {
        });
        List<Bids> validBids = new ArrayList<>();
        for (Bids bids : bidsList) {
            if (bids.getAccepted() == null || !bids.getAccepted()) {
                continue;
            } else if (bids.getSeller().equals(sellerName) && bids.getCompetition().equals(competitionName) && bids.getAccepted()) {
                validBids.add(bids);
            }
        }
        return validBids;
    }

    public static boolean isOfferedCapacityValid(int offerCapacity, int minimumCapacity) {
        return offerCapacity >= minimumCapacity;
    }

    public static Competitions getCompetition(String competitionId) {
        List<Competitions> competitionsList = (List<Competitions>) getObject(readJson("InputData/competitions.json"), new TypeReference<List<Competitions>>() {
        });
        Competitions expectedCompetition = null;
        for (Competitions competitions : competitionsList)
            if (competitions.getId().equals(competitionId)) {
                expectedCompetition = competitions;
                break;
            }
        return expectedCompetition;
    }

    public static List<Bids> getValidBidList(List<Bids> inputPartiallyValidBidList, String competitionId) throws ParseException {
        List<Bids> actualValidBidList = new ArrayList<>();
        Competitions competitionInfo = getCompetition(competitionId);

        for (Bids bids : inputPartiallyValidBidList) {
            boolean isOfferedCapacityValid = isOfferedCapacityValid(bids.getOfferedCapacity(), competitionInfo.getMinimum_capacity());
            boolean isDateRangeValid = DateUtils.isDateValid(bids.getCreated(), competitionInfo.getOpen(), competitionInfo.getClosed());
            if (isOfferedCapacityValid && isDateRangeValid) {
                actualValidBidList.add(bids);
            }
        }
        return actualValidBidList;
    }

    public static boolean isBuyerValid(String buyerName, String competitionId) {
        Competitions competition = getCompetition(competitionId);
        return buyerName.equals(competition.getBuyer());
    }

    public static void DisplayFullRowsAreCorrect(String competitionName, String sellerName,  String buyer,int bid) throws ParseException {

        if (((getValidBidList(getAcceptTrueBids(competitionName, sellerName), competitionName).size()) == bid) && bid != 0  && validSellers(sellerName) == true && isBuyerValid(buyer, competitionName) == true){

            System.out.println("===Accurate Rows===");
            System.out.println("competition: "+competitionName+","+"Buyer :"+buyer+"," +"seller :"+sellerName+"," +"Expected_Bid_Count:" + getValidBidList(FileUtils.getAcceptTrueBids(competitionName, sellerName), competitionName).size() + "," + "Actual_Bid_Count:" + bid);}


    }
}
