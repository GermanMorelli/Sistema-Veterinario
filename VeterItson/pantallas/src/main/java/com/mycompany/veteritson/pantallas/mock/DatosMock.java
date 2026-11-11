package com.mycompany.veteritson.pantallas.mock;

import java.util.List;

/**
 * Datos de prueba (MOCK) para llenar las pantallas.
 * Se reemplazarán por los datos reales del módulo correspondiente.
 */
public final class DatosMock {

    private DatosMock() {
    }

    /** Mascota registrada en la clínica. */
    public record Mascota(int id, String nombre, String especie, String raza, String sexo,
            double peso, String senas, String dueno, String telefono) {

        /** Nombre que se muestra en las listas. */
        @Override
        public String toString() {
            return nombre;
        }
    }

    /** Cita agendada en un día y hora. */
    public record Cita(String paciente, String dia, String hora) {
    }

    /** Vacuna aplicada a una mascota (renglón de la cartilla). */
    public record Aplicacion(int idMascota, String fecha, String vacuna, String lote,
            String veterinario, String estado) {
    }

    // MOCK: mascotas registradas
    public static final List<Mascota> mascotas = List.of(
            new Mascota(262746, "Julian", "Cuy", "Cuy peruano", "Macho", 0.7, "Cafecito", "Mario Gomez", "1234567890"),
            new Mascota(262747, "Mike", "Perro", "Chihuahua", "Macho", 2.5, "Mancha blanca", "Ana Lopez", "6441112233"),
            new Mascota(262748, "Juan", "Perro", "Shih Tzu", "Macho", 5.1, "Pelo largo", "Luis Perez", "6442223344"),
            new Mascota(262749, "Tutancamon", "Perro", "Pug", "Macho", 8.0, "Cara negra", "Karla Gonzalez", "6443334455"));

    // MOCK: citas de la semana para la agenda
    public static final List<Cita> citas = List.of(
            new Cita("Luna - Karla Gonzalez", "Lunes", "10:00 AM"),
            new Cita("Julian - Victor Ortega", "Lunes", "01:00 PM"));

    // MOCK: vacunas aplicadas para la cartilla digital
    public static final List<Aplicacion> aplicaciones = List.of(
            new Aplicacion(262746, "14/08/26", "Inventadita 2da dosis", "12556", "Dra. Ana Garcia", "Aplicada"),
            new Aplicacion(262746, "20/07/26", "Desparasitante FillPro", "23456", "Dr. Carlos Ruiz", "Aplicada"),
            new Aplicacion(262746, "15/06/26", "Inventadita 1ra dosis", "45687", "Dra. Ana Garcia", "Aplicada"));

    // MOCK: totales del resumen de inicio
    public static final int citasHoy = 6;
    public static final int registros = 7;

    // MOCK: días y horas de atención de la clínica
    public static final List<String> dias = List.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado");
    public static final List<String> horas = List.of("10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM",
            "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM");

    // MOCK: motivos posibles de una cita
    public static final List<String> motivos = List.of("Baño", "Chequeo general", "Estetica", "Vacunas");
}
