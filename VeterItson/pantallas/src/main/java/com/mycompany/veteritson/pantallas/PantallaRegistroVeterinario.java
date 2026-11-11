package com.mycompany.veteritson.pantallas;

import com.mycompany.veteritson.pantallas.mock.DatosMock;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;

/**
 * Formulario para registrar un veterinario y sus días de trabajo.
 */
public class PantallaRegistroVeterinario extends Pantalla {

    public PantallaRegistroVeterinario() {
        super("Registro de Veterinario");

        // Una casilla por cada día de atención
        FlowPane diasTrabajo = new FlowPane(15, 8);
        for (String dia : DatosMock.dias) {
            diasTrabajo.getChildren().add(new CheckBox(dia));
        }

        agregar(
                Componentes.formulario("Nombres:", "Teléfono:", "Apellidos:", "Correo:",
                        "Domicilio:", "Cédula:", "Fecha de nacimiento:"),
                Componentes.texto("Días disponibles", "subtitulo"),
                diasTrabajo,
                Componentes.botonesRegistro());
    }
}
