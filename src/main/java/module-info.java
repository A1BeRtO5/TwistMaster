module org.example.twistmaster {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.twistmaster to javafx.fxml;
    exports org.example.twistmaster;
}