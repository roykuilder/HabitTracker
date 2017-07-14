package com.example.android.myapplication.data;

import android.provider.BaseColumns;

public final class HabitContract {

    public HabitContract() {
    }

    public class HabitEntry implements BaseColumns{

        /**
         * Table name for the DB
         */
        public static final String TABLE_NAME= "habit";

        /**
         * The unique number for the database.
         *
         * Type: INTEGER
         */
        public static final String _ID = BaseColumns._ID;


        /**
         * The date of the practice session.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_DATE = "date";

        /**
         * Number of sets for the session.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_SETS = "sets";

        /**
         * number of pushups per set.
         *
         * Type: INTEGER
         */
        public static final String COLUMN_NUMBER_PUSHUPS = "number";

        /**
         * comment on the feeling after the session
         *
         * Type: TEXT
         */
        public static final String COLUMN_FEELING = "feeling";
    }
}
