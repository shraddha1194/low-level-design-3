package com.lld.tictactoe.main.src.strategies.winning;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;
import com.lld.tictactoe.main.src.models.GameSymbol;

import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol currentSymbol) {
        for (int col = 0; col < board.getSize(); col++) {
            boolean isWinner = true;
            for (List<BoardCell> row : board.getCells()) {
                if (row.get(col).getSymbol() != currentSymbol){
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
