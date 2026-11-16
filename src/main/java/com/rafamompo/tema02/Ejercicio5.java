package com.rafamompo.tema02;

public class Ejercicio5 {

    static void main(String[] args) {


        int n = Integer.parseInt(args[0]);


        for (int i = 1; i<=n;i++){

            HiloNumeros h = new HiloNumeros(i);

            h.start();

        }


        //Se ejecutan el orden que le da la puta gana al sistema operativo.

        System.out.println("Fin del programa");


    }
}
