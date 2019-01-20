package scislo;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    public Button close;

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TableColumn<Person, String> idColumn;

    private Main main;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void handleCLose() {
        Platform.exit();
        System.exit(0);
    }

    private void setList() {
        this.personList.add(new Person("1", "Tomek", "Ścisło"));
        this.personList.add(new Person("2", "Grzegorz", "Ścisło"));
        this.personList.add(new Person("3", "Jan", "Kowalski"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        setList();
        tableView.setItems(this.personList);
    }
}
