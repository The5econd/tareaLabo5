/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo.pkg4.threads;

import javax.swing.JLabel;

/**
 *
 * @author LN710Q
 */
public class AnimalThread3 extends Thread {
    private String nombre;
    private int limite,x2,y2;
    private JLabel animal;
    
    public AnimalThread3(){}
    public AnimalThread3(String nombre, int x2, int y2, int limite, JLabel animal){
        this.nombre = nombre;
        this.x2=x2;
        this.y2=y2;
        this.limite=limite;
        this.animal=animal;
    }
    @Override
    public void run()
    {
        for (int i=x2; i<=this.limite;i+=90)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y2);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for (int i=this.limite; i>0;i-=90)
        {
            System.out.println(this.nombre + "  avanza");
            this.animal.setLocation(i,y2);
            try{
                sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + "ha llegado a la meta");
        yield();
    }
}
