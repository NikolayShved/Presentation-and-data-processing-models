package com.company;

import com.company.converter.CarConverter;
import com.company.entity.Car;
import com.company.entity.Student;
import com.company.jframe.CarTable;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Student studentFromIniFile = new Student();
        System.out.println(studentFromIniFile);

        List<HashMap> arrayCars = CarConverter.convertXmlFileToListMap();
        System.out.println(arrayCars);

        ArrayList<Car> carArrayForJTable = CarConverter.convertListMapToListCar(arrayCars);
        new CarTable(carArrayForJTable);
    }
}
