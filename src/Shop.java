import java.util.ArrayList;
import java.util.List;

public class Shop {

    String nameShop;
    ArrayList<Department> Departments = new ArrayList<Department>();
    public Shop(String nameShop){
        this.nameShop = nameShop;
    }

    public String getNameShop(){
        return nameShop;
    }
}