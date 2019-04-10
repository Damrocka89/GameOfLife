package GameOfLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameOfLife {

    private Scanner scanner = new Scanner(System.in);
    private List<Cell> aliveCells;
    private int size;


    public GameOfLife(int size) {
        this.aliveCells = new ArrayList<Cell>();
        this.size = size;
    }

    public void start() {
        String next = "n";
        while (next.equalsIgnoreCase("n")) {
            wyświetl();
            następnePokolenie();
            System.out.println("Pokazać kolejny? Wciśnij \"n\"");
            next=scanner.nextLine().trim();
        }
    }

    private void wyświetl() {
        wypiszKoordynatyWNagłówkuTabeli();

        for (int i = 1; i <= size; i++) {
            if (i < 10) {
                System.out.print("  " + i);
            } else {
                System.out.print(" " + i);
            }
            for (int j = 1; j <= size; j++) {
                String sign = "  ";
                for (Cell aliveCell : aliveCells) {
                    if (aliveCell.getCoordinates().getX() == j && aliveCell.getCoordinates().getY() == i) {
                        sign = " O";
                        break;
                    } else {
                        sign = "  ";
                    }
                }
                System.out.print(" " + sign);
            }
            System.out.println();
        }
    }

    private void następnePokolenie() {
        List<Cell> temporary = new ArrayList<Cell>();
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                int countNeighbours = 0;
                Cell toCheck = new Cell(new Coordinates(x, y));
                countNeighbours = getNumberOfNeighbours(x, y, countNeighbours);

                if (countNeighbours == 3 && !(aliveCells.contains(toCheck))) {
                    temporary.add(toCheck);
                } else if ((countNeighbours == 2 || countNeighbours == 3) && aliveCells.contains(toCheck)) {
                    temporary.add(toCheck);
                }
            }
        }
        aliveCells.clear();
        aliveCells.addAll(temporary);
    }

    private int getNumberOfNeighbours(int x, int y, int countNeighbours) {
        for (Cell aliveCell : aliveCells) {
            int xCell = aliveCell.getCoordinates().getX();
            int yCell = aliveCell.getCoordinates().getY();
            if (xCell == x && yCell == (y - 1)) {
                countNeighbours++;
            }
            if (xCell == x && yCell == (y + 1)) {
                countNeighbours++;
            }
            if (xCell == (x + 1) && yCell == y) {
                countNeighbours++;
            }
            if (xCell == (x - 1) && yCell == y) {
                countNeighbours++;
            }
            if (xCell == (x - 1) && yCell == (y - 1)) {
                countNeighbours++;
            }
            if (xCell == (x + 1) && yCell == (y + 1)) {
                countNeighbours++;
            }
            if (xCell == (x + 1) && yCell == (y - 1)) {
                countNeighbours++;
            }
            if (xCell == (x - 1) && yCell == (y + 1)) {
                countNeighbours++;
            }
        }
        return countNeighbours;
    }

    private void wypiszKoordynatyWNagłówkuTabeli() {
        System.out.println(" ");
        for (int j = 0; j <= size; j++) {
            if (j < 10) {
                System.out.print("  " + j);
            } else {
                System.out.print(" " + j);
            }
        }

        System.out.println();
    }

    public boolean addCellToList(int x, int y) {
        if (x > 15 || y > 15 || x < 1 || y < 1) {
            throw new IllegalArgumentException("Number needs to be between 1 and 15 inclusive");
        }
        Cell cell = new Cell(new Coordinates(x, y));
        if (aliveCells.contains(cell)) {
            return false;
        }
        aliveCells.add(cell);
        return true;
    }

    public List<Cell> getAliveCells() {
        return aliveCells;
    }
}
