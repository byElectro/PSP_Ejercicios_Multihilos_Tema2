package com.rafamompo.tema02;

public class Ejercicio8 {

    //En el array he puesto 50 ya que mi ordenador tiene 16 núcleos.
    static int[] numeros = {
            2,4,4,4,4,4,4,4,
            2,4,4,4,4,4,4,4,
            2,4,4,4,2,4,4,4,
            2,4,4,4,4,4,4,4,
            2,4,4,4,4,4,2,4,
            2,4,4,4,4,4,4,4

    };

    public static int contador = 0;

    static void main () throws InterruptedException {


        int n = Runtime.getRuntime().availableProcessors();

        System.out.println ("El numero de núcleos es: " + n);




        int tamanyo = numeros.length / n;


        ContadorPrimos[] contadoresPrimos = new ContadorPrimos[n];


        for (int i= 0; i < n - 1; i++ ){

            contadoresPrimos[i] = new ContadorPrimos(i*tamanyo, i*tamanyo+tamanyo-1);

            contadoresPrimos[i].start();
        }

        //Esto es para contemplar en caso de que el array no salga multiplo de los hilos que tengo. Entonces
        //el último Thread tiene que recorrer todo el resto.
        contadoresPrimos[n-1] = new ContadorPrimos((n-1) * tamanyo, numeros.length -1);

        contadoresPrimos[n-1].start();

        //Esperamos a que todos los hijos terminen para saber si alguno de los hilos ha encontrado el número a buscar.
        for (ContadorPrimos c: contadoresPrimos){
            c.join();
        }

        System.out.println("La cantidad de números primos es: " + contador);


    }
}
