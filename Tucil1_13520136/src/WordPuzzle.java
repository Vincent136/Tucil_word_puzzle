import java.io.*;
import java.util.Scanner;

public class WordPuzzle {
    private static final Scanner keyboard_scanner = new Scanner(System.in);

    static Scanner s = null;

    public static int[] RowNColCount(String FileName)
    {
        try {
            s = new Scanner(new File("../test/"+FileName));
            String RRows = s.nextLine();
            RRows = RRows.replaceAll("\\s","");
            
            int Rows = 0;
            
            String line = "dummy";
            while(s.hasNextLine() && line != "") {
                Rows++;
                line = s.nextLine();
            }
            s.nextLine();

            int total_words=1;

            while(s.hasNextLine()) {
                total_words++;
                s.nextLine();
            }

            s.close();

            int Cols = RRows.length();

            int[] Result = new int[3];

            Result[0] = Rows;
            Result[1] = Cols;
            Result[2] = total_words;

            return Result;
        } catch(Exception e) {
            int[] Result = new int[1];
            Result[0] = -1;
            s.close();
            return Result;
        }
    }

    public static void ReadPuzzle(String FileName,char[][]puzzle, String[] words)
    {
        try{
            s = new Scanner(new File("../test/"+FileName));

            int Rows = puzzle.length;
            int Cols = puzzle[0].length;

            int count = 0;
            int count2 = 0;

            while(s.hasNextLine())
            {
                int countL = 0;
                String str = s.nextLine();
                str = str.replaceAll("\\s","");
                if(count < Rows){
                    while (countL < Cols) {
                        puzzle[count][countL] = str.charAt(countL);
                        countL++;
                    } 
                    count++;
                } else 
                {
                    if (str != "")
                    {
                        words[count2] = str;
                        count2++;
                    }
                }
            }
            
        } catch (Exception e){

        }
    }

    public static void print2D(char mat[][])
    {
        for (int i = 0; i < mat.length; i++){
 
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void PuzzleOutput(int[][]arr, char[][]puzzle)
    {
        for (int x=0; x < puzzle.length; x++) {
            for (int y=0; y < puzzle[0].length; y++) {
                if(arr[x][y] == 1)
                {
                    System.out.print(puzzle[x][y] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void TurnToZero(int[][]arr)
    {
        for (int row = 0; row < arr.length; row++)
        {
            for (int col = 0; col < arr[row].length; col++)
            {
                arr[row][col] = 0; 
            }
        }
    }

    public static int BruteForceWordPuzzle(char[][]puzzle,String[]words, int[][]Result)
    {
        int Rows = puzzle.length;
        int Cols = puzzle[0].length;
        int Pwords = words.length;
        int TotalCompare = 0;

        for (int i=0; i < Pwords ; i++){
            int Pword = words[i].length();
            for (int j=0; j < Rows; j++){
                for (int k=0; k < Cols; k++){
                    if(words[i].charAt(0) == puzzle[j][k]){
                        boolean Found = false;
                        int m;
                        int n;
                        int counter;

                        // cek ke atas
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k; 
                            while(m != 0 && counter < Pword) {
                                m--;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m--;
                                    counter++;
                                }

                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kiri
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k; 
                            while(n != 0 && counter < Pword) {
                                n--;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    n--;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke bawah
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(m != Rows-1 && counter < Pword) {
                                m++;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                } 
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m++;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kanan
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(n != Cols-1 && counter < Pword) {
                                n++;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    n++;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kiri atas
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(n != 0 && m != 0 && counter < Pword) {
                                m--;
                                n--;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m--;
                                    n--;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kiri bawah
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(n != 0 && m != Rows-1 && counter < Pword) {
                                m++;
                                n--;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                } 
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m++;
                                    n--;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kanan bawah
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(n != Cols-1 && m != Rows-1 && counter < Pword) {
                                m++;
                                n++;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m++;
                                    n++;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }

                        // cek ke kanan atas
                        if(!Found){
                            counter = 1;  
                            m = j;
                            n = k;   
                            while(n != Cols-1 && m != 0 && counter < Pword) {
                                m--;
                                n++;
                                if (words[i].charAt(counter) != puzzle[m][n]) {
                                    TotalCompare++;
                                    break;
                                }
                                TotalCompare++;
                                counter++;
                            }
                            if(counter == Pword) {
                                counter = 0;
                                System.out.println(words[i]);

                                int [][]arr = new int[Rows][Cols];
                                
                                TurnToZero(arr);

                                m = j;
                                n = k;
                                while(counter < Pword) {
                                    arr[m][n] = 1;
                                    m--;
                                    n++;
                                    counter++;
                                }
                                
                                PuzzleOutput(arr,puzzle);
                            }
                        }
                    }
                    TotalCompare++;
                }
            }
        }
        return TotalCompare;
    }
    public static void main(String[] args){
        System.out.print("Masukkan nama file: ");
        String FileName = keyboard_scanner.next();
        System.out.println();

        int[] RC = RowNColCount(FileName);
        char[][] puzzle = new char[RC[0]][RC[1]];
        String[] words = new String[RC[2]];
        int[][] Result = new int[RC[2]][4];

        ReadPuzzle(FileName, puzzle, words);

        long StartTime = System.currentTimeMillis();
        int TotalCompare = BruteForceWordPuzzle(puzzle, words, Result);
        long StopTime = System.currentTimeMillis();

        System.out.println("");

        System.out.println("Execution time: " + (StopTime - StartTime) + " ms");

        System.out.print("Total Comparison: " + TotalCompare);
    }
}
