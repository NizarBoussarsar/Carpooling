package team.esprit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/covoiturage";
    private static final String login = "root";
    private static final String pwd = "";
    private static Connection con;

    private MyConnection() {
    }

    public Connection etablirConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Erreur de chargement du driver " + ex.getMessage());
        } 
        catch (SQLException ex) {
            System.out.println("Probleme d'établissement de connection " + ex.getMessage());
        }
        return con;
    }

    public static Connection getInstance() {
        if (con == null) {
            new MyConnection().etablirConnection();
        }
        return con;
    }
}