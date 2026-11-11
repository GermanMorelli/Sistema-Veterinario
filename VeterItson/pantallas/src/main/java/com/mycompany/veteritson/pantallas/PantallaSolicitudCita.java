package com.mycompany.veteritson.pantallas;

import com.mycompany.veteritson.pantallas.mock.DatosMock;
import com.mycompany.veteritson.pantallas.mock.DatosMock.Mascota;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Formulario para agendar una cita: busca la mascota y elige fecha, hora y motivo.
 */
public class PantallaSolicitudCita extends Pantalla {

    public PantallaSolicitudCita() {
        super("Solicitud de Cita");

        TextField buscador = new TextField();
        buscador.setPromptText("Mascota o dueño (ID o nombre)");

        // MOCK: resultado fijo de la búsqueda
        Mascota mascota = DatosMock.mascotas.get(0);
        VBox datosMascota = new VBox(4,
                dato("Mascota", mascota.nombre()),
                dato("Especie", mascota.especie()),
                dato("ID", mascota.id()),
                dato("Dueño", mascota.dueno()),
                dato("Contacto", mascota.telefono()));
        HBox resultado = new HBox(15, datosMascota, Componentes.foto(80));
        resultado.getStyleClass().add("resumen");

        DatePicker fecha = new DatePicker();
        fecha.setPromptText("Fecha");

        ComboBox<String> hora = new ComboBox<>();
        hora.getItems().addAll(DatosMock.horas);
        hora.setPromptText("Hora");

        ComboBox<String> motivo = new ComboBox<>();
        motivo.getItems().addAll(DatosMock.motivos);
        motivo.setPromptText("Motivo");

        agregar(buscador, resultado, new HBox(10, fecha, hora, motivo), Componentes.botonesRegistro());
    }
}
