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
import Entity.Person;
import Entity.PhoneNumber;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)
    {
        Person person1 = new Person("Adam","Ludwiczak","Olimpjska",41,538211128);
        Person person2 = new Person("Jakub","Ludwiczak","Wyszynskiego",42,123123123);
        Person person3 = new Person("Jan","Kowalski","Targowa",43,321321321);
        Person person4 = new Person("Janusz","Laskowski","Targowa",44,90348902);
        Company company1 = new Company("Politechnika","Radwanska",42,123456789);
        Company company2 = new Company("ZF Automotive","Felinskiego",42,456456456);
        Company company3 = new Company("Pizzeria Piaski","Wyszyskiego",42,987654321);
        Company company4 = new Company("Pizzeria 105","Wyszyskiego",42,233123123);
        //Company 5 ma taki sam klucz jak company4 wiec nie powinien zostać dodany do TreeMap
        Company company5 = new Company("Pizzeria Nova","Elizejska",42,233123123);

        TreeMap<PhoneNumber, Person> mapOfPersons = new TreeMap<>();
        TreeMap<PhoneNumber, Company> mapOfCompanies = new TreeMap<>();

        AddPerson(person1, mapOfPersons);
        AddPerson(person2, mapOfPersons);
        AddPerson(person3, mapOfPersons);
        AddPerson(person4, mapOfPersons);
        AddCompany(company1, mapOfCompanies);
        AddCompany(company2, mapOfCompanies);
        AddCompany(company3, mapOfCompanies);
        AddCompany(company4, mapOfCompanies);
        AddCompany(company5, mapOfCompanies);

        System.out.println("Persons:");
        for(Map.Entry<PhoneNumber, Person> m: mapOfPersons.entrySet())
        {
            m.getValue().PrintDesription();
        }

        System.out.println("Companies:");
        for(Map.Entry<PhoneNumber, Company> m: mapOfCompanies.entrySet())
        {
            m.getValue().PrintDesription();
        }
    }

    public static boolean AdresInPersonMap(Person person, TreeMap<PhoneNumber, Person> personTreeMap)
    {
        boolean isInMap = false;
        for(Map.Entry<PhoneNumber,Person> m: personTreeMap.entrySet())
        {
            if(m.getValue().GetAdres() == person.GetAdres())
            {
                isInMap = true;
            }
        }

        return isInMap;
    }

    public static boolean AdresInCompaniesMap(Company company, TreeMap<PhoneNumber, Company> companyTreeMap)
    {
        boolean isInMap = false;
        for(Map.Entry<PhoneNumber,Company> m: companyTreeMap.entrySet())
        {
            if(m.getValue().GetAdres() == company.GetAdres())
            {
                isInMap = true;
            }
        }

        return isInMap;
    }

    public static void AddPerson(Person person, TreeMap<PhoneNumber, Person> personTreeMap)
    {
        if(!AdresInPersonMap(person, personTreeMap))
        {
            personTreeMap.put(person.GetPhoneNumber(), person);
        }
    }

    public static void AddCompany(Company company, TreeMap<PhoneNumber, Company> companyTreeMap)
    {
        if(!AdresInCompaniesMap(company, companyTreeMap))
        {
            companyTreeMap.put(company.GetPhoneNumber(), company);
        }
    }
}
