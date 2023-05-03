package exos;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateCodeUml {
    private String chaine;
    private String entete;
    private Method[] tab_methodes;
    private Field[] tab_champs ;
    private Constructor[] tab_constructeur;
    private ClassType typeclass;
    private Map <Integer, String > myMap = new HashMap<>();//test

    public CreateCodeUml(AvoirConstructeur constructeur, AvoirChamps champs, AvoirMethodes methodes, Class  classe_a_traitee) {
        typeclass = new ClassType(classe_a_traitee);
        if(!classe_a_traitee.isEnum() & classe_a_traitee!=null) {

            tab_constructeur = constructeur.getConstructors();

            tab_champs = champs.getChamps();

            tab_methodes = methodes.getMethodes();

            entete = "@startuml\n" +
                    "skinparam style strictuml\n" +
                    "skinparam classAttributeIconSize 0\n" +
                    "skinparam classFontStyle Bold\n" +
                    "hide enum methods\n" + typeclass.GetTypeClass() + " " + classe_a_traitee.getSimpleName() + "{\n ";


            EcrireUml ecrireUml = new EcrireUml(classe_a_traitee.getSimpleName());
            chaine = ecrireUml.EcrireChamps(tab_champs);
            chaine = ecrireUml.EcrireConstructeur(tab_constructeur);
            chaine = ecrireUml.EcrireMethodes(tab_methodes);

            chaine += "}" + "\n";

            VerificationSuperClass verifSuperClass = new VerificationSuperClass(classe_a_traitee);
            chaine += verifSuperClass.getClass_renvoi();
            chaine += "\n";

            chaine += "@enduml";
            chaine = entete + chaine;
            for (String ajouts: ecrireUml.getLiens()) {
                chaine+= classe_a_traitee.getName() + ajouts;
            }

        }
        else{
            chaine = typeclass.GetTypeClass();
        }
    }

    public String getChaine() {
        return chaine;
    }


}
