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
public class ItemController implements Initializable {
    @FXML
    private TextField itemId;

    @FXML
    private TextField itemName;

    @FXML
    private TextField itemQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onBtnAddItemClick() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Item VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, itemId.getText());
            statement.setString(2, itemName.getText());
            statement.setString(3, itemQty.getText());
            if (statement.executeUpdate() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alert");
                alert.setHeaderText("Item added");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("Error! Item isn't added");
                alert.showAndWait();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBtnHomeClick() {
        Stage stage = (Stage) this.itemId.getScene().getWindow();
        try {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/exam/view/Home.fxml"));
            stage.setScene(new Scene(parent));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
