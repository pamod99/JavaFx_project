/*---------------------------------------------------------------------------------------------
 *  Copyright (c) IJSE. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package lk.ijse.exam.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.exam.db.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Pamod Bulathgama <cbulathgama8@gmail.com>
 * @since 8/7/21
 */
public class CustomerController implements Initializable {
    @FXML
    private TextField customerId;

    @FXML
    private TextField customerName;

    @FXML
    private TextField customerAddress;

    @FXML
    private TextField customerNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onBtnAddCustomerClick() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Customer VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customerId.getText());
            statement.setString(2, customerName.getText());
            statement.setString(3, customerAddress.getText());
            statement.setString(4, customerNumber.getText());
            if (statement.executeUpdate() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("Customer added");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("Error! Customer isn't added");
                alert.showAndWait();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onBtnHomeClick() {
        Stage stage = (Stage) this.customerId.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/exam/view/Home.fxml"));
            stage.setScene(new Scene(parent));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
