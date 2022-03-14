package Entity;

import java.util.ArrayList;

public class Category {
    String CategoryName;
    ArrayList<Product> products = new ArrayList<>();

    public Category(String categoryName)
    {
        this.CategoryName = categoryName;
    }
}
