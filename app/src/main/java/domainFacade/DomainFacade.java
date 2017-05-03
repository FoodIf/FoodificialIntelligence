package domainFacade;
import GUI.*;
import domain.*;

/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade {
    private Main main;

    public DomainFacade(){
        this.main = new Main();
    }
    public void compareEmail(String email){
        main.compareEmail(email);
    }
    public void comparePassword(String password){
        main.comparePassword(password);
    }
}
