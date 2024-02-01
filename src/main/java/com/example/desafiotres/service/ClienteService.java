package com.example.desafiotres.service;

import java.time.LocalDate;

public abstract class ClienteService {
    public static int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - fechaNacimiento.getYear();

        // Verifica si la fecha actual aún no ha llegado al día y mes del cumpleaños de la persona,
        // y en ese caso, decrementa la edad en 1.
        if (hoy.getMonthValue() < fechaNacimiento.getMonthValue() || (hoy.getMonthValue() == fechaNacimiento.getMonthValue() && hoy.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
}