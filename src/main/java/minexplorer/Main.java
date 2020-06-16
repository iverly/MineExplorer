package minexplorer;

import minexplorer.mines.Centralia;
import minexplorer.mines.Luisenthal;
import minexplorer.mongo.Mongo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
public class Main {

    public static Mongo mongo;

    public static void main(String[] args) {
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.getLogger("org.mongodb").setLevel(Level.OFF);
        mongo = new Mongo();

        System.out.println("Connection à la base de donnée ...");
        boolean connect = mongo.connect();
        if (!connect) {
            System.out.println("Une erreur de connection est apparue !");
            System.exit(1);
        } else {
            System.out.println("Connexion à la base de donnée réussie !");
        }

        Game game = new Game(1);
        game.ajouterMines(new Centralia(), new Luisenthal());
        game.start();
    }

}
