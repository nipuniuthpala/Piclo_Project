import com.piclo.Functions.Function;
import com.piclo.models.Frontend;
import com.piclo.utils.FileUtils;
import com.piclo.utils.DriverUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.util.List;



public class Pico_Test {




    @Test(description = "Load the website and validate the bid counts are accurate ", alwaysRun = true, priority = 1)
    public void validateBidCountIsAccurate() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        List<Frontend> Fe_data = DriverUtils.getTableValues();
        int i;
        for (i = 0; i < Fe_data.size(); i++) {
            String comp_id = (Fe_data.get(i).getCompetition_id());
            String buyer = (Fe_data.get(i).getBuyer());
            String seller = (Fe_data.get(i).getSeller());
            int bid = Integer.parseInt(Fe_data.get(i).getBidCount());

            //bidCount Verification
            softAssert.assertEquals(FileUtils.getValidBidList(FileUtils.getAcceptTrueBids(comp_id, seller), comp_id).size(), bid);
            System.out.println("competition: "+comp_id+","+"Buyer :"+buyer+"," +"seller :"+seller+"," +"Expected_Bid_Count:" + FileUtils.getValidBidList(FileUtils.getAcceptTrueBids(comp_id, seller), comp_id).size() + "," + "Actual_Bid_Count:" + bid);
            softAssert.assertAll();


        }

    }

    @Test(description = "Load the website and validate the seller in records are verified true", alwaysRun = true, priority = 2)
    public void validateSellerIsVerifiedInEachRow() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        List<Frontend> Fe_data = DriverUtils.getTableValues();
        int i;
        for (i = 0; i < Fe_data.size(); i++) {

            String seller = (Fe_data.get(i).getSeller());

            //seller verification
            softAssert.assertTrue(FileUtils.validSellers(seller));
            System.out.println("Seller:" + seller + "," + "Seller_status: " + FileUtils.validSellers(seller));
            softAssert.assertAll();
        }

    }


    @Test(description = "Load the website and validate the buyer shows in records are valid ", alwaysRun = true, priority = 3)
    public void validateBuyerIsValidInEachRow() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        List<Frontend> Fe_data = DriverUtils.getTableValues();
        int i;
        for (i = 0; i < Fe_data.size(); i++) {
            String comp_id = (Fe_data.get(i).getCompetition_id());
            String buyer = (Fe_data.get(i).getBuyer());

            //buyer verification
            softAssert.assertTrue(FileUtils.isBuyerValid(buyer, comp_id));
            System.out.println("Competition: "+comp_id+","+"Buyer:" + buyer + "," + "Buyer_status: " + FileUtils.isBuyerValid(buyer, comp_id));
            softAssert.assertAll();
        }
    }


        @Test(description = "Load the website and display the accurate row counts which are correct", alwaysRun = true, priority = 4)
        public void validateDisplayFullRowCount() throws ParseException {
            SoftAssert softAssert = new SoftAssert();
            List<Frontend> Fe_data = DriverUtils.getTableValues();
            int i;
            for (i = 0; i < Fe_data.size(); i++) {

                String comp_id = (Fe_data.get(i).getCompetition_id());
                String buyer = (Fe_data.get(i).getBuyer());
                String seller = (Fe_data.get(i).getSeller());
                int bid = Integer.parseInt(Fe_data.get(i).getBidCount());


                //accurate rows display
                FileUtils.DisplayFullRowsAreCorrect(comp_id,seller,buyer,bid);
                softAssert.assertAll();
            }
        }


    @Test(description = "Verify Values get sorted from Competition", alwaysRun = true, priority = 5)
    public void ValidateSortingFromCompetitions() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Function.sortCompetition());
        softAssert.assertAll();

    }


    @Test(description = "Verify Values get sorted from bid count", alwaysRun = true, priority = 6)
    public void ValidateSortingFromBids() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Function.sortBids());
        softAssert.assertAll();

        }

    @Test(description = "Verify Values get sorted from buyer", alwaysRun = true, priority = 7)
    public void ValidateSortingFromBuyer() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Function.sortBuyer());
        softAssert.assertAll();

    }

    @Test(description = "Verify Values get sorted from seller", alwaysRun = true, priority = 8)
    public void ValidateSortingFromSeller() throws ParseException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Function.sortSeller());
        softAssert.assertAll();

    }

}
