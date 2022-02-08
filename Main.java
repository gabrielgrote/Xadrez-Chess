import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static String[][] board = {
        {"t","h","b","q","k","b","h","t"},
        {"p","p","p","p","p","p","p","p"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"-","-","-","-","-","-","-","-"},
        {"P","P","P","P","P","P","P","P"},
        {"T","H","B","Q","K","B","H","T"},
    };
    public static void main(String[] args){
        boolean kingDead = verifyIsKingDead();
        while(!kingDead){
            displayBoard();
            int[] input = readInput();
            verifyMove(input);
            displayBoard();
            int[] input2 = readInputEnemy();
            verifyMoveEnemy(input2);
            kingDead = verifyIsKingDead();
        }
        

    }

    public static boolean verifyIsKingDead(){
        boolean isKingDead = true;
        boolean kingFriend = true;
        boolean kingFoe = true;
        for (int i = 0; i<=7;i++){
            for (int j = 0;j<=7;j++){
                if (board[i][j]=="K"){
                    kingFriend = false;
                }
                if (board[i][j]=="k"){
                    kingFoe = false;
                }
            }
        }
        if (kingFriend||kingFoe){
            isKingDead = true;
        }else {
            isKingDead = false;
        }
        return isKingDead;
    }

    public static int[] readInputEnemy(){
        System.out.println("JOGADOR 2: Passe a linha do tabuleiro e a coluna para selecionar peça (exemplo: 52): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toString();
        int lineFrom = Character.getNumericValue(input.charAt(0));
        int columnFrom = Character.getNumericValue(input.charAt(1));
        lineFrom = lineFrom -1;
        columnFrom = columnFrom -1;

        System.out.println("JOGADOR 2: Passe a linha do tabuleiro e a coluna para mover a peça (exemplo: 36): ");
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

    public static int[] readInput(){
        System.out.println("JOGADOR 1: Passe a linha do tabuleiro e a coluna para selecionar peça (exemplo: 52): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toString();
        int lineFrom = Character.getNumericValue(input.charAt(0));
        int columnFrom = Character.getNumericValue(input.charAt(1));
        lineFrom = lineFrom -1;
        columnFrom = columnFrom -1;

        System.out.println("JOGADOR 1: Passe a linha do tabuleiro e a coluna para mover a peça (exemplo: 36): ");
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
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]+1 && (board[arr[2]][arr[3]]=="p"||board[arr[2]][arr[3]]=="t"||board[arr[2]][arr[3]]=="h"||board[arr[2]][arr[3]]=="b"||board[arr[2]][arr[3]]=="q"||board[arr[2]][arr[3]]=="k")){
                board[arr[2]][arr[3]] = "P";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]-1 && (board[arr[2]][arr[3]]=="p"||board[arr[2]][arr[3]]=="t"||board[arr[2]][arr[3]]=="h"||board[arr[2]][arr[3]]=="b"||board[arr[2]][arr[3]]=="q"||board[arr[2]][arr[3]]=="k")){
                board[arr[2]][arr[3]] = "P";
                board[arr[0]][arr[1]] = "-";
            }else{
                System.out.println("Jogada invalida");
            }
        }
        // tower
        if (board[arr[0]][arr[1]] == "T"){
            
            // vai pra cima
            if (arr[0]>arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]-1;i>=arr[2];i--){
                    if (board[i][arr[1]]=="P"||board[i][arr[1]]=="T"||board[i][arr[1]]=="H"||board[i][arr[1]]=="Q"||board[i][arr[1]]=="K"||board[i][arr[1]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra baixo
            if (arr[0]<arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]+1;i<=arr[2];i++){
                    if (board[i][arr[1]]=="P"||board[i][arr[1]]=="T"||board[i][arr[1]]=="H"||board[i][arr[1]]=="Q"||board[i][arr[1]]=="K"||board[i][arr[1]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra direita
            if (arr[1]<arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]+1;i<=arr[3];i++){
                    if (board[arr[0]][i]=="P"||board[i][arr[0]]=="T"||board[i][arr[0]]=="H"||board[i][arr[0]]=="Q"||board[i][arr[0]]=="K"||board[i][arr[0]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra esquerda
            if (arr[1]>arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]-1;i>=arr[3];i--){
                    if (board[arr[0]][i]=="P"||board[i][arr[0]]=="T"||board[i][arr[0]]=="H"||board[i][arr[0]]=="Q"||board[i][arr[0]]=="K"||board[i][arr[0]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "T";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            
            
        }
        // horse
        if (board[arr[0]][arr[1]] == "H"){
            if (arr[2]==arr[0]-2 && arr[3]==arr[1]+1){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]+2){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]+2){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+2 && arr[3]==arr[1]+1){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+2 && arr[3]==arr[1]-1){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]-2){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]-2){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-2 && arr[3]==arr[1]-1){
                board[arr[2]][arr[3]] = "H";
                board[arr[0]][arr[1]] = "-";
            }else{
                System.out.println("Jogada invalida");
            }

        }
        // bishop
        if (board[arr[0]][arr[1]] == "B"){
            boolean flag = true;
            int longestLength;
            if (arr[2]>arr[3]){
                longestLength = arr[2];
            }else {
                longestLength = arr[3];
            }
            if (arr[2] >= 8 || arr[3]>=8){
                System.out.println("Jogada invalida");
            }else{
                if (arr[2]>arr[0] && arr[3]>arr[1]){

                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]+i] == "P"||board[arr[0]+1][i] == "T"||board[arr[0]+1][i] == "H"||board[arr[0]+1][i] == "B"||board[arr[0]+1][i] == "Q"||board[arr[0]+1][i] == "K"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "B";
                            board[arr[0]][arr[1]] = "-";
                        }
                    }
                    
                    
                }
                if (arr[2]>arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]-i] == "P"||board[arr[0]+1][i] == "T"||board[arr[0]+1][i] == "H"||board[arr[0]+1][i] == "B"||board[arr[0]+1][i] == "Q"||board[arr[0]+1][i] == "K"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "B";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]-i][arr[1]-i] == "P"||board[arr[0]+1][i] == "T"||board[arr[0]+1][i] == "H"||board[arr[0]+1][i] == "B"||board[arr[0]+1][i] == "Q"||board[arr[0]+1][i] == "K"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "B";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]>arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (arr[0]-i<0){
                            i=0;
                        }
                        if (board[arr[0]-i][arr[1]+i] == "P"||board[arr[0]+1][i] == "T"||board[arr[0]+1][i] == "H"||board[arr[0]+1][i] == "B"||board[arr[0]+1][i] == "Q"||board[arr[0]+1][i] == "K"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "B";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }  
            }
             
        }
        // queen
        if (board[arr[0]][arr[1]]=="Q"){
            boolean flag = true;
            int longestLength;
            if (arr[2]>arr[3]){
                longestLength = arr[2];
            }else {
                longestLength = arr[3];
            }
            if (arr[2] >= 8 || arr[3]>=8){
                System.out.println("Jogada invalida");
            }else{
                if (arr[2]>arr[0] && arr[3]>arr[1]){

                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]+i] != "-"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "Q";
                            board[arr[0]][arr[1]] = "-";
                        }
                    }
                    
                    
                }
                if (arr[2]>arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]-i] != "-"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "Q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]-i][arr[1]-i] != "-"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "Q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]>arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (arr[0]-i<0){
                            i=0;
                        }
                        if (board[arr[0]-i][arr[1]+i] != "-"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "Q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }  
            }
            // vai pra cima
            if (arr[0]>arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]-1;i>=arr[2];i--){
                    if (board[i][arr[1]]=="P"||board[i][arr[1]]=="T"||board[i][arr[1]]=="H"||board[i][arr[1]]=="Q"||board[i][arr[1]]=="K"||board[i][arr[1]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "Q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra baixo
            if (arr[0]<arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]+1;i<=arr[2];i++){
                    if (board[i][arr[1]]=="P"||board[i][arr[1]]=="T"||board[i][arr[1]]=="H"||board[i][arr[1]]=="Q"||board[i][arr[1]]=="K"||board[i][arr[1]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "Q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra direita
            if (arr[1]<arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]+1;i<=arr[3];i++){
                    if (board[arr[0]][i]=="P"||board[i][arr[0]]=="T"||board[i][arr[0]]=="H"||board[i][arr[0]]=="Q"||board[i][arr[0]]=="K"||board[i][arr[0]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "Q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra esquerda
            if (arr[1]>arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]-1;i>=arr[3];i--){
                    if (board[arr[0]][i]=="P"||board[i][arr[0]]=="T"||board[i][arr[0]]=="H"||board[i][arr[0]]=="Q"||board[i][arr[0]]=="K"||board[i][arr[0]]=="B"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "Q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            
        }
        // king
        if (board[arr[0]][arr[1]]=="K"){
            // verifica se to place é correto
            if (board[arr[2]][arr[3]] == "p"||board[arr[2]][arr[3]] == "t"||board[arr[2]][arr[3]] == "h"||board[arr[2]][arr[3]] == "b"||board[arr[2]][arr[3]] == "q"||board[arr[2]][arr[3]] == "k"||board[arr[2]][arr[3]] == "-"){
                // vai pra cima
                if (arr[2]==arr[0]-1 && arr[3]==arr[1]){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai pra baixo
                if (arr[2]==arr[0]+1 && arr[3]==arr[1]){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai pra direita
                if (arr[2]==arr[0] && arr[3]==arr[1]+1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai pra esquerda
                if (arr[2]==arr[0] && arr[3]==arr[1]-1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                
                // vai up right
                if (arr[2]==arr[0]-1 && arr[3]==arr[1]+1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai down right
                if (arr[2]==arr[0]+1 && arr[3]==arr[1]+1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai down left
                if (arr[2]==arr[0]+1 && arr[3]==arr[1]-1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
                // vai up left
                if (arr[2]==arr[0]-1 && arr[3]==arr[1]-1){
                    board[arr[2]][arr[3]] = "K";
                    board[arr[0]][arr[1]] = "-";
                }
            
            
            }
        
        }
    
        
    }

    public static void verifyMoveEnemy(int[] arr){
        // pawn
        if (board[arr[0]][arr[1]] == "p"){
            if (arr[2] == arr[0]+1 && arr[3] == arr[1]){
                board[arr[2]][arr[3]] = "p";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]+1 && (board[arr[2]][arr[3]]=="P"||board[arr[2]][arr[3]]=="T"||board[arr[2]][arr[3]]=="H"||board[arr[2]][arr[3]]=="B"||board[arr[2]][arr[3]]=="Q"||board[arr[2]][arr[3]]=="K")){
                board[arr[2]][arr[3]] = "p";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]-1 && (board[arr[2]][arr[3]]=="P"||board[arr[2]][arr[3]]=="T"||board[arr[2]][arr[3]]=="H"||board[arr[2]][arr[3]]=="B"||board[arr[2]][arr[3]]=="Q"||board[arr[2]][arr[3]]=="K")){
                board[arr[2]][arr[3]] = "p";
                board[arr[0]][arr[1]] = "-";
            }else{
                System.out.println("Jogada invalida");
            }
        }
        // tower
        if (board[arr[0]][arr[1]] == "t"){
            
            // vai pra cima
            if (arr[0]>arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]-1;i>=arr[2];i--){
                    if (board[i][arr[1]]=="p"||board[i][arr[1]]=="t"||board[i][arr[1]]=="h"||board[i][arr[1]]=="q"||board[i][arr[1]]=="k"||board[i][arr[1]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "t";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra baixo
            if (arr[0]<arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]+1;i<=arr[2];i++){
                    if (board[i][arr[1]]=="p"||board[i][arr[1]]=="t"||board[i][arr[1]]=="h"||board[i][arr[1]]=="q"||board[i][arr[1]]=="k"||board[i][arr[1]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "t";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra direita
            if (arr[1]<arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]+1;i<=arr[3];i++){
                    if (board[arr[0]][i]=="p"||board[i][arr[0]]=="t"||board[i][arr[0]]=="h"||board[i][arr[0]]=="q"||board[i][arr[0]]=="k"||board[i][arr[0]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "t";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra esquerda
            if (arr[1]>arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]-1;i>=arr[3];i--){
                    if (board[arr[0]][i]=="p"||board[i][arr[0]]=="t"||board[i][arr[0]]=="h"||board[i][arr[0]]=="q"||board[i][arr[0]]=="k"||board[i][arr[0]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "t";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            
            
        }
        // horse
        if (board[arr[0]][arr[1]] == "h"){
            if (arr[2]==arr[0]-2 && arr[3]==arr[1]+1){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]+2){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]+2){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+2 && arr[3]==arr[1]+1){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+2 && arr[3]==arr[1]-1){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]+1 && arr[3]==arr[1]-2){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-1 && arr[3]==arr[1]-2){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else if (arr[2]==arr[0]-2 && arr[3]==arr[1]-1){
                board[arr[2]][arr[3]] = "h";
                board[arr[0]][arr[1]] = "-";
            }else{
                System.out.println("Jogada invalida");
            }

        }
        // bishop
        if (board[arr[0]][arr[1]] == "b"){
            boolean flag = true;
            int longestLength;
            if (arr[2]>arr[3]){
                longestLength = arr[2];
            }else {
                longestLength = arr[3];
            }
            if (arr[2] >= 8 || arr[3]>=8){
                System.out.println("Jogada invalida");
            }else{
                if (arr[2]>arr[0] && arr[3]>arr[1]){

                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]+i] == "p"||board[arr[0]+1][i] == "t"||board[arr[0]+1][i] == "h"||board[arr[0]+1][i] == "b"||board[arr[0]+1][i] == "q"||board[arr[0]+1][i] == "k"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "b";
                            board[arr[0]][arr[1]] = "-";
                        }
                    }
                    
                    
                }
                if (arr[2]>arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]-i] == "p"||board[arr[0]+1][i] == "t"||board[arr[0]+1][i] == "h"||board[arr[0]+1][i] == "b"||board[arr[0]+1][i] == "q"||board[arr[0]+1][i] == "k"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "b";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]-i][arr[1]-i] == "p"||board[arr[0]+1][i] == "t"||board[arr[0]+1][i] == "h"||board[arr[0]+1][i] == "b"||board[arr[0]+1][i] == "q"||board[arr[0]+1][i] == "k"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "b";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]>arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (arr[0]-i<0){
                            i=0;
                        }
                        if (board[arr[0]-i][arr[1]+i] == "p"||board[arr[0]+1][i] == "t"||board[arr[0]+1][i] == "h"||board[arr[0]+1][i] == "b"||board[arr[0]+1][i] == "q"||board[arr[0]+1][i] == "k"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "b";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }  
            }
             
        }
        // queen
        if (board[arr[0]][arr[1]]=="q"){
            boolean flag = true;
            int longestLength;
            if (arr[2]>arr[3]){
                longestLength = arr[2];
            }else {
                longestLength = arr[3];
            }
            if (arr[2] >= 8 || arr[3]>=8){
                System.out.println("Jogada invalida");
            }else{
                if (arr[2]>arr[0] && arr[3]>arr[1]){

                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]+i] != "-"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "q";
                            board[arr[0]][arr[1]] = "-";
                        }
                    }
                    
                    
                }
                if (arr[2]>arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]+i][arr[1]-i] != "-"){
                            break;
                        }
                        if (arr[0]+i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]<arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (board[arr[0]-i][arr[1]-i] != "-"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]-i == arr[3]){
                            board[arr[2]][arr[3]] = "q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }
                if (arr[2]<arr[0] && arr[3]>arr[1]){
                    
                    for (int i = 1;i<longestLength;i++){
                        if (arr[0]-i<0){
                            i=0;
                        }
                        if (board[arr[0]-i][arr[1]+i] != "-"){
                            break;
                        }
                        if (arr[0]-i == arr[2] && arr[1]+i == arr[3]){
                            board[arr[2]][arr[3]] = "q";
                            board[arr[0]][arr[1]] = "-";
                            
                        }
                    }
                }  
            }
            // vai pra cima
            if (arr[0]>arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]-1;i>=arr[2];i--){
                    if (board[i][arr[1]]=="p"||board[i][arr[1]]=="t"||board[i][arr[1]]=="h"||board[i][arr[1]]=="q"||board[i][arr[1]]=="k"||board[i][arr[1]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra baixo
            if (arr[0]<arr[2]){
                // verifica se tem sugeira no caminho
                for (int i=arr[0]+1;i<=arr[2];i++){
                    if (board[i][arr[1]]=="p"||board[i][arr[1]]=="t"||board[i][arr[1]]=="h"||board[i][arr[1]]=="q"||board[i][arr[1]]=="k"||board[i][arr[1]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[2]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra direita
            if (arr[1]<arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]+1;i<=arr[3];i++){
                    if (board[arr[0]][i]=="p"||board[i][arr[0]]=="t"||board[i][arr[0]]=="h"||board[i][arr[0]]=="q"||board[i][arr[0]]=="k"||board[i][arr[0]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            // vai pra esquerda
            if (arr[1]>arr[3]){
                // verifica se tem sugeira no caminho
                for (int i=arr[1]-1;i>=arr[3];i--){
                    if (board[arr[0]][i]=="p"||board[i][arr[0]]=="t"||board[i][arr[0]]=="h"||board[i][arr[0]]=="q"||board[i][arr[0]]=="k"||board[i][arr[0]]=="b"){
                        break;
                    // se ultimo index for igual ao selecionado para mover peça
                    }else if (i == arr[3]){
                        // aloca peça
                        board[arr[2]][arr[3]] = "q";
                        board[arr[0]][arr[1]] = "-";
                    }
                }
            }
            
        }
            // king
            if (board[arr[0]][arr[1]]=="k"){
                // verifica se to place é correto
                if (board[arr[2]][arr[3]] == "P"||board[arr[2]][arr[3]] == "T"||board[arr[2]][arr[3]] == "H"||board[arr[2]][arr[3]] == "B"||board[arr[2]][arr[3]] == "Q"||board[arr[2]][arr[3]] == "K"||board[arr[2]][arr[3]] == "-"){
                    // vai pra cima
                    if (arr[2]==arr[0]-1 && arr[3]==arr[1]){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai pra baixo
                    if (arr[2]==arr[0]+1 && arr[3]==arr[1]){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai pra direita
                    if (arr[2]==arr[0] && arr[3]==arr[1]+1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai pra esquerda
                    if (arr[2]==arr[0] && arr[3]==arr[1]-1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    
                    // vai up right
                    if (arr[2]==arr[0]-1 && arr[3]==arr[1]+1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai down right
                    if (arr[2]==arr[0]+1 && arr[3]==arr[1]+1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai down left
                    if (arr[2]==arr[0]+1 && arr[3]==arr[1]-1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
                    // vai up left
                    if (arr[2]==arr[0]-1 && arr[3]==arr[1]-1){
                        board[arr[2]][arr[3]] = "k";
                        board[arr[0]][arr[1]] = "-";
                    }
        
        
    }
    
}
}
}