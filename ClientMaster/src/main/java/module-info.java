module com.clientmaster.clientmaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.incubator.foreign;


    opens com.clientmaster.clientmaster to javafx.fxml;
    opens com.clientmaster.clientmaster.controllers to javafx.fxml;
    exports com.clientmaster.clientmaster;
    exports com.clientmaster.clientmaster.controllers;
    opens com.clientmaster.clientmaster.model;

}