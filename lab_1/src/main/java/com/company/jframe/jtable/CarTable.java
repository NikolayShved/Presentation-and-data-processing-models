package com.company.jframe.jtable;

import com.company.entity.Car;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

public class CarTable extends JFrame {

    private Object[] columnsHeader = new String[] {
            "Модель", "Название", "Цена", "Кол-во мест", "Объём двигателя"
    };

    public CarTable(ArrayList<Car> carArray) {
        super("Автомобили");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Vector<String> header = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();

        for (int i = 0; i < columnsHeader.length; i++) {
            header.add((String) columnsHeader[i]);
        }

        for (Car car: carArray) {
            Vector<String> row = new Vector<>();
            row.add(car.getCarModel());
            row.add(car.getCarName());
            row.add(Integer.toString(car.getPrice()));
            row.add(Integer.toString(car.getSeats()));
            row.add(Float.toString(car.getVolumeGasoline()));

            data.add(row);
        }

        JTable carTable = new JTable(data, header);

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(carTable));
        setContentPane(contents);
        setSize(1024, 200);
        setVisible(true);
    }
}
