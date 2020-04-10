package com.kolmikra;

import com.kolmikra.algorithms.Dijkstra;

public class DijkstraTest {
    public static void main(String[] args) {
        final int[][] data = {
                {0, 4, 0, 0},
                {4, 0, 8, 0},
                {0, 8, 0, 7},
                {0, 0, 7, 0}};

        final String[] cities = {
                "Manchester",
                "Liverpool",
                "York",
                "Birmingham",
                "london"};

        Dijkstra.dijkstra(data, cities, "York", "Manchester");
    }
}

