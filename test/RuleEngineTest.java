import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jerryhoerig on 11/30/16.
 */
public class RuleEngineTest {

    RuleEngine engine;

    @Before
    public void setUp() throws Exception {
        engine =  new RuleEngine();
    }

    @Test
    public void cellIsAlive() {
        int [][] grid = {{0, 0, 1},
                         {0, 0, 0},
                         {0, 0, 0}};
        assertEquals("Cell should be alive", true, engine.isCellAlive(grid, 0, 2));
    }

    @Test
    public void cellIsDead() {
        int [][] grid = {{0, 0, 0},
                         {0, 0, 0},
                         {0, 0, 0}};
        assertEquals("Cell should be dead", false, engine.isCellAlive(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithNoLiveNeighboursDies() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with no neighbors should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneInTopLeft() {
        int [][] grid = {{1, 0, 0},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with one neighbor at the top left should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneInTopCenter() {
        int [][] grid = {{0, 1, 0},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with one neighbor at the top center should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneInTopRight() {
        int [][] grid = {{0, 0, 1},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with one neighbor at the top right should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneToLeft() {
        int [][] grid = {{0, 0, 0},
                         {1, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with one neighbor to the left should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneToRight() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 1},
                         {0, 0, 0}};
        assertEquals("A live cell with one neighbor to the right should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneToBottomLeft() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 0},
                         {1, 0, 0}};
        assertEquals("A live cell with one neighbor at the bottom left should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneToBottomCenter() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 0},
                         {0, 1, 0}};
        assertEquals("A live cell with one neighbor at the bottom center should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourDies_OneToBottomRight() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 0},
                         {0, 0, 1}};
        assertEquals("A live cell with one neighbor at the bottom right should die", true, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithTwoLiveNeighboursLives() {
        int [][] grid = {{1, 1, 0},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with two neighbors should live", false, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithThreeLiveNeighboursLives() {
        int [][] grid = {{1, 1, 1},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with three neighbors should live", false, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void aLiveCellWithMoreThanThreeLiveNeighboursDies() {
        int [][] grid = {{1, 1, 1},
                         {1, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with more than three neighbors should live", false, engine.shouldCellDie(grid, 1, 1));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTopAndNoneToTheLeftAndHasThreeNeighbors() {
        int [][] grid = {{1, 1, 0},
                         {1, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 0, 0));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTopAndHasThreeNeighbors() {
        int [][] grid = {{1, 1, 1},
                         {0, 1, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 0, 1));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTopAndNoneToTheRightAndHasThreeNeighbors() {
        int [][] grid = {{0, 1, 1},
                         {0, 1, 1},
                         {0, 0, 0}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 0, 2));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsTheRightAndHasThreeNeighbors() {
        int [][] grid = {{0, 0, 1},
                         {0, 1, 1},
                         {0, 0, 1}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 1, 2));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTheBottomAndNoNeighborsToTheLeftAndHasThreeNeighbors() {
        int [][] grid = {{0, 0, 0},
                         {1, 1, 0},
                         {1, 1, 0}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 2, 0));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTheBottomAndHasThreeNeighbors() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 0},
                         {1, 1, 1}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 2, 1));
    }

    @Test
    public void cornerCaseWhereCellIsAliveAndHasNoNeighborsToTheBottomAndNoNeighborsToTheRightAndHasThreeNeighbors() {
        int [][] grid = {{0, 0, 0},
                         {0, 1, 1},
                         {0, 1, 1}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 2, 2));
    }

    @Test
    public void aDeadCellWithExactlyThreeLiveNeighboursRegenerates() {
        int [][] grid = {{1, 1, 1},
                         {0, 0, 0},
                         {0, 0, 0}};
        assertEquals("A live cell with three neighbors should live", true, engine.shouldCellRegenerate(grid, 1, 1));
    }

}
