package com.mycompany.veteritson.pantallas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * Formulario para registrar una mascota nueva.
 */
public class PantallaRegistroMascota extends Pantalla {

    public PantallaRegistroMascota() {
        super("Registro de Mascota");

        // La carga de la imagen se implementará después
        HBox fotoMascota = new HBox(10, Componentes.foto(100), Componentes.botonSecundario("Subir nueva imagen", () -> { }));
        fotoMascota.setAlignment(Pos.BOTTOM_LEFT);

        agregar(
                Componentes.formulario("Nombre:", "Señas particulares:", "Especie:", "Peso (kg):",
                        "Raza:", "Dueño:", "Sexo:", "Teléfono:"),
                fotoMascota,
                Componentes.botonesRegistro());
    }
}
