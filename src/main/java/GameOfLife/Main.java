package GameOfLife;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(15);
        gameOfLife.addCellToList(5, 2);
        gameOfLife.addCellToList(6, 4);
        gameOfLife.addCellToList(6, 3);
        gameOfLife.addCellToList(7, 3);
        gameOfLife.addCellToList(5, 2);
        gameOfLife.addCellToList(8, 3);
        gameOfLife.addCellToList(8, 2);
        gameOfLife.addCellToList(8, 4);

        gameOfLife.addCellToList(1, 1);
        gameOfLife.addCellToList(2, 1);
        gameOfLife.addCellToList(3, 1);

        gameOfLife.start();
    }
}
