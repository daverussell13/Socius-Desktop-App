package com.socius.Models;

public class Session {
    private boolean authenticated;

    private Account loggedAccount;

    private Session() {
        this.authenticated = false;
        this.loggedAccount = null;
    }

    private static class InstanceHolder {
        private static final Session instance = new Session();
    }

    public static Session getInstance() {
        return InstanceHolder.instance;
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    public Account getLoggedAccount() {
        return loggedAccount;
    }

    public void setLoggedAccount(Account loggedAccount) {
        this.loggedAccount = loggedAccount;
        this.authenticated = true;
    }

    public void unsetLoggedAccount() {
        this.loggedAccount = null;
        this.authenticated = false;
    }
}