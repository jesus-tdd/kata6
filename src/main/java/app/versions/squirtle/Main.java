package app.versions.squirtle;

import app.io.CsvPokeParser;
import app.io.HistogramAdapter;
import app.io.RemoteStore;
import architecture.tasks.HistogramBuilder;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class Main {
    static void main() {
        Javalin app = Javalin.create();
        app.get("/", Main::hello);
        app.get("/pokemons", Main::pokemons);
        app.get("/pokemon/{name}", Main::pokemon);
        app.get("/histogram", Main::histogram);
        app.start(8080);
    }

    private static void histogram(Context context) {
        context.json(HistogramAdapter.toPojo(
                HistogramBuilder.with(new RemoteStore(CsvPokeParser::parse).pokemons())
                        .title("Pokemons per Type")
                        .x("Types")
                        .y("Count")
                        .legend("Pokemons")
                        .build(p -> p.types().stream())
        ));
    }

    private static void pokemon(Context context) {
        String name = context.pathParam("name");
        context.json(
                new RemoteStore(CsvPokeParser::parse).pokemons()
                        .filter(p -> p.name().equals(name))
                        .toList()
        );
    }

    private static void pokemons(Context context) {
        context.json(new RemoteStore(CsvPokeParser::parse).pokemons().toList());
    }

    private static void hello(Context context) {
        context.result("Hello world!");
        context.status(200);
    }
}
