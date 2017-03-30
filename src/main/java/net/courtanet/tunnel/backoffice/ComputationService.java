/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package net.courtanet.tunnel.backoffice;

import java.sql.*;

public class ComputationService {
    private final BackOfficeDAO dao = new BackOfficeDAO() ;

    public int sumEntries() throws SQLException {
        int sum = 0;
        for (BackOfficeEntry entry : dao.listAll(getConnection()))
            sum += entry.getValue();
        return sum;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:h2:~/lesfurets-test-tech", "sa", "");
    }
}
