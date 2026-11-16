package com.rafamompo.tema02;

public class Buscador extends Thread {


    private int inicio,fin;


    public Buscador(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;

    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++ ){

            //Aqui no hace falta syncronized porque cada Thread tiene sus propias parte a la cual acceder.
            if (Ejercicio7.numeros[i] == Ejercicio7.numBuscar){
                modificar (true);
                break;
            }

        }


    }


    //Cuando una variable esta siendo compartida por todos los hilos, hay que sincronizarlos.
    // Con synchronized solo un unico hilo puede hacer esta accion a la vez si no varios podrian
    // modificar el valor de la variable.
    private synchronized void modificar (boolean encontrado){
        Ejercicio7.encontrado = encontrado;

    }
}
