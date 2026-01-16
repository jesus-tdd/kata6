package app.versions.bulbasaur;

import app.io.CsvPokeParser;
import app.io.RemoteStore;
import app.view.MainFrame;
import architecture.model.Pokemon;
import architecture.model.Pokemon.Type;
import architecture.tasks.HistogramBuilder;
import architecture.viewmodel.Histogram;

import java.util.stream.Stream;

public class Main {
    static void main() {
        MainFrame.create()
                .display(histogramOf(pokemons()))
                .setVisible(true);
    }

    private static Histogram<Type> histogramOf(Stream<Pokemon> pokemons) {
        return HistogramBuilder.with(pokemons)
                .title("Pokemons per Type")
                .x("Types")
                .y("Count")
                .legend("Pokemons")
                .build(p -> p.types().stream());
    }

    private static Stream<Pokemon> pokemons() {
        return new RemoteStore(CsvPokeParser::parse).pokemons();
    }
}
