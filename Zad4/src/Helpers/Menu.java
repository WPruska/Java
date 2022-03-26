package Helpers;

import Entity.Category;
import Entity.Product;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    private final ArrayList<Category> _listOfItems;
    private final ArrayList<Product> _shoppingList;
    private final Scanner _scan;

    public Menu(ArrayList<Product> shoppingList, ArrayList<Category> listOfItems)
    {
        _scan = new Scanner(System.in);
        _shoppingList = shoppingList;
        _listOfItems = listOfItems;
    }

    private void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    private void ShowItemList()
    {
        System.out.println("========ITEMS LIST========");
        int i[] = {0};
        _listOfItems.forEach((c) ->
        {
            c.products.forEach(p -> {
                System.out.println(p.Id+1 + ". " + p.Name);
                i[0] = p.Id + 1;
            });
        });
        System.out.println(i[0] + 1 + ". Return");
    }

    private void AddProductToShopingList()
    {
        boolean isCorrect = false;
        int choicedItem = 0;
        ShowItemList();

        ArrayList<Product> productList = new ArrayList<>();
        _listOfItems.forEach((c) ->
        {
            productList.addAll(c.products);
        });

        while(!isCorrect)
        {
            try {
                System.out.println("Which item you want to add: ");
                choicedItem = _scan.nextInt();
                isCorrect = true;
                if(choicedItem < 1 || choicedItem > productList.size() + 1)
                {
                    System.out.println("Bad choice! Take another one!");
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Bad choice! Take another one!");
                _scan.next();
            }
        }

        if (choicedItem == productList.size() + 1)
        {
            return;
        }

        try
        {
            int finalChoicedItem = choicedItem;
            Product productToAdd = productList.stream().filter(product -> product.Id == finalChoicedItem - 1).findFirst().orElseThrow();
            _shoppingList.add(productToAdd);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private void RemoveItemFormShopingList()
    {
        boolean isCorrect = false;
        int choicedItem = 0;
        final int[] i = {0};
        System.out.println("=====SHOPPING LIST=====");
        _shoppingList.forEach(product ->
        {
            System.out.println(i[0] +1 + ". " + product.Name);
            i[0]++;
        });
        System.out.println(i[0] + 1 + ". Return");

        while(!isCorrect)
        {
            try {
                System.out.println("Which item you want to remove: ");
                choicedItem = _scan.nextInt();
                isCorrect = true;
                if(choicedItem < 1 || choicedItem > _shoppingList.size() + 1)
                {
                    System.out.println("Bad choice! Take another one!");
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Bad choice! Take another one!");
                _scan.next();
            }
        }

        if(choicedItem == i[0] +1)
        {
            return;
        }

        try
        {
            _shoppingList.remove(choicedItem-1);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return;
    }

    private void TakeAChoice()
    {
        boolean isCorrect = false;
        int choice = 0;
        System.out.println("1. Add product to shopping list");
        System.out.println("2. Remove product from shopping list");
        System.out.println("3. Remove all products from shopping list");
        System.out.println("4. Save shopping list");
        System.out.println("5. Exit");

        while(!isCorrect)
        {
            try {
                System.out.println("Choice what you want to do: ");
                choice = _scan.nextInt();
                isCorrect = true;
                if(choice < 1 || choice > 6)
                {
                    System.out.println("Bad choice! Take another one!");
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Bad choice! Take another one!");
                _scan.next();
            }
        }

        switch (choice)
        {
            case 1:
                AddProductToShopingList();
                break;
            case 2:
                RemoveItemFormShopingList();
                break;
            case 3:
                _shoppingList.clear();
                break;
            case 4:
                SaveDataToFile.SaveData(_shoppingList);
                break;
            case 5:
                exit(1);
                break;
            default:
                break;
        }

    }

    public void ShowMenu()
    {
        while(true)
        {
            System.out.println("/========================\\");
            System.out.println("|==========MENU==========|");
            System.out.println("\\========================/");
            TakeAChoice();
            clearConsole();
        }
    }
}
