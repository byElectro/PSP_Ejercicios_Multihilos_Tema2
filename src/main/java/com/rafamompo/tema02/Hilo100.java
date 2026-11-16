package com.rafamompo.tema02;

public class Hilo100 extends Thread {




    @Override
    public void run (){
        for (int x = 0; x < 100; x++){

            System.out.println(x);


        }
    }
}
