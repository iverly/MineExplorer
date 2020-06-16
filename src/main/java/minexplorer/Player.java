package minexplorer;

import dev.morphia.annotations.*;
import org.bson.types.ObjectId;

/**
 * @author iverly on 16/06/2020
 * @project MineExplorer
 */
@Entity(value = "players", noClassnameStored = true)
public class Player {

    @Id
    private ObjectId id;

    @Indexed(options = @IndexOptions(unique = true))
    private String name;

    private float money;

    public Player() {}

    public Player(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}
