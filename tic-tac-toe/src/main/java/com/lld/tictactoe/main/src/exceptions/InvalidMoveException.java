package com.lld.tictactoe.main.src.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int col) {
        super("This move is invalid: " + row + "," + col);
    }
}
