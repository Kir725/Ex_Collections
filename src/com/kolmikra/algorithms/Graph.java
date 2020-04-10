package com.kolmikra.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public final int numberVertices;
    public List<Edge>[] nodeEdges;

    public Graph(int V) {
        this.numberVertices = V;
        nodeEdges = new List[V];
        for (int i = 0; i < V; i++) {
            nodeEdges[i] = new ArrayList<Edge>();
        }
    }

    void addEdge(int source, int dest, int weight) {
        nodeEdges[source].add(new Edge(source, dest, weight));
    }
    public static class Edge {

        public int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
