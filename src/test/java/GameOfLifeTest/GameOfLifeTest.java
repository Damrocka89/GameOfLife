package GameOfLifeTest;

import GameOfLife.Cell;
import GameOfLife.Coordinates;
import GameOfLife.GameOfLife;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class GameOfLifeTest {

    private GameOfLife gameOfLife=new GameOfLife(15);

    @Test
    private void testAddingWrongValue(){
        Assertions.assertThrows(IllegalArgumentException.class,()->gameOfLife.addCellToList(36,-1));
    }

    @Test
    private void shouldBeAbleToConvertCellToString(){
        Cell cell=new Cell(new Coordinates(15,9));
        Assertions.assertEquals("O",cell.toString());
    }

    @Test
    private void shouldBeAbleToCheckIfCellsAreTheSamet(){
        Cell cell=new Cell(new Coordinates(15,9));
        Cell cell2=new Cell(new Coordinates(15,9));
        Assertions.assertEquals(cell,cell2);
    }

    @Test
    private void cellsAdded(){
        gameOfLife.addCellToList(2,5);
        gameOfLife.addCellToList(5,5);
        List<Cell> list=new ArrayList<Cell>();
        Assertions.assertEquals(list,gameOfLife.getAliveCells());
    }

    @Test
    private void listOfCellsShouldBeEmpty(){
        Assertions.assertTrue(gameOfLife.getAliveCells().isEmpty());
    }

//    @Test
//    @Disabled
//    private void cellsShouldBeBorn(){
//        gameOfLife.addCellToList(2,5);
//        gameOfLife.addCellToList(3,5);
//        gameOfLife.addCellToList(3,4);
//        List<Cell> list=new ArrayList<Cell>();
//        list.add(new Cell(new Coordinates(2,5)));
//        list.add(new Cell(new Coordinates(3,5)));
//        list.add(new Cell(new Coordinates(3,4)));
//        list.add(new Cell(new Coordinates(2,4)));
//        gameOfLife.następnePokolenie();
//        Assertions.assertEquals(list,gameOfLife.getAliveCells());
//    }


}
