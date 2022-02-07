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
        int[] input = readInput();
        

    }

    public static int[] readInput(){
        System.out.println("Passe a linha do tabuleiro e a coluna para selecionar peça: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toString();
        int lineFrom = input.charAt(0);
        int columnFrom = input.charAt(1);

        System.out.println("Passe a linha do tabuleiro e a coluna para mover a peça: ");
        Scanner scan2 = new Scanner(System.in);
        String input2 = scan2.nextLine().toString();
        int lineTo = input.charAt(0);
        int columnTo = input.charAt(1);
        
        return new int[] {lineFrom, columnFrom, lineTo, columnTo};
    }

    public static void displayBoard(){
        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    
}