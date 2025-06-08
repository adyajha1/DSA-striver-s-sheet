/*There exist two undirected trees with n and m nodes, with distinct labels in ranges [0, n - 1] and [0, m - 1], respectively.

You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree. You are also given an integer k.

Node u is target to node v if the number of edges on the path from u to v is less than or equal to k. Note that a node is always target to itself.

Return an array of n integers answer, where answer[i] is the maximum possible number of nodes target to node i of the first tree if you have to connect one node from the first tree to another node in the second tree.

Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.*/


class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
          int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildAdjList(edges1, n);
        List<List<Integer>> tree2 = buildAdjList(edges2, m);

     
        int maxTree2Reach = 0;
        for (int i = 0; i < m; i++) {
            int count = bfs(tree2, i, k - 1);
            maxTree2Reach = Math.max(maxTree2Reach, count);
        }

      
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int tree1Reach = bfs(tree1, i, k);
            result[i] = tree1Reach + maxTree2Reach;
        }

        return result;
    }

   
    private List<List<Integer>> buildAdjList(int[][] edges, int size) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

   
    private int bfs(List<List<Integer>> adj, int start, int maxDist) {
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > maxDist) continue;
            count++;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return count;
    }

}