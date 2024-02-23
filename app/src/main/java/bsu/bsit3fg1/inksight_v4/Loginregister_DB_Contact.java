package bsu.bsit3fg1.inksight_v4;

import android.provider.BaseColumns;

public final class Loginregister_DB_Contact {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Loginregister_DB_Contact() {}

    // Inner class that defines the table contents
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PASSWORD = "password";
    }
}