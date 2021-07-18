package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will contain a list of variables associated with the database being used
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Globals {
    private static String db_name;
    private static String db_username;
    private static String db_pass;

    public static String getDb_name() {
        return db_name;
    }
    public static void setDb_name(String db_name) {
        Globals.db_name = db_name;
    }

    public static String getDb_username() {
        return db_username;
    }
    public static void setDb_username(String db_username) {
        Globals.db_username = db_username;
    }

    public static String getDb_pass() {
        return db_pass;
    }
    public static void setDb_pass(String db_pass) {
        Globals.db_pass = db_pass;
    }
}