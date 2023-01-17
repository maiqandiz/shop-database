import java.util.ArrayList;

public class Shop {

    String nameShop;
    ArrayList<Department> Departments = new ArrayList<>();
    public Shop(String nameShop){
        this.nameShop = nameShop;
    }

    public String getName(){
        return nameShop;
    }
}