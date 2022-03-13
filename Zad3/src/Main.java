/*
Napisz program losujący liczbę z zakresu 0-N. Limit zakresu N przekazywany jest z linii poleceń. Program pyta
użytkownika, jaka jest wylosowana liczba. Jeżeli użytkownik nie zgadł, dowiaduje się czy wylosowana liczba jest większa
czy mniejsza od podanej. Jeżeli zgadł, dowiaduje się ile wykonał prób i jest pytany czy chce kontynuować grę. Uwzględnij
w programie wszelkie możliwe pomyłki użytkownika w przekazaniu parametru do programu.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int min = 0;
        int max = 0;
        int randomNumber = 0;
        int tryCount = 0;
        boolean isDone = false;
        boolean isCorrect = false;
        boolean playNext = false;
        Scanner scan = new Scanner(System.in);

        while(!playNext)
        {
            isCorrect = false;
            while(!isCorrect)
            {
                try {
                    System.out.println("Podaj zakres losowanej liczby: ");
                    max = scan.nextInt();
                    isCorrect = true;
                }catch (InputMismatchException e)
                {
                    System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                    scan.next();
                }
            }

            randomNumber = (int)((Math.random() * (max - min)) + min);

            System.out.println("Hmmm... Mam pewna liczbe od 0 do " + max + " sprobuj ja zgadnac");
            while(!isDone)
            {
                tryCount++;
                int number = 0;

                isCorrect = false;
                while(!isCorrect)
                {
                    try {
                        System.out.println("Podaj liczbe:");
                        number = scan.nextInt();
                        isCorrect = true;
                    }catch (InputMismatchException e)
                    {
                        System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                        scan.next();
                    }
                }

                if (number == randomNumber)
                {
                    System.out.println("Brawo... Zgadles w " + tryCount + " probie");
                    isDone = true;
                }
                else if (number < randomNumber)
                {
                    System.out.println("Za malo!");
                }
                else
                {
                    System.out.println("Za duzo!");
                }
            }

            isCorrect = false;
            while(!isCorrect)
            {
                try {
                    System.out.println("Czy chesz zagrac raz jeszcze? 0 - NIE, 1 - TAK");
                    int decision = scan.nextInt();
                    isCorrect = true;
                    if(decision == 0)
                    {
                        playNext = true;
                    }
                    else if (decision == 1)
                    {
                        System.out.println("Zagrajmy raz jeszcze :D");
                        isDone = false;
                    }
                    else
                    {
                        System.out.println("Zla decyzja, podaj jeszcze raz!");
                        isCorrect = false;
                    }
                }catch (InputMismatchException e)
                {
                    System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                    scan.next();
                }
            }

        }
    }
}
