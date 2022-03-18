package Entity;

import java.util.ArrayList;

public class Category {
    public String CategoryName;
    public ArrayList<Product> products = new ArrayList<>();

    public Category(String categoryName)
    {
        this.CategoryName = categoryName;
    }
}
