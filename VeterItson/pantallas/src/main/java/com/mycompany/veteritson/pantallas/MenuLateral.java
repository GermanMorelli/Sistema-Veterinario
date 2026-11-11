package com.mycompany.veteritson.pantallas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Menú lateral que aparece en todas las pantallas.
 */
public class MenuLateral extends VBox {

    public MenuLateral() {
        super(10);
        getStyleClass().add("menu");

        Label logo = new Label("VeterItson");
        logo.getStyleClass().add("logo");

        getChildren().addAll(
                logo,
                opcion("Inicio", Navegador::irAInicio),
                opcion("Mascotas y Cartilla", () -> Navegador.mostrar(new PantallaListadoMascotas())),
                opcion("Personal Veterinario", () -> Navegador.mostrar(new PantallaRegistroVeterinario())));
    }

    /** Crea un botón del menú que ejecuta la acción indicada. */
    private Button opcion(String texto, Runnable accion) {
        Button boton = new Button(texto);
        boton.getStyleClass().add("opcion-menu");
        boton.setMaxWidth(Double.MAX_VALUE);
        boton.setOnAction(evento -> accion.run());
        return boton;
    }
}
