
public class Good {

    private String name;
    private float quantity;
    private float price;
    private float sum;
    private float nds10;

    public Good(String name, float sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float getNds10() {
        return nds10;
    }

    public void setNds10(float nds10) {
        this.nds10 = nds10;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", sum=" + sum +
                ", nds10=" + nds10 +
                '}';
    }
}
