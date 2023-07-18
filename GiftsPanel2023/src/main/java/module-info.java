module gonzalezsantos.manuel.giftspanel2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens gonzalezsantos.manuel.giftspanel2023.controlador to javafx.fxml;
    exports gonzalezsantos.manuel.giftspanel2023.controlador;
}