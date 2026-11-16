package com.rafamompo.tema02;

public class HiloNumeros extends Thread {

    private int identificador;

    public HiloNumeros (int id){

        this.identificador = id;



    }





    @Override
    public void run (){
        for (int x = 0; x < 10000; x++){

            System.out.println("Hilo: " + identificador  +  " (" + x + ")\n");


        }
    }





}
