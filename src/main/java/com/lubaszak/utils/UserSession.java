package com.lubaszak.utils;

public final class UserSession {

    private static UserSession instance;

    private int id;

    private UserSession(int id) {
        this.id = id;
    }

    public static void setSession(int id) {
        if(instance == null) {
            instance = new UserSession(id);
        }
    }

    public int getId() {
        return id;
    }

    public static UserSession getSession() {
        return instance;
    }

    public void cleanUserSession() {
        id = 0;// or null

    }

    @Override
    public String toString() {
        return "UserSession{" +
                "id='" + id;
    }
}
