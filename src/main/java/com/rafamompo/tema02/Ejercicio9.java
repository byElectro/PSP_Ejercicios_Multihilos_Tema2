package com.rafamompo.tema02;

public class Ejercicio9 {


    // Atributos.

    // Número de participantes.
    private static final int NUM_COHETES = 4;

    // Lista de cohetes participantes en la carrera.
    private static Cohete [] cohetes = new Cohete [NUM_COHETES];

    // Nombres de los cohetes.
    private static final String [] NOMBRES = {"Soyuz 2", "Falcon 9", "Ariane 5", "Miura"};

    // Clasificación guarda los identificadores de los cohetes segun van llegando.
    private static int [] clasificacion;

    // Distancia del recorrido de la carrera.
    private static final int DISTANCIA = 50;

    // Puesto del próximo cohete en llegar.
    private static int puesto;

    // Avance máximo de cada cohete.
    public static final int PASO_MAXIMO = DISTANCIA / 10;

    // Intervalo entre avances.
    public static final int PAUSA = 1000;


    // Instante inicial.
    private static long inicio;

    // Métodos.

    static void main (String [] args) throws InterruptedException
    {
        // Semilla de inicialización de números aleatorios.
        Lib.setRandomSeed(0);

        // Puesto del próximo cohete en llegar.
        puesto = 0;

        // Clasificación
        clasificacion = new int [NUM_COHETES];


        // Creacion de los cohetes.
        for (int i = 0; i < NUM_COHETES; i++)
        {
            cohetes [i] = new Cohete (i, Ansi.randomColor(), DISTANCIA);
        }

        // Comienzo de la carrera.
        inicio = System.currentTimeMillis();

        for (int i = 0; i < NUM_COHETES; i++)
        {
            cohetes [i].start ();
        }

        // Esperar a que acaben todos los cohetes.
        for (int i = 0; i < NUM_COHETES; i++)
        {
            cohetes [i].join ();
        }

        // Mostar el resumen de la carrera.
        mostrarResumen ();
    }


    // Muestra en pantalla la situación actual del cohete.
    public static void mostrarEstado(Cohete c)
    {
        if (c.getDistanciaActual() >= DISTANCIA)
        {
            System.out.println(NOMBRES[c.getIdentificador()] + ": Aterrizado!");

            // Anotar puesto y tiempo.
            clasificacion [puesto] = c.getIdentificador();
            c.setTiempo (System.currentTimeMillis()-inicio);

            puesto++;
        }
        else
        {
            System.out.println(NOMBRES[c.getIdentificador()] + ": " + c.getDistanciaActual());
        }
    }

    // Muestra la clasificación y el tiempo empleado por cada cohete.
    private static void mostrarResumen ()
    {
        System.out.println ("\nResultado de la carrera:");

        String formato = "%d. %10s (%.4f s)";

        for (int i = 0; i < clasificacion.length; i++)
        {
            int id = clasificacion [i];
            System.out.println (String.format (formato, i+1, NOMBRES [id], (float)(cohetes[id].getTiempo())/1000.0f));
        }

    }


}
