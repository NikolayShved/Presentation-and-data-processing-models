package ru.cchgeu.db;

import ru.cchgeu.entity.Kafedra;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB_Worker {

    private static final String URL = "jdbc:mysql://localhost:3306/example?autoReconnect=true" +
                                                                           "&useSSL=false" +
                                                                           "&useLegacyDatetimeCode=false" +
                                                                           "&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    public static void Connections()
    {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e) {
            e.getSQLState();
        }
    }


    public void addNewKafedra(Kafedra kafedra)
    {
        try {
            String query = " INSERT INTO kafedra (id, name, fone, address, age)"  + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, kafedra.getId());
            preparedStmt.setString (2, kafedra.getName());
            preparedStmt.setString (3, kafedra.getFone());
            preparedStmt.setString (4, kafedra.getAddress());
            preparedStmt.setInt (5, kafedra.getAge());
            preparedStmt.execute();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }


    public List<Kafedra> getKafedraData(String tableName) {

        List<Kafedra> kafedraList = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tableName;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Kafedra kafedra = new Kafedra(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
                kafedraList.add(kafedra);
            }

            return kafedraList;
        }
        catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return kafedraList;
    }


    public List<Kafedra> getKafedraMetaData(String tableName) {
        List<Kafedra> kafedraList = new ArrayList<>();
        ArrayList<HashMap> arrayList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {

                HashMap<String, Object> map = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    map.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i));
                }
                arrayList.add(map);
            }

            for (HashMap<String, Object> item: arrayList) {
                kafedraList.add(new Kafedra(item));
            }

            return kafedraList;
        }
        catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return kafedraList;
    }

}
