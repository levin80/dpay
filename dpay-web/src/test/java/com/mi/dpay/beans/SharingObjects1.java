package com.mi.dpay.beans;

public class SharingObjects1 {  
    private static boolean ready;  
    private static int number;  
      
    private static class ReaderThread extends Thread{  
        @Override  
        public void run(){  
            while(!ready){  
                Thread.yield();  
                System.out.println(number);  
            }  
            System.out.println("thread "+Thread.currentThread().getId()+" over");  
        }  
          
          
        public static void main(String[] args) {  
            new ReaderThread().start();  
            number = 42;  
            ready = true;  
            System.out.println("thread "+Thread.currentThread().getId()+" over");  
        }  
    }  
}