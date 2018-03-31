/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.hospital.DbConeection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asitha Imala
 */
public class DB {

    private static Connection con;

    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb", "root", ""
                + "");
        return con;
    }

}
