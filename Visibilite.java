package exos;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.*;
import java.util.List;

public class Visibilite {
    private String[] visibilite;

    public Visibilite(Method[] methods)//paramètres : méthodes / champs / constructeur
    {
        try{
            visibilite = new String[methods.length];
            for(int i=0; i< methods.length; i++)
            {
                int mod = methods[i].getModifiers();
                if(Modifier.isPublic(mod))
                {
                    visibilite[i] = "+";
                }
                else if(Modifier.isPrivate(mod))
                {
                    visibilite[i] = "-";
                }
                else if(Modifier.isProtected(mod))
                {
                    visibilite[i] = "#";
                }
            }
        }
        catch (Throwable e)
        {
            System.out.println(e);
        }
    }

    public  Visibilite(Field[] fields)
    {
        try {
            visibilite = new String[fields.length];
            for(int i=0; i< fields.length; i++)
            {
                int mod = fields[i].getModifiers();
                if(Modifier.isPublic(mod))
                {
                    visibilite[i] = "+";
                }
                else if(Modifier.isPrivate(mod))
                {
                    visibilite[i] = "-";
                }
                else if(Modifier.isProtected(mod))
                {
                    visibilite[i] = "#";
                }
            }
        }
        catch (Throwable e)
        {
            System.out.println(e);
        }
    }

    public Visibilite (Constructor[] constructor)
    {
        visibilite = new String[constructor.length];
        for(int i=0; i< constructor.length; i++)
        {
            int mod = constructor[i].getModifiers();
            if(Modifier.isPublic(mod))
            {
                visibilite[i] = "+";
            }
            else if(Modifier.isPrivate(mod))
            {
                visibilite[i] = "-";
            }
            else if(Modifier.isProtected(mod))
            {
                visibilite[i] = "#";
            }

        }
    }

    public String[] getVisibilite() {

        return visibilite;
    }


}
