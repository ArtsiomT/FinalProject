package by.epam.terehovich.internetprovider.dao;

import by.epam.terehovich.internetprovider.connection.ConnectionPool;
import by.epam.terehovich.internetprovider.entity.Entity;
import by.epam.terehovich.internetprovider.entity.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by aterehovich on 18.7.15.
 */
public abstract class AbstractDAO<K, T extends Entity> {
    protected Connection connection;

    public AbstractDAO(){
        this.connection = ConnectionPool.getInstance().getConnection();
    }
    public abstract List<T> findAll();
    public abstract T findById(K id);
    public abstract T findByKey(String key);
    public abstract boolean insertNew(T entity);
    public abstract boolean deleteById(K id);
}
