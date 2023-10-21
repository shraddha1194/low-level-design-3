package com.lld.tictactoe.main.src.exceptions;

public class InvalidGameLevelException extends RuntimeException {
    public InvalidGameLevelException() {
        super("Invalid game difficulty level. Please select EASY, MEDIUM or HARD");
    }
}
