public class LC200NumOfIsland {
    public int numIslands(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int num = 0;

        for (int i = 0; i < rLen; i++){
            for (int j = 0; j < cLen; j++){
                if (grid[i][j] == '1'){
                    overwrite(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void overwrite(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')return;

        grid[i][j] = '0';

        overwrite(grid, i + 1, j);
        overwrite(grid, i - 1, j);
        overwrite(grid, i, j + 1);
        overwrite(grid, i, j - 1);
    }
}
