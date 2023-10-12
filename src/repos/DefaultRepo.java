package repos;

import models.Trade;

import java.util.List;

public interface DefaultRepo<T> {
    void save(T obj);
    T findById(int id);
    void update(T obj);
    void removeById(int id);
    List<T> listAll();
}
