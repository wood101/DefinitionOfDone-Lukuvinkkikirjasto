/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.data_access;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author bisi
 */
public interface Database {

    /**
     *
     * @throws SQLException
     */
    void init() throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;
}