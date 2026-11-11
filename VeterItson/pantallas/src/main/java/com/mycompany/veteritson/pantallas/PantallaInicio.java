package com.mycompany.veteritson.pantallas;

import com.mycompany.veteritson.pantallas.mock.DatosMock;
import com.mycompany.veteritson.pantallas.mock.DatosMock.Cita;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Pantalla principal: resumen del día, accesos rápidos y agenda de citas.
 */
public class PantallaInicio extends Pantalla {

    public PantallaInicio() {
        super("Inicio");

        VBox accesos = new VBox(8,
                Componentes.botonSecundario("Registrar Veterinario", () -> Navegador.mostrar(new PantallaRegistroVeterinario())),
                Componentes.botonSecundario("Registrar Mascota", () -> Navegador.mostrar(new PantallaRegistroMascota())),
                Componentes.botonSecundario("Agendar Cita", () -> Navegador.mostrar(new PantallaSolicitudCita())),
                Componentes.botonSecundario("Registrar nuevas Vacunas", () -> Navegador.mostrar(new PantallaRegistroVacuna())));
        accesos.setAlignment(Pos.TOP_RIGHT);

        // Espacio flexible que empuja los accesos a la derecha
        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        HBox parteSuperior = new HBox(15,
                resumen("Citas de Hoy", DatosMock.citasHoy),
                resumen("Registros", DatosMock.registros),
                espacio,
                accesos);

        agregar(parteSuperior, Componentes.texto("Agenda de citas", "subtitulo"), crearAgenda());
    }

    /** Recuadro con un título y un total. */
    private VBox resumen(String titulo, int total) {
        VBox recuadro = new VBox(5, new Label(titulo), Componentes.texto(String.valueOf(total), "total"));
        recuadro.getStyleClass().add("resumen");
        return recuadro;
    }

    /** Tabla de la semana: horas en filas y días en columnas. */
    private GridPane crearAgenda() {
        GridPane agenda = new GridPane();
        agenda.getStyleClass().add("agenda");

        // Encabezados
        agenda.add(celda("Hora"), 0, 0);
        for (int d = 0; d < DatosMock.dias.size(); d++) {
            agenda.add(celda(DatosMock.dias.get(d)), d + 1, 0);
        }

        // Una fila por hora con la cita de cada día (si existe)
        for (int h = 0; h < DatosMock.horas.size(); h++) {
            String hora = DatosMock.horas.get(h);
            agenda.add(celda(hora), 0, h + 1);
            for (int d = 0; d < DatosMock.dias.size(); d++) {
                Label celda = celda(buscarCita(DatosMock.dias.get(d), hora));
                if (!celda.getText().isEmpty()) {
                    celda.getStyleClass().add("cita");
                }
                agenda.add(celda, d + 1, h + 1);
            }
        }
        return agenda;
    }

    /** Devuelve el paciente citado en ese día y hora, o vacío si no hay cita. */
    private String buscarCita(String dia, String hora) {
        for (Cita cita : DatosMock.citas) {
            if (cita.dia().equals(dia) && cita.hora().equals(hora)) {
                return cita.paciente();
            }
        }
        return "";
    }

    /** Celda de la agenda con borde. */
    private Label celda(String texto) {
        Label celda = Componentes.texto(texto, "celda");
        celda.setMaxWidth(Double.MAX_VALUE);
        return celda;
    }
}
