package com.company.jframe.jlist;

import com.company.entity.Car;
import com.company.entity.Student;

import javax.swing.*;
import java.util.List;

public class StudentList extends JFrame {

    private DefaultListModel<Student> dlm = new DefaultListModel<>();

    public StudentList(List<Student> students)
    {
        super("Студенты");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();

        for (Student student : students) {
            dlm.add(0, student);
        }

        JList<Student> list1 = new JList<>(dlm);

        contents.add(new JScrollPane(list1));

        setContentPane(contents);
        setSize(900, 200);
        setVisible(true);
    }
}
