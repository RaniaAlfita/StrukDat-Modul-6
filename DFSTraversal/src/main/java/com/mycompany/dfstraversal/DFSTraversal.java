/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.dfstraversal;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class DFSTraversal {
    
    private final LinkedList<Integer> adj[]; /*adjacency list representation*/
    private final boolean visited[];
    
    /*Creation of the graph*/
    DFSTraversal(int V){/*'V' is the number of vertices in the graph*/
        adj = new LinkedList[V];
        visited = new boolean[V];
        
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }
    
    /*Adding an edge to the graph */
    void insertEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        /*Mark the current node as visited*/
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    public static void main(String args[]) {
        DFSTraversal graph = new DFSTraversal(8);

        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);

        System.out.println("Depth First Traversal for the graph is:");
        graph.DFS(0);
    }
            
}