package com.lld.tictactoe.main.src.exceptions;

public class InvalidPlayersException extends RuntimeException {
    public  InvalidPlayersException() {
        super("Invalid players input.");
    }
}
