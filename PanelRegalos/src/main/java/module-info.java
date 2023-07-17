module gonzalezsantos.manuel.panelregalos {
    requires javafx.controls;
    requires javafx.fxml;


    opens gonzalezsantos.manuel.panelregalos to javafx.fxml;
    exports gonzalezsantos.manuel.panelregalos.controlador;
}