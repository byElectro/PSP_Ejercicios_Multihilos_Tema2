package com.rafamompo.tema02;

public class Ejercicio6 {

    static void main(String[] args) {


        int n = Runtime.getRuntime().availableProcessors();

        System.out.println ("El numero de núcleos es: " + n);


        for (int i = 1; i<=n;i++){

            HiloNumeros h = new HiloNumeros(i);

            h.start();

        }


        //Se ejecutan el orden que le da la puta gana al sistema operativo.

        System.out.println("Fin del programa");


    }
}
