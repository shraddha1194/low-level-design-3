package com.lld.tictactoe.main.src.strategies.playing;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy{
    @Override
    public BoardCell makeMove(Board board) {
        // Output -> A cell from the list of available cells

        // Get list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        // Generate random index for the cells
        int randomIndex = (int) (Math.random() * emptyCells.size());

        // Return the random cells
        BoardCell cell = emptyCells.get(randomIndex);
        return new BoardCell(cell.getRow(), cell.getCol());
    }
}
