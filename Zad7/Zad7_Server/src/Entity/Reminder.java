package Entity;

public class Reminder {
    private String Message = "";
    private Date ReminderDate;

    public Reminder(String message, Date reminderDate)
    {
        Message = message;
        ReminderDate = reminderDate;
    }

    public Date getReminderDate() {
        return ReminderDate;
    }

    public String getMessage() {
        return Message;
    }
}
