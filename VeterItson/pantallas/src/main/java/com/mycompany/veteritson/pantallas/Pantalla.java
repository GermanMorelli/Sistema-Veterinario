package com.mycompany.veteritson.pantallas;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Base de todas las pantallas: una tarjeta blanca con título y contenido.
 */
public abstract class Pantalla extends VBox {

    private final VBox tarjeta = new VBox(15);

    protected Pantalla(String titulo) {
        getStyleClass().add("pantalla");
        tarjeta.getStyleClass().add("tarjeta");
        tarjeta.getChildren().add(Componentes.texto(titulo, "titulo"));
        getChildren().add(tarjeta);
    }

    /** Agrega elementos a la tarjeta, debajo del título. */
    protected void agregar(Node... nodos) {
        tarjeta.getChildren().addAll(nodos);
    }

    /** Crea una etiqueta tipo "Campo: valor" para mostrar datos. */
    protected Label dato(String campo, Object valor) {
        return new Label(campo + ": " + valor);
    }
}
