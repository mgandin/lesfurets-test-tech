/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package net.courtanet.tunnel.backoffice;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class BackOfficeDAO {

    private static final String SQL_SELECT_LAST_WEEK = "SELECT ID, VALUE, CREATION_DATE from BO_FICHE";

    public List<BackOfficeEntry> listAll(Connection conn) throws SQLException {
        final List<BackOfficeEntry> entries = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_LAST_WEEK);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                Integer value = rs.getInt("VALUE");
                java.util.Date date = rs.getDate("CREATION_DATE");
                LocalDate creationDate = Instant.ofEpochMilli(date.getTime())
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate();
                final BackOfficeEntry entry = new BackOfficeEntry(id, value, creationDate);
                entries.add(entry);
            }
            return entries;
        } finally {
            doFinally(ps, rs);
        }
    }

    private void doFinally(PreparedStatement ps, ResultSet rs) {

    }
}
