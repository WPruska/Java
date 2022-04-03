package Helpers;

import Entities.Vector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile
{
    public static void SaveData(Vector vector)
    {
        try {
            FileWriter myWriter = new FileWriter("vectorResponse.txt");

            vector._points.forEach(p ->
            {
                try {
                    myWriter.write(p + " ");
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
