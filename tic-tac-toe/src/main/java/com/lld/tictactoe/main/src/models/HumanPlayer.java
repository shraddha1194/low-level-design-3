package com.lld.tictactoe.main.src.models;

import com.lld.tictactoe.main.src.strategies.playing.PlayingStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;


// Extrinsic state - dynamic states
@SuperBuilder
@Getter
public class HumanPlayer extends Player {
    private User user;

    // Builder will not be able to reassign - this is default for builder
    @Builder.Default
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(GameSymbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new BoardCell(row, col, getSymbol());
    }
}
