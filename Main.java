import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;

class Main{
    public static String[][] board = {
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","P","T","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","P","P","P","P","P","P","P"},
        {"-","H","B","Q","K","B","H","T"},
    };
    public static void main(String[] args){
        displayBoard();
        int[] input = readInput();
        verifyMove(input);
        displayBoard();

    }

    public static int[] readInput(){
        System.out.println("Passe a linha do tabuleiro e a coluna para selecionar peça: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toString();
        int lineFrom = Character.getNumericValue(input.charAt(0));
        int columnFrom = Character.getNumericValue(input.charAt(1));
        lineFrom = lineFrom -1;
        columnFrom = columnFrom -1;

        System.out.println("Passe a linha do tabuleiro e a coluna para mover a peça: ");
        Scanner scan2 = new Scanner(System.in);
        String input2 = scan2.nextLine().toString();
        int lineTo = Character.getNumericValue(input2.charAt(0));
        int columnTo = Character.getNumericValue(input2.charAt(1));
        lineTo = lineTo -1;
        columnTo = columnTo -1;

        System.out.println(lineFrom);
        System.out.println(columnFrom);
        System.out.println(lineTo);
        System.out.println(columnTo);
        return new int[] {lineFrom, columnFrom, lineTo, columnTo};
    }

    public static void displayBoard(){
        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void verifyMove(int[] arr){
        // pawn
        if (board[arr[0]][arr[1]] == "P"){
            if (arr[2] == arr[0]-1 && arr[3] == arr[1]){
                board[arr[2]][arr[3]] = "P";
                board[arr[0]][arr[1]] = "-";
            }
        }
        // tower
        if (board[arr[0]][arr[1]] == "T"){
            boolean flag = false;
            if (arr[1]<arr[3] || arr[2]<arr[0]){
                if (arr[2] == arr[0] && arr[3] != arr[1]){
                    for (int i = arr[1];i<arr[3];i++){
                        if (board[arr[0]][i] != "-"){
                            flag = true;
                        }
                    }
                    if (!flag){
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
                if (arr[2] != arr[0] && arr[3] == arr[1]){
                    for (int i = arr[2];i<arr[0];i++){
                        if (board[i][arr[1]] != "-"){
                            flag = true;
                        }
                        
                    }
                    if (!flag){
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            if (arr[1]>arr[3] || arr[2]>arr[0]){
                if (arr[2] == arr[0] && arr[3] != arr[1]){
                    for (int i = arr[3];i<arr[1];i++){
                        if (board[arr[0]][i] != "-"){
                            flag = true;
                        }
                    }
                    if (!flag){
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
                if (arr[2] != arr[0] && arr[3] == arr[1]){
                    for (int i = arr[2];i<arr[0];i++){
                        if (board[i][arr[1]] != "-"){
                            flag = true;
                        }
                        
                    }
                    if (!flag){
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            
        }
        
    }
    
}