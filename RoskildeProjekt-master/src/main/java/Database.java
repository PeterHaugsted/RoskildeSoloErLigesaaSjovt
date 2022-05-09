import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Database {
    private static ArrayList<User> users; //User has to go through database
    public static final String userPath = "VolunteerNewData.txt";


    public static boolean loadVolunteerDataFromFileToUsers() { //All data load
        try {
            FileInputStream fis = new FileInputStream(userPath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            users = new ArrayList<>();
            loadNew();
            System.err.println("Fil findes ik");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            users = new ArrayList<>();
            loadNew();
            System.err.println("io fejl");
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            users = new ArrayList<>();
            loadNew();
            System.err.println("class fejl");
            return false;
        }
        return true;
    }

    public static boolean saveVToFile() {
        if (users == null)
            loadVolunteerDataFromFileToUsers();
        try {
            FileOutputStream fos = new FileOutputStream(userPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Couldn't save file");
            return false;
        }
        return true;
    }

    public static boolean addV(User user) {
        users.add(user);
        saveVToFile();
        return true;
    }

    public static User getUserFromName(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return users.get(i);
            }
        }
        System.err.println("User not found");
        return null;
    }

    public static boolean removePerson(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (user == users.get(i)) {
                users.remove(i);
                saveVToFile();
                return true;
            }
        }
        return false;
    }

    private static void loadNew() {

        User user = new User("test", "peterhaugsted@hotmail.com", "31105068", "Skodsborgvej 190", "12");
        user.setResponsible(true);
        users.add(user);

        user = new User("Peter", "peterhaugsted@hotmail.com", "31105068", "Skodsborgvej 190", "5289");
        user.setResponsible(true);
        users.add(user);
    }

    public static ObservableList<Shift> getOBSShift() {
        ArrayList<Shift> allShifts = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getShifts().size(); j++) {
                allShifts.add(users.get(i).getShifts().get(j));
            }
        }
        return FXCollections.observableArrayList(allShifts);
    }

    public static ArrayList<Shift> getAllShifts() {
        ArrayList<Shift> allShifts = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getShifts().size(); j++) {
                allShifts.add(users.get(i).getShifts().get(j));
            }
        }
        return allShifts;
    }

    public static boolean removeShiftForEditShiftComtroller(Shift shift) { //This function is created specifically for the editShifts controller
        //I find the user, from the database, from a new parameter, called volunteer, which is a new way to store names
        //If the user doesn't exist, the program stops
        //we get all the shifts from the user we found, and store them inside allshift
        //If a shift matches, we remove it, and save it.
        User user = getUserFromName(shift.getVolunteer());
        if (user == null) {
            return false;
        }
        ArrayList<Shift> allShift = user.getShifts();
        for (int i = 0; i < allShift.size(); i++) {
            if (allShift.get(i).matchForEditShiftComtroller(shift)) {
                allShift.remove(i);
                Database.saveVToFile();
                return true;
            }
        }
        return false;
    }
}
