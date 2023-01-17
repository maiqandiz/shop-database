public class Product extends Department {

    int price;
    String nameProduct;
    public Product(String nameShop, String nameDepart, String OHours, String nameProduct, int price){
        super(nameShop, nameDepart, OHours);
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public void setNameProduct(String nameProduct){
        this.nameProduct = nameProduct;
    }

    public String getNameProduct(){
        return nameProduct;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
