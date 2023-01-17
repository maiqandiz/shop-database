public class Product{

    String nameProduct, price;
    public Product(String nameProduct, String price){
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public void setNameProduct(String nameProduct){
        this.nameProduct = nameProduct;
    }

    public String getNameProduct(){
        return nameProduct;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public String getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return this.nameProduct;
    }
}
