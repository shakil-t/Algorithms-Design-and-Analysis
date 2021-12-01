/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Scanner;



/**
 *
 * @author Shakila Tayefe
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    
    public static int[] a;
    public static boolean newBinarySearch(int low, int high, int x){
        int m1=(int)(low+high)/3;
        int m2=(int)2*(low+high)/3;
        if(low==high-1){
            return false;
        }
        if(x==a[m1] || x==a[m2]){
            //System.out.println(m1);
            //System.out.println(m2);
            return true;
        }else{
            if(x<a[m1] && x<a[m2]){
                return newBinarySearch(low, m1-1, x);
            }else{
                if(x>a[m1] && x<a[m2]){
                    return newBinarySearch(m1+1, m2-1, x);
                }else{
                    return newBinarySearch(m2+1, high, x);
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements:");
        n=input.nextInt();
        a=new int[n];
        Arrays.sort(a);
        //just for sure!
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        int x;
        System.out.println("Enter the number you're looking for:");
        x=input.nextInt();
        boolean searchResult=newBinarySearch(0, n-1, x);
        if(searchResult){
            System.out.println("Found");
        }else{
            System.out.println("Not Found!");
        }
}
}
