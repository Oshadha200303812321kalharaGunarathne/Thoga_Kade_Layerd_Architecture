package itemController;

import Service.Impl.ItemServiceImpl;
import Service.ItemManagementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ItemDetails;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    ItemManagementService itemManagementService=new ItemServiceImpl();

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
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemDetails> tblItemDetails;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtPackSize;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        ItemDetails itemDetails=new ItemDetails(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText())
        );

        itemManagementService.addItemDetails(itemDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtItemCode.setText(null);
        txtDescription.setText(null);
        txtPackSize.setText(null);
        txtUnitPrice.setText(null);
        txtQtyOnHand.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ID=txtItemCode.getText();
        ItemManagementService itemManagementService=new ItemServiceImpl();
        itemManagementService.deleteItemDetails(ID);

        btnClearOnAction(event);
        btnViewOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemDetails itemDetails=new ItemDetails(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQtyOnHand.getText())
        );
        itemManagementService.updateItemDetails(itemDetails);
        btnViewOnAction(event);
        btnClearOnAction(event);
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        tblItemDetails.setItems(itemManagementService.viewItemDetails());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("PackSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
    }
}
