package data;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class UserBroker extends Broker {

    //private DataTransferObject dto;
    private String tag = "user";
    private String file = "userList.txt";

    public UserBroker(){
        setFile(this.file);
        //searchDatabase(this.dto, this.tag);
    }
}
