package com.car.rental.model;

public class Car implements Vehicle{
    private String model;
    private String numberPlate;
    private CarType type;

    public Car() {

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
    public void setType(CarType type){
        this.type=type;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public CarType getType() {
        return type;
    }
}
