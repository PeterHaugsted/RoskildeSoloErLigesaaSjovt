import java.util.Comparator;

public class shiftComparable implements Comparator<Shift> {

    @Override
    public int compare(Shift o1, Shift o2) {
        if (o1.millsFromNow() == o2.millsFromNow()) {
            return 0;
        } else if (o1.millsFromNow() > o2.millsFromNow()) {
            return 1;
        } else {
            return -1;
        }
    }
}
