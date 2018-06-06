/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo.pkg4.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import labo.pkg4.threads.AnimalThread;
import labo.pkg4.threads.AnimalThread2;
import labo.pkg4.threads.AnimalThread3;

/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame {
    private JLabel [] labels;
    
    private JButton inicio;
    
    private String[] nombres = {"canguro","tortuga","dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    
    private void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    
        labels=new JLabel[3];
        inicio=new JButton("inicio");
        Container container = getContentPane();
        
        for (int i=0;i<3;i++){
        
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);
        }
        inicio.setBounds(10,0,100,30);
        container.add(inicio);
        
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),labels[0].getY(),510,labels[0]);
                AnimalThread2 tortuga = new AnimalThread2("tortuga",labels[1].getX(),labels[1].getY(),510,labels[1],Gui.this);
                AnimalThread3 dragon = new AnimalThread3("dragon",labels[2].getX(),labels[2].getY(),510,labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });
        setSize(700,650);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Gui().setVisible(true);
            }
        });
    }
    
}
