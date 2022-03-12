/*
Napisz program rozwiązujący równanie kwadratowe ax2 + bx + c = 0. Współczynniki a, b, c przekazywane są z linii poleceń.
Uwzględnij w programie pomyłkę użytkownika polegającą na przekazaniu do programu nieprawidłowej liczby parametrów.
Wskazówka: do konwersji parametrów skorzystaj z funkcji parseDouble w klasie Double. Przed użyciem tej funkcji zapoznaj
się z jej specyfikacją. Realizację zadania rozpocznij od napisania programu wczytującego parametry wywołania programu i
konwertującego je do typu double.
 */

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args)
    {
        double a,b,c;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj a: ");
        a = scan.nextDouble();
        System.out.println("Podaj b: ");
        b = scan.nextDouble();
        System.out.println("Podaj c: ");
        c = scan.nextDouble();

        double delta = pow(b,2) - 4.0 * a * c;

        if (delta < 0)
        {
            System.out.println("Solution didn't exist in a real set of numbers");
        }
        else if(delta == 0)
        {
            double x = -b / 2 * a;
            System.out.println("Soulution is x = " + x);
        }
        else
        {
            double sqrtDelta = sqrt(delta);
            double x1, x2;
            x1 = (-b - sqrtDelta) / 2 * a;
            x2 = (-b + sqrtDelta) / 2 * a;

            System.out.println("Solution is x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
