package Entities;

import MyExceptions.WektoryRoznejDlugosciException;

import java.util.ArrayList;

public class Vector {
    public ArrayList<Integer> _points;
    public Vector(ArrayList<Integer> points)
    {
        _points = points;
    }

    public static Vector AddVectors(Vector vector1, Vector vector2)
    {
        ArrayList<Integer> vectorToReturn = new ArrayList<>();
        try
        {
            if(vector1._points.size() != vector2._points.size())
            {
                throw new WektoryRoznejDlugosciException("Wektor AA ma dlugosc = " + vector1._points.size() +
                        ", a dlugosc wektora BB = " + vector2._points.size() + ". Nie mozna dodac wektorow" +
                        "o roznej dlugosci!!!!");
            }

            for(int i = 0; i < vector1._points.size(); i++)
            {
                int endpoint = vector1._points.get(i) + vector2._points.get(i);
                vectorToReturn.add(endpoint);
            }
        }
        catch (WektoryRoznejDlugosciException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

        return new Vector(vectorToReturn);
    }

    @Override
    public String toString()
    {
        String mes = "";
        for (int i = 0; i < _points.size(); i++)
        {
            mes += Integer.toString(_points.get(i)) + " ";
        }

        return mes;
    }
}
