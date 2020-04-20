package org.songzxdev.leetcode.study.week01;

public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if ((obstacleGrid[0][0] | obstacleGrid[m - 1][n - 1]) == 1) {
            return 0;
        }
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else if (i == 0) {
                    if (j > 0) {
                        paths[i][j] = paths[i][j - 1];
                    }
                } else if (j == 0) {
                    paths[i][j] = paths[i - 1][j];
                } else {
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
