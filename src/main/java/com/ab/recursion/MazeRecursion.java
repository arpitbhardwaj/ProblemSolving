package com.ab.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeRecursion {
    public static void main(String[] args) {
        printPaths("",3,3);
        System.out.println(countPaths(3,3));
        //can move only right and down
        System.out.println(paths("",3,3));
        //can move right, down and diagonal
        System.out.println(pathsDiagonal("",3,3));
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(pathsObstacles("",maze,0,0));
    }

    private static void printPaths(String p, int r, int c) {
        if (r==1 && c==1){
            System.out.println(p);
            return;
        }
        if (r>1){
            printPaths(p+'D', r-1,c);
        }
        if (c>1){
            printPaths(p+'R',r,c-1);
        }
    }
    private static int countPaths(int r, int c) {
        if (r==1 || c==1){
            return 1;
        }
        int left = countPaths(r-1,c);
        int right = countPaths(r,c-1);
        return left+right;
    }
    private static List<String> paths(String p, int r, int c) {
        if (r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (r>1){
            list.addAll(paths(p+'D', r-1,c));
        }
        if (c>1){
            list.addAll(paths(p+'R',r,c-1));
        }
        return list;
    }

    private static List<String> pathsDiagonal(String p, int r, int c) {
        if (r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if (r>1 && c>1){
            list.addAll(pathsDiagonal(p+'D', r-1,c-1));
        }
        if (r>1){
            list.addAll(pathsDiagonal(p+'V', r-1,c));
        }
        if (c>1){
            list.addAll(pathsDiagonal(p+'H',r,c-1));
        }
        return list;
    }

    private static List<String> pathsObstacles(String p,boolean[][] maze, int r, int c) {
        int m = maze.length;
        int n = maze[0].length;
        if (r==m-1 && c==n-1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        if (maze[r][c]) {
            if (r<m-1){
                list.addAll(paths(p+'D', r+1,c));
            }
            if (c<n-1){
                list.addAll(paths(p+'R',r,c+1));
            }
        }
        return list;
    }
}
