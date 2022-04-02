package Entity;

public class Company extends Entry
{
    private String CompanyName;
    private String Adres;
    private PhoneNumber PhoneNumber;

    public Company(String CompanyName, String Adres, PhoneNumber PhoneNumber)
    {
        this.CompanyName = CompanyName;
        this.Adres = Adres;
        this.PhoneNumber = PhoneNumber;
    }

    public Company(String CompanyName, String Adres, int Code, int Number)
    {
        this.CompanyName = CompanyName;
        this.Adres = Adres;
        this.PhoneNumber = new PhoneNumber(Code,Number);
    }

    @Override
    public void PrintDesription() {
        System.out.println("-===COMPANY===-");
        System.out.println(CompanyName);
        System.out.println(Adres);
        System.out.println(PhoneNumber);
    }

    public PhoneNumber GetPhoneNumber()
    {
        return this.PhoneNumber;
    }
}
