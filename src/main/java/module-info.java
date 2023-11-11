module com.mariq.rasyid.latihanmf3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mariq.rasyid.latihanmf3 to javafx.fxml;
    exports com.mariq.rasyid.latihanmf3;
}
