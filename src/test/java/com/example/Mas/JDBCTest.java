package com.example.Mas;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Fail.fail;

public class JDBCTest {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://192.168.0.65:3306/security?useSSL=false&serverTimezone=Asia/Seoul",
                            "cos",
                            "cos12345")){
            System.out.println(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}