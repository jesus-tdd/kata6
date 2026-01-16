package app.versions.charmander;

import app.io.CsvPokeParser;
import app.io.DatabaseRecorder;
import app.io.DatabaseStore;
import app.io.RemoteStore;
import app.view.MainFrame;
import architecture.model.Pokemon;
import architecture.model.Pokemon.Type;
import architecture.tasks.HistogramBuilder;
import architecture.viewmodel.Histogram;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final File database = new File("pokemon.db");
    static void main() {
        try (Connection connection = openConnection()) {
            importDataFromRemoteIfRequired(connection);
            Histogram<Type> histogram = HistogramBuilder.with(new DatabaseStore(connection).pokemons())
                    .title("Pokemons per Type")
                    .x("Types")
                    .y("Count")
                    .legend("Pokemons")
                    .build(p -> p.types().stream());
            MainFrame.create()
                    .display(histogram)
                    .setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void importDataFromRemoteIfRequired(Connection connection) throws SQLException {
        if (database.length() > 0) return;
        new DatabaseRecorder(connection).put(new RemoteStore(CsvPokeParser::parse).pokemons());
    }

    private static Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + database.getAbsolutePath());
        connection.setAutoCommit(false);
        return connection;
    }
}
