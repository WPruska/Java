package Entity;

public class Person extends Entry
{
    private String Name;
    private String Surname;
    private String Adres;
    private PhoneNumber PhoneNumber;

    public Person(String Name, String Surname, String Adres, PhoneNumber PhoneNumber)
    {
        this.Name = Name;
        this.Surname = Surname;
        this.Adres = Adres;
        this.PhoneNumber = PhoneNumber;
    }

    public Person(String Name, String Surname, String Adres, int Code, int Number)
    {
        this.Name = Name;
        this.Surname = Surname;
        this.Adres = Adres;
        this.PhoneNumber = new PhoneNumber(Code,Number);
    }

    @Override
    public void PrintDesription() {
        System.out.println("-===PERSON===-");
        System.out.println(Name + " " + Surname);
        System.out.println(Adres);
        System.out.println(PhoneNumber);
    }

    public PhoneNumber GetPhoneNumber()
    {
        return this.PhoneNumber;
    }
}
