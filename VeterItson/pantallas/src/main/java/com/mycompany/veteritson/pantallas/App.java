package com.mycompany.veteritson.pantallas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Punto de entrada: crea la ventana con el menú lateral y abre la pantalla de inicio.
 */
public class App extends Application {

    @Override
    public void start(Stage escenario) {
        BorderPane ventana = new BorderPane();
        ventana.setLeft(new MenuLateral());

        Navegador.iniciar(ventana);
        Navegador.irAInicio();

        Scene escena = new Scene(ventana, 1000, 650);
        escena.getStylesheets().add(App.class.getResource("estilos.css").toExternalForm());

        escenario.setTitle("VeterItson");
        escenario.setScene(escena);
        escenario.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
