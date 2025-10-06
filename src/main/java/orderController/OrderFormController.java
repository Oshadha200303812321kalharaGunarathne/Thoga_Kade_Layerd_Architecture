package orderController;

import Service.Impl.OrderServiceImpl;
import Service.OrderManagementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Orders;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    OrderManagementService orderManagementService=new OrderServiceImpl();

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
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableView<Orders> tblOrderDetails;

    @FXML
    private JFXTextField txtCustID;

    @FXML
    private DatePicker pickerDate;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Orders orders=new Orders(
                txtOrderID.getText(),
                pickerDate.getValue().toString(),
                txtCustID.getText()
        );
        orderManagementService.addOrders(orders);
        btnViewOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderID.setText(null);
        pickerDate.setValue(null);
        txtCustID.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ID=txtOrderID.getText();
        orderManagementService.deleteOrders(ID);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Orders orders=new Orders(
                txtOrderID.getText(),
                pickerDate.getValue().toString(),
                txtCustID.getText()
        );
        orderManagementService.updateOrders(orders);
        btnClearOnAction(event);
        btnViewOnAction(event);
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        tblOrderDetails.setItems(orderManagementService.viewOrders());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
        colCustID.setCellValueFactory(new PropertyValueFactory<>("CustID"));
    }
}
