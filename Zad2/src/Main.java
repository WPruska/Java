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
        int start,end;
        String text;

        Scanner scan = new Scanner(System.in);

        System.out.println("Give text: ");
        text =  scan.nextLine();
        System.out.println("Give first number of string: ");
        start = scan.nextInt();
        System.out.println("Give end number of string: ");
        end = scan.nextInt();

        if(start < 0 || end > text.length())
        {
            System.out.printf("Bad given index");
            return;
        }

        String stringToDisplay = text.substring(start,end);
        System.out.println(stringToDisplay);
    }
}
