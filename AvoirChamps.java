package exos;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AvoirChamps{

    //elements = champs
    private Field[] champs;

    public AvoirChamps(Class classe)
    {
        champs = classe.getDeclaredFields();
    }

    public Field[] getChamps() {
        return champs;
    }


}
