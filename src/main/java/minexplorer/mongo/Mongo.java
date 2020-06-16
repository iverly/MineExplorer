package minexplorer.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import minexplorer.Player;
import minexplorer.mongo.providers.PlayerProvider;
import org.bson.Document;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
public class Mongo {

    public MongoClient client;
    private Morphia morphia;
    public Datastore datastore;

    public PlayerProvider playerProvider;

    public boolean connect() {
        try {
            client = new MongoClient(new MongoClientURI("mongodb+srv://dev:arkcore@acf-dev-xmihg.gcp.mongodb.net/acf?retryWrites=true&w=majority"));
            MongoDatabase database = client.getDatabase("mineexplorer");
            database.runCommand(new Document("connectionStatus", 1));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        morphia = new Morphia();
        datastore = morphia.createDatastore(client, "mineexplorer");
        datastore.ensureIndexes();

        // Providers
        playerProvider = new PlayerProvider(Player.class, datastore);

        return true;
    }

}
