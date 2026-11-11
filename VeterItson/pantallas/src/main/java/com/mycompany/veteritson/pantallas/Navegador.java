package com.mycompany.veteritson.pantallas;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * Cambia la pantalla que se muestra en el centro de la ventana.
 */
public final class Navegador {

    private static BorderPane ventana;

    private Navegador() {
    }

    /** Guarda la ventana principal donde se mostrarán las pantallas. */
    static void iniciar(BorderPane ventanaPrincipal) {
        ventana = ventanaPrincipal;
    }

    /** Muestra la pantalla indicada. */
    public static void mostrar(Node pantalla) {
        ventana.setCenter(pantalla);
    }

    /** Regresa a la pantalla de inicio. */
    public static void irAInicio() {
        mostrar(new PantallaInicio());
    }
}
