package exos;

import java.lang.reflect.Field;

public class ClassType {
    private Class class_a_traite;
    private String renvoi="";
    public ClassType(Class classe){
        class_a_traite=classe;
    }
    public String GetTypeClass()
    {
        if (class_a_traite.isInterface()){

            renvoi = "<<interface>>";
        }
        else if (class_a_traite.isEnum()){
            AvoirChamps ac = new AvoirChamps(class_a_traite);
            Field[] champs = ac.getChamps();
            renvoi = "<<enumeration>> " + class_a_traite.getSimpleName() + "{ \n";
            for (int i=0; i< champs.length; i++) {
                if(champs[i].isEnumConstant()) {
                    renvoi += champs[i].getName() + "\n";
                }
            }
            renvoi += "}";
        }
        else{
            renvoi = "class";
        }

        return renvoi;
    }
}

