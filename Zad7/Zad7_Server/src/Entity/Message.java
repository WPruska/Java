package Entity;

import java.io.Serializable;

public class Message implements Serializable{
    private String Message = "";
    private DateOwn Time;

    public Message(String message, DateOwn reminderDate)
    {
        Message = message;
        Time = reminderDate;
    }

    public DateOwn getTime() {
        return Time;
    }

    public String getMessage() {
        return Message;
    }
}
