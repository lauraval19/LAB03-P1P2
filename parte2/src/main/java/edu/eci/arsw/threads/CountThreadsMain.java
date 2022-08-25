/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author Carlos Orduz - Laura Alvarado
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        //First thread
        Thread t1 = new Thread(new CountThread(0,99));
        //Second Thread
        Thread t2 = new Thread(new CountThread(99,199));
        //Third Thread
        Thread t3 = new Thread(new CountThread(200,299));

        /**
         * t1.start();
         * t2.start();
         * t3.start();
         */

        //Start Cycle
        t1.run();
        t2.run();
        t3.run();

    }
    
}
