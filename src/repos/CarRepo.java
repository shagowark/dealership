package repos;

import models.Car;

import java.util.List;

public interface CarRepo {
    void save(Car car);
    Car findById(int id);
    void update(Car car);
    void removeById(int id);
    List<Car> listAll();
}
