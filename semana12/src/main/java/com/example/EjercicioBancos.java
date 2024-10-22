package com.example;

import java.util.Scanner;



public class EjercicioBancos {
    static String[] nombres = {"Julian CR7", "Garcia Ibraimobich", "Susi neymar"};
    static double[] saldos = {85,000, 120,000, 580,300};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int indiceDeposito = seleccionarCuenta(scanner);
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    depositar(indiceDeposito, cantidadDeposito);
                    break;
                case 2:
                    int indiceRetiro = seleccionarCuenta(scanner);
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    retirar(indiceRetiro, cantidadRetiro);
                    break;
                case 3:
                    int indiceConsulta = seleccionarCuenta(scanner);
                    consultarSaldo(indiceConsulta);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("----------------");
    }

    public static int seleccionarCuenta(Scanner scanner) {
        System.out.println("Seleccione una cuenta:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i + ". " + nombres[i]);
        }
        int indice;
        while (true) {
            System.out.print("Ingrese el índice de la cuenta: ");
            indice = scanner.nextInt();
            if (indice >= 0 && indice < nombres.length) {
                break;
            } else {
                System.out.println("Índice inválido. Intente de nuevo.");
            }
        }
        return indice;
    }

    public static void depositar(int indice, double cantidad) {
        saldos[indice] += cantidad;
        System.out.println("Depósito de " + cantidad + " realizado con éxito. Nuevo saldo: " + saldos[indice]);
    }

    public static void retirar(int indice, double cantidad) {
        if (cantidad <= saldos[indice]) {
            saldos[indice] -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado con éxito. Nuevo saldo: " + saldos[indice]);
        } else {
            System.out.println("Saldo insuficiente. No se puede retirar " + cantidad);
        }
    }

    public static void consultarSaldo(int indice) {
        System.out.println("El saldo de " + nombres[indice] + " es: " + saldos[indice]);
    }
}