package com.company.jframe;

import com.company.entity.Car;

import javax.swing.*;
import java.util.List;

public class CarList extends JFrame {
    private DefaultListModel<Car> dlm = new DefaultListModel<Car>();

    public CarList(List<Car> cars)
    {
        super("Автомобили");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();

        for (Car car : cars) {
            dlm.add(0, car);
        }

        JList<Car> list1 = new JList<Car>(dlm);

        contents.add(new JScrollPane(list1));

        setContentPane(contents);
        setSize(600, 200);
        setVisible(true);
    }

}
