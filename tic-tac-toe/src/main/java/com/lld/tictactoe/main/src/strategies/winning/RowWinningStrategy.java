package com.lld.tictactoe.main.src.strategies.winning;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;
import com.lld.tictactoe.main.src.models.GameSymbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        return checkRows(board, symbol);
    }

    private boolean checkRows(Board board, GameSymbol currentSymbol) {
        for (List<BoardCell> rows : board.getCells()) {
            boolean isWinner = true;
            for (BoardCell cell : rows) {
                if (cell.getSymbol() != currentSymbol) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                return true;
            }
        }
        return false;
    }
}
