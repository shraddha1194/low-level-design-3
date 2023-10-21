package com.lld.tictactoe.main.src.exceptions;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("You have entered an invalid symbol. Use 0 or X.");
    }
}
