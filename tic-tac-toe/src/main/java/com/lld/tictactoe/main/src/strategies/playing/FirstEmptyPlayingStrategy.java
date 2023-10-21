package com.lld.tictactoe.main.src.strategies.playing;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;

public class FirstEmptyPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        return board.getEmptyCells().stream().findFirst().get();
    }
}
