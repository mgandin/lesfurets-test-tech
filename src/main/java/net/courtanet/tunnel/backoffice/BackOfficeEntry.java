/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package net.courtanet.tunnel.backoffice;

import java.time.LocalDate;

public class BackOfficeEntry {

    private final Integer id;
    private final Integer value;
    private final LocalDate creationDate;

    public BackOfficeEntry(Integer id, Integer value, LocalDate creationDate) {
        this.id = id;
        this.value = value;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
