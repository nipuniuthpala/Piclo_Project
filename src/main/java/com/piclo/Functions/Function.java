package com.piclo.Functions;

import com.piclo.models.Frontend;
import com.piclo.utils.DriverUtils;

import java.util.*;

public class Function {
    public static boolean sortCompetition() {

        List<Frontend> sorted_com_ids = DriverUtils.getCompetitionColumnValuesAfterSort();
        List<String> com_id= new ArrayList<String>();
        int i;
        for (i = 0; i < sorted_com_ids.size(); i++) {
            com_id.add(sorted_com_ids.get(i).getCompetition_id());}
        System.out.println("Actual:"+com_id);


        List<String> comp_id_sorted= new ArrayList<String>();
        Collections.sort(comp_id_sorted);
        int j;
        for (j = 0; j < com_id.size(); j++) {
            comp_id_sorted.add(com_id.get(j));
        }
        System.out.println("Expected:"+comp_id_sorted);
        boolean is_Sorted=true;
        for (int k = 0; k < comp_id_sorted.size(); k++) {
            if(!comp_id_sorted.get(k).equals(com_id.get(k))){
                is_Sorted=false;
                break;
            }

        }
        return is_Sorted;

    }

    public static boolean sortBids() {

        List<Frontend> sorted_bid_ids = DriverUtils.getBidCountColumnValuesAfterSort();
        List<String> bid_id = new ArrayList<String>();
        int i;
        for (i = 0; i < sorted_bid_ids.size(); i++) {
            bid_id.add(sorted_bid_ids.get(i).getBidCount());
        }
        System.out.println("Actual:"+bid_id);


        List<String> bid_id_sorted = new ArrayList<String>();
        int j;
        for (j = 0; j < bid_id.size(); j++) {
            bid_id_sorted.add(bid_id.get(j));
        }

        Collections.sort(bid_id_sorted);
        System.out.println("Expected:"+bid_id_sorted);
        boolean is_Sorted=true;
        for (int k = 0; k < bid_id_sorted.size(); k++) {
            if(!bid_id_sorted.get(k).equals(bid_id.get(k))){
                is_Sorted=false;
                break;
            }

        }
        return is_Sorted;
    }


    public static boolean sortBuyer() {

        List<Frontend> sorted_buyer = DriverUtils.getBuyerColumnValuesAfterSort();
        List<String> buyer = new ArrayList<String>();
        int i;
        for (i = 0; i < sorted_buyer.size(); i++) {
            buyer.add(sorted_buyer.get(i).getBuyer());
        }
        System.out.println("Actual:"+buyer);


        List<String> buyer_sorted = new ArrayList<String>();
        int j;
        for (j = 0; j < buyer.size(); j++) {
            buyer_sorted.add(buyer.get(j));
        }
        Collections.sort(buyer_sorted);
        System.out.println("Expected:"+buyer_sorted);
        boolean is_Sorted=true;
        for (int k = 0; k < buyer_sorted.size(); k++) {
          if(!buyer_sorted.get(k).equals(buyer.get(k))){
                is_Sorted=false;
                break;
            }

        }
        return is_Sorted;

    }

    public static boolean sortSeller() {

        List<Frontend> sorted_seller = DriverUtils.getSellersColumnValuesAfterSort();
        List<String> seller = new ArrayList<String>();
        int i;
        for (i = 0; i < sorted_seller.size(); i++) {
            seller.add(sorted_seller.get(i).getSeller());
        }
        System.out.println("Actual:"+seller);

        List<String> seller_sorted = new ArrayList<String>();

        int j;
        for (j = 0; j < seller.size(); j++) {
            seller_sorted.add(seller.get(j));
        }
        Collections.sort(seller_sorted);
        System.out.println("Expected:"+seller_sorted);

        boolean is_Sorted=true;
        for (int k = 0; k < seller_sorted.size(); k++) {
            if(!seller_sorted.get(k).equals(seller.get(k))){
                is_Sorted=false;
                break;
            }

        }
        return is_Sorted;
    }
}


