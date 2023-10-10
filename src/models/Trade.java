package models;

public class Trade {
    private static int ID_COUNTER;
    private int id;
    private Car car;
    private Customer customer;

    public Trade(Car car, Customer customer) {
        this.id = ++ID_COUNTER;
        this.car = car;
        this.customer = customer;
    }

    public Trade(int id, Car car, Customer customer) {
        this.id = id;
        this.car = car;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return id +
                " " +
                car.toString() +
                " " +
                customer.toString();
    }
}
