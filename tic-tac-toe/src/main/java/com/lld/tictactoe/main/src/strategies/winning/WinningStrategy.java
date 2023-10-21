package com.lld.tictactoe.main.src.strategies.winning;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.GameSymbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, GameSymbol symbol);
}
