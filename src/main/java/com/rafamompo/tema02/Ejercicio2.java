package com.rafamompo.tema02;

public class Ejercicio2 {

    static void main () throws InterruptedException {
        Hilo100 h = new Hilo100();

        h.start();

        //Esto es para que main espere hasta que acabe el hijo.
        h.join();


        System.out.println("Fin del programa");

    }
}
