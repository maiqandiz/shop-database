public class Department extends Shop {

    String nameDepart, OHours;
    public Department(String nameShop, String nameDepart, String OHours){
        super(nameShop);
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
}
