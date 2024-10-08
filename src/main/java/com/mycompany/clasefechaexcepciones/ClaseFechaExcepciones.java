/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clasefechaexcepciones;

/**
 *
 * @author 34639
 */

import java.util.Scanner;

public class ClaseFechaExcepciones {

    private int dia;
    private int mes;
    private int anio;

    // Constructor por defecto
    public ClaseFechaExcepciones() {
        dia = 0;
        anio = 0;
        mes = 0;
    }

    // Constructor parametrizado con manejo de excepciones
    public ClaseFechaExcepciones(int dia, int mes, int anio) throws IllegalArgumentException {
        if (esFechaValida(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
        } else {
            throw new IllegalArgumentException("Fecha no válida.");
        }
    }

    // Métodos getter y setter
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) throws IllegalArgumentException {
        if (dia > 0 && dia <= 31) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Día no válido.");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) throws IllegalArgumentException {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mes no válido.");
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) throws IllegalArgumentException {
        if (anio >= 1900 && anio <= 2024) {
            this.anio = anio;
        } else {
            throw new IllegalArgumentException("Año no válido. Debe estar entre 1900 y 2024.");
        }
    }

    // Método para verificar si una fecha es válida
    private boolean esFechaValida(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        if (dia < 1 || dia > 31) {
            return false;
        }

        if (mes == 2) {
            if (esAnioBisiesto(anio)) {
                return dia <= 29;
            } else {
                return dia <= 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30;
        } else {
            return true;
        }
    }

    // Método para determinar si un año es bisiesto
    private boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    // Método para imprimir la fecha
    public void mostrarFecha() {
        System.out.println(dia + "/" + mes + "/" + anio);
    }

    // Método para leer la fecha desde el teclado
    public void leerFecha(Scanner scanner) {
        System.out.println("Ingrese la fecha:");

        System.out.print("Día: ");
        int d = scanner.nextInt();

        System.out.print("Mes: ");
        int m = scanner.nextInt();

        System.out.print("Año: ");
        int a = scanner.nextInt();

        try {
            setDia(d);
            setMes(m);
            setAnio(a);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClaseFechaExcepciones fecha = new ClaseFechaExcepciones();

        fecha.leerFecha(scanner);
        fecha.mostrarFecha();

        scanner.close();
    }
}
