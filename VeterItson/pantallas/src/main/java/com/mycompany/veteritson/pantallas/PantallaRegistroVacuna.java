package com.mycompany.veteritson.pantallas;

/**
 * Formulario para registrar una vacuna nueva en el catálogo.
 */
public class PantallaRegistroVacuna extends Pantalla {

    public PantallaRegistroVacuna() {
        super("Registrar nueva vacuna");

        agregar(
                Componentes.formulario("Nombre comercial:", "Nombre del fabricante:",
                        "Registro sanitario:", "Presentación:"),
                Componentes.botonesRegistro());
    }
}
