package search;
public class Node{
    
    public double f,g,h;
    public Node parent;
    public int x, y;
    
    public Node(double g, int x, int y){
        this.x = x;
        this.y = y;
        this.g = g;
        h = Math.sqrt(Math.pow(x - Solve.B.x, 2) + Math.pow(y - Solve.B.y, 2));
        this.f = this.h + this.g;
    }

    @Override
    public String toString(){
        return "Node: (" + x + " | " + y + " | f:" + f + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        Node n = (Node) obj;
        if(this.x == n.x && this.y == n.y){
            return true;
        }else{
            return false;
        }
    }
    
}
