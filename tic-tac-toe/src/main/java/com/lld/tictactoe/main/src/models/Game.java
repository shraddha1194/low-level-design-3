package com.lld.tictactoe.main.src.models;

import com.lld.tictactoe.main.src.exceptions.InvalidMoveException;
import com.lld.tictactoe.main.src.exceptions.InvalidPlayersException;
import com.lld.tictactoe.main.src.strategies.winning.ColumnWinningStrategy;
import com.lld.tictactoe.main.src.strategies.winning.DiagonalWinningStrategy;
import com.lld.tictactoe.main.src.strategies.winning.RowWinningStrategy;
import com.lld.tictactoe.main.src.strategies.winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Game {
    private static final int PLAYERS_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;

    private Board board;
    //initialize to avoid NPE
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private List<WinningStrategy> strategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(),
            new DiagonalWinningStrategy());

    public void start() {
        // Assign a random value to the nextPlayerIndex
        // Random value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1
        // 0.1 * 2 = 0.2 = 0
        // 0.8 * 2 = 1.6 = 1
        nextPlayerIndex = (int) (Math.random() * players.size());
    }

    public void makeMove() {
        // monster functions are broken into smaller functions
        // Get next move
        BoardCell move = getNextMove();
        // update the board
        board.update(move);
        // check for a winner
        if (checkWinner(move.getSymbol())) {
            status = GameStatus.FINISHED;
            System.out.println(move.getSymbol() + " won the game!");
        }
        // check for a draw
        if (checkDraw(move.getSymbol())) {
            status = GameStatus.DRAW;
            System.out.println("Oh no! It was draw.");
        }
        // update next player
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    private boolean checkWinner(GameSymbol symbol) {
        // Implement check rows
        for (WinningStrategy strategy : strategies) {
            boolean hasWinner = strategy.checkWinner(getBoard(), symbol);
            if (hasWinner) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw(GameSymbol symbol) {
        return false;
    }

    private void validateMove(BoardCell move) {
        if (!board.isEmpty(move.getRow(), move.getCol())) {
            throw new InvalidMoveException(move.getRow(), move.getCol());
        }
    }

    private BoardCell getNextMove() {
        //get the next player
        Player player = players.get(nextPlayerIndex);
        // get the next move from the player
        BoardCell move = player.makeMove(board);
        //validate the move - check if the cell is already filled
        validateMove(move);
        return move;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;
        private Builder() {
            this.game = new Game();
        }

        public Builder withBoardSize(int size) {
            game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.getPlayers().add(player);
            return this;
        }

        public Game build() {
            boolean isValid = validate();
            if (!isValid) {
                throw new InvalidPlayersException();
            }
            Game newGame = new Game();
            newGame.board = game.board;
            newGame.players = game.players;
            newGame.status = DEFAULT_STATUS;
            return newGame  ;
        }

        private boolean validate() {
            if (game.players.size() != PLAYERS_COUNT) {
                return false;
            }
            //if symbols are unique
            Set<GameSymbol> symbols = game.players.stream()
                    .map(Player::getSymbol).collect(Collectors.toSet());
            if (symbols.size() != PLAYERS_COUNT) {
                return false;
            }
            return true;
        }
    }
}
