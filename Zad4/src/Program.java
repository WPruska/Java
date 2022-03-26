import Entity.Category;
import Entity.Category;
import Entity.Product;
import Helpers.Menu;
import Helpers.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private String _path = "";
    private ArrayList<Product> _shoppingList;
    private ArrayList<Category> _listOfItems;
    private ReadFromFile _rff;
    private final Scanner _scan;

    Program() {
        _scan = new Scanner(System.in);
        _path = GetProjectPath();
        _rff = new ReadFromFile(_path);
        _listOfItems =  _rff.LoadDataFormFile();
        _shoppingList = LoadShopingList();
    }

    public void StartProgram()
    {
        Menu menu = new Menu(_shoppingList, _listOfItems);
        menu.ShowMenu();
    }

    private static String GetProjectPath()
    {
        String path = "";
        try {
            path = new File(".").getCanonicalPath();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    private ArrayList<Product> LoadShopingList()
    {
        boolean isCorrect = false;
        String answer;
        ArrayList<Product> shoppingList = new ArrayList<>();

        while(!isCorrect)
        {
            try {
                System.out.println("Do you want load shopping list Y/N: ");
                answer = _scan.nextLine();

                if (answer.equals("Y") || answer.equals("y"))
                {
                    shoppingList = _rff.LoadShoppingList();
                    return shoppingList;
                }
                else if(answer.equals("N") || answer.equals("n"))
                {
                    return shoppingList;
                }
                else
                {
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Bad choice! Take another one!");
                _scan.next();
            }
        }
        return shoppingList;
    }
}