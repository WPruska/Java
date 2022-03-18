package Helpers;

import Entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveDataToFile {
    public static void SaveData(ArrayList<Product> productsList)
    {
        try {
            FileWriter myWriter = new FileWriter("shoppingList.txt");
            productsList.forEach(product ->
            {
                try {
                    myWriter.write(String.valueOf(product.Id) + "\n");
                    myWriter.write(product.Name + "\n");
                    myWriter.write(product.Category + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
