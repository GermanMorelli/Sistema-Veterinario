package com.mycompany.veteritson.pantallas;

import com.mycompany.veteritson.pantallas.mock.DatosMock;
import com.mycompany.veteritson.pantallas.mock.DatosMock.Aplicacion;
import com.mycompany.veteritson.pantallas.mock.DatosMock.Mascota;
import java.util.function.Function;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Cartilla digital: datos de la mascota y las vacunas que se le han aplicado.
 */
public class PantallaCartilla extends Pantalla {

    public PantallaCartilla(Mascota mascota) {
        super("Cartilla Digital");

        VBox datos = new VBox(4,
                Componentes.texto(mascota.nombre() + " (ID: " + mascota.id() + ")", "subtitulo"),
                new Label(mascota.especie() + " - " + mascota.raza()),
                dato("Dueño", mascota.dueno()));

        TableView<Aplicacion> tabla = new TableView<>();
        tabla.getColumns().add(columna("Fecha", Aplicacion::fecha));
        tabla.getColumns().add(columna("Vacuna", Aplicacion::vacuna));
        tabla.getColumns().add(columna("Lote", Aplicacion::lote));
        tabla.getColumns().add(columna("Veterinario", Aplicacion::veterinario));
        tabla.getColumns().add(columna("Estado", Aplicacion::estado));
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        // Solo las vacunas de esta mascota
        for (Aplicacion aplicacion : DatosMock.aplicaciones) {
            if (aplicacion.idMascota() == mascota.id()) {
                tabla.getItems().add(aplicacion);
            }
        }

        agregar(new HBox(15, Componentes.foto(80), datos), tabla);
    }

    /** Crea una columna que muestra el valor indicado de cada renglón. */
    private TableColumn<Aplicacion, String> columna(String titulo, Function<Aplicacion, String> valor) {
        TableColumn<Aplicacion, String> columna = new TableColumn<>(titulo);
        columna.setCellValueFactory(celda -> new SimpleStringProperty(valor.apply(celda.getValue())));
        return columna;
    }
}
