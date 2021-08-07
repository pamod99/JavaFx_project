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
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Pamod Bulathgama <cbulathgama8@gmail.com>
 * @since 8/7/21
 */
public class HomeController implements Initializable {
    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onBtnCustomerClick() {
        Stage stage = (Stage) this.btnCustomer.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/exam/view/Customer.fxml"));
            stage.setScene(new Scene(parent));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onBtnItemClick() {
        Stage stage = (Stage) this.btnCustomer.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/exam/view/Item.fxml"));
            stage.setScene(new Scene(parent));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
