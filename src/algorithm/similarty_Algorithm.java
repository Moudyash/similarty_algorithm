/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Medo
 */
public class similarty_Algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner input=new Scanner(System.in);
        details();
        String text1,text2;
        System.err.println("Enter first text");      
        text1=input.nextLine();
                System.err.println(ConsoleColors.GREEN+"Enter second text");      
                

        text2=input.nextLine();
        System.out.println(ConsoleColors.CYAN_BOLD+"1st text file:"+text1);
                TimeUnit.SECONDS.sleep(1); 

                System.out.println(ConsoleColors.RED_BOLD+"2ed text file:"+text2);
        TimeUnit.SECONDS.sleep(1); 

           double similarity = findSimilarity(text1,text2);
        TimeUnit.SECONDS.sleep(1); 

           System.out.println(ConsoleColors.BLUE_BOLD+"similarity: "+similarity);
        
        
    }
      private static void details() throws InterruptedException {
            System.out.println( ConsoleColors.GREEN+"information retrieval");
        TimeUnit.SECONDS.sleep(1); 
        System.out.println( ConsoleColors.BLUE_UNDERLINED+"similarty  Algorithm");
        TimeUnit.SECONDS.sleep(1); 

        System.out.println( ConsoleColors.RED+"Student Name: " + "Mohammed Yehia Ashour");
                TimeUnit.SECONDS.sleep(1);

        System.out.println(ConsoleColors.CYAN+ "Student ID: " + "1301195595");
        TimeUnit.SECONDS.sleep(1);
        
    }
       public static int getLevenshteinDistance(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
 
        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }
 
        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }
 
        return T[m][n];
    }
 
    public static double findSimilarity(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        
        double maxLength = Double.max(x.length(), y.length());
        if (maxLength > 0) {
            // optionally ignore case if needed
            return (maxLength - getLevenshteinDistance(x, y)) / maxLength;
        }
        return 1.0;
    }
}
