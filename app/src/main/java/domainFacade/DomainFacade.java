package domainFacade;
import GUI.*;
import domain.*;

/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade {
    private static final DomainFacade instance = new DomainFacade();
    private Main main;

    private DomainFacade(){
        this.main = new Main();
    }
    public static DomainFacade getInstance(){
        return instance;
    }
    public boolean compareEmail(String email){
        return main.compareEmail(email);
    }
    public boolean comparePassword(String password){
        return main.comparePassword(password);
    }
}
