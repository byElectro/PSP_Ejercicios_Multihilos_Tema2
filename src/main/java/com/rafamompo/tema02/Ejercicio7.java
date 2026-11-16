package com.rafamompo.tema02;

public class Ejercicio7 {

    //En el array he puesto 50 ya que mi ordenador tiene 16 núcleos.
    static int[] numeros = {1,2,3,6,7,8,0,23,
            24,22,33,46,77,68,80,223,
            122,278,398,665,78,89,20,231,
            136,2311,321,623,79,86,99,232,
            178,243,32,678,72,87,111,234,
            14,221,333,66,97,78,770,235,2312,923
    };


    public static int numBuscar = 2312;

    public static boolean encontrado = false;

    static void main () throws InterruptedException {


        int n = Runtime.getRuntime().availableProcessors();

        System.out.println ("El numero de núcleos es: " + n);




        int tamanyo = numeros.length / n;


        Buscador[] hilosBuscadores = new Buscador[n];


        for (int i= 0; i < n - 1; i++ ){

            hilosBuscadores[i] = new Buscador(i*tamanyo, i*tamanyo+tamanyo-1);

            hilosBuscadores[i].start();
        }

        //Esto es para contemplar en caso de que el array no salga multiplo de los hilos que tengo. Entonces
        //el último Thread tiene que recorrer todo el resto.
        hilosBuscadores[n-1] = new Buscador((n-1) * tamanyo, numeros.length -1);

        hilosBuscadores[n-1].start();

        //Esperamos a que todos los hijos terminen para saber si alguno de los hilos ha encontrado el número a buscar.
        for (Buscador b : hilosBuscadores){
            b.join();
        }

        if (encontrado){
            System.out.println("El número de la lista fue encontrado.");
        }
        else{
            System.out.println("El número de la lista no fue encontrado.");
        }


    }
}
