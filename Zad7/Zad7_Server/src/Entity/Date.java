package Entity;

public class Date {
    int Year;
    int Month;
    int Day;
    int Hour;
    int Minute;
    int Secound;

    public Date()
    {
        Year = 1;
        Month = 1;
        Day = 1;
        Hour = 0;
        Minute = 0;
        Secound = 0;
    }

    public Date(int Year, int Month, int Day, int Hour, int Minute, int Secound)
    {
        this.Year = Year;
        this.Month = Month;
        this.Day = Day;
        this.Hour = Hour;
        this.Minute = Minute;
        this.Secound = Secound;
    }
}
