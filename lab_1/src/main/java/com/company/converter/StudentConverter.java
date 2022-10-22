package com.company.converter;

import com.company.entity.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class StudentConverter {

    public static List<Student> parseStudentList() throws IOException {
        Map<String, Properties> result = new HashMap();
        new Properties() {

            private Properties section;

            @Override
            public Object put(Object key, Object value) {
                String header = (((String) key) + " " + value).trim();
                if (header.startsWith("[") && header.endsWith("]"))
                    return result.put(header.substring(1, header.length() - 1),
                            section = new Properties());
                else
                    return section.put(key, value);
            }

        }.load(new FileInputStream("./src/main/resources/Student.ini"));

        List<Student> students = new ArrayList<>();

        result.forEach((header, value) -> {

            Student student = new Student();
            student.setFirstName(value.getProperty("FIRST_NAME"));
            student.setLastName(value.getProperty("LAST_NAME"));
            student.setAge(Integer.valueOf(value.getProperty("AGE")));
            student.setCountry(value.getProperty("COUNTRY"));
            student.setCity(value.getProperty("CITY"));
            student.setGroup(value.getProperty("GROUP"));
            student.setMarriage(Boolean.valueOf(value.getProperty("IS_MARRIAGE")));

            students.add(student);
        });

        return students;
    }
}
