/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



/**
 *
 * @author shakil
 */
class MyComparator implements Comparator<Entry<Integer, Double>> {
  public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
    return o1.getValue().compareTo(o2.getValue());
  }
}

class Util {
  public static HashMap<Integer, Double> sortByComparator(
      Map<Integer, Double> unsortMap){
    List<Entry<Integer, Double>> list=new LinkedList<Entry<Integer, Double>>(
        unsortMap.entrySet());
    Collections.sort(list, new MyComparator());
    HashMap<Integer, Double> sortedMap=new LinkedHashMap<Integer, Double>();
    for(Entry<Integer, Double> entry: list){
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }
}
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        int items;
        System.out.println("Enter the number of items:");
        items=scan.nextInt();
        double[] price=new double[items];
        double[] weight=new double[items];
        HashMap<Integer, Double> ratio;
        HashMap<Integer, Double> temp=new HashMap<>();
        System.out.println("For each item enter the price and weigth respectively:");
        for(int i=0;i<items;i++){
            price[i]=scan.nextDouble();
            weight[i]=scan.nextDouble();
            temp.put(i, price[i]/weight[i]);
        }
        int maxWeight;
        System.out.println("Enter the maximum weigth:");
        maxWeight=scan.nextInt();
        int totalPrice=0;
        int currentWeight=0;
        int[] knapsack=new int[items];
        for(int i=0;i<items;i++){
            knapsack[i]=0;
        }
        ratio=Util.sortByComparator(temp);
        Set<Integer> reverse=ratio.keySet();
        List<Integer> keys=new LinkedList<Integer>();
        for(Integer k: reverse){
            keys.add(k);
        }
        Collections.reverse(keys);
        /*for(Integer k: keys){
            System.out.println(k);
        }*/
        for(Integer k: keys){
            int index=k.intValue();
            if(currentWeight+weight[index]<maxWeight){
                currentWeight+=weight[index];
                totalPrice+=price[index];
                knapsack[index]++;
            }else{
                totalPrice+=price[index]*((maxWeight-currentWeight)/weight[index]);
                knapsack[index]+=(maxWeight-currentWeight)/weight[index];
            }
        }
        System.out.println("You should by:");
        for(int i=0;i<items;i++){
            if(knapsack[i]!=0){
                int index=i+1;
                System.out.println(knapsack[i]+" of item "+ index);
            }
        }
        System.out.println("Total price="+totalPrice);
    }
}
