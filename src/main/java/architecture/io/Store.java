package architecture.io;

import architecture.model.Pokemon;

import java.util.stream.Stream;

public interface Store {
    Stream<Pokemon> pokemons();
}
