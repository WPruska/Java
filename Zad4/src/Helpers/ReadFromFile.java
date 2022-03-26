package Helpers;

import Entity.Category;
import Entity.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile
{
    private String _data = "";
    public ReadFromFile(String data)
    {
        _data =  data;
    }

    public ArrayList<Category> LoadDataFormFile()
    {
        File fileToLoadData = OpenFile(_data + "/ListOfProducts.txt");

        return LoadDataItems(fileToLoadData);
    }

    public ArrayList<Product> LoadShoppingList()
    {
        File file = OpenFile(_data + "/shoppingList.txt");
        ArrayList<Product> shoppingList = LoadShoppingList(file);

        return shoppingList;
    }

    private File OpenFile(String data)
    {
        File file = null;
        try
        {
            file = new File(data);
            if(!file.exists())
            {
                System.out.println("File doesn't exist!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return file;
    }

    private ArrayList<Category> LoadDataItems(File file)
    {
        ArrayList<Category> listToReturn = new ArrayList<>();

        try
        {
            Scanner scan = new Scanner(file);
            Category categoryToAdd = null;
            int id = 0;

            while(scan.hasNextLine())
            {
                String line = scan.nextLine();

                if(!line.startsWith("-"))
                {
                    if(categoryToAdd != null)
                    {
                        listToReturn.add(categoryToAdd);
                    }

                    categoryToAdd = new Category(line);
                }
                else
                {
                    Product productToAdd = new Product(id, line.substring(1), categoryToAdd.CategoryName);
                    id++;
                    categoryToAdd.products.add(productToAdd);
                }
            }

            listToReturn.add(categoryToAdd);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return listToReturn;
    }

    private ArrayList<Product> LoadShoppingList(File file)
    {
        ArrayList<Product> listToReturn = new ArrayList<>();

        try
        {
            Scanner scan = new Scanner(file);
            int Id = 0;
            String Name = null;
            String Category = null;

            while(scan.hasNextLine())
            {
                Id = Integer.parseInt(scan.nextLine());
                Name = scan.nextLine();
                Category = scan.nextLine();
                listToReturn.add(new Product(Id, Name, Category));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return listToReturn;
    }
}
