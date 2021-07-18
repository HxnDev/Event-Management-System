package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Database to store each pre-defined menus or customer's customized menu
// MANAGER also has access to this class.
// Manager/Event -> MenuDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.sql.*;
import java.util.Scanner;

public class MenuDB {

    public void displayAllMenus() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - display all menus");

                String query = "select * from MENU";  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    String id = rs.getString("menu_id");

                    String rice = rs.getString("rice");
                    String bread = rs.getString("bread");
                    String protein = rs.getString("protein");

                    boolean coke = rs.getBoolean("coke");
                    boolean miranda = rs.getBoolean("miranda");
                    boolean sprite = rs.getBoolean("sprite");
                    boolean water = rs.getBoolean("water");

                    boolean dryfruit = rs.getBoolean("dryfruit");
                    boolean sugarfree = rs.getBoolean("sugarfree");

                    boolean icecream = rs.getBoolean("icecream");
                    boolean cake = rs.getBoolean("cake");

                    int cost = rs.getInt("cost");

                    System.out.print("ID: ");
                    System.out.println(id);

                    Menu obj = new Menu(rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost);
                    obj.display();
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void displayMenu(String id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - display a menu");

                String query = "select * from MENU where MENU_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    String rice = rs.getString("rice");
                    String bread = rs.getString("bread");
                    String protein = rs.getString("protein");

                    boolean coke = rs.getBoolean("coke");
                    boolean miranda = rs.getBoolean("miranda");
                    boolean sprite = rs.getBoolean("sprite");
                    boolean water = rs.getBoolean("water");

                    boolean dryfruit = rs.getBoolean("dryfruit");
                    boolean sugarfree = rs.getBoolean("sugarfree");

                    boolean icecream = rs.getBoolean("icecream");
                    boolean cake = rs.getBoolean("cake");

                    int cost = rs.getInt("cost");

                    System.out.print("ID: ");
                    System.out.println(id);

                    Menu obj = new Menu(rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost);
                    obj.display();
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Menu getMenu(String id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - getting a menu");

                String query = "select * from MENU where MENU_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    String rice = rs.getString("rice");
                    String bread = rs.getString("bread");
                    String protein = rs.getString("protein");

                    boolean coke = rs.getBoolean("coke");
                    boolean miranda = rs.getBoolean("miranda");
                    boolean sprite = rs.getBoolean("sprite");
                    boolean water = rs.getBoolean("water");

                    boolean dryfruit = rs.getBoolean("dryfruit");
                    boolean sugarfree = rs.getBoolean("sugarfree");

                    boolean icecream = rs.getBoolean("icecream");
                    boolean cake = rs.getBoolean("cake");

                    int cost = rs.getInt("cost");

                    System.out.print("ID: ");
                    System.out.println(id);

                    Menu obj = new Menu(rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, cost);
                    return obj;
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        Menu emptyObj = new Menu();
        return emptyObj;
    }

    public String addMenu()                           //Manager can add menu
    {
        Scanner input = new Scanner(System.in);
        String rice, protein, bread;
        boolean icecream, cake, dryfruit, sugarfree, coke, miranda, sprite, water;
        int net_sum;
        char c;

        System.out.print("Enter rice dish (Biryani / Pulao / Plain White Rice / Plain Brown Rice) : ");
        rice = input.nextLine();

        System.out.print("Enter the protein (Chicken/Beef/Mutton/Fish): ");
        protein = input.nextLine();

        System.out.print("Enter your bread preference (Tandoori, naan, lebanese) : ");
        bread = input.nextLine();

        System.out.print("Do you need dry-fruits in your menu? y/n : ");
        c = input.next().charAt(0);
        dryfruit = (c == 'y');
        int df = dryfruit ? 1 : 0;

        System.out.print("Do you need ice-cream in your menu? y/n : ");
        c = input.next().charAt(0);
        icecream = (c == 'y');
        int ic = icecream ? 1 : 0;

        System.out.print("Do you need cake in your menu? y/n : ");
        c = input.next().charAt(0);
        cake = (c == 'y');
        int cake_ = cake ? 1 : 0;

        System.out.print("Do you need sugarfree in your menu? y/n : ");
        c = input.next().charAt(0);
        sugarfree = (c == 'y');
        int sg = sugarfree ? 1 : 0;

        System.out.print("Do you need Coke in your menu? y/n : ");
        c = input.next().charAt(0);
        coke = (c == 'y');
        int ck = coke ? 1 : 0;

        System.out.print("Do you need Miranda in your menu? y/n : ");
        c = input.next().charAt(0);
        miranda = (c == 'y');
        int mr = miranda ? 1 : 0;

        System.out.print("Do you need Sprite in your menu? y/n : ");
        c = input.next().charAt(0);
        sprite = (c == 'y');
        int sp = sprite ? 1 : 0;

        System.out.print("Do you need water in your menu? y/n : ");
        c = input.next().charAt(0);
        water = (c == 'y');
        int wt = water ? 1 : 0;

        System.out.print("The total price for this menu: ");
        net_sum = input.nextInt();

        Menu obj = new Menu(rice, bread, protein, coke, miranda, sprite, water, dryfruit, sugarfree, icecream, cake, net_sum);

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - inserting a menu");

                String query = "select * from menu";  // selects all data from database

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String last_id = "10000";

                while (rs.next()) {                                            // reads a row
                    last_id = rs.getString("menu_id");             // reads an id
                }

                int temp = Integer.parseInt(last_id);
                temp++;
                String new_id = Integer.toString(temp);

                query = "insert into MENU(MENU_ID, RICE, BREAD, PROTEIN, COKE, MIRANDA, SPRITE, WATER, DRYFRUIT, SUGARFREE, ICECREAM, CAKE, COST)" +
                        "values('" + new_id + "','" + obj.getRice() + "','" + obj.getBread() + "','" + obj.getProtein() + "'," + ck + "," + mr + "," + sp + "," +
                        wt + "," + df + "," + sg + "," + ic + "," + cake + "," +obj.getCost() + ")";

                // System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");

                return new_id;
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

        return "";
    }

    public void addMenu(Menu obj, String id)
    {
        int df, sg, ck, mr, sp, wt, ic, cake;

        ck = obj.isCoke() ? 1 : 0;
        mr = obj.isMiranda() ? 1 : 0;
        sp = obj.isSprite() ? 1 : 0;
        wt = obj.isWater() ? 1 : 0;

        df = obj.isDryfruit() ? 1 : 0;
        sg = obj.isSugarFree() ? 1 : 0;

        ic = obj.isIcecream() ? 1 : 0;
        cake = obj.isCake() ? 1 : 0;

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - adding a menu object + id");

                Statement stmt = conn.createStatement();

                String query = "insert into MENU(MENU_ID, RICE, BREAD, PROTEIN, COKE, MIRANDA, SPRITE, WATER, DRYFRUIT, SUGARFREE, ICECREAM, CAKE, COST)" +
                        "values('" + id + "','" + obj.getRice() + "','" + obj.getBread() + "','" + obj.getProtein() + "'," + ck + "," + mr + "," + sp + "," +
                        wt + "," + df + "," + sg + "," + ic + "," + cake + "," +obj.getCost() + ")";

                //System.out.println(query);
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

    public String addMenu(Menu obj)
    {
        int df, sg, ck, mr, sp, wt, ic, cake;

        ck = obj.isCoke() ? 1 : 0;
        mr = obj.isMiranda() ? 1 : 0;
        sp = obj.isSprite() ? 1 : 0;
        wt = obj.isWater() ? 1 : 0;

        df = obj.isDryfruit() ? 1 : 0;
        sg = obj.isSugarFree() ? 1 : 0;

        ic = obj.isIcecream() ? 1 : 0;
        cake = obj.isCake() ? 1 : 0;

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null) {
                System.out.println("Database - adding a menu object");

                String query = "select * from menu";  // selects all data from database

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String last_id = "10000";

                while (rs.next()) {                                            // reads a row
                    last_id = rs.getString("menu_id");             // reads an id
                }

                int temp = Integer.parseInt(last_id);
                temp++;
                String new_id = Integer.toString(temp);

                query = "insert into MENU(MENU_ID, RICE, BREAD, PROTEIN, COKE, MIRANDA, SPRITE, WATER, DRYFRUIT, SUGARFREE, ICECREAM, CAKE, COST)" +
                        "values('" + new_id + "','" + obj.getRice() + "','" + obj.getBread() + "','" + obj.getProtein() + "'," + ck + "," + mr + "," + sp + "," +
                        wt + "," + df + "," + sg + "," + ic + "," + cake + "," +obj.getCost() + ")";

                //System.out.println(query);
                stmt.executeUpdate(query);
                stmt.executeUpdate("commit");

                return new_id;
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

        return "";
    }

    public void removeMenu(String id)                         //Manager can delete a menu
    {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - removing a menu");

                String query = "delete from MENU where MENU_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
    public void editMenu(String id)                                   //Manager can edit menu
    {
        Menu obj = getMenu(id);

        Scanner input = new Scanner(System.in);
        char c;

        System.out.print("Enter name for the menu: ");
        obj.setName(input.nextLine());

        System.out.print("Enter rice dish (Biryani / Pulao / Plain White Rice / Plain Brown Rice) : ");
        obj.setRice(input.nextLine());

        System.out.print("Enter the protein (Chicken/Beef/Mutton/Fish): ");
        obj.setProtein(input.nextLine());

        System.out.print("Enter your dish (Karahi, Qorma, Daal, Manchurian, White Qorma) : ");
        obj.setDish(input.nextLine());

        System.out.print("Do you need dry-fruits in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setDry_fruit((c == 'y'));

        System.out.print("Do you need roti/naan in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setBread((c == 'y'));

        System.out.print("Do you need sugarfree in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setSugarFree((c == 'y'));

        System.out.print("Do you need Coke in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setCoke((c == 'y'));

        System.out.print("Do you need Miranda in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setMiranda((c == 'y'));

        System.out.print("Do you need Sprite in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setSprite((c == 'y'));

        System.out.print("Do you need water in your menu? y/n : ");
        c = input.next().charAt(0);
        obj.setWater((c == 'y'));

        System.out.print("Enter the total price for this menu: ");
        obj.setNet_sum(input.nextInt());

        this.removeMenu(id);
        this.addMenu(obj, id);
    } */

    public int getMenuCost(String id) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Globals.getDb_name(), Globals.getDb_username(), Globals.getDb_pass());
        )
        {
            if (conn != null)
            {
                System.out.println("Database - getting cost of a menu");

                String query = "select * from MENU where MENU_ID = " + id;  // query to be sent

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    int cost = rs.getInt("cost");
                    return cost;
                }
            }

            else
            {
                System.out.println("Failed to make connection!");
            }
        }

        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return 0;
    }
}
