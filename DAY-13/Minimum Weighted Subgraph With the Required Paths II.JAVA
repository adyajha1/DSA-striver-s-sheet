/*You are given an undirected weighted tree with n nodes, numbered from 0 to n - 1. It is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi, wi] indicates that there is an edge between nodes ui and vi with weight wi.​

Additionally, you are given a 2D integer array queries, where queries[j] = [src1j, src2j, destj].

Return an array answer of length equal to queries.length, where answer[j] is the minimum total weight of a subtree such that it is possible to reach destj from both src1j and src2j using edges in this subtree.

A subtree here is any connected subset of nodes and edges of the original tree forming a valid tree.*/

class Solution {
    int limit = 18; 
        public int[] minimumWeight(int[][] edges, int[][] queries) {

        int maxNode = 0;
        for (int[] e : edges) {
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        for (int[] q : queries) {
            maxNode = Math.max(maxNode, Math.max(q[0], q[1]));
            maxNode = Math.max(maxNode, q[2]);
        }
        int n = maxNode + 1;

        List<long[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new long[]{v, w});
            adj[v].add(new long[]{u, w});
        }
        int[][] up = new int[limit][n];
        int[] depth = new int[n];
        long[] dist0 = new long[n];
        dfs(0, -1, 0, 0L, adj, depth, dist0, up[0]);
        for (int k = 1; k < limit; k++) {
            for (int i = 0; i < n; i++) {
                int p = up[k - 1][i];
                up[k][i] = (p < 0 ? -1 : up[k - 1][p]);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int d = queries[i][2];
            long du = dist(u, d, depth, dist0, up);
            long dv = dist(v, d, depth, dist0, up);
            long uv = dist(u, v, depth, dist0, up);
            long ans = (du + dv + uv) / 2;
            result[i] = (int) ans;
        }
        return result;
    }

    void dfs(int u, int p, int dep, long acc,
                     List<long[]>[] adj, int[] depth, long[] dist0, int[] up0) {
        depth[u] = dep;
        dist0[u] = acc;
        up0[u] = p;
        for (long[] e : adj[u]) {
            int v = (int) e[0], w = (int) e[1];
            if (v == p) continue;
            dfs(v, u, dep + 1, acc + w, adj, depth, dist0, up0);
        }
    }
    long dist(int a, int b, int[] depth, long[] dist0, int[][] up) {
        int c = lca(a, b, depth, up);
        return dist0[a] + dist0[b] - 2 * dist0[c];
    }
    private int lca(int a, int b, int[] depth, int[][] up) {
        if (depth[a] < depth[b]) {
            int t = a; a = b; b = t;
        }
        a = shift(a, depth[a] - depth[b], up);
        if (a == b) return a;
        for (int k = limit - 1; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }
    int shift(int u, int diff, int[][] up) {
        for (int k = 0; k < limit; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
                if (u < 0) break;
            }
        }
        return u;
    }
}