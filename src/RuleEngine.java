/**
 * Created by jerryhoerig on 11/30/16.
 *
 * Conway's Game of Life Rules
 * 1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.
 * 2) Any live cell with two or three live neighbours lives on to the next generation.
 * 3) Any live cell with more than three live neighbours dies, as if by over-population.
 * 4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 *
 * The first generation is created by applying the above rules simultaneously to every cell in the seed
 */
public class RuleEngine {

    private static final int ALIVE = 1;

    public boolean shouldCellDie(int [][] grid, int row, int column) {
        int neighbors = 0;

        if(checkNeighborAtTopLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtTopCenter(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtTopRight(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtRight(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomCenter(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomRight(grid, row, column)) {
            neighbors++;
        }

        return neighbors < 2;
    }

    public boolean shouldCellRegenerate(int[][] grid, int row, int column) {
        int neighbors = 0;

        if(checkNeighborAtTopLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtTopCenter(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtTopRight(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtRight(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomLeft(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomCenter(grid, row, column)) {
            neighbors++;
        }

        if(checkNeighborAtBottomRight(grid, row, column)) {
            neighbors++;
        }

        return neighbors == 3;
    }

    private boolean checkNeighborAtTopLeft(int[][] grid, int row, int column) {
        if(row > 0 && column > 0) {
            return grid[row - 1][column - 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtTopCenter(int[][] grid, int row, int column) {
        if(row > 0) {
            return grid[row - 1][column] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtTopRight(int[][] grid, int row, int column) {
        if(row > 0 && column < grid[row].length - 1) {
            return grid[row - 1][column + 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtLeft(int[][] grid, int row, int column) {
        if(column > 0) {
            return grid[row][column - 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtRight(int[][] grid, int row, int column) {
        if(column < grid[row].length - 1) {
            return grid[row][column + 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtBottomLeft(int[][] grid, int row, int column) {
        if(row < grid.length - 1 && column > 0) {
            return grid[row + 1][column - 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtBottomCenter(int[][] grid, int row, int column) {
        if(row < grid.length - 1) {
            return grid[row + 1][column] == ALIVE;
        }
        else {
            return false;
        }
    }

    private boolean checkNeighborAtBottomRight(int[][] grid, int row, int column) {
        if(row < grid.length - 1 && column < grid[row].length - 1) {
            return grid[row + 1][column + 1] == ALIVE;
        }
        else {
            return false;
        }
    }

    public boolean isCellAlive(int[][] grid, int row, int column) {
        return grid[row][column] == ALIVE;
    }

}
