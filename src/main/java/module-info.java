module com.mycompany.proyecto2_grupo10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyecto2_grupo10 to javafx.fxml;
    exports com.mycompany.proyecto2_grupo10;
}
