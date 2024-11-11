package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void whenSecondPlayerWin() {
        Player petya = new Player(123, "Петя", 120);
        Player vasya = new Player(1241354, "Вася", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerWin() {
        Player vasya = new Player(1, "Вася", 120);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenStrengthEqual() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(petya);
        game.register(vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дима", "Вася")
        );
    }

    @Test
    public void whenSecondPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Дима")
        );
    }
}