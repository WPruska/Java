package Helpers;

import Entities.Vector;

import java.util.ArrayList;
import java.util.Scanner;

public class LoadDataFromUser {
    Scanner _scan;

    public LoadDataFromUser()
    {
        _scan = new Scanner(System.in);
    }

    public Vector LoadVector()
    {
        ArrayList<Integer> v = new ArrayList<>();
        System.out.println("Podaj wektor po spacji (np. 5 10 15): ");

        try
        {
            String vectorString;
            vectorString = _scan.nextLine();
            String[] stringOfInts = vectorString.split(" ", -2);

            for (String a : stringOfInts)
            {
                try{
                    v.add(Integer.parseInt(a));
                }
                catch (Exception e)
                {
                    e.getMessage();
                    return null;
                }
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }


        return new Vector(v);
    }
}
