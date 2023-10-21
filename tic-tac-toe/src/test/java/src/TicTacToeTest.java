package src;

import com.lld.tictactoe.main.src.models.*;
import com.lld.tictactoe.main.src.strategies.playing.RandomPlayingStrategy;
import com.lld.tictactoe.main.src.strategies.winning.RowWinningStrategy;
import com.lld.tictactoe.main.src.strategies.winning.WinningStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private static final int BOARD_SIZE = 3; // screaming case
    @Test
    public void testCreateBoard() {
        Board board = new Board(3);
        int rowSize = board.getCells().size();
        assertEquals(3, rowSize,
                "If the constructor of board is called with n, it should create n rows");
        int columnSize = board.getCells().get(0).size();
        assertEquals(3, columnSize,
                "If the constructor of board is called with n, it should create n columns");
    }

    @Test
    public void testCreateGame() {
        // Board board = new Board(3); // magic numbers == hard coded
        Board board = new Board(BOARD_SIZE);
        Player human = new HumanPlayer(GameSymbol.O, new User());
        Player bot = new BotPlayer(GameSymbol.X, GameLevel.EASY, new RandomPlayingStrategy());
        Game game = new Game(board, List.of(human, bot), GameStatus.IN_PROGRESS, 0, List.of(new RowWinningStrategy())); // try builder pattern

        Game game1 = Game.builder()
                .withBoardSize(BOARD_SIZE)
                .withPlayer(HumanPlayer.builder()
                        .user(new User())
                        .symbol(GameSymbol.O)
                .build())
                .withPlayer(BotPlayer.builder()
                        .symbol(GameSymbol.X)
                        .playingStrategy(new RandomPlayingStrategy())
                        .build())
                .build();
        assertEquals(2, game.getPlayers().size(), "If game is created it should have 2 players." );
        assertEquals(2, game1.getPlayers().size(), "If game is created it should have 2 players.");
    }
}
