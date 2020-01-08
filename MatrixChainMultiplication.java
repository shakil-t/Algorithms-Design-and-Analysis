/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.chain.multiplication;

import java.util.Scanner;

/**
 *
 * @author shakil
 */
public class MatrixChainMultiplication {

    /**
     * @param args the command line arguments
     */
    public static void matrixChainMultiplication(int[] dimensions){
        int n=dimensions.length-1;
        int[][] D=new int[n][n];
        int[][] p=new int[n][n];
        for(int d=1;d<n;d++){
            for(int i=0;i<n-d;i++){
                D[i][i+d]=Integer.MAX_VALUE;
                for(int k=i;k<i+d;k++){
                    int temp=D[i][k]+D[k+1][i+d]+dimensions[i]*dimensions[k+1]*dimensions[i+d+1];
                    if(temp<D[i][i+d]){
                        D[i][i+d]=temp;
                        p[i][i+d]=k;
                    }
                }
            }
        }
        System.out.println("The amount of multiplication opearations:"+D[0][n-1]);
        printParentheses(p, 0, n-1);
        System.out.println();
    }
    public static void printParentheses(int[][] p, int i, int j) {
        if(i==j){
            System.out.print((i + 1));
        }else{
            System.out.print("(");
            printParentheses(p, i, p[i][j]);
	    printParentheses(p, p[i][j]+1, j);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of matrices:");
        n=input.nextInt();
        int[] dimensions=new int[n];
        System.out.println("Enter the dimensions respectively and note that row and column of two matrices must be equal in order to multiply them!");
        for(int i=0;i<n;i++){
            dimensions[i]=input.nextInt();
        }
        matrixChainMultiplication(dimensions);
    }
    
}
