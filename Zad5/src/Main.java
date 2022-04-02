/*
Napisz klasę NrTelefoniczny, posiadającą dwa pola: nrkierunkowy i nrTelefonu i implementującą interfejs Comparable.
Następnie utwórz abstrakcyjną klasę Wpis a następnie dziedziczące z niej klasy Osoba i Firma. Klasa Wpis ma
abstrakcyjną metodę opis, która opisuje dany wpis. Być może ma również inne metody abstrakcyjne lub nie w miarę potrzeb.
Klasa Osoba ma zawierać informacje o imieniu, nazwisku, adresie i (w tym nrTelefonu). Klasa Firma ma mieć nazwę i adres
(w tym NrTelefonu). Utwórz kilka obiektów klasy Osoba i kilka obiektów klasy Firma i umieść je w kontenerze TreeMap,
posługując się jako kluczem numerem telefonicznym. Następnie wypisz utworzoną w ten sposób książkę telefoniczną za
pomocą iteratora. Następnie zaproponuj sposób eliminacji tych wpisów, które mają identyczną nazwę ulicy w adresie.
Wypisz ponownie zawartość mapy.
 */

import Entity.Company;
import Entity.Entry;
import Entity.Person;
import Entity.PhoneNumber;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)
    {
        Person person1 = new Person("Adam","Ludwiczak","Olimpjska",42,538211128);
        Person person2 = new Person("Jakub","Ludwiczak","Wyszynskiego",42,123123123);
        Person person3 = new Person("Jan","Kowalski","Targowa",42,321321321);
        Company company1 = new Company("Politechnika","Radwanska",42,123456789);
        Company company2 = new Company("ZF Automotive","Pilsudskiego",42,456456456);
        Company company3 = new Company("Pizzeria Piaski","Wyszyskiego",42,987654321);

        TreeMap<PhoneNumber, Object> map = new TreeMap<>();

        map.put(person1.GetPhoneNumber(), person1);
        map.put(person2.GetPhoneNumber(), person2);
        map.put(person3.GetPhoneNumber(), person3);
        map.put(company1.GetPhoneNumber(), company1);
        map.put(company2.GetPhoneNumber(), company2);
        map.put(company3.GetPhoneNumber(), company3);

        for(Map.Entry m: map.entrySet())
        {
            
        }
    }
}
