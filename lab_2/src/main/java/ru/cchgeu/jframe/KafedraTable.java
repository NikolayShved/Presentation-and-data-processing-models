package ru.cchgeu.jframe;

import ru.cchgeu.entity.Kafedra;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class KafedraTable extends JFrame {

    private Object[] columnsHeader = new String[] {
            "Id", "Аббревиатура", "Телефон", "Адрес", "Возраст"
    };

    public KafedraTable(List<Kafedra> kafedraList) {
        super("Кафедры");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Vector<String> header = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();

        for (int i = 0; i < columnsHeader.length; i++) {
            header.add((String) columnsHeader[i]);
        }

        for (Kafedra kafedra: kafedraList) {
            Vector<String> row = new Vector<>();
            row.add(Integer.toString(kafedra.getId()));
            row.add(kafedra.getName());
            row.add(kafedra.getFone());
            row.add(kafedra.getAddress());
            row.add(Integer.toString(kafedra.getAge()));

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
