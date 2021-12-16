module com.example.calculatorproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculatorproject to javafx.fxml;
    exports com.example.calculatorproject;
}