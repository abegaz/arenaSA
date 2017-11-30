package arenaClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AdPriceController {

    @FXML
    private JFXButton goBackBtn;

    @FXML
    private JFXButton updatePriceBtn;

    @FXML
    private TextField topPriceField;

    @FXML
    private TextField leftPriceField;

    @FXML
    private TextField rightPriceField;

    @FXML
    private TextField bottomPriceField;

    @FXML
    private TextField backPriceField;
    @FXML
    private TextField balPriceField;
    @FXML
    private Label errorMsg;

    @FXML
    private Label successMsg;
    Scene scene;
    Stage stage = new Stage();
    FXMLLoader loader = new FXMLLoader();
    private int top, left, right, bottom, back, balance;

    public void initialize() {
        try {
            getAdPrices();
            getMaxBal();
        }catch(Exception ex){
            showError(ex.getLocalizedMessage());
        }
    }

    private void getAdPrices() throws SQLException {
        Connection connection = DBHandler.getConnection();
        String roleNames = "SELECT * FROM arenadatabase.advertismentscheme";

        try {
            ResultSet rs = connection.createStatement().executeQuery(roleNames);
            while (rs.next()) {


                switch (rs.getInt("AdvertismentSchemeId")) {
                    case 1:
                        topPriceField.setText(rs.getString("AdPrice"));
                        top = Integer.parseInt(rs.getString("AdPrice"));
                    case 2:
                        leftPriceField.setText(rs.getString("AdPrice"));
                        left = Integer.parseInt(rs.getString("AdPrice"));
                    case 3:
                        rightPriceField.setText(rs.getString("AdPrice"));
                        right = Integer.parseInt(rs.getString("AdPrice"));
                    case 4:
                        bottomPriceField.setText(rs.getString("AdPrice"));
                        bottom = Integer.parseInt(rs.getString("AdPrice"));
                    case 5:
                        backPriceField.setText(rs.getString("AdPrice"));
                        back = Integer.parseInt(rs.getString("AdPrice"));
                }


            }

        } catch (SQLException e) {
            showError(e.getLocalizedMessage());
            System.out.println("ERROR @ AdvertController.populateRemoveImageChoiceComboBox");
        }


    }
    private void getMaxBal() throws SQLException {
        Connection connection = DBHandler.getConnection();
        String roleNames = "SELECT * FROM arenadatabase.admaxbal WHERE id = 1";

        try {
            ResultSet rs = connection.createStatement().executeQuery(roleNames);
            while (rs.next()) {


                balPriceField.setText(rs.getString("amount"));
                balance = Integer.parseInt(rs.getString("amount"));


            }

        } catch (SQLException e) {
            showError(e.getLocalizedMessage());
            System.out.println("ERROR @ AdvertController.populateRemoveImageChoiceComboBox");
        }


    }
    @FXML
    private void updatePrices(ActionEvent event) throws SQLException{
        hideMsgs();
        if(top != Integer.parseInt(topPriceField.getText()) ||
                left != Integer.parseInt(leftPriceField.getText()) ||
                        right != Integer.parseInt(rightPriceField.getText()) ||
                                bottom != Integer.parseInt(bottomPriceField.getText()) ||
                                        back != Integer.parseInt(backPriceField.getText()) ||
                                            balance != Integer.parseInt(balPriceField.getText())
        ){
            Connection connection = DBHandler.getConnection();
            String update;
            ArrayList<String> updatedList = new ArrayList<>();
            if(top != Integer.parseInt(topPriceField.getText())) {
                update ="UPDATE advertismentscheme SET AdPrice ="+ topPriceField.getText() +" WHERE AdvertismentSchemeID = 1";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Top Banner");
                    top =  Integer.parseInt(topPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            if(left != Integer.parseInt(leftPriceField.getText())) {
                update ="UPDATE advertismentscheme SET AdPrice ="+ leftPriceField.getText() +" WHERE AdvertismentSchemeID = 2";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Left Banner");
                    left =  Integer.parseInt(leftPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            if(right != Integer.parseInt(rightPriceField.getText())) {
                update ="UPDATE advertismentscheme SET AdPrice ="+ rightPriceField.getText() +" WHERE AdvertismentSchemeID = 3";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Right Banner");
                    right =  Integer.parseInt(rightPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            if(bottom != Integer.parseInt(bottomPriceField.getText())) {
                update ="UPDATE advertismentscheme SET AdPrice ="+ bottomPriceField.getText() +" WHERE AdvertismentSchemeID = 4";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Bottom Banner");
                    bottom =  Integer.parseInt(bottomPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            if(back != Integer.parseInt(backPriceField.getText())) {
                update ="UPDATE advertismentscheme SET AdPrice ="+ backPriceField.getText() +" WHERE AdvertismentSchemeID = 5";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Back Banner");
                    back =  Integer.parseInt(backPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            if(balance != Integer.parseInt(balPriceField.getText())) {
                update ="UPDATE admaxbal SET amount ="+ balPriceField.getText() +" WHERE id = 1";
                try {
                    PreparedStatement preparedStatementOne = connection.prepareStatement(update);
                    preparedStatementOne.executeUpdate(update);
                    updatedList.add("Max Ad Balance");
                    balance =  Integer.parseInt(balPriceField.getText());

                } catch (SQLException e) {
                    showError(e.getLocalizedMessage());
                }
            }
            String success = "Updated: " + updatedList.toString();
            showSuccess(success);

        }else{
            //no changes to be made
            showError("No changes were made");
        }

    }

    private void showError(String e){
        errorMsg.setText(e);
        if(!errorMsg.isVisible()){
            errorMsg.setVisible(true);
        }
    }
    private void showSuccess(String s){
        successMsg.setText(s);
        if(!successMsg.isVisible())
            successMsg.setVisible(true);
    }
    private void hideMsgs(){
        errorMsg.setVisible(false);
        successMsg.setVisible(false);
    }
    @FXML
    private void handleGoBackBtn(ActionEvent ae) throws Exception{
        goBackBtn.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();

    }


}

