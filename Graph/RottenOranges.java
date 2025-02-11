package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting (int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for(int i=0;i<m;i++){
            for(int j =0; j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if (freshCount==0)
            return 0;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int minutes =-1;

        while(!queue.isEmpty()){
            int size = queue.size();
            minutes++;

            for (int i =0; i< size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int column = cell[1];

                for(int[] dir: directions){
                    int newRow = row + dir[0];
                    int newColumn = column + dir[1];

                    if (newRow>=0 && newRow<m && newColumn >=0 && newColumn< n && grid[newRow][newColumn]==1){
                        grid[newRow][newColumn] = 2;
                        queue.offer( new int[]{newRow, newColumn});
                        freshCount--;

                        if (freshCount==0)
                            return minutes+1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid2));
    }
}
