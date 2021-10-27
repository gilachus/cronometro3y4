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
public class Thousandth implements Runnable{
    private static boolean working = true;
    
    @Override
    public void run() {
        int count = Integer.parseInt(Screen.jTextThousandth.getText());
        while(working){
            Screen.jTextThousandth.setText(count+"");
            count++;
            if(count==1000){
                count=0;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thousandth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static void stop(){
        working = false;
    }
    
}
