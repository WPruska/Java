package Entity;

public class PhoneNumber implements Comparable<PhoneNumber> {
    public int Code;
    public int Number;

    @Override
    public int compareTo(PhoneNumber o) {
        if (this.Number == o.Number) return 0;
        else if (this.Number > o.Number) return 1;
        else return -1;
    }
}
