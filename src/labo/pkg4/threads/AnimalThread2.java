/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo.pkg4.threads;

import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class AnimalThread2 extends Thread{
    private String nombre;
    private int limite,x1,y1;
    private JLabel animal;
    private JFrame frame;
    
    public AnimalThread2(){}
    public AnimalThread2(String nombre, int x1, int y1, int limite, JLabel animal, JFrame frame){
        this.nombre = nombre;
        this.x1=x1;
        this.y1=y1;
        this.limite=limite;
        this.animal=animal;
        this.frame=frame;
    }
    @Override
    public void run()
    {
        for (int i=x1; i<=this.limite;i+=25)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y1);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + "ha llegado a la meta");

        for (int i=this.limite; i>0;i-=25)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y1);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + "ha llegado al inicio");
        frame.dispose();
        yield();
    }
}
