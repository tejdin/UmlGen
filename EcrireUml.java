package exos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class EcrireUml {
    private String chaine_intermediaire = ""; //renvoyer la chaine
    private Classifiers classifiers;
    private String[] string_visibilite;
    private String[] string_type;
    private Parametres parametres;
    private Parameter[] tab_param;
    private Type type_param;
    private String[] stringparam;
    private Type type;
    private String nomClasse;
    private ArrayList<String> liens;

    public EcrireUml(String nomClasse)
    {
        this.nomClasse = nomClasse;
    }
    public String EcrireChamps(Field[] fields)//tab_champs
    {
        classifiers = new Classifiers(fields);
        string_visibilite = classifiers.getVisibilite();
        type = new Type(fields);
        string_type = type.getType();
        liens = type.getLiens();
        for(int i=0; i<type.getLiens().size(); i++)
        {
            if(!liens.contains(type.getLiens().get(i)))
            {
                liens.add(type.getLiens().get(i));
            }
        }

        for(int i=0; i<fields.length; i++)
        {
            chaine_intermediaire += string_visibilite[i] + fields[i].getName() +  string_type[i] + "\n";
        }
        return chaine_intermediaire;
    }

    public String EcrireConstructeur(Constructor[] constructors)//tab_constructeurs
    {
        classifiers = new Classifiers(constructors);
        string_visibilite = classifiers.getVisibilite();


        for (int i = 0; i < constructors.length; i++) {
            //cv[i] + nomClasse + "(typeparam : param)"
            chaine_intermediaire += string_visibilite[i] + "<<create>>"+ nomClasse + "(";

            parametres = new Parametres(constructors[i]);
            tab_param = parametres.getParametres();
            type_param = new Type(tab_param);
            stringparam = type_param.getType();
            liens = type.getLiens();
            for(int k=0; k<type.getLiens().size(); k++)
            {
                if(!liens.contains(type.getLiens().get(k)))
                {
                    liens.add(type.getLiens().get(k));
                }
            }

            for (int j = 0; j < tab_param.length; j++) {
                String s = tab_param[j].getName() +  stringparam[j] +" ";
                chaine_intermediaire += s;
            }
            chaine_intermediaire += ") \n";
        }
        return chaine_intermediaire;
    }

    public String EcrireMethodes(Method[] methods)//tab_methodes
        {
            classifiers = new Classifiers(methods);
            string_visibilite = classifiers.getVisibilite();
            type = new Type(methods);
            string_type = type.getType();
            liens = type.getLiens();
            for(int i=0; i<type.getLiens().size(); i++)
            {
                if(!liens.contains(type.getLiens().get(i)))
                {
                    liens.add(type.getLiens().get(i));
                }
            }


            for(int i=0; i< methods.length; i++)
            {
                //visbilite + nom + (
                chaine_intermediaire = chaine_intermediaire + string_visibilite[i] + methods[i].getName() + "(";
                //param : type + nom
                parametres = new Parametres(methods[i]);
                tab_param = parametres.getParametres();
                type_param = new Type(tab_param);
                stringparam = type_param.getType();
                liens = type.getLiens();
                for(int k=0; k<type.getLiens().size(); k++)
                {
                    if(!liens.contains(type.getLiens().get(k)))
                    {
                        liens.add(type.getLiens().get(k));
                    }
                }


                for (int j = 0; j < tab_param.length; j++) {
                    String s = tab_param[j].getName() + stringparam[j] + " ";
                    chaine_intermediaire += s;
                }
                chaine_intermediaire += ")" + string_type[i] + "\n";
            }
            return chaine_intermediaire;
        }

        public ArrayList<String> getLiens()
        {
            return liens;
        }
}



