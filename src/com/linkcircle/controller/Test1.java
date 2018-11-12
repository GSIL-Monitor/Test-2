package com.linkcircle.controller;

public class Test1 {
    @org.junit.Test
    public void test(){


        String fileName = ".wav";

       Thread s = new Thread();
        for(int i=1;i<10;i++){
            System.err.println("fileName"+i+fileName);
//
//            try {
//                s.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            System.err.println(i);
        }

    }
}
