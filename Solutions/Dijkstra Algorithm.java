/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;



/**
 *
 * @author shakil
 */
class Node implements Comparable<Node> {
        int label;
        List<Edge> neighbors;
        int cost;
        boolean visited;
        Node previous;
        
        public Node(int label){
            this.label=label;
            this.neighbors=new ArrayList<>();
            this.cost=Integer.MAX_VALUE;
            this.visited=false;
            this.previous=null;
        }
        
        public int compareTo(Node other){
            return Long.compare(this.cost, other.cost);
        }
    }

class Edge {
        Node destination;
        int weight;
        
        public Edge(Node destination, int weight) {
            this.destination=destination;
            this.weight=weight;
        }
    }

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void dijkstra(List<Node> graph, Node source) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        source.cost=0;
        source.visited = true;
        pq.add(source);
        while(!pq.isEmpty()){
            Node current=pq.remove();
            current.visited=true;
            for(Edge edge: current.neighbors){
                Node nextNode=edge.destination;
                int newCost=current.cost+edge.weight;
                if(!nextNode.visited && newCost<nextNode.cost){
                    nextNode.cost=newCost;
                    pq.add(nextNode);
                    nextNode.previous=current;
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        int v;
        System.out.println("Enter the number of Vertices:");
        v=input.nextInt();
        int e;
        System.out.println("Enter the number of Edges:");
        e=input.nextInt();
        ArrayList<Node> graph=new ArrayList<>(v);
        for(int i=0;i<v;i++){
            graph.add(new Node(i));
        }
        for(int i=0;i<e;i++){
            int x=input.nextInt()-1;
            int y=input.nextInt()-1;
            int weight=input.nextInt();
            Node startNode=graph.get(x);
            Node endNode=graph.get(y);
            startNode.neighbors.add(new Edge(endNode, weight));
            endNode.neighbors.add(new Edge(startNode, weight));
        }
        int source;
        System.out.println("Enter the starting node:");
        source=input.nextInt();
        int destination;
        System.out.println("Enter the destination node:");
        destination=input.nextInt();
        dijkstra(graph, graph.get(source-1));
        int shortestPath=graph.get(v-1).cost;
        if(shortestPath==Integer.MAX_VALUE) {
            System.out.println("No path, sorry!");
        }else{
            Node last=graph.get(v-1);
            List<Integer> back=new LinkedList<>();
            while(last!=null) {
                back.add((last.label+1));
                last=last.previous;
            }
            Collections.reverse(back);
            for(int i: back) {
                System.out.print(i + " ");
            }
        }


}
}
