package com.lld.tictactoe.main.src.models;

import com.lld.tictactoe.main.src.strategies.playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player {
    private  GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(GameSymbol symbol) {
        super(symbol);
    }

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level= level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
        BoardCell cell = playingStrategy.makeMove(board);
        cell.setSymbol(getSymbol());
        return cell;
    }
}
