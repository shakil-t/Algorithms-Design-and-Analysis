/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;



/**
 *
 * @author shakil
 */

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void floyd(int[][] adj, int vertices){
        int[][] next=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<next.length;j++){
                if(i!=j){
                    next[i][j]=j+1;
                }
            }
        }
        for(int k=0;k<vertices;k++){
            for(int i=0;i<vertices;i++){
                for(int j=0;j<vertices;j++){
                    if(adj[i][k]+adj[k][j]<adj[i][j]){
                        adj[i][j]=adj[i][k]+adj[k][j];
                        next[i][j]=next[i][k];
                    }
                }
            }
        }
        printResult(adj, next);
    }
    public static void printResult(int[][] adj, int[][] next){
        System.out.println("Vertices     "+"Distance"+"     Path");
        for(int i=0;i<next.length;i++){
            for(int j=0;j<next.length;j++){
                if(i!=j){
                    int u=i+1;
                    int v=j+1;
                    System.out.print(u+" ");
                    System.out.print(v);
                    System.out.print("     "+adj[i][j]+"     ");
                    do{
                        u=next[u-1][v-1];
                        System.out.print(u+" ");
                    }while(u!=v);
                    System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        int vertices;
        System.out.println("Enter the number of vertices:");
        vertices=scan.nextInt();
        int[][] adj=new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                adj[i][j]=Integer.MAX_VALUE;
            }
        }
        System.out.println("The adjacency matrix:");
        System.out.println("If there is no edge from vertice A to B enter -1!");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                int temp=scan.nextInt();
                if(temp!=-1){
                    adj[i][j]=temp;
                }
            }
        }
        floyd(adj, vertices);
    }
}
