package org.songzxdev.leetcode.year20;

/**
 * @author huyu097308@163.com
 * @date 2021-02-16 9:11
 */
public class Solution1 {
    private final int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};

    /**
     * No.200
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count += dfsFill(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private int dfsFill(char[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (!(x < 0 || y < 0 || x >= m || y >= n)) {
                dfsFill(grid, x, y, m, n);
            }
        }
        return 1;
    }
}
