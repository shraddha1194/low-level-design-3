package com.lld.tictactoe.main.src;


import com.lld.tictactoe.main.src.exceptions.InvalidGameLevelException;
import com.lld.tictactoe.main.src.exceptions.InvalidPlayersException;
import com.lld.tictactoe.main.src.exceptions.InvalidSymbolException;
import com.lld.tictactoe.main.src.models.*;
import com.lld.tictactoe.main.src.strategies.playing.RandomPlayingStrategy;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

// Client Code
public class TicTacToe {

    private static final int BOARD_SIZE = 3;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");

        // Create User - Ask name, email and symbol
        Player human = getUserInput();
        System.out.println("Human player created: " + human.getSymbol());

        Player secondPlayer = getSecondPlayer();

        // Create a game, Initialize a bot player, Mark game in progress
        Game game = createGame(human, secondPlayer);

        // Start a game, Assign the first player
        game.start();

        // start playing
        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player player = game.getNextPlayer();
            System.out.println("Next player playing " + player.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();
        }
    }

    private static Player getSecondPlayer() {
        System.out.println("Please select second player. Human(H) or Bot(B)");
        PlayerType playerType;
        try {
            playerType = PlayerType.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidPlayersException();
        }
        if (playerType == PlayerType.H) {
            return getUserInput();
        } else {
            return getBotInput();
        }
    }

    private static Player getBotInput() {
        System.out.println("Enter symbol for bot");
        GameSymbol symbol;
        GameLevel level;
        try {
            symbol = GameSymbol.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();
        }

        System.out.println("Enter game difficulty level EASY, MEDIUM or HARD");
        try {
            level = GameLevel.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidGameLevelException();
        }
        return BotPlayer.builder()
                .symbol(symbol)
                .level(level)
                .playingStrategy(new RandomPlayingStrategy())
                .build();
    }

    private static Game createGame(Player humanPlayer, Player secondPlayer) {
        return Game.builder()
                .withBoardSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(secondPlayer)
                .build();
    }

    private static GameSymbol decideBotSymbol(GameSymbol symbol) {
        Optional<GameSymbol> botSymbol = Arrays.stream(GameSymbol.values())
                .filter(sym -> sym != symbol)
                .findAny();
        return botSymbol.get();
    }

    private static HumanPlayer getUserInput() {
        System.out.println("Enter name");
        String name = sc.nextLine();

        System.out.println("Enter email");
        String email = sc.nextLine();

        System.out.println("Enter symbol");

        GameSymbol symbol;
        try {
            symbol = GameSymbol.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException();
        }

        User user = new User(name, email, null);
        return new HumanPlayer(symbol, user);
    }
}
