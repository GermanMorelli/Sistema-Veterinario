package com.mycompany.veteritson.pantallas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * Elementos visuales que se repiten en varias pantallas.
 */
public final class Componentes {

    private Componentes() {
    }

    /** Crea una etiqueta con un estilo del archivo CSS. */
    public static Label texto(String texto, String estilo) {
        Label etiqueta = new Label(texto);
        etiqueta.getStyleClass().add(estilo);
        return etiqueta;
    }

    /** Botón morado para la acción principal. */
    public static Button botonPrincipal(String texto, Runnable accion) {
        return boton(texto, "boton-principal", accion);
    }

    /** Botón claro para acciones secundarias. */
    public static Button botonSecundario(String texto, Runnable accion) {
        return boton(texto, "boton-secundario", accion);
    }

    private static Button boton(String texto, String estilo, Runnable accion) {
        Button boton = new Button(texto);
        boton.getStyleClass().add(estilo);
        boton.setOnAction(evento -> accion.run());
        return boton;
    }

    /**
     * Botones Cancelar y Registrar alineados a la derecha.
     * Por ahora ambos regresan al inicio; el guardado será de otro módulo.
     */
    public static HBox botonesRegistro() {
        HBox botones = new HBox(10,
                botonSecundario("Cancelar", Navegador::irAInicio),
                botonPrincipal("Registrar", Navegador::irAInicio));
        botones.setAlignment(Pos.CENTER_RIGHT);
        return botones;
    }

    /** Formulario de dos columnas con una caja de texto por cada etiqueta. */
    public static GridPane formulario(String... etiquetas) {
        GridPane rejilla = new GridPane();
        rejilla.setHgap(10);
        rejilla.setVgap(10);
        for (int i = 0; i < etiquetas.length; i++) {
            int columna = (i % 2) * 2; // 0 = izquierda, 2 = derecha
            int fila = i / 2;
            rejilla.add(new Label(etiquetas[i]), columna, fila);
            rejilla.add(new TextField(), columna + 1, fila);
        }
        return rejilla;
    }

    /** Recuadro gris que ocupa el lugar de una foto. */
    public static StackPane foto(double tamano) {
        StackPane recuadro = new StackPane(new Label("Foto"));
        recuadro.getStyleClass().add("foto");
        recuadro.setPrefSize(tamano, tamano);
        recuadro.setMaxSize(tamano, tamano);
        return recuadro;
    }
}
