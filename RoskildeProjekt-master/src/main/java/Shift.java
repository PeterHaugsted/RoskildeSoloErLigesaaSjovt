import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.getInstance;

public class Shift implements Serializable {
    private String date;
    private String task;
    private String time;
    private User user;

    public User getUser() {
        return user;
    }

    public Shift(String date, String task, String time, User user) {
        this.date = date;
        this.task = task;
        this.time = time;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public String getTask() {
        return task;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GregorianCalendar getDateDate() {
        int y = Integer.parseInt(date.split("-")[0]);
        int m = Integer.parseInt(date.split("-")[1]);
        int d = Integer.parseInt(date.split("-")[2]);
        int hh = Integer.parseInt(time.split(":")[0]);
        int mm = Integer.parseInt(time.split(":")[0].substring(0, 1));

        return new GregorianCalendar(y, m-1, d, hh, mm);
    }

    public String stringToPrint() {
        return (date + " " + time + " " + task);
    }

    public long millsFromNow() {
        long time = this.getDateDate().getTimeInMillis() - GregorianCalendar.getInstance().getTimeInMillis();
        if (time>0)
            return time;
        return -1;
    }

    public void setName(String name){
        user.setName(name);
    }

    public String getName(){
        return user.getName();
    }


}
