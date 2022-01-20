import java.io.*;
import java.util.Scanner;

public class ReadFile {
    private static final Scanner keyboard_scanner = new Scanner(System.in);

    static Scanner s = null;

    public static int[] RowNColCount(String FileName)
    {
        try {
            s = new Scanner(new File(FileName));
            String[] RRows = s.nextLine().split(" ");
            
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

            int Cols = RRows.length;

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
            s = new Scanner(new File(FileName));

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

    public static void BruteForceWordPuzzle(char[][]puzzle,String[]words)
    {
        int Rows = puzzle.length;
        int Cols = puzzle[0].length;
        int Pwords = words.length;

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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
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
                                    break;
                                }
                                counter++;
                            }
                            if(counter == Pword) {
                                System.out.print(words[i]);
                                System.out.println(" Ketemu!");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] RC = RowNColCount("test.txt");

        char[][] puzzle = new char[RC[0]][RC[1]];
        String[] words = new String[RC[2]];

        ReadPuzzle("test.txt", puzzle, words);

        BruteForceWordPuzzle(puzzle, words);
    }
}
