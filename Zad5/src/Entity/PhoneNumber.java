package Entity;

public class PhoneNumber implements Comparable<PhoneNumber> {
    public int Code;
    public int Number;

    public PhoneNumber(int Code, int Number)
    {
        this.Code = Code;
        this.Number = Number;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        if (this.Number == o.Number) return 0;
        else if (this.Number > o.Number) return 1;
        else return -1;
    }

    @Override
    public String toString()
    {
        return "+" + Integer.toString(this.Code) + " " + Integer.toString(Number);
    }
}
