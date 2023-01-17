import java.util.ArrayList;

public class Department{

    String nameDepart, OHours;
    ArrayList<Product> Products = new ArrayList<>();
    public Department(String nameDepart, String OHours){
        this.nameDepart = nameDepart;
        this.OHours = OHours;
    }

    public void setNameDepart(String nameDepart){
        this.nameDepart = nameDepart;
    }

    public String getNameDepart(){
        return nameDepart;
    }

    public void setOHours(String OHours){
        this.OHours = OHours;
    }

    public String getOHours(){
        return OHours;
    }

    @Override
    public String toString(){
        return this.nameDepart;
    }
}
