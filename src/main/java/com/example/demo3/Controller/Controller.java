package com.example.demo3.Controller;
import com.example.demo3.Data.*;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.AcceptMaxBid.AcceptMaxBidRandom;
import com.example.demo3.TestAPI.ContactUs.ContactUsRandom;
import com.example.demo3.TestAPI.CreateAuction.CreateAuctionRandom;
import com.example.demo3.TestAPI.CreateBid.CreateBidRandom;
import com.example.demo3.TestAPI.CreateComment.CreateCommentRandom;
import com.example.demo3.TestAPI.CreateItem.CreateItemRandom;
import com.example.demo3.TestAPI.DeleteComment.deleteCommentAll;
import com.example.demo3.TestAPI.AcceptMaxBid.AcceptMaxBidAll;
import com.example.demo3.TestAPI.ContactUs.ContactUsAll;
import com.example.demo3.TestAPI.CreateAuction.CreateAuctionAll;
import com.example.demo3.TestAPI.CreateBid.CreateBidAll;
import com.example.demo3.TestAPI.CreateComment.CreateCommentAll;
import com.example.demo3.TestAPI.CreateItem.CreateItemAll;
import com.example.demo3.TestAPI.EditAccount.EditAccount;
import com.example.demo3.TestAPI.EditAccount.EditAccountRandom;
import com.example.demo3.TestAPI.EditAuction.EditAuction;
import com.example.demo3.TestAPI.EditAuction.EditAuctionAtIndex;
import com.example.demo3.TestAPI.GetDetailAuction.GetDetailAuction;
import com.example.demo3.TestAPI.GetDetailAuction.GetDetailAuctionAtIndex;
import com.example.demo3.TestAPI.GetListAuction.GetListAuctions;
import com.example.demo3.TestAPI.GetListAuctionByStatus.GetListAuctionsByStatus;
import com.example.demo3.TestAPI.GetListAuctionByStatus.GetListAuctionsByStatusAtIndex;
import com.example.demo3.TestAPI.GetListAuctionByType.GetListAuctionsByType;
import com.example.demo3.TestAPI.GetListAuctionByType.GetListAuctionsByTypeAtIndex;
import com.example.demo3.TestAPI.GetListAuctionByUser.GetListAuctionsByUser;
import com.example.demo3.TestAPI.GetListAuctionByUser.GetListAuctionsByUserAtIndex;
import com.example.demo3.TestAPI.GetListBid.GetListBids;
import com.example.demo3.TestAPI.GetListBid.GetListBidsAtIndex;
import com.example.demo3.TestAPI.GetListBrands.GetListBrands;
import com.example.demo3.TestAPI.GetListBrands.GetListBrandsAtIndex;
import com.example.demo3.TestAPI.GetListCategories.GetListCategories;
import com.example.demo3.TestAPI.GetListCategories.GetListCategoriesAtIndex;
import com.example.demo3.TestAPI.GetListComment.GetListComment;
import com.example.demo3.TestAPI.GetListComment.GetListCommentAtIndex;
import com.example.demo3.TestAPI.LikeAuction.LikeAuctionAll;
import com.example.demo3.TestAPI.LikeAuction.LikeAuctionRandom;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import com.example.demo3.TestAPI.LoginTest.LoginTestRandom;
import com.example.demo3.TestAPI.ReadNews.readNewsAll;
import com.example.demo3.TestAPI.ReadNews.readNewsRandom;
import com.example.demo3.TestAPI.GetListLike.getListLikes;
import com.example.demo3.TestAPI.GetNews.getNews;
import com.example.demo3.TestAPI.GetNotification.getNotifications;
import com.example.demo3.TestAPI.GetTotalLikeOfAuction.getTotalLikesOfAuction;
import com.example.demo3.TestAPI.LogoutTest.LogoutTest;
import com.example.demo3.TestAPI.ReadNotification.readNotifications;
import com.example.demo3.TestAPI.Search.Search;
import com.example.demo3.TestAPI.Search.SearchAtIndex;
import com.example.demo3.TestAPI.SignUp.Signup;
import com.example.demo3.TestAPI.SignUp.SignupAtIndex;
import com.example.demo3.TestAPI.Slider.Slider;
import com.example.demo3.TestAPI.GetListLike.getListLikesAtIndex;
import com.example.demo3.TestAPI.GetTotalLikeOfAuction.getTotalLikesOfAuctionAtIndex;
import com.example.demo3.TestAPI.ReadNotification.readNotificationsAtIndex;
import com.example.demo3.TestAPI.Slider.SliderAtIndex;
import com.example.demo3.TestAPI.GetNotification.getNotificationsAtIndex;
import com.example.demo3.TestAPI.GetNews.getNewsAtIndex;
import com.example.demo3.TestAPI.Slider.SliderAtIndex;
import com.example.demo3.TestAPI.SignUp.SignupAtIndex;
import com.example.demo3.TestAPI.GetListAuctionByType.GetListAuctionsByTypeAtIndex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Pair;
import org.testng.TestNG;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static int keyURL;
    public static String stringURL;
    public static int UnitTest;
    public static StringBuilder gettextoutput;
    public static int indexrandom;

    public static int pos;
    public static String[] Tempstring = new String[20];
    @FXML
    private ComboBox<Pair<Integer, String>> selectUNIT;
    @FXML
    private ComboBox<Pair<Integer, String>> listlinkURL;
    @FXML
    private Label label;
    @FXML
    private TextArea textinput;
    @FXML
    public TextArea textoutput;
    @FXML
    private Button sendAPI;
    @FXML
    private Button clsI;

    @FXML
    public void SelectLinkURL(ActionEvent ignoredE) throws IOException {
        stringURL= listlinkURL.getSelectionModel().getSelectedItem().getValue();
        keyURL = listlinkURL.getSelectionModel().getSelectedItem().getKey();
        textinput.clear();
        textinput.appendText("Link URL: " + stringURL + "\n");
        if(stringURL == constant.LOG_IN){
            LoginData.loginDataProviderMethod();
            int a = LoginData.sizeData;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[LoginData.sizeData-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.LIKE_AUCTION){
            LikeAuctionData.LikeAuctionProvider();
            int a = LikeAuctionData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[LikeAuctionData.n-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.READ_NEWS){
            ReadNewsData.ReadNewsProvider();
            int a = ReadNewsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.ACCEPT_MAX_BID){
            AcceptMaxBidData.AcceptMaxBidDataProvider();
            int a = AcceptMaxBidData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.CONTACT_US){
            ContactUsData.ContactUsDataProvider();
            int a = ContactUsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.CREATE_AUCTION){
            CreateAuctionData.CreateAuctionDataProvider();
            int a = CreateAuctionData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.CREATE_BID){
            CreateBidData.CreateBidDataProvider();
            int a = CreateBidData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.CREATE_COMMENT){
            CreateBidData.CreateBidDataProvider();
            int a = CreateBidData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.CREATE_ITEM){
            CreateItemData.CreateItemDataProvider();
            int a = CreateItemData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.DELETE_COMMENT){
            DeleteCommentsData.DeleteCommentsProvider();
            int a = DeleteCommentsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.EDIT_ACCOUNT){
            EditAccountData.EditAccountDataProvider();
            int a = EditAccountData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.EDIT_AUCTION){
            EditAuctionData.EditAuctionDataProvider();
            int a = EditAuctionData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_DETAIL_AUCTION){
            GetDetailAuctionData.GetDetailAuctionDataProvider();
            int a = GetDetailAuctionData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_DETAIL_AUCTION){
            GetDetailAuctionData.GetDetailAuctionDataProvider();
            int a = GetDetailAuctionData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_STATUS){
            GetListAuctionsByStatusData.GetListAuctionsByStatusDataProvider();
            int a = GetListAuctionsByStatusData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_TYPE){
            GetListAuctionsByTypeData.GetListAuctionsByTypeDataProvider();
            int a = GetListAuctionsByTypeData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_USER){
            GetListAuctionsByUserData.GetListAuctionsByUserDataProvider();
            int a = GetListAuctionsByUserData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS){
            GetListAuctionsData.GetListAuctionsDataProvider();
            int a = GetListAuctionsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_BIDS){
            GetListBidsData.GetListBidsDataProvider();
            int a = GetListBidsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_BRANDS){
            GetListBrandsData.GetListBrandsDataProvider();
            int a = GetListBrandsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_CATEGORIES){
            GetListCategoriesData.GetListCategoriesDataProvider();
            int a = GetListCategoriesData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_COMMENT){
            GetListCommentData.GetListCommentDataProvider();
            int a = GetListCommentData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_LIST_LIKE){
            GetListLikesData.GetListLikesProvider();
            int a = GetListLikesData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_NEWS){
            GetNewsData.GetNewsProvider();
            int a = GetNewsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_NOTIFICATIONS){
            GetNotificationsData.GetNotificationsProvider();
            int a = GetNotificationsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.LOG_OUT){
            LogoutData.logoutDataProviderMethod();
            int a = LogoutData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.READ_NEWS){
            ReadNewsData.ReadNewsProvider();
            int a = ReadNewsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.READ_NOTIFICATION){
            ReadNotificationsData.ReadNotificationsProvider();
            int a = ReadNotificationsData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.SEARCH){
            SearchData.SearchDataProvider();
            int a = SearchData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.SIGN_UP){
            SignupData.SignupDataProvider();
            int a = SignupData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.GET_SLIDER){
            SliderData.SliderDataProvider();
            int a = SliderData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
        else if(stringURL == constant.TOTAL_LIKES_OF_AUCTION){
            SliderData.SliderDataProvider();
            int a = SliderData.n;
            ObservableList<Pair<Integer, String>> menuli;
            Pair<Integer,String>[] k = new Pair[a-4];
            for(int i=0;i<a-4;i++) k[i] = new Pair<>(i+1,"UnitTest " + (i+1));
            menuli = FXCollections.observableArrayList(k);
            selectUNIT.setItems(menuli);
        }
    }
    @FXML
    public void SelectUnitest(ActionEvent ignoredE) throws IOException {
        if(stringURL == constant.LOG_IN) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) LoginData.loginDataProviderMethod();
            textinput.appendText("{\n");
            textinput.appendText("     email:" + data[UnitTest][0] + '\n');
            textinput.appendText("     password: " + data[UnitTest][1] + '\n');
            textinput.appendText("     code: " + data[UnitTest][2] + '\n');
            textinput.appendText("     message: " + data[UnitTest][3] + '\n');
            textinput.appendText("}\n");
            LoginTestRandom.testRandom(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.CONTACT_US) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) ContactUsData.ContactUsDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     name:" + data[UnitTest][0] + '\n');
            textinput.appendText("     phone: " + data[UnitTest][1] + '\n');
            textinput.appendText("     email: " + data[UnitTest][2] + '\n');
            textinput.appendText("     content: " + data[UnitTest][3] + '\n');
            textinput.appendText("     file" + data[UnitTest][4] + '\n');
            textinput.appendText("     report_type: " + data[UnitTest][5] + '\n');
            textinput.appendText("     code: " + data[UnitTest][6] + '\n');
            textinput.appendText("     message: " + data[UnitTest][7] + '\n');
            textinput.appendText("}\n");
            ContactUsRandom.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5],data[UnitTest][6],data[UnitTest][7]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_NEWS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetNewsData.GetNewsProvider();
            textinput.appendText("{\n");
            textinput.appendText("     index:" + data[UnitTest][0] + '\n');
            textinput.appendText("     count: " + data[UnitTest][1] + '\n');
            textinput.appendText("     code: " + data[UnitTest][2] + '\n');
            textinput.appendText("     message: " + data[UnitTest][3] + '\n');
            textinput.appendText("}\n");
            getNewsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.CREATE_AUCTION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) CreateAuctionData.CreateAuctionDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     logged_in:" + data[UnitTest][0] + '\n');
            textinput.appendText("     category_id: " + data[UnitTest][1] + '\n');
            textinput.appendText("     TTS: " + data[UnitTest][2] + '\n');
            textinput.appendText("     TTL: " + data[UnitTest][3] + '\n');
            textinput.appendText("     title_ni: " + data[UnitTest][4] + '\n');
            textinput.appendText("     code: " + data[UnitTest][5] + '\n');
            textinput.appendText("     message: " + data[UnitTest][6] + '\n');
            textinput.appendText("}\n");
            CreateAuctionRandom.testCreateAuction(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5],data[UnitTest][6]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.CREATE_BID) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) CreateBidData.CreateBidDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     logged_in: " + data[UnitTest][1] + '\n');
            textinput.appendText("     price: " + data[UnitTest][2] + '\n');
            textinput.appendText("     bid_last_id: " + data[UnitTest][3] + '\n');
            textinput.appendText("     code: " + data[UnitTest][4] + '\n');
            textinput.appendText("     message: " + data[UnitTest][5] + '\n');
            textinput.appendText("}\n");
//            CreateBidRandom.testAll(data[0][0],data[0][1],data[0][2],data[0][3],data[0][4],data[0][5]);
//            textoutput.appendText(gettextoutput.toString());
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {CreateBidRandom.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(stringURL == constant.CREATE_COMMENT) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) CreateCommentData.CreateCommentDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     logged_in: " + data[UnitTest][1] + '\n');
            textinput.appendText("     content: " + data[UnitTest][2] + '\n');
            textinput.appendText("     comment_last_id: " + data[UnitTest][3] + '\n');
            textinput.appendText("     code: " + data[UnitTest][4] + '\n');
            textinput.appendText("     message: " + data[UnitTest][5] + '\n');
            textinput.appendText("}\n");
            CreateCommentRandom.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.CREATE_ITEM) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) CreateItemData.CreateItemDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     logged_in: " + data[UnitTest][1] + '\n');
            textinput.appendText("     name: " + data[UnitTest][2] + '\n');
            textinput.appendText("     starting_price: " + data[UnitTest][3] + '\n');
            textinput.appendText("     brand_id: " + data[UnitTest][4] + '\n');
            textinput.appendText("     description: " + data[UnitTest][5] + '\n');
            textinput.appendText("     series: " + data[UnitTest][6] + '\n');
            textinput.appendText("     image: " + data[UnitTest][7] + '\n');
            textinput.appendText("     code: " + data[UnitTest][8] + '\n');
            textinput.appendText("     message: " + data[UnitTest][9] + '\n');
            textinput.appendText("}\n");
            CreateItemRandom.testCreateAuction(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5],data[UnitTest][6],data[UnitTest][7],data[UnitTest][8],data[UnitTest][9]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.EDIT_AUCTION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) EditAuctionData.EditAuctionDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     logged_in: " + data[UnitTest][1] + '\n');
            textinput.appendText("     category_id: " + data[UnitTest][2] + '\n');
            textinput.appendText("     TTS: " + data[UnitTest][3] + '\n');
            textinput.appendText("     TTL: " + data[UnitTest][4] + '\n');
            textinput.appendText("     title_ni: " + data[UnitTest][5] + '\n');
            textinput.appendText("     code: " + data[UnitTest][6] + '\n');
            textinput.appendText("     message: " + data[UnitTest][7] + '\n');
            textinput.appendText("}\n");
            EditAuctionAtIndex.testCreateAuction(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5],data[UnitTest][6],data[UnitTest][7]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_DETAIL_AUCTION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetDetailAuctionData.GetDetailAuctionDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            GetDetailAuctionAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_STATUS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListAuctionsByStatusData.GetListAuctionsByStatusDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     status_Id:" + data[UnitTest][0] + '\n');
            textinput.appendText("     index: " + data[UnitTest][1] + '\n');
            textinput.appendText("     count: " + data[UnitTest][2] + '\n');
            textinput.appendText("     code: " + data[UnitTest][3] + '\n');
            textinput.appendText("     message: " + data[UnitTest][4] + '\n');
            textinput.appendText("}\n");
            GetListAuctionsByStatusAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_USER) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListAuctionsByUserData.GetListAuctionsByUserDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     logged_id: " + data[UnitTest][0] + '\n');
            textinput.appendText("     index: " + data[UnitTest][1] + '\n');
            textinput.appendText("     status_Id: " + data[UnitTest][2] + '\n');
            textinput.appendText("     count: " + data[UnitTest][3] + '\n');
            textinput.appendText("     code: " + data[UnitTest][4] + '\n');
            textinput.appendText("     message: " + data[UnitTest][5] + '\n');
            textinput.appendText("}\n");
            GetListAuctionsByUserAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_BIDS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListBidsData.GetListBidsDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auctionId: " + data[UnitTest][0] + '\n');
            textinput.appendText("     index: " + data[UnitTest][1] + '\n');
            textinput.appendText("     count: " + data[UnitTest][2] + '\n');
            textinput.appendText("     code: " + data[UnitTest][3] + '\n');
            textinput.appendText("     message: " + data[UnitTest][4] + '\n');
            textinput.appendText("}\n");
            GetListBidsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_BRANDS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListBrandsData.GetListBrandsDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[UnitTest][0] + '\n');
            textinput.appendText("     message: " + data[UnitTest][1] + '\n');
            textinput.appendText("}\n");
            GetListBrandsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_CATEGORIES) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListCategoriesData.GetListCategoriesDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[UnitTest][0] + '\n');
            textinput.appendText("     message: " + data[UnitTest][1] + '\n');
            textinput.appendText("}\n");
            GetListCategoriesAtIndex.testAll(data[UnitTest][0],data[UnitTest][1]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_COMMENT) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListCommentData.GetListCommentDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_Id: " + data[UnitTest][0] + '\n');
            textinput.appendText("     index: " + data[UnitTest][1] + '\n');
            textinput.appendText("     count: " + data[UnitTest][2] + '\n');
            textinput.appendText("     code: " + data[UnitTest][3] + '\n');
            textinput.appendText("     message: " + data[UnitTest][4] + '\n');
            textinput.appendText("}\n");
            GetListCommentAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_LIST_LIKE) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetListLikesData.GetListLikesProvider();
            textinput.appendText("{\n");
            textinput.appendText("     status_ID: " + data[UnitTest][0] + '\n');
            textinput.appendText("     index: " + data[UnitTest][1] + '\n');
            textinput.appendText("     count: " + data[UnitTest][2] + '\n');
            textinput.appendText("     code: " + data[UnitTest][3] + '\n');
            textinput.appendText("     message: " + data[UnitTest][4] + '\n');
            textinput.appendText("}\n");
            getListLikesAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.GET_NOTIFICATIONS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) GetNotificationsData.GetNotificationsProvider();
            textinput.appendText("{\n");
            textinput.appendText("     index: " + data[UnitTest][0] + '\n');
            textinput.appendText("     count: " + data[UnitTest][1] + '\n');
            textinput.appendText("     code: " + data[UnitTest][2] + '\n');
            textinput.appendText("     message: " + data[UnitTest][3] + '\n');
            textinput.appendText("}\n");
            getNotificationsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.TOTAL_LIKES_OF_AUCTION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) TotalLikesOfAuctionData.TotalLikesOfAuctionProvider();
            textinput.appendText("{\n");
            textinput.appendText("     status_Id: " + data[UnitTest][0] + '\n');
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            getTotalLikesOfAuctionAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.LIKE_AUCTION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) LikeAuctionData.LikeAuctionProvider();
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            LikeAuctionRandom.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.LOG_OUT) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) LogoutData.logoutDataProviderMethod();
            textinput.appendText("{\n");
            textinput.appendText("     logged_in: " + data[UnitTest][0] + '\n');
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            LogoutTest.testLogout(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.READ_NEWS) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) ReadNewsData.ReadNewsProvider();
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            readNewsRandom.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.READ_NOTIFICATION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) ReadNewsData.ReadNewsProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auctionDenyId: " + data[UnitTest][0] + '\n');
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            readNotificationsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.ACCEPT_MAX_BID) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) AcceptMaxBidData.AcceptMaxBidDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_id: " + data[UnitTest][0] + '\n');
            textinput.appendText("     logged_in: " + data[UnitTest][1] + '\n');
            textinput.appendText("     selling_info: " + data[UnitTest][2] + '\n');
            textinput.appendText("     code: " + data[UnitTest][3] + '\n');
            textinput.appendText("     message: " + data[UnitTest][4] + '\n');
            textinput.appendText("}\n");
            AcceptMaxBidRandom.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.READ_NOTIFICATION) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) ReadNotificationsData.ReadNotificationsProvider();
            textinput.appendText("{\n");
            textinput.appendText("     auction_DenyId: " + data[UnitTest][0] + '\n');
            textinput.appendText("     code: " + data[UnitTest][1] + '\n');
            textinput.appendText("     message: " + data[UnitTest][2] + '\n');
            textinput.appendText("}\n");
            readNotificationsAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.SEARCH) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) SearchData.SearchDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     type: " + data[UnitTest][0] + '\n');
            textinput.appendText("     key: " + data[UnitTest][1] + '\n');
            textinput.appendText("     code: " + data[UnitTest][2] + '\n');
            textinput.appendText("     message: " + data[UnitTest][3] + '\n');
            textinput.appendText("}\n");
            SearchAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3]);
            textoutput.appendText(gettextoutput.toString());
        }
        else if(stringURL == constant.SIGN_UP) {
            gettextoutput = new StringBuilder();
            UnitTest = selectUNIT.getSelectionModel().getSelectedItem().getKey()-1;
            String[][] data = (String[][]) SignupData.SignupDataProvider();
            textinput.appendText("{\n");
            textinput.appendText("     email: " + data[UnitTest][0] + '\n');
            textinput.appendText("     password: " + data[UnitTest][1] + '\n');
            textinput.appendText("     re_pass: " + data[UnitTest][2] + '\n');
            textinput.appendText("     address: " + data[UnitTest][3] + '\n');
            textinput.appendText("     name: " + data[UnitTest][4] + '\n');
            textinput.appendText("     phone: " + data[UnitTest][5] + '\n');
            textinput.appendText("     avatar: " + data[UnitTest][6] + '\n');
            textinput.appendText("     code: " + data[UnitTest][7] + '\n');
            textinput.appendText("     message: " + data[UnitTest][8] + '\n');
            textinput.appendText("}\n");
            SignupAtIndex.testAll(data[UnitTest][0],data[UnitTest][1],data[UnitTest][2],data[UnitTest][3],data[UnitTest][4],data[UnitTest][5],data[UnitTest][6],data[UnitTest][7],data[UnitTest][8]);
            textoutput.appendText(gettextoutput.toString());
        }
    }
    @FXML
    void SelectAll(ActionEvent ignoredEvent) throws IOException {
        if(Objects.equals(stringURL, constant.LOG_IN)) {
            String[][] data = (String[][]) LoginData.loginDataProviderMethod();
            int n = LoginData.sizeData;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     email:" + data[i][0] + '\n');
                textinput.appendText("     password: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { LoginTestAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.LIKE_AUCTION)){
            String[][] data = (String[][]) LikeAuctionData.LikeAuctionProvider();
            int n = LikeAuctionData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     code: " + data[i][0] + '\n');
                textinput.appendText("     message: " + data[i][1] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { LikeAuctionAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.READ_NEWS)){
            String[][] data = (String[][]) ReadNewsData.ReadNewsProvider();
            int n = ReadNewsData.n;
            for(int i=0;i<n-5;i++){
                textinput.appendText("{\n");
                textinput.appendText("     code: " + data[i][0] + '\n');
                textinput.appendText("     message: " + data[i][1] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { readNewsAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.ACCEPT_MAX_BID)){
            String[][] data = (String[][]) AcceptMaxBidData.AcceptMaxBidDataProvider();
            int n = AcceptMaxBidData.n;
            for(int i=0;i<n-5;i++){
                textinput.appendText("{\n");
                textinput.appendText("     logged_in: " + data[i][1] + '\n');
                textinput.appendText("     selling_info: " + data[i][2] + '\n');
                textinput.appendText("     code: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { AcceptMaxBidAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.CONTACT_US)){
            String[][] data = (String[][]) ContactUsData.ContactUsDataProvider();
            int n = ContactUsData.n;
            for(int i=0;i<1;i++){
                textinput.appendText("{\n");
                textinput.appendText("     name: " + data[i][0] + '\n');
                textinput.appendText("     phone: " + data[i][1] + '\n');
                textinput.appendText("     email: " + data[i][2] + '\n');
                textinput.appendText("     content: " + data[i][3] + '\n');
                textinput.appendText("     file: " + data[i][4] + '\n');
                textinput.appendText("     report_type: " + data[i][5] + '\n');
                textinput.appendText("     code: " + data[i][6] + '\n');
                textinput.appendText("     message: " + data[i][7] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { ContactUsAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.CREATE_AUCTION)){
            String[][] data = (String[][]) CreateAuctionData.CreateAuctionDataProvider();
            int n = CreateAuctionData.n;
            textinput.appendText(String.valueOf(n));
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     logged_in: " + data[i][0] + '\n');
                textinput.appendText("     category_id: " + data[i][1] + '\n');
                textinput.appendText("     TTS: " + data[i][2] + '\n');
                textinput.appendText("     TTL: " + data[i][3] + '\n');
                textinput.appendText("     title_ni: " + data[i][4] + '\n');
                textinput.appendText("     code: " + data[i][5] + '\n');
                textinput.appendText("     message: " + data[i][6] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { CreateAuctionAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.CREATE_BID)){
            String[][] data = (String[][]) CreateBidData.CreateBidDataProvider();
            int n = CreateBidData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_id: " + data[i][0] + '\n');
                textinput.appendText("     logged_in: " + data[i][1] + '\n');
                textinput.appendText("     price: " + data[i][2] + '\n');
                textinput.appendText("     bid_last_id: " + data[i][3] + '\n');
                textinput.appendText("     title_ni: " + data[i][4] + '\n');
                textinput.appendText("     code: " + data[i][5] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { CreateBidAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.CREATE_COMMENT)){
            String[][] data = (String[][]) CreateCommentData.CreateCommentDataProvider();
            int n = CreateCommentData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_id: " + data[i][0] + '\n');
                textinput.appendText("     logged_in: " + data[i][1] + '\n');
                textinput.appendText("     content: " + data[i][2] + '\n');
                textinput.appendText("     comment_last_id: " + data[i][3] + '\n');
                textinput.appendText("     code: " + data[i][4] + '\n');
                textinput.appendText("     message: " + data[i][5] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { CreateCommentAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.CREATE_ITEM)){
            String[][] data = (String[][]) CreateItemData.CreateItemDataProvider();
            int n = CreateItemData.n;
            for(int i=0;i<2;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_id: " + data[i][0] + '\n');
                textinput.appendText("     logged_in: " + data[i][1] + '\n');
                textinput.appendText("     name: " + data[i][2] + '\n');
                textinput.appendText("     starting_price: " + data[i][3] + '\n');
                textinput.appendText("     brand_id: " + data[i][4] + '\n');
                textinput.appendText("     description: " + data[i][5] + '\n');
                textinput.appendText("     series: " + data[i][6] + '\n');
                textinput.appendText("     image: " + data[i][7] + '\n');
                textinput.appendText("     code: " + data[i][8] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { CreateItemAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.DELETE_COMMENT)){
            String[][] data = (String[][]) DeleteCommentsData.DeleteCommentsProvider();
            int n = DeleteCommentsData.n;
            for(int i=0;i<2;i++){
                textinput.appendText("{\n");
                textinput.appendText("     comment_Id: " + data[i][0] + '\n');
                textinput.appendText("     code: " + data[i][1] + '\n');
                textinput.appendText("     message: " + data[i][2] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] { deleteCommentAll.class });
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.EDIT_AUCTION)){
            String[][] data = (String[][]) EditAuctionData.EditAuctionDataProvider();
            int n = EditAuctionData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_id: " + data[i][0] + '\n');
                textinput.appendText("     logged_in: " + data[i][1] + '\n');
                textinput.appendText("     category_id: " + data[i][2] + '\n');
                textinput.appendText("     TTS: " + data[i][3] + '\n');
                textinput.appendText("     TTL: " + data[i][4] + '\n');
                textinput.appendText("     title_ni: " + data[i][5] + '\n');
                textinput.appendText("     code: " + data[i][6] + '\n');
                textinput.appendText("     message: " + data[i][7] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {EditAuction.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.EDIT_ACCOUNT)){
            String[][] data = (String[][]) EditAccountData.EditAccountDataProvider();
            int n = EditAccountData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     email: " + data[i][0] + '\n');
                textinput.appendText("     password: " + data[i][1] + '\n');
                textinput.appendText("     re_pass: " + data[i][2] + '\n');
                textinput.appendText("     address: " + data[i][3] + '\n');
                textinput.appendText("     name: " + data[i][4] + '\n');
                textinput.appendText("     phone: " + data[i][5] + '\n');
                textinput.appendText("     avatar: " + data[i][6] + '\n');
                textinput.appendText("     code: " + data[i][7] + '\n');
                textinput.appendText("     message: " + data[i][8] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {EditAccount.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_AUCTIONS)){
            String[][] data = (String[][]) GetListAuctionsData.GetListAuctionsDataProvider();
            int n = GetListAuctionsData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     index: " + data[i][0] + '\n');
                textinput.appendText("     count: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListAuctions.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_DETAIL_AUCTION)){
            String[][] data = (String[][]) GetDetailAuctionData.GetDetailAuctionDataProvider();
            int n = GetDetailAuctionData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_Id: " + data[i][0] + '\n');
                textinput.appendText("     code: " + data[i][1] + '\n');
                textinput.appendText("     message: " + data[i][2] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetDetailAuction.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_AUCTIONS_BY_STATUS)){
            String[][] data = (String[][]) GetListAuctionsByStatusData.GetListAuctionsByStatusDataProvider();
            int n = GetListAuctionsByStatusData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     status_Id: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     code: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListAuctionsByStatus.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_AUCTIONS_BY_TYPE)){
            String[][] data = (String[][]) GetListAuctionsByTypeData.GetListAuctionsByTypeDataProvider();
            int n = GetListAuctionsByTypeData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     type_Id: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     code: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListAuctionsByType.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_AUCTIONS_BY_USER)){
            String[][] data = (String[][]) GetListAuctionsByUserData.GetListAuctionsByUserDataProvider();
            int n = GetListAuctionsByUserData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     logged_in: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     status_id: " + data[i][3] + '\n');
                textinput.appendText("     coded: " + data[i][4] + '\n');
                textinput.appendText("     message: " + data[i][5] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListAuctionsByUser.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_BIDS)){
            String[][] data = (String[][]) GetListBidsData.GetListBidsDataProvider();
            int n = GetListBidsData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auctionId: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     coded: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListBids.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_BRANDS)){
            String[][] data = (String[][]) GetListBrandsData.GetListBrandsDataProvider();
            int n = GetListBrandsData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     coded: " + data[i][0] + '\n');
                textinput.appendText("     message: " + data[i][1] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListBrands.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_CATEGORIES)){
            String[][] data = (String[][]) GetListCategoriesData.GetListCategoriesDataProvider();
            int n = GetListCategoriesData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     coded: " + data[i][0] + '\n');
                textinput.appendText("     message: " + data[i][1] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListCategories.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_COMMENT)){
            String[][] data = (String[][]) GetListCommentData.GetListCommentDataProvider();
            int n = GetListCommentData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auctionId: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     coded: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {GetListComment.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_LIST_LIKE)){
            String[][] data = (String[][]) GetListLikesData.GetListLikesProvider();
            int n = GetListLikesData.n;
            for(int i=0;i<n-5;i++){
                textinput.appendText("{\n");
                textinput.appendText("     status_ID: " + data[i][0] + '\n');
                textinput.appendText("     index: " + data[i][1] + '\n');
                textinput.appendText("     count: " + data[i][2] + '\n');
                textinput.appendText("     code: " + data[i][3] + '\n');
                textinput.appendText("     message: " + data[i][4] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {getListLikes.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_NEWS)){
            String[][] data = (String[][]) GetNewsData.GetNewsProvider();
            int n = GetNewsData.n;
            for(int i=0;i<n-5;i++){
                textinput.appendText("{\n");
                textinput.appendText("     index: " + data[i][0] + '\n');
                textinput.appendText("     count: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {getNews.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_NOTIFICATIONS)){
            String[][] data = (String[][]) GetNotificationsData.GetNotificationsProvider();
            int n = GetNotificationsData.n;
            for(int i=0;i<n-5;i++){
                textinput.appendText("{\n");
                textinput.appendText("     index: " + data[i][0] + '\n');
                textinput.appendText("     count: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {getNotifications.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.TOTAL_LIKES_OF_AUCTION)){
            String[][] data = (String[][]) TotalLikesOfAuctionData.TotalLikesOfAuctionProvider();
            int n = TotalLikesOfAuctionData.n;
            for(int i=0;i<13;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auction_ID: " + data[i][0] + '\n');
                textinput.appendText("     code: " + data[i][1] + '\n');
                textinput.appendText("     message: " + data[i][2] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {getTotalLikesOfAuction.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.LOG_OUT)){
            String[][] data = (String[][]) LogoutData.logoutDataProviderMethod();
            int n = LogoutData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     logged_in: " + data[i][0] + '\n');
                textinput.appendText("     code: " + data[i][1] + '\n');
                textinput.appendText("     message: " + data[i][2] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {LogoutTest.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.READ_NOTIFICATION)){
            String[][] data = (String[][]) ReadNotificationsData.ReadNotificationsProvider();
            int n = ReadNotificationsData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     auctionDenyId: " + data[i][0] + '\n');
                textinput.appendText("     code: " + data[i][1] + '\n');
                textinput.appendText("     message: " + data[i][2] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {readNotifications.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.SEARCH)){
            String[][] data = (String[][]) SearchData.SearchDataProvider();
            int n = SearchData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     type: " + data[i][0] + '\n');
                textinput.appendText("     key: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {Search.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.SEARCH)){
            String[][] data = (String[][]) SearchData.SearchDataProvider();
            int n = SearchData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     type: " + data[i][0] + '\n');
                textinput.appendText("     key: " + data[i][1] + '\n');
                textinput.appendText("     code: " + data[i][2] + '\n');
                textinput.appendText("     message: " + data[i][3] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {Search.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.SIGN_UP)){
            String[][] data = (String[][]) SignupData.SignupDataProvider();
            int n = SignupData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     email: " + data[i][0] + '\n');
                textinput.appendText("     password: " + data[i][1] + '\n');
                textinput.appendText("     re_pass: " + data[i][2] + '\n');
                textinput.appendText("     address: " + data[i][3] + '\n');
                textinput.appendText("     name: " + data[i][4] + '\n');
                textinput.appendText("     phone: " + data[i][5] + '\n');
                textinput.appendText("     avatar: " + data[i][6] + '\n');
                textinput.appendText("     code: " + data[i][7] + '\n');
                textinput.appendText("     message: " + data[i][8] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {Signup.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(Objects.equals(stringURL, constant.GET_SLIDER)){
            String[][] data = (String[][]) SliderData.SliderDataProvider();
            int n = SliderData.n;
            for(int i=0;i<n-4;i++){
                textinput.appendText("{\n");
                textinput.appendText("     code: " + data[i][0] + '\n');
                textinput.appendText("     message: " + data[i][1] + '\n');
                textinput.appendText("}\n");
            }
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {Slider.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
    }
    @FXML
    void SelectRamdom(ActionEvent ignoredEvent) throws IOException {
        if(stringURL == constant.LOG_IN){
            String[][] data = (String[][]) LoginData.loginDataProviderMethod();
            int n = LoginData.sizeData;
            Random x = new Random();
            int y = x.nextInt(n) + 1;
            textinput.appendText("{\n");
            textinput.appendText("     email:" + data[y][0] + '\n');
            textinput.appendText("     password: " + data[y][1] + '\n');
            textinput.appendText("     code: " + data[y][2] + '\n');
            textinput.appendText("     message: " + data[y][3] + '\n');
            textinput.appendText("}\n");
            LoginTestRandom.testRandom(data[y][0],data[y][1],data[y][2],data[y][3]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(stringURL == constant.LIKE_AUCTION){
            String[][] data = (String[][]) LikeAuctionData.LikeAuctionProvider();
            Random x = new Random();
            int n = LikeAuctionData.n;
            int y = x.nextInt(n) + 1;
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[y][1] + '\n');
            textinput.appendText("     message: " + data[y][2] + '\n');
            textinput.appendText("}\n");
            LikeAuctionRandom.testAll(data[y][0],data[y][1],data[y][2]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(stringURL == constant.READ_NEWS){
            String[][] data = (String[][]) ReadNewsData.ReadNewsProvider();
            Random x = new Random();
            int n = ReadNewsData.n;
            int y = x.nextInt(n) + 1;
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[y][1] + '\n');
            textinput.appendText("     message: " + data[y][2] + '\n');
            textinput.appendText("}\n");
            readNewsAll.testAll(data[y][0],data[y][1],data[y][2]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(stringURL == constant.ACCEPT_MAX_BID){
            String[][] data = (String[][]) AcceptMaxBidData.AcceptMaxBidDataProvider();
            Random x = new Random();
            int n = AcceptMaxBidData.n;
            int y = x.nextInt(n-4) + 0;
            AcceptMaxBidRandom.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     logged_in: " + data[y][1] + '\n');
            textinput.appendText("     selling_info: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.CONTACT_US){
            String[][] data = (String[][]) ContactUsData.ContactUsDataProvider();
            Random x = new Random();
            int n = ContactUsData.n;
            int y = x.nextInt(n-4) + 0;
            ContactUsRandom.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5],data[y][6],data[y][7]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     name: " + data[y][0] + '\n');
            textinput.appendText("     phone: " + data[y][1] + '\n');
            textinput.appendText("     email: " + data[y][2] + '\n');
            textinput.appendText("     password: " + data[y][3] + '\n');
            textinput.appendText("     file: " + data[y][4] + '\n');
            textinput.appendText("     report_type: " + data[y][5] + '\n');
            textinput.appendText("     code: " + data[y][6] + '\n');
            textinput.appendText("     message: " + data[y][7] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.CREATE_BID){
            String[][] data = (String[][]) CreateBidData.CreateBidDataProvider();
            Random x = new Random();
            int n = CreateBidData.n;
            int y = x.nextInt(n-4) + 0;
            CreateBidRandom.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_id: " + data[y][0] + '\n');
            textinput.appendText("     logged_in: " + data[y][1] + '\n');
            textinput.appendText("     price: " + data[y][2] + '\n');
            textinput.appendText("     bid_last_id: " + data[y][3] + '\n');
            textinput.appendText("     code: " + data[y][4] + '\n');
            textinput.appendText("     message: " + data[y][5] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.CREATE_COMMENT){
            String[][] data = (String[][]) CreateCommentData.CreateCommentDataProvider();
            Random x = new Random();
            int n = CreateCommentData.n;
            int y = x.nextInt(n-4) + 0;
            CreateCommentRandom.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_id: " + data[y][0] + '\n');
            textinput.appendText("     logged_in: " + data[y][1] + '\n');
            textinput.appendText("     content: " + data[y][2] + '\n');
            textinput.appendText("     comment_last_id: " + data[y][3] + '\n');
            textinput.appendText("     code: " + data[y][4] + '\n');
            textinput.appendText("     message: " + data[y][5] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.CREATE_ITEM){
            String[][] data = (String[][]) CreateItemData.CreateItemDataProvider();
            Random x = new Random();
            int n = CreateItemData.n;
            int y = x.nextInt(n-4) + 0;
            CreateItemRandom.testCreateAuction(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5],data[y][6],data[y][7],data[y][8],data[y][9]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_id: " + data[y][0] + '\n');
            textinput.appendText("     logged_in: " + data[y][1] + '\n');
            textinput.appendText("     name: " + data[y][2] + '\n');
            textinput.appendText("     starting_price: " + data[y][3] + '\n');
            textinput.appendText("     brand_id: " + data[y][4] + '\n');
            textinput.appendText("     description: " + data[y][5] + '\n');
            textinput.appendText("     series: " + data[y][6] + '\n');
            textinput.appendText("     image: " + data[y][7] + '\n');
            textinput.appendText("     code: " + data[y][8] + '\n');
            textinput.appendText("     message: " + data[y][9] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.EDIT_ACCOUNT){
            String[][] data = (String[][]) EditAccountData.EditAccountDataProvider();
            Random x = new Random();
            int n = EditAccountData.n;
            int y = x.nextInt(n-4) + 0;
            textinput.appendText("{\n");
            textinput.appendText("     email: " + data[y][0] + '\n');
            textinput.appendText("     password: " + data[y][1] + '\n');
            textinput.appendText("     re_pass: " + data[y][2] + '\n');
            textinput.appendText("     address: " + data[y][3] + '\n');
            textinput.appendText("     name: " + data[y][4] + '\n');
            textinput.appendText("     phone: " + data[y][5] + '\n');
            textinput.appendText("     avatar: " + data[y][6] + '\n');
            textinput.appendText("     code: " + data[y][7] + '\n');
            textinput.appendText("     message: " + data[y][8] + '\n');
            textinput.appendText("}\n");
            TestNG teng = new TestNG();
            teng.setTestClasses( new Class[] {EditAccountRandom.class});
            teng.run();
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
        }
        else if(stringURL == constant.GET_DETAIL_AUCTION){
            String[][] data = (String[][]) GetDetailAuctionData.GetDetailAuctionDataProvider();
            Random x = new Random();
            int n = GetDetailAuctionData.n;
            int y = x.nextInt(n-4) + 0;
            GetDetailAuctionAtIndex.testAll(data[y][0],data[y][1],data[y][2]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auctionId: " + data[y][0] + '\n');
            textinput.appendText("     code: " + data[y][1] + '\n');
            textinput.appendText("     message: " + data[y][2] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_STATUS){
            String[][] data = (String[][]) GetListAuctionsByStatusData.GetListAuctionsByStatusDataProvider();
            Random x = new Random();
            int n = GetListAuctionsByStatusData.n;
            int y = x.nextInt(n-4) + 0;
            GetListAuctionsByStatusAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     status_Id: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_TYPE){
            String[][] data = (String[][]) GetListAuctionsByTypeData.GetListAuctionsByTypeDataProvider();
            Random x = new Random();
            int n = GetListAuctionsByTypeData.n;
            int y = x.nextInt(n-4) + 0;
            GetListAuctionsByTypeAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     type_Id: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_AUCTIONS_BY_USER){
            String[][] data = (String[][]) GetListAuctionsByUserData.GetListAuctionsByUserDataProvider();
            Random x = new Random();
            int n = GetListAuctionsByUserData.n;
            int y = x.nextInt(n-4) + 0;
            GetListAuctionsByUserAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     logged_in: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     status_id: " + data[y][3] + '\n');
            textinput.appendText("     code: " + data[y][4] + '\n');
            textinput.appendText("     message: " + data[y][5] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_BIDS){
            String[][] data = (String[][]) GetListBidsData.GetListBidsDataProvider();
            Random x = new Random();
            int n = GetListBidsData.n;
            int y = x.nextInt(n-4) + 0;
            GetListBidsAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_Id: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_BRANDS){
            String[][] data = (String[][]) GetListBrandsData.GetListBrandsDataProvider();
            Random x = new Random();
            int n = GetListBrandsData.n;
            int y = x.nextInt(n-4) + 0;
            GetListBrandsAtIndex.testAll(data[y][0],data[y][1]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[y][0] + '\n');
            textinput.appendText("     message: " + data[y][1] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_CATEGORIES){
            String[][] data = (String[][]) GetListCategoriesData.GetListCategoriesDataProvider();
            Random x = new Random();
            int n = GetListCategoriesData.n;
            int y = x.nextInt(n-4) + 0;
            TestNG teng = new TestNG();
            GetListCategoriesAtIndex.testAll(data[y][0],data[y][1]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[y][0] + '\n');
            textinput.appendText("     message: " + data[y][1] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_COMMENT){
            String[][] data = (String[][]) GetListCommentData.GetListCommentDataProvider();
            Random x = new Random();
            int n = GetListCommentData.n;
            int y = x.nextInt(n-4) + 0;
            GetListCommentAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_Id: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_LIST_LIKE){
            String[][] data = (String[][]) GetListLikesData.GetListLikesProvider();
            Random x = new Random();
            int n = GetListLikesData.n;
            int y = x.nextInt(n-4) + 0;
            getListLikesAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     status_ID: " + data[y][0] + '\n');
            textinput.appendText("     index: " + data[y][1] + '\n');
            textinput.appendText("     count: " + data[y][2] + '\n');
            textinput.appendText("     code: " + data[y][3] + '\n');
            textinput.appendText("     message: " + data[y][4] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_NEWS){
            String[][] data = (String[][]) GetNewsData.GetNewsProvider();
            Random x = new Random();
            int n = GetNewsData.n;
            int y = x.nextInt(n-4) + 0;
            getNewsAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     index: " + data[y][0] + '\n');
            textinput.appendText("     count: " + data[y][1] + '\n');
            textinput.appendText("     code: " + data[y][2] + '\n');
            textinput.appendText("     message: " + data[y][3] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_NOTIFICATIONS){
            String[][] data = (String[][]) GetNotificationsData.GetNotificationsProvider();
            Random x = new Random();
            int n = GetNotificationsData.n;
            int y = x.nextInt(n-4) + 0;
            TestNG teng = new TestNG();
            getNotificationsAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     index: " + data[y][0] + '\n');
            textinput.appendText("     count: " + data[y][1] + '\n');
            textinput.appendText("     code: " + data[y][2] + '\n');
            textinput.appendText("     message: " + data[y][3] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.TOTAL_LIKES_OF_AUCTION){
            String[][] data = (String[][]) TotalLikesOfAuctionData.TotalLikesOfAuctionProvider();
            Random x = new Random();
            int n =TotalLikesOfAuctionData.n;
            int y = x.nextInt(14) + 0;
            TestNG teng = new TestNG();
            getTotalLikesOfAuctionAtIndex.testAll(data[y][0],data[y][1],data[y][2]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     action_ID: " + data[y][0] + '\n');
            textinput.appendText("     code: " + data[y][1] + '\n');
            textinput.appendText("     message: " + data[y][2] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.READ_NOTIFICATION){
            String[][] data = (String[][]) ReadNotificationsData.ReadNotificationsProvider();
            Random x = new Random();
            int n = ReadNotificationsData.n;
            int y = x.nextInt(n-4) + 0;
            TestNG teng = new TestNG();
            readNotificationsAtIndex.testAll(data[y][0],data[y][1],data[y][2]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     auction_Id: " + data[y][0] + '\n');
            textinput.appendText("     code: " + data[y][1] + '\n');
            textinput.appendText("     message: " + data[y][2] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.SEARCH){
            String[][] data = (String[][]) SearchData.SearchDataProvider();
            Random x = new Random();
            int n = SearchData.n;
            int y = x.nextInt(n-4) + 0;
            SearchAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     type: " + data[y][0] + '\n');
            textinput.appendText("     key: " + data[y][1] + '\n');
            textinput.appendText("     code: " + data[y][2] + '\n');
            textinput.appendText("     message: " + data[y][3] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.SIGN_UP){
            String[][] data = (String[][]) SignupData.SignupDataProvider();
            Random x = new Random();
            int n = SignupData.n;
            int y = x.nextInt(n-4) + 0;
            SignupAtIndex.testAll(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5],data[y][6],data[y][7],data[y][8]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     email: " + data[y][0] + '\n');
            textinput.appendText("     password: " + data[y][1] + '\n');
            textinput.appendText("     re_pass: " + data[y][2] + '\n');
            textinput.appendText("     address: " + data[y][3] + '\n');
            textinput.appendText("     name: " + data[y][4] + '\n');
            textinput.appendText("     phone: " + data[y][5] + '\n');
            textinput.appendText("     avatar: " + data[y][6] + '\n');
            textinput.appendText("     code: " + data[y][7] + '\n');
            textinput.appendText("     message: " + data[y][8] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.GET_SLIDER){
            String[][] data = (String[][]) SliderData.SliderDataProvider();
            Random x = new Random();
            int n = SliderData.n;
            int y = x.nextInt(n-4) + 0;
            SliderAtIndex.testAll(data[y][0],data[y][1]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("     code: " + data[y][0] + '\n');
            textinput.appendText("     message: " + data[y][1] + '\n');
            textinput.appendText("}\n");
        }
        else if(stringURL == constant.CREATE_AUCTION){
            String[][] data = (String[][]) CreateAuctionData.CreateAuctionDataProvider();
            Random x = new Random();
            int n = CreateAuctionData.n;
            int y = x.nextInt(n-4);
            CreateAuctionRandom.testCreateAuction(data[y][0],data[y][1],data[y][2],data[y][3],data[y][4],data[y][5],data[y][6]);
            textoutput.appendText(gettextoutput.toString());
            gettextoutput = null;
            textinput.appendText("{\n");
            textinput.appendText("\n" + y + '\n');
            textinput.appendText("     logged_in: " + data[y][0] + '\n');
            textinput.appendText("     category_id: " + data[y][1] + '\n');
            textinput.appendText("     TTS: " + data[y][2] + '\n');
            textinput.appendText("     TTL: " + data[y][3] + '\n');
            textinput.appendText("     title_ni: " + data[y][4] + '\n');
            textinput.appendText("     code: " + data[y][5] + '\n');
            textinput.appendText("     message: " + data[y][6] + '\n');
            textinput.appendText("}\n");
        }

    }
    @FXML
    void clearInput(ActionEvent ignoredEvent){
        textinput.clear();
    }
    @FXML
    public void clearOutput(ActionEvent actionEvent) {
        textoutput.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Pair<Integer, String>> menulist = FXCollections.observableArrayList(
                new Pair<>(1, constant.LOG_IN),
                new Pair<>(2, constant.SIGN_UP),
                new Pair<>(3, constant.GET_LIST_CATEGORIES),
                new Pair<>(4, constant.GET_LIST_AUCTIONS),
                new Pair<>(5, constant.GET_LIST_BIDS),
                new Pair<>(6, constant.ACCEPT_MAX_BID),
                new Pair<>(7, constant.CONTACT_US),
                new Pair<>(8, constant.CREATE_AUCTION),
                new Pair<>(9, constant.CREATE_COMMENT),
                new Pair<>(10,constant.CREATE_ITEM),
                new Pair<>(11,constant.CREATE_BID),
                new Pair<>(12,constant.DELETE_COMMENT),
                new Pair<>(13,constant.EDIT_AUCTION),
                new Pair<>(14,constant.TOTAL_LIKES_OF_AUCTION),
                new Pair<>(15,constant.SEARCH),
                new Pair<>(16,constant.READ_NOTIFICATION),
                new Pair<>(17,constant.READ_NEWS),
                new Pair<>(18,constant.LOG_OUT),
                new Pair<>(19,constant.LIKE_AUCTION),
                new Pair<>(20,constant.GET_SLIDER),
                new Pair<>(21,constant.GET_NOTIFICATIONS),
                new Pair<>(22,constant.GET_LIST_AUCTIONS_BY_STATUS),
                new Pair<>(23,constant.GET_LIST_AUCTIONS_BY_USER),
                new Pair<>(24,constant.GET_LIST_AUCTIONS_BY_TYPE),
                new Pair<>(25,constant.GET_DETAIL_AUCTION),
                new Pair<>(26,constant.GET_LIST_COMMENT),
                new Pair<>(27,constant.GET_LIST_BRANDS),
                new Pair<>(28,constant.GET_NEWS ),
                new Pair<>(29,constant.EDIT_ACCOUNT),
                new Pair<>(30,constant.GET_LIST_LIKE));
        listlinkURL.setItems(menulist);
    }
}
