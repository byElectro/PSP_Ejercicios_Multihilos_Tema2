package com.rafamompo.tema02;

public class Ejercicio4 {

    static void main() throws InterruptedException {

        Hilo100 h = new Hilo100();

        //Esto es para ponerlo en segundo plano
        h.setDaemon(true);
        h.start();
        h.join();

// Al hacer esto, solo imprime los numeros antes de que acabe el programa principal. Porque cuando
// acaba el programa principal, la máquina virtual termina cuando todos los procesos que queden sean solo demonios.

        System.out.println("Fin del programa");



    }
}
