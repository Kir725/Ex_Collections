package com.kolmikra.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    private static int dest, source;

    public static void dijkstra(int[][] data, String[] cityNames, String start, String destination) {

        int numberVertices = data.length;
        Graph graph = new Graph(numberVertices);
        int[] unsettledNeighbors = new int[graph.numberVertices];
        int[] settledNeighbors = new int[graph.numberVertices];
        Arrays.fill(settledNeighbors, -1);
        Arrays.fill(unsettledNeighbors, Integer.MAX_VALUE / 2);
        for (int i = 0; i < numberVertices; i++) {
            if (cityNames[i].equals(start)) source = i;
            if (cityNames[i].equals(destination)) dest = i;
            for (int j = 0; j < numberVertices; j++) {
                if (data[i][j] != 0) {
                    graph.addEdge(i, j, data[i][j]);
                }
            }
        }
        unsettledNeighbors[source] = 0;
        Queue<Neighbor> priorityQueue = new PriorityQueue<Neighbor>();
        priorityQueue.add(new Neighbor(0, source));
        while (!priorityQueue.isEmpty()) {
            Neighbor min = priorityQueue.poll();
            if (min.distance != unsettledNeighbors[min.vertexNum]) {
                continue;
            }

            for (Graph.Edge e : graph.nodeEdges[min.vertexNum]) {
                int currUnSet = unsettledNeighbors[min.vertexNum] + e.weight;
                if (unsettledNeighbors[e.dest] > currUnSet) {
                    unsettledNeighbors[e.dest] = currUnSet;
                    settledNeighbors[e.dest] = min.vertexNum;
                    priorityQueue.add(new Neighbor(currUnSet, e.dest));
                }
            }
        }

        System.out.println("Shortest path from: " + start + " to " + destination + " is: " + unsettledNeighbors[dest]);
        printPath(settledNeighbors, dest, cityNames);
    }

    public static void printPath(int[] settledNeighbors, int dest, String[] cities) {
        StringBuilder result = new StringBuilder();
        while (true) {
            result.insert(0, cities[dest]);
            dest = settledNeighbors[dest];
            if (dest < 0) {
                break;
            }
            result.insert(0, " >> ");
        }
        System.out.println("Trace: " + result);
    }

    public static class Neighbor implements Comparable<Neighbor> {
        int distance;
        int vertexNum;

        public Neighbor(int distance, int v) {
            this.distance = distance;
            this.vertexNum = v;
        }

        public int compareTo(Neighbor q) {
            return Integer.compare(distance, q.distance);
        }
    }
}
