package exos;

import java.lang.reflect.*;
import java.util.List;

import exos.Visibilite;


public class AvoirMethodes{

    private Method[] methodes;

    public AvoirMethodes(Class classe)
    {
        //super(classe);
        try{
            methodes = classe.getDeclaredMethods();
        }
        catch(Throwable e)
        {
            System.out.println(e);
        }
    }

    public Method[] getMethodes() {
        return methodes;
    }




}
