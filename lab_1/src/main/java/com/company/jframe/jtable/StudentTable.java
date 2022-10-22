package com.company.jframe.jtable;

import com.company.entity.Student;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class StudentTable extends JFrame {

    private Object[] columnsHeader = new String[] {
            "Имя", "Фамилия", "Возраст", "Страна", "Город", "Группа", "Семейное положение"
    };

    public StudentTable(List<Student> studentArray) {
        super("Студенты");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Vector<String> header = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();

        for (int i = 0; i < columnsHeader.length; i++) {
            header.add((String) columnsHeader[i]);
        }

        for (Student student: studentArray) {
            Vector<String> row = new Vector<>();
            row.add(student.getFirstName());
            row.add(student.getLastName());
            row.add(Integer.toString(student.getAge()));
            row.add(student.getCountry());
            row.add(student.getCity());
            row.add(student.getGroup());
            row.add(student.getMarriage(student.isMarriage()));

            data.add(row);
        }

        JTable studentTable = new JTable(data, header);

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(studentTable));
        setContentPane(contents);
        setSize(1024, 200);
        setVisible(true);
    }
}
