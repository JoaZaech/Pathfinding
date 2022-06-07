/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Joalu
 */
public class Panel extends javax.swing.JPanel {

    Solve s;
    ArrayList<Point> weg;
    
    public Panel() {
        s = new Solve();
        weg = s.berechneWeg();
        initComponents();
    }
public void paintComponent(Graphics g){
        super.paintComponent(g);
        zeichneGrid(g);
        zeichneWeg(g);
        zeichnePunkt(g);
    }
    
    public void zeichneGrid(Graphics g){
        for (int i = 0; i < 10; i++) {
            g.setColor(Color.black);
            g.drawLine(i * 50, 0, i * 50, 500);  
            g.drawLine(0, i * 50, 500, i * 50);
        }
       for (int i = 0; i < Solve.Karte[0].length; i++) {
           for (int j = 0; j < Solve.Karte.length; j++) {
                if(Solve.Karte[j][i] == 1){
                    g.setColor(Color.black);
                    g.fillRect(j*50,i*50,50,50);
                }
           }
        }
    }
    
    public void zeichnePunkt(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(Solve.A.x * 50, Solve.A.y*50, 50,50);
        g.setColor(Color.red);
        g.fillRect(Solve.B.x * 50, Solve.B.y*50, 50,50);
    }
    
    public void zeichneWeg(Graphics g){
        for (Point n : weg) {
            g.setColor(Color.green);
            g.fillRect(n.x*50, n.y*50, 50, 50);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
