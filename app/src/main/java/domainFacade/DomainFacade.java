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
    public boolean compareEmail(String email){
        return main.compareEmail(email);
    }
    public boolean comparePassword(String password){
        return main.comparePassword(password);
    }
}
