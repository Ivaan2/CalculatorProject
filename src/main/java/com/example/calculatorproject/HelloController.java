package com.example.calculatorproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    //Mensaje predefinido para controlar excepciones
    private static final String msjError = "SyntaxError";

    @FXML
    public Button clear;
    @FXML
    private Label texto;
    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    String operaciones[] = { "+", "-", "*", "/"};
    @FXML
    private ComboBox operacion = new ComboBox(FXCollections.observableArrayList(operaciones));
    @FXML
    private Button calcular;


    //Variables
    double n1, n2, res;
    String simboloOperacion;
    boolean n1Insertado = false;
    boolean n2Insertado = false;
    boolean simbInsertado = false;
    char cOperacion;

    @FXML
        protected void calcularOperacion(MouseEvent actionEvent) {
            if(!n1Insertado || !n2Insertado || !simbInsertado){
                texto.setText(msjError);
            }else{
                res = realizarCalculo();
                texto.setText(String.valueOf(res));
            }
            clear(actionEvent);
        }

    @FXML
        protected void recogerOperacion(MouseEvent actionEvent){
            simboloOperacion = operacion.getSelectionModel().getSelectedItem().toString();
        }

    private double realizarCalculo() {
        cOperacion = filtrarSimbolo();
        double r = 0;
        switch (cOperacion){
            case '+':
                r = n1 + n2;
                break;

            case '-':
                r = n1 - n2;
                break;

            case '*':
                r = n1 * n2;
                break;

            case '/':
                if(n2 == 0){
                    texto.setText(msjError);
                }else{
                    r = n1 / n2;
                }
                break;
        }
        return r;
    }

    private char filtrarSimbolo() {
        char c;
        if(simboloOperacion.contains("+")){
            c = '+';
        }else if (simboloOperacion.contains("-")){
            c = '-';
        }else if(simboloOperacion.contains("*")){
            c = '*';
        }else{
            c= '/';
        }
        return c;
    }

    @FXML
        protected void recogerNum1(MouseEvent actionEvent){
            if(num1.getSelectedText() == null){
                texto.setText(msjError);
            }
            n1 = Double.parseDouble(num1.getSelectedText());
            n1Insertado = true;
        }

    @FXML
        protected void recogerNum2(MouseEvent actionEvent){
            if(num2.getSelectedText() == null){
                texto.setText(msjError);
            }
            n2 = Double.parseDouble(num1.getSelectedText());
            n2Insertado = true;
        }

    @FXML
        protected void clear(MouseEvent actionEvent){
            texto.setText("0");
            n1 = 0.0;
            n2 = 0.0;
            n1Insertado = false;
            n2Insertado = false;
        }
}