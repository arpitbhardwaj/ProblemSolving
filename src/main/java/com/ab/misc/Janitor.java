package com.ab.misc;

public class Janitor {
    public static void main(String[] args) {
        double[] weights = {1.99, 1.01, 2.5, 1.5, 1.01};
        double max = 3.0;
        System.out.println(getMinTrips(weights, max));
    }

    static int res = Integer.MAX_VALUE;

    private static int getMinTrips(double[] weights, double max) {
        boolean[] visited = new boolean[weights.length];
        dfs(weights, visited, 0.0, 1, max);
        return res;
    }

    private static void dfs(double[] weights, boolean[] visited, double w, int tmp, double max) {
        if(tmp > res)
            return;
        if(isAllVisited(visited)) {
            res = Math.min(res, tmp);
            return;
        }
        for(int i=0;i<weights.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                if(w + weights[i] <= max)
                    dfs(weights, visited, w + weights[i], tmp, max);
                else
                    dfs(weights, visited, weights[i], tmp+1, max);
                visited[i] = false;
            }
        }
    }

    private static boolean isAllVisited(boolean[] visited) {
        for(boolean v : visited)
            if(v == false)
                return false;
        return true;
    }
}
