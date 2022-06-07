package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readMaze {
    
    private int[][] maze;
    
    public readMaze(String Pfad){
        maze = new int[10][10];
        try{
            Scanner r = new Scanner(new File(Pfad));
                for (int i = 0; r.hasNextLine(); i++) {
                    char[] chars = r.nextLine().toCharArray(); 
                    for (int j = 0; j < chars.length; j++) {
                        maze[j][i] = Character.getNumericValue(chars[j]);
                    }
                }
            r.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public int[][] getMaze(){
        return maze;
    }
    
}
