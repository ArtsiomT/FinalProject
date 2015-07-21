package by.epam.terehovich.internetprovider.entity;

/**
 * Created by aterehovich on 18.7.15.
 */
public abstract class Entity {
    private int id;

    public Entity(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
