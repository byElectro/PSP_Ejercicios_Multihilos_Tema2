package com.rafamompo.tema02;

public class Cohete extends Thread{



        // Atributos.

        // Distancia a recorrer.
        private int distancia;

        // Identificador del cohete.
        private int identificador;

        // Color del cohete.
        private AnsiColor color;

        // Distancia actual.
        private int distanciaActual;

        // Tiempo empelado.
        private long tiempo;


        // Métodos.

        public Cohete (int id, AnsiColor c, int d)
        {
            this.identificador = id;
            this.color = c;
            this.distancia = d;
            this.distanciaActual = 0;
        }

        public int getIdentificador() {
            return identificador;
        }

        public int getDistanciaActual() {
            return distanciaActual;
        }

        public long getTiempo ()
        {
            return this.tiempo;
        }

        public void setTiempo (long t)
        {
            this.tiempo = t;
        }

        public AnsiColor getColor() {
            return color;
        }


        @Override
        public void run ()
        {
            while (this.distanciaActual < this.distancia)
            {
                avanzar ();

                // Dormir el Thread para que los otros Thread puedan ejecutarse.
                Lib.wait(Ejercicio9.PAUSA);
            }
        }

        // Con synchronized solo un Thread puede ejecutar esta funcion, asi evitamos que varios Thread la ejecuten
        // al mismo tiempo.
        private synchronized void avanzar ()
        {
            // Avance de un paso.
            distanciaActual = distanciaActual + Lib.random (0, Ejercicio9.PASO_MAXIMO);

            // Mostrar evolución.
            Ejercicio9.mostrarEstado (this);
        }
    }

