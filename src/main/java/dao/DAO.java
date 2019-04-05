package dao;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {
    T create (T t);

    T read(int i);

    T update(int i,T t);

    void delete(int id);
}
