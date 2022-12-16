package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionReal {
    final static String NOME_DO_BANCO = "realstate";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
}
