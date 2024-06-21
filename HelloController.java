package com.example.hehehe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<user> userTable;
    public TableColumn<user,Integer> id;
    public TableColumn<user,String> naam;
    public TableColumn<user,String> mail;
    public TableColumn<user,String> pass;
    public TextField idd;
    public TextField unaam;
    public TextField uemail;
    public TextField upass;
    @FXML
    private Label welcomeText;

    ObservableList<user> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        loadData();
    }

    private void loadData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hurray";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM sure";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String naam = resultSet.getString("naam");
                String mail = resultSet.getString("email");
                String pass = resultSet.getString("password");
                userTable.getItems().add(new user(id, naam, mail, pass));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<user,Integer>("id"));
        naam.setCellValueFactory(new PropertyValueFactory<user,String>("naam"));
        mail.setCellValueFactory(new PropertyValueFactory<user,String>("email"));
        pass.setCellValueFactory(new PropertyValueFactory<user,String>("password"));
        userTable.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String naam = unaam.getText();
        String mail = uemail.getText();
        String pass = upass.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hurray";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to insert data into the database
            String query = "INSERT INTO sure (naam, email, password) VALUES ('" + naam + "','" + mail + "','" + pass + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String id = idd.getText();
        String naam = unaam.getText();
        String mail = uemail.getText();
        String pass = upass.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hurray";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to update data in the database
            String query = "UPDATE sure SET naam='" + naam + "', email='" + mail + "', password='" + pass + "' WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        String id = idd.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hurray";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to delete data from the database
            String query = "DELETE FROM sure WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        String id = idd.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hurray";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM sure WHERE id='" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                String naam = resultSet.getString("naam");
                String mail = resultSet.getString("email");
                String pass = resultSet.getString("password");

                unaam.setText(naam);
                uemail.setText(mail);
                upass.setText(pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
