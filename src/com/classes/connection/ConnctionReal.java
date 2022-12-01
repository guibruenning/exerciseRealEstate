package com.classes.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnctionReal {
    final static String NOME_DO_BANCO = "realState";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
            //System.err.println("Erro: " + e.toString());
            //e.printStackTrace();
            return null;
        }
    }
}
