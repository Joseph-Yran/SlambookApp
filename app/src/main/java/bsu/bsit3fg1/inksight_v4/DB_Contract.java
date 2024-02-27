package bsu.bsit3fg1.inksight_v4;

import android.provider.BaseColumns;

public class DB_Contract {
    public static class User implements BaseColumns{
        //Table
        public static final String USER_TABLE = "table_user";
        //Columns
        public static final String ID = "user_id";
        public static final String COMPLETE_NAME = "user_complete_name";
        public static final String USERNAME = "user_username";
        public static final String PASSWORD = "user_password";
        public static final String BIRTHDAY = "user_birthday";
        public static final String ADDRESS = "user_address";
        public static final String ARCHIVED = "archived";
    }

    public static class Post implements  BaseColumns{
        public static final String POST_TABLE = "table_post";
        public static final String ID = "post_id";
        public static final String USER_ID = "user_id";
        public static final String TEXT = "post_text";
        public static final String DATE = "post_date";
    }

}
