package sample;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will add menu. It has a list of items that will be decided by the customer/ manager
// Customer/Manager -> Menu -> MenuDB
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Menu
{
    private String rice;                                //Which rice dish you want?
    private String bread;                                //tandoori/lebanese/naan
    private String protein;                             //Chicken/Beef/Mutton/Fish
    private boolean coke;                               //Beverage # 1
    private boolean miranda;                            //Beverage # 2
    private boolean sprite;                             //Beverage # 3
    private boolean water;                              //Beverage # 4
    private boolean dryfruit;                          //Dish for dry fruits?
    private boolean sugarfree;                              //Sugar free or not
    private boolean icecream;
    private boolean cake;
    private int cost;

    public Menu()
    {
        rice = bread = protein = "";
        dryfruit = sugarfree = false;
        coke = miranda = sprite = water = false;
        cost = 0;
    }

    public Menu(String rice, String bread, String protein, boolean coke, boolean miranda, boolean sprite,
                boolean water, boolean dryfruit, boolean sugarfree, boolean icecream, boolean cake, int cost) {
        this.rice = rice;
        this.bread = bread;
        this.protein = protein;
        this.coke = coke;
        this.miranda = miranda;
        this.sprite = sprite;
        this.water = water;
        this.dryfruit = dryfruit;
        this.sugarfree = sugarfree;
        this.icecream = icecream;
        this.cake = cake;
        this.cost = cost;
    }

    public String getRice() {
        return rice;
    }
    public void setRice(String rice) {
        this.rice = rice;
    }

    public String getBread() {
        return bread;
    }
    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getProtein() {
        return protein;
    }
    public void setProtein(String protein) {
        this.protein = protein;
    }

    public boolean isCoke() {
        return coke;
    }
    public void setCoke(boolean coke) {
        this.coke = coke;
    }

    public boolean isMiranda() {
        return miranda;
    }
    public void setMiranda(boolean miranda) {
        this.miranda = miranda;
    }

    public boolean isSprite() {
        return sprite;
    }
    public void setSprite(boolean sprite) {
        this.sprite = sprite;
    }

    public boolean isWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isDryfruit() {
        return dryfruit;
    }
    public void setDryfruit(boolean dryfruit) {
        this.dryfruit = dryfruit;
    }

    public boolean isSugarFree() {
        return sugarfree;
    }
    public void setSugar(boolean sugar) {
        this.sugarfree = sugarfree;
    }

    public boolean isIcecream() {
        return icecream;
    }
    public void setIcecream(boolean icecream) {
        this.icecream = icecream;
    }

    public boolean isCake() {
        return cake;
    }
    public void setCake(boolean cake) {
        this.cake = cake;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void display() {
        System.out.println("Rice = " + rice);
        System.out.println("Protein = " + protein);
        System.out.println("Bread = " + bread);

        System.out.print("Sugar Free = ");
        String str = (sugarfree) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Dry fruits included = ");
        str = (dryfruit) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Coke = ");
        str = (coke) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Miranda = ");
        str = (miranda) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Sprite = ");
        str = (coke) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Water = ");
        str = (coke) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Icecream = ");
        str = (icecream) ? "Yes" : "No";
        System.out.println(str);

        System.out.print("Cake = ");
        str = (cake) ? "Yes" : "No";
        System.out.println(str);

        System.out.println("Net cost = " + cost);

        System.out.println("");
    }

    public Menu getMenu(String menu_id) {
        MenuDB obj = new MenuDB();
        return obj.getMenu(menu_id);
    }

    public String addMenu() {
        MenuDB obj = new MenuDB();
        String menu_id = obj.addMenu(this);
        return menu_id;
    }
}
