package domainFacade;
import GUI.*;
import domain.*;

/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade {
    private Main main;
    private String email;

    public DomainFacade(){
        this.main = new Main();
    }

    public void setEmail(String email){
        this.email = email;
    }
}
