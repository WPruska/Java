/*
Napisz program proszący o podanie 2 wektorów (wektor to ciąg liczb). Koniec wektora oznacza się za pomocą wciśnięcia
klawisza enter. Jeżeli podany ciąg nie jest liczbą, jest ignorowany. Następnie należy spróbować dodać wektory, jeżeli
są równej długości (są równej długości jeśli mają tę samą liczbę elementów). Jeżeli nie są, rzucany jest własny wyjątek
WektoryRoznejDlugosciException, za pomocą którego można podać a następnie odczytać długości tych wektorów
(należy tak skonstruować wyjątek, aby możliwe było skonstruowanie zdania po jego przechwyceniu :
"Długość pierwszego wektora to AA a drugiego to BB" lub dowolnego innego zdania wykorzystującego wartości AA i BB,
np. określającego różnicę w długościach). Jeżeli są równej długości, wynik dodawania zapisywany jest do pliku.
Jeżeli nie są równej długości, użytkownik jest proszony o ponowne wprowadzenie tych wektorów.
 */

import Entities.Vector;
import Helpers.LoadDataFromUser;
import Helpers.SaveToFile;

public class Main {
    public static void main(String[] args)
    {
        boolean isCorrect = false;
        while(!isCorrect)
        {
            LoadDataFromUser ldf = new LoadDataFromUser();
            Vector vector1 = ldf.LoadVector();
            Vector vector2 = ldf.LoadVector();
            if(vector1 == null || vector2 == null)
            {
                System.out.println("Podano zle dane! Prosze podac jeszcze raz!");
                continue;
            }

            Vector vector3 = Vector.AddVectors(vector1, vector2);
            if(vector3 == null)
            {
                System.out.println("Podano zle dane! Prosze podac jeszcze raz!");
                continue;
            }else
            {
                isCorrect = true;
            }

            System.out.println("Wektor 1:");
            System.out.println(vector1.toString());
            System.out.println("Wektor 2:");
            System.out.println(vector2.toString());
            System.out.println("Wektor 3:");
            System.out.println(vector3.toString());

            SaveToFile.SaveData(vector3);
        }
    }
}
