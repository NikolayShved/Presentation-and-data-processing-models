package com.company;

import com.company.converter.CarConverter;
import com.company.converter.StudentConverter;
import com.company.entity.Car;
import com.company.entity.Student;
import com.company.jframe.jlist.CarList;
import com.company.jframe.jtable.CarTable;
import com.company.jframe.jlist.StudentList;
import com.company.jframe.jtable.StudentTable;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        List<Student> studentFromIniFile = StudentConverter.parseStudentList();
        System.out.println(studentFromIniFile);

        List<HashMap> arrayCars = CarConverter.convertXmlFileToListMap();
        System.out.println(arrayCars);

        ArrayList<Car> carArrayForJTableAndJList = CarConverter.convertListMapToListCar(arrayCars);

        new CarTable(carArrayForJTableAndJList);
        new StudentTable(studentFromIniFile);
        new CarList(carArrayForJTableAndJList);
        new StudentList(studentFromIniFile);
    }
}
