/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author shakil
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Integer> l=new ArrayList<>();
    public static int findMax(int low, int high) {
        if(high-low==1){
            if(l.get(low)>l.get(high)){
                return l.get(low);
            }else{
                return l.get(high);
            }
        }
        int middle=(low+high)/2;
        int max1=findMax(low, middle);
        int max2=findMax(middle, high);
        if(max1>max2){
            return max1;
        }
        return max2;
    }
    public static int findMin(int low, int high) {
        if(high-low==1){
            if(l.get(low)<l.get(high)){
                return l.get(low);
            }else{
                return l.get(high);
            }
        }
        int middle=(low+high)/2;
        int min1=findMin(low, middle);
        int min2=findMin(middle, high);
        if(min1<min2){
            return min1;
        }
        return min2;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements:");
        n=scan.nextInt();
        System.out.println("Enter the number of elements:");
        while(n-->0){
            int element=scan.nextInt();
            l.add(element);
        }
        int maxValue=findMax(0, l.size()-1);
        int minValue=findMin(0, l.size()-1);
        System.out.println("Max value is: "+maxValue+"\n");
        System.out.println("Min value is: "+minValue);
}
}
