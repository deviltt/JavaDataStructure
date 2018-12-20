package food.src.com.imooc.entity;

public class Food {
    int foodId;
    String foodName;
    String taste;
    String path;
    double price;
    String desc;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getPrive() {
        return price;
    }

    public void setPrice(double prive) {
        this.price = prive;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", taste='" + taste + '\'' +
                ", path='" + path + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
