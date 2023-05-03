package exos;
import java.lang.reflect.*;
import java.net.PortUnreachableException;

public class Parametres {
    private Parameter[] parametres;
    private String type_parametre="";

    public Parametres(Method m){
        parametres=m.getParameters();
    }
    public Parametres(Constructor constructor){
        parametres=constructor.getParameters();
    }
    public Parameter[] getParametres(){
        return parametres;
    }

}
