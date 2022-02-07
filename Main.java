import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;

class Main{
    public static String[][] board = {
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"p","p","p","p","p","p","p","p"},
        {"T","H","B","Q","K","B","H","T"},
    };
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toString();
        int line = Character.getNumericValue(input.charAt(0));
        int column = Character.getNumericValue(input.charAt(1));
        System.out.println(line);
        /*
        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }*/
        

    }
    
}