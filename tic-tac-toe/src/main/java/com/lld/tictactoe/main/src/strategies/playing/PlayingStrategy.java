package com.lld.tictactoe.main.src.strategies.playing;

import com.lld.tictactoe.main.src.models.Board;
import com.lld.tictactoe.main.src.models.BoardCell;

public interface PlayingStrategy {

    BoardCell makeMove(Board board);
}
