package repos;

import models.Trade;

import java.util.List;
import java.util.UUID;

public interface DefaultRepo<T> {
    void save(T obj);
    T findById(UUID id);
    void update(T obj);
    void removeById(UUID id);
    List<T> listAll();
}
