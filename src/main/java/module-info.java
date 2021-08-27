module com.mycompany.proyecto2_grupo10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2_grupo10 to javafx.fxml;
    exports com.mycompany.proyecto2_grupo10;
    requires java.mail;


}
