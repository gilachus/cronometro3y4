/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gilachus.chronometer3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Second implements Runnable{
    private static boolean working = true;
    
    @Override
    public void run() {
        int count = Integer.parseInt(Screen.jTextSecond.getText());
        while(working){
            Screen.jTextSecond.setText(count+"");
            count++;
            if(count==60){
                count=0;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thousandth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static void stop(){
        working = false;
    }
}
