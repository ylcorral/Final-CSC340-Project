/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.DB;

/**
 * Interface to DB Connector 11/15/2020
 *
 * @author David Bowles
 */

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface DBConnectorInterface {

    //reda one parameter
    public static String readUserParameters(String _label, int _rowNum) throws SQLException {
        return null;
    }

    ;
   
   //reads whole row
   public static HashMap<String, String> readUserInfoDB(int _rowNum) throws SQLException {
        return null;
    }

    ;
   
   //updates userinfo
   public static void updateUserInfoDB(String _label, String _variable, String _id) throws SQLException {

    }

    ;
   //deletes info
   public static void deleteUserInfoDB(int _rowNum) throws SQLException {

    }

    ;
   //adds new user
   public static void addUserInfoDB(HashMap<String, String> _map) throws SQLException {

    }
;
}
