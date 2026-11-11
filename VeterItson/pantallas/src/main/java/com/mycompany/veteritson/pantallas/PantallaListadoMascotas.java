package com.mycompany.veteritson.pantallas;

import com.mycompany.veteritson.pantallas.mock.DatosMock;
import com.mycompany.veteritson.pantallas.mock.DatosMock.Mascota;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

/**
 * Lista de mascotas registradas. Al elegir una se abre su cartilla.
 */
public class PantallaListadoMascotas extends Pantalla {

    public PantallaListadoMascotas() {
        super("Listado de mascotas");

        ListView<Mascota> lista = new ListView<>();
        lista.getItems().addAll(DatosMock.mascotas);

        // Abre la cartilla de la mascota seleccionada
        lista.getSelectionModel().selectedItemProperty().addListener(
                (propiedad, anterior, elegida) -> Navegador.mostrar(new PantallaCartilla(elegida)));

        HBox botones = new HBox(Componentes.botonSecundario("Cerrar", Navegador::irAInicio));
        botones.setAlignment(Pos.CENTER_RIGHT);

        agregar(new Label("Selecciona una mascota para ver su cartilla"), lista, botones);
    }
}
