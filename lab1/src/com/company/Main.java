package com.company;

import com.company.entity.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Student studentFromIniFile = new Student();
        System.out.println(studentFromIniFile);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        // Создаётся экземпляр DocumentBuilder
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        // Создаётся экземпляр документа DOM из XML-файла
        Document document = builder.parse("./src/cars.xml");

        // Получаем корневой элемент '<cars>'
        Node rootElement = document.getDocumentElement();
        // Получаем список автомобилей (элементов '<car>')
        NodeList cars = rootElement.getChildNodes();

        // Создание объекта ArrayList для записей данных об автомобилях (Map = {"название поля", "значение поля"})
        List<HashMap> arrayCars = new ArrayList<>();
        for (int i = 0; i < cars.getLength(); i++) {
            // Нода для автомобилей (запись конкретного автомобиля)
            Node car = cars.item(i);
            // Проверка на наличие типа элемента XML-файла
            if (car.getNodeType() == Node.ELEMENT_NODE) {
                // Список полей конкретного автомобиля
                NodeList carProperties = car.getChildNodes();
                // Объект HashMap для записи этих полей - {"название поля", "значение поля"}
                HashMap<String, String> mapCarProperties = new HashMap<>();
                for (int j = 0; j < carProperties.getLength(); j++) {

                    // Нода для полей автомобиля (запись конкретного поля)
                    Node carProperty = carProperties.item(j);
                    // Проверка на наличие типа элемента XML-файла (в данном случае - параметр автомобиля)
                    if (carProperty.getNodeType() == Node.ELEMENT_NODE) {
                        // Добавление поля автомобиля в мапу mapCarProperties
                        mapCarProperties.put(
                                carProperty.getNodeName(),                                    // название поля
                                carProperty.getChildNodes().item(0).getTextContent()    // значение поля
                        );
                    }
                }
                // Добавление мапы mapCarProperties со свойствами автомобиля в массив автомобилей
                arrayCars.add(mapCarProperties);
            }
        }
        System.out.println(arrayCars);
    }
}
