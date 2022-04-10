package Entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class DateOwn implements Serializable {
    private long Time;

    public DateOwn()
    {
        Time = ZonedDateTime.now().toInstant().toEpochMilli();
    }

    public long getTime() {
        return Time;
    }
}
