package ru.mcg.patchboard;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final Map<Long, Game> games = new ConcurrentHashMap<>();

    @GetMapping
    public List<Game> getGames() {
        return List.copyOf(games.values());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        if (game.steamAppId() <= 0
                || game.name() == null
                || game.name().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Positive steamAppId and non-empty name are required"
            );
        }

        Game existingGame = games.putIfAbsent(game.steamAppId(), game);

        if (existingGame != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Game is already tracked"
            );
        }

        return game;
    }
}