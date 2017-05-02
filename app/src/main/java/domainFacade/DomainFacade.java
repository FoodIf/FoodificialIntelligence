package domainFacade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade {

    public ArrayList <String> userDetails() {
        ArrayList<String> userList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("userList.txt"));
            String userRow;
            while ((userRow = in.readLine()) != null) {
                userList.add(userRow);
                for (int i = 0; i < userList.size(); i++) {
                    System.out.print(userList.get(i));
                }
            }
            in.close();
        } catch (IOException e) {
            e.getMessage();
        }
    return userList;
    }
}