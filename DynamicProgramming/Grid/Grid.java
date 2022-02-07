import java.util.*;

class Grid {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        // System.out.println(grid[1][0]);
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minPathSumHelper(grid, 0, 0, dp);
    }

    public static int minPathSumHelper(int[][] grid, int row, int col, int[][] dp) {

        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (row >= grid.length - 1 && col >= grid[0].length - 1) {
            return grid[row][col];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (col < grid[0].length - 1) { // 2-1 = 1
            right = minPathSumHelper(grid, row, col + 1, dp) + grid[row][col];
        }
        if (row < grid.length - 1) { // 3 - 1 =2
            down = minPathSumHelper(grid, row + 1, col, dp) + grid[row][col];
        }

        int min = Math.min(right, down);
        dp[row][col] = min;
        return min;
    }
}