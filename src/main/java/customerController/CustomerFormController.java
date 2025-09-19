package customerController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    ObservableList <CustomerDetails> customerDetails = FXCollections.observableArrayList();

    CustomerManagementService customerManagementService=new CustomerManagementController();

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnView;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustAddress;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustTitle;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colsalary;

    @FXML
    private JFXComboBox<String> comboCity;

    @FXML
    private JFXComboBox<String> comboCustTitle;

    @FXML
    private JFXComboBox<String> comboProvince;

    @FXML
    private DatePicker pickerDOB;

    @FXML
    private TableView<CustomerDetails> tblCustomerDetails;

    @FXML
    private JFXTextField txtCustAddress;

    @FXML
    private JFXTextField txtCustID;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        CustomerDetails customerDetails=new CustomerDetails(
                txtCustID.getText(),
                comboCustTitle.getValue(),
                txtCustName.getText(),
                pickerDOB.getValue().toString(),
                Double.parseDouble(txtSalary.getText()),
                txtCustAddress.getText(),
                comboCity.getValue(),
                comboProvince.getValue(),
                txtPostalCode.getText()
        );
        customerManagementService.addCustomerDetails(customerDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCustID.setText(null);
        comboCustTitle.setValue(null);
        txtCustName.setText(null);
        pickerDOB.setValue(null);
        txtSalary.setText(null);
        txtCustAddress.setText(null);
        comboCity.setValue(null);
        comboProvince.setValue(null);
        txtPostalCode.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerManagementService.DeleteCustomerDetails(txtCustID.getText());
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerDetails customerDetails=new CustomerDetails(
                txtCustID.getText(),
                comboCustTitle.getValue(),
                txtCustName.getText(),
                pickerDOB.getValue().toString(),
                Double.parseDouble(txtSalary.getText()),
                txtCustAddress.getText(),
                comboCity.getValue(),
                comboProvince.getValue(),
                txtPostalCode.getText()
        );
        customerManagementService.UpdateCustomerDetails(customerDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        tblCustomerDetails.setItems(customerManagementService.viewCustomerDetails());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("custTitle"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        colsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        ObservableList<String>CustTitles=FXCollections.observableArrayList(
                "Mr.",
                "Miss.",
                "Mrs",
                "Ms"
        );

        comboCustTitle.setItems(CustTitles);

        ObservableList<String>CityType=FXCollections.observableArrayList(
                "Ampara",
                "Anuradhapura",
                "Badulla",
                "Batticaloa",
                "Colombo",
                "Galle",
                "Gampaha",
                "Hambanthota",
                "Jaffna",
                "Kandy",
                "Kegalle",
                "Killinochchi",
                "Kurunagala",
                "Mannar",
                "Matale",
                "Matara",
                "Monaragala",
                "Mullaitivu",
                "Nuwara Eliya",
                "Polonnaruwa",
                "Puttalam",
                "Ratnapura",
                "Trincomalee",
                "Vavuniya",
                "Kalutara",
                "Panadura"
        );

        comboCity.setItems(CityType);

        ObservableList<String>ProvinceType=FXCollections.observableArrayList(
                "Central",
                "Western",
                "Eastern",
                "Nothern",
                "Uva",
                "Sabaragamuwa",
                "Southern",
                "North Western",
                "North Central"
        );
        comboProvince.setItems(ProvinceType);
    }
}
