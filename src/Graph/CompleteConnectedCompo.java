package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteConnectedCompo {
    public static void main(String[] args) {
        int[][]graph = {{0,1},{0,2},{1,2},{3,4}, {3,5}};
        int ans = countCompleteComponents(6, graph);
        System.out.println(ans);
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i<=n; i++) {
            graph.add(i, new ArrayList<>());
        }
        // graph created
        for(int [] temp: edges) {
            graph.get(temp[0]).add(temp[1]);
            graph.get(temp[1]).add(temp[0]);
        }
        boolean[]visited = new boolean[n];
        int noOfCompo = 0;
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                noOfCompo+=dfsCalNoOfComponents(graph, visited, i);
            }
        }
        return noOfCompo;
    }

    public static int dfsCalNoOfComponents(List<List<Integer>> graph, boolean[] visited, int src) {
        int[] nodeCount = {0};
        int[] degreeSum = {0};

        dfs(graph, visited, src, nodeCount, degreeSum);

        int actualEdges = degreeSum[0] / 2; // because each edge is counted twice
        int expectedEdges = nodeCount[0] * (nodeCount[0     ] - 1) / 2;

        return actualEdges == expectedEdges ? 1 : 0;
    }

    public static void dfs(List<List<Integer>> graph, boolean[]visited, int src, int[] nodeCount, int[] degreeSum) {
        visited[src] = true;
        nodeCount[0]++;
        // Since it is an un-directed graph a is connected to b and b is connected to a.
        degreeSum[0] = degreeSum[0] + graph.get(src).size(); // total degree from current node
        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(graph, visited, neighbor, nodeCount, degreeSum);
            }
        }
    }

    public static int calNoOfComponents(List<List<Integer>> graph, boolean[] visited, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        int nodeCount = 0;
        int degreeSum = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            nodeCount++;
            // Since it is an un-directed graph a is connected to b and b is connected to a.
            degreeSum += graph.get(curr).size(); // total degree from current node

            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        int actualEdges = degreeSum / 2; // because each edge is counted twice
        int expectedEdges = nodeCount * (nodeCount - 1) / 2;

        return actualEdges == expectedEdges ? 1 : 0;
    }

    public static void test(List<List<Integer>> graph, int index, boolean[]visited) {
        visited[index] = true;
        for(int i : graph.get(index)) {
            if(!visited[i]) {
                test(graph, i, visited);
            }
        }
    }


    public static void test2(List<List<Integer>> graph, int index, boolean[]visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;

        while(!q.isEmpty()) {
            int ele = q.poll();
            for(int i : graph.get(ele)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

}
