package com.lld.tictactoe.main.src.strategies.winning;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;
import com.lld.tictactoe.main.src.models.GameSymbol;

import java.util.List;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        boolean isWinner = true;
        List<List<BoardCell>> cells = board.getCells();
        for (int i = 0; i < board.getSize(); i++) {
            if (cells.get(i).get(i).getSymbol() != symbol) {
                isWinner = false;
                break;
            }
        }

        if (isWinner) {
            return true;
        }
        isWinner = true;
        for (int i = 0, j = board.getSize()-1; i < board.getSize(); i++, j--) {
            if (cells.get(i).get(j).getSymbol() != symbol) {
                isWinner = false;
                break;
            }
        }
        if (isWinner) {
            return true;
        }

        return false;
    }
}
