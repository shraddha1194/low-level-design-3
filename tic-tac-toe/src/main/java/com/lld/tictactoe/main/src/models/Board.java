package com.lld.tictactoe.main.src.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Board {
    private Integer size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int col) {
        return cells.get(row).get(col).getSymbol() == null;
    }

    public void update(BoardCell move) {
        int row = move.getRow();
        int col = move.getCol();
        BoardCell cell = getBoardCell(row, col);
        cell.setSymbol(move.getSymbol());
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    private BoardCell getBoardCell(int row, int col) {
        return cells.get(row).get(col);
    }

    public List<BoardCell> getEmptyCells() {
        // Iterate over the cells
        // Flatten the array 2D array to 1D
        // Filter out cells where symbol != null
        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .collect(Collectors.toList());
    }
}
