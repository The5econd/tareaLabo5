/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo.pkg4.threads;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class AnimalThread extends Thread {
    private String nombre;
    private int limite,x,y;
    private JLabel animal;
    private JFrame frame;
    
    public AnimalThread(){}
    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal){
        this.nombre = nombre;
        this.x=x;
        this.y=y;
        this.limite=limite;
        this.animal=animal;
        this.frame=frame;
    }
    @Override
    public void run()
    {
        for (int i=x; i<=this.limite;i+=60)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for (int i=this.limite; i>0;i-=60)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
        System.out.println(this.nombre + "ha llegado a la meta");
        //frame.dispose();
        yield();
    }
}
