package org.programacion3.examenfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloController {

    private ObservableList<Producto> listaProd = FXCollections.observableArrayList();

    @FXML
    private TableView<Producto> productosTABLE;

    @FXML
    private TableColumn<Producto, Integer> IDTABLE;

    @FXML
    private TableColumn<Producto, String> tActivoTABLE;

    @FXML
    private TableColumn<Producto, String> marcaTABLE;

    @FXML
    private TableColumn<Producto, String> modeloTABLE;

    @FXML
    private TableColumn<Producto, String> serialTABLE;

    @FXML
    private TableColumn<Producto, String> responsableTABLE;

    @FXML
    private ComboBox tipoActivoCBX;

    @FXML
    private Pane paneBusqueda;

    @FXML
    private TextField idTF;

    @FXML
    private TextField marcaTF;

    @FXML
    private TextField modeloTF;

    @FXML
    private TextField responsableTF;

    @FXML
    private TextField serialTF;


    @FXML
    void agregarProductoOnAction(ActionEvent event) {
        Producto p = new Producto(Integer.parseInt(idTF.getText()),
                tipoActivoCBX.getValue().toString(),marcaTF.getText(),
                modeloTF.getText(),serialTF.getText(),responsableTF.getText());
        System.out.println(p);
        p.CrearArchivo(p);
        limpiarOnAction();
    }

    @FXML
    private Pane paneInventario;

    @FXML
    void BtnConsultarOnAction(ActionEvent event) {
        paneBusqueda.setVisible(true);
        paneInventario.setVisible(false);
    }

    @FXML
    void BtnInventarioOnAction(ActionEvent event) {
        paneInventario.setVisible(true);
        paneBusqueda.setVisible(false);
    }

    @FXML
    void btnBuscarProductos(ActionEvent event) {
        listaProd.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/erick/IdeaProjects/ExamenFinal/src/main/resources/org/programacion3/Archivo/productos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Producto producto = Producto.fromString(linea);
                listaProd.add(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        productosTABLE.setItems(listaProd);
    }

    @FXML
    void limpiarOnAction() {
    idTF.clear();
    marcaTF.clear();
    modeloTF.clear();
    serialTF.clear();
    responsableTF.clear();
    tipoActivoCBX.setValue(null);
    }

    public void initialize() {
        tipoActivoCBX.getItems().addAll(
                "Desktop",
                "Laptop",
                "Impresora",
                "Scanner",
                "Switch",
                "Router",
                "Firewall"
        );

        IDTABLE.setCellValueFactory(new PropertyValueFactory<>("IDproducto"));
        tActivoTABLE.setCellValueFactory(new PropertyValueFactory<>("tipoActivo"));
        marcaTABLE.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloTABLE.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        serialTABLE.setCellValueFactory(new PropertyValueFactory<>("serial"));
        responsableTABLE.setCellValueFactory(new PropertyValueFactory<>("pResponsable"));
    }
}
