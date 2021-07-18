package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Database to store new manager's information
// Promotes pre-existing employee
// Manager -> ManagerDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class ManagerDB {
  /*  public void addManager() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee id of the employee to be promoted: ");
        String id = input.nextLine();

        System.out.print("Enter no# of past projects: ");
        int pp = input.nextInt();

        input.nextLine();

        System.out.print("Enter starting time of shift: ");
        String start = input.nextLine();

        System.out.print("Enter ending time of shift: ");
        String end = input.nextLine();

        System.out.print("Enter achievements (if any): ");
        String achievements = input.nextLine();

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Connected to the database!");

                Statement stmt = conn.createStatement();

                String query = "insert into manager(emp_id, shift_starts_at, shift_ends_at, no_of_past_projects, achievements)" +
                        "values('" + id + "','" + start + "','" + end + "'," + Integer.toString(pp) + ",'" + achievements + "')";

                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

   */

    public void approveEvent(String event_id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database: Manager approving event");

                String query = "UPDATE event SET approved = 1 WHERE event_id = '" + event_id + "'";

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);

                query = "commit";
                stmt.executeUpdate(query);
            }

            else {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
