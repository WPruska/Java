/*
Napisz program, który pobiera dwie liczby oraz łańcuch znaków z wiersza poleceń, a następnie wyświetla fragment podanego
łańcucha określony wprowadzonymi liczbami. Na przykład:
java Substring Witaj 2 4
wyświetla:
taj
java Substring Katamaran 5 7
wyświetla:
ara
java Substring Katamaran 3 40
wyświetla:
amaran
Uwzględnij w programie wszelkie możliwe pomyłki użytkownika w przekazaniu parametrów do programu.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int start = 0,end = 0;
        boolean isCorrect = false;
        String text = "";
        Scanner scan = new Scanner(System.in);

        while(!isCorrect)
        {
            System.out.println("Podaj tekst: ");
            text =  scan.nextLine();
            if(text.length() > 0) isCorrect = true;
            else System.out.println("Podano za krotki tekst");
        }

        isCorrect = false;
        while(!isCorrect)
        {
            try {
                System.out.println("Podaj index poczatku: ");
                start = scan.nextInt();
                isCorrect = true;
                if(start < 0 || start > text.length())
                {
                    System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                scan.next();
            }
        }

        isCorrect = false;
        while(!isCorrect)
        {
            try {
                System.out.println("Podaj index konca: ");
                end = scan.nextInt();
                isCorrect = true;
                if(end < 0 || end > text.length() || end < start)
                {
                    System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                    isCorrect = false;
                }
            }catch (Exception e)
            {
                System.out.println("Podano zla wartosc! Podaj jeszcze raz!");
                scan.next();
            }
        }

        String stringToDisplay = text.substring(start,end);
        System.out.println(stringToDisplay);
    }
}
