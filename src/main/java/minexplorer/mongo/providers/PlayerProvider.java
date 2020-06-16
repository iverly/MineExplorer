package minexplorer.mongo.providers;

import dev.morphia.Datastore;
import dev.morphia.dao.BasicDAO;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import minexplorer.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
public class PlayerProvider extends BasicDAO<Player, String> {

    public PlayerProvider(Class<Player> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    public Player findByName(String name) {
        return findOne("name", name);
    }

    public LinkedList<Player> getClassement() {
        List<Player> players = createQuery()
                .order(Sort.descending("money"))
                .limit(10)
                .asList();
        return new LinkedList<>(players);
    }

}
