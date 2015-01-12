package com.shop.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogEntryKey {
    private Session session;
    private Transaction transaction;

    public LogEntryKey(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntryKey)) return false;

        final LogEntryKey logEntryKey = (LogEntryKey) o;

        if (session != logEntryKey.session) return false;
        if (transaction != logEntryKey.transaction) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = session.hashCode();
        result = 29 * result + (transaction != null ? transaction.hashCode() : 0);
        return result;
    }
}
