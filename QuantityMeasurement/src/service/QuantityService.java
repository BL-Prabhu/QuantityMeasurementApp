package service;


import model.IMeasurable;
import model.Quantity;

public interface QuantityService<U extends IMeasurable> {

    Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U unit);

    double divide(Quantity<U> q1, Quantity<U> q2);
}