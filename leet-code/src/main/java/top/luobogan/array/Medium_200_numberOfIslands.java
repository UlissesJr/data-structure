package top.luobogan.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-islands/
 * Created by LuoboGan
 * Date:2023/3/14
 */
public class Medium_200_numberOfIslands {

    public static void main(String[] args) {

    }

    /**\
     * 解题思路：
     * 用 DFS 算法解决岛屿题目是最常见的，每次遇到一个岛屿中的陆地，就用 DFS 算法吧这个岛屿「淹掉」。
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for(int i = 0 ; i < m; i++ ){
            for(int j = 0; j < n; j++ ){
                if( grid[i][j] == '1' ){
                    count++;
                    // 把这个区域变成0
                    bfs(grid,i,j);
                }
            }
        }

        return count;
    }

    // 把 grid[i][j] 相连的所有岛屿淹掉（相连的 1 变成 0）
    private void bfs(char[][] grid, int i, int j){
        // m 行数  n 列数
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,j});
        // 将当前岛屿淹没
        grid[i][j] = '0';

        while(!q.isEmpty()){
            int sz = q.size();
            for( int k = 0 ; k < sz ; k++ ){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                // 将满足条件的相邻岛屿加入队列，并将岛屿置为 ‘0’
                if( x + 1 < m && grid[x+1][y] == '1'){
                    q.offer(new int[]{x+1,y});
                    grid[x+1][y] = '0';
                }
                if( x - 1 >= 0 && grid[x -1][y] == '1'){
                    q.offer(new int[]{x-1,y});
                    grid[x-1][y] = '0';
                }
                if( y + 1 < n && grid[x][y+1] == '1'){
                    q.offer(new int[]{x,y+1});
                    grid[x][y+1] = '0';
                }
                if( y - 1 >= 0 && grid[x][y-1] == '1'){
                    q.offer(new int[]{x,y-1});
                    grid[x][y-1] = '0';
                }
            }
        }
    }

}
