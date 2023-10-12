package services;

import models.Car;

import java.util.List;

public interface DefaultService<T> {
    void save(T obj);
    T findById(int id);
    void update(T obj);
    void removeById(int id);
    List<T> listAll();
}
