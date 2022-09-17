package com.company.entity;

public class Car {

    private String carModel;
    private String carName;
    private int price;
    private int seats;
    private float volumeGasoline;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getVolumeGasoline() {
        return volumeGasoline;
    }

    public void setVolumeGasoline(float volumeGasoline) {
        this.volumeGasoline = volumeGasoline;
    }

    @Override
    public String toString() {
        return "Модель - '" + carModel + "'\n" +
                ", Название - '" + carName + "'\n" +
                ", Цена - " + price + "\n" +
                ", Кол. мест - " + seats + "\n" +
                ", Объем бака - " + volumeGasoline + "\n";
    }
}
