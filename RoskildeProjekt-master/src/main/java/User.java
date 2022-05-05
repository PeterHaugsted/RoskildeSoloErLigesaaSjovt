import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class User implements Serializable {
    private String name;
    private String eMail;
    private String tlfNr;
    private String address;
    private String password;
    private boolean responsible;
    private ArrayList<Shift> shifts;

    public boolean isResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public User(String name, String eMail, String tlfNr, String address, String password) {
        this.name = name;
        this.eMail = eMail;
        this.tlfNr = tlfNr;
        this.address = address;
        this.password = password;
        responsible = false;
        shifts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    public Shift getNextShift() {
        Shift nextShift = null;
        long minDelta = Long.MAX_VALUE;
        for (int i = 0; i < shifts.size(); i++) {
            long delta = shifts.get(i).millsFromNow();
            if (delta < minDelta && delta != -1) {
                minDelta = delta;
                nextShift = shifts.get(i);
            }
        }
        return nextShift;
    }

    public ArrayList<Shift> getNext3Shifts(){
        ArrayList<Shift> moreShifts = new ArrayList<>();
        try {
            int n = 3;
            for (int i = 0; i < n; i++) {
                if (shifts.get(i) != null) {
                    if (shifts.get(i).millsFromNow() != -1){
                        moreShifts.add(shifts.get(i));
                    } else {
                        n++;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e){

        }
        return moreShifts;
    }

    public boolean addShift(Shift shift){
        shifts.add(shift);
        Collections.sort(shifts, new shiftComparable());
        return Database.saveVToFile();
    }


}
