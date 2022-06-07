package search;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solve {

    public static Point A, B;
    public static int[][] Karte;
    private ArrayList<Node> offeneListe;
    private ArrayList<Node> geschlosseneListe;

    public Solve() {
        A = new Point(0, 0);
        B = new Point(8, 8);
        Karte = new readMaze("Maze/test.txt").getMaze();
        offeneListe = new ArrayList();
        geschlosseneListe = new ArrayList();
    }

    public ArrayList<Point> berechneWeg() {
        offeneListe.add(new Node(0, A.x, A.y));

        while (!offeneListe.isEmpty()) {
            // Lowest f Score Node
            Node current = offeneListe.get(0);
            
            for (Node n : offeneListe) {
                if(current.f > n.f){
                    current = n;
                }
            }
            
            offeneListe.remove(current);
            geschlosseneListe.add(current);

            // Wenn Ziel erreicht, Methode zu Ende
            if (current.x == B.x && current.y == B.y) {

                return Pfadfinden(current);

            }

            ArrayList<Node> Nachbarn = gibNachbarn(current);

            for (Node n : Nachbarn) {
                if (geschlosseneListe.contains(n)) {
                    continue;
                }
                if (offeneListe.contains(n)) {
                    
                    int index = offeneListe.indexOf(n);
                    Node oldNode = offeneListe.get(index);
                    if(n.g < oldNode.g){
                        oldNode = n;
                    }else{
                        continue; 
                    }
                }

                offeneListe.add(n);
                n.parent = current;

            }

        }
        return null;
    }

    private ArrayList<Point> Pfadfinden(Node goal) {
        ArrayList<Point> data = new ArrayList();
        Node tmp = goal;
        data.add(new Point(tmp.x,tmp.y));
        while(tmp.parent != null){
            data.add(new Point(tmp.parent.x, tmp.parent.y));
            //System.out.println(tmp.g);
            tmp = tmp.parent;
        }
        return data;
    }

    private ArrayList<Node> gibNachbarn(Node current) {
        ArrayList<Node> Nachbarn = new ArrayList();

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                // Wenn Position die jetzigen gleicht 
                if (x == 0 && y == 0) {
                    continue;
                }

                int checkX = current.x + x;
                int checkY = current.y + y;

                // Check ob die Node ausserhalb der Karte sind: 
                if (checkX >= 0 && checkX < Karte.length && checkY >= 0 && checkY < Karte[0].length) {
                    if (Karte[checkX][checkY] != 1) {
                        Nachbarn.add(new Node(current.g + gibDistanz(current, checkX, checkY), checkX, checkY));
                    }
                }

            }
        }

        return Nachbarn;
    }

    private double gibDistanz(Node current, int x, int y) {
        return Math.sqrt(Math.pow(current.x - x, 2) + Math.pow(current.y - y, 2));
    }
}
