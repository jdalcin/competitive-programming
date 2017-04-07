import java.io.*;
import java.util.*;

/*------------------
 * Author: Jeremy Dalcin
 * Class:finds the greatest sum of all hourglass shapes in a 6 X 6 array
 -----------------*/

public class tutorial19 {

    public static void main(String[] args) {
        
        //Scanner sc = new Scanner(System.in);
        int[][] multiArray = new int[6][6];
        
        //fills up multidimensional array with inputs
        for(int i = 0; i < multiArray.length; i++ ){
            for(int j = 0; j < multiArray[i].length; j++){
                multiArray[i][j] = (int) (10* Math.random() );
            }
        //sc.nextLine();
        }
        /*
        System.out.println();
        for(int[] row : multiArray){
            for(int column : row){
                System.out.print(column + " ");
            }
        System.out.println();
        }
        */
        
        int biggest = Integer.MIN_VALUE;
        int hourglass = 0;
        
        for(int i = 1; i < (multiArray.length-1); i++){
        	
        	// vertical hourglass
        	for(int j = 1; j < (multiArray[i].length-1); j++){
        		hourglass = multiArray[i][j] + multiArray[i-1][j] + multiArray[i-1][j-1] + multiArray[i-1][j+1] + multiArray[i+1][j] + multiArray[i+1][j-1] + multiArray[i+1][j+1];;
        		
        		if (biggest < hourglass){
            		biggest = hourglass;
            	}
        	hourglass = 0;
        	}
        	
        	//horizontal hourglass
        	for(int j = 1; j < (multiArray[i].length-1); j++){
        		hourglass = multiArray[i][j] + multiArray[i][j-1] + multiArray[i-1][j-1] + multiArray[i+1][j-1] + multiArray[i][j+1] + multiArray[i-1][j+1] + multiArray[i+1][j+1];;
        		
        		if (biggest < hourglass){
            		biggest = hourglass;
            	}
        	hourglass = 0;
        	}
        	
        }
        
      //diagnol hourglasses 
        for(int i = 2; i < 4; i++){
        	//northwest diagnols
        	for(int j = 2; j < 4; j++){
        		hourglass = multiArray[i][j] + multiArray[i-1][j-1] + multiArray[i-2][j] + multiArray[i][j-2] + multiArray[i+1][j+1] + multiArray[i+2][j] + multiArray[i][j+2];;
        		
        		if (biggest < hourglass){
            		biggest = hourglass;
            	}
        	hourglass = 0;
        	}
        	//northeast diagnols
        	for(int j = 2; j < 4; j++){
        		hourglass = multiArray[i][j] + multiArray[i+1][j-1] + multiArray[i][j-2] + multiArray[i+2][j] + multiArray[i-1][j+1] + multiArray[i-2][j] + multiArray[i][j+2];;
        		
        		if (biggest < hourglass){
            		biggest = hourglass;
            	}
        	hourglass = 0;
        	}
        }
    	        
   System.out.print(biggest);
            
   }
            
}
