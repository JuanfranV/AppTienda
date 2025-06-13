package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {

    public static final Properties props = new Properties();
    static{
        try(
                InputStream in = JDBCUtil.class.getClassLoader().
                        getResourceAsStream("db.properties")
        ){
            if (in==null){
                throw new RuntimeException("No se encuentra el archivo");
            }
            props.load(in);
        }catch (IOException e){
                    throw new ExceptionInInitializerError("Error al cargar el archivo" + e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception{
        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("jdbc.user");
        String password = props.getProperty("jdbc.password"):
        return DriverManager.getConnection(url, user, password);
    }

}
