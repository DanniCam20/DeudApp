package com.example.deudapp;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.application.Platform;
import java.io.IOException;


public class HelloController {


     // Declaracion de Contenedor principal y Menu

    @FXML
    private StackPane contentPane;
    @FXML
    private VBox menuLateral;

    // Metodo para cambiar de pantallas

    private void loadView(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            contentPane.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Declaracion de botones del menú

    @FXML
    private Button BtnInicio;
    @FXML
    private Button BtnPersonas;
    @FXML
    private Button BtnRegistrar;
    @FXML
    private Button BtnAbonar;
    @FXML
    private Button BtnReportes;
    @FXML
    private Button BtnAjustes;
    @FXML
    private Button BtnSalir;
    @FXML
    private Button BtnMenu;


    // Funciones de botones del menú

    @FXML
    private void goInicio() {
        loadView("/com/example/deudapp/bienvenida-view.fxml");
        setActive(BtnInicio);
    }

    @FXML
    private void goPersonas() {
        loadView("/com/example/deudapp/personas-view.fxml");
        setActive(BtnPersonas);
    }

    @FXML
    private void goAbonar() {
        loadView("/com/example/deudapp/abonar-view.fxml");
        setActive(BtnAbonar);
    }

    @FXML
    private void goReportes() {
        loadView("/com/example/deudapp/reportes-view.fxml");
        setActive(BtnReportes);
    }

    @FXML
    private void goRegistrar() {
        loadView("/com/example/deudapp/registrar-view.fxml");
        setActive(BtnRegistrar);
    }

    @FXML
    private void goAjustes() {
        loadView("/com/example/deudapp/ajustes-view.fxml");
        setActive(BtnAjustes);
    }

    @FXML
    private void goSalir() {
        System.exit(0);
    }


    //  🔹Metodos de activacion de botones de menu

    private void setActive(Button selected) {
        // quitar active a todos
        BtnInicio.getStyleClass().remove("active");
        BtnPersonas.getStyleClass().remove("active");
        BtnRegistrar.getStyleClass().remove("active");
        BtnAbonar.getStyleClass().remove("active");
        BtnReportes.getStyleClass().remove("active");
        BtnAjustes.getStyleClass().remove("active");

        // poner active al seleccionado
        selected.getStyleClass().add("active");
    }

    // Funcion de animacion de menu

    public void mostrarMenuAnimado(){
        menuLateral.setTranslateX(-200);
        TranslateTransition anim = new TranslateTransition();
        anim.setNode(menuLateral);
        anim.setDuration(Duration.millis(500));
        anim.setToX(0);
        anim.play();
    }

    // Pantalla inicial o inicializacion de pantalla
    // NOTA: Las pantallas y contenedores estan declaradas al inicio del codigo

    @FXML
    public void initialize() {
        loadView("/com/example/deudapp/bienvenida-view.fxml");
        setActive(BtnInicio);

        // Animacion de entrada de menu
        Platform.runLater(() -> {
            mostrarMenuAnimado();
        });

    }



}