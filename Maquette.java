package exos;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.io.IOException;

public class Maquette
{
    private CreateCodeUml Uml ;
    private AvoirMethodes avoirMethodes;
    private AvoirChamps avoirChamps;
    private String classename;
    private AvoirConstructeur avoirConstructeur;
    private Class classe_maq;
    public Maquette(Class classe)
    {
        classe_maq=classe;

        //1. Trouver la classe via CLASSPATH
        //si la classe n'est pas déjà trouvable alors:
        //voir où mentionner le répertoire où il y a la classe : paramètres Intellij
        //set CLASSPATH = %CLASSPATH%;C:\...

        try{
            avoirMethodes = new AvoirMethodes(classe);
            avoirChamps = new AvoirChamps(classe);
            avoirConstructeur=new AvoirConstructeur(classe);
            classename = classe.getName();
        }
        catch(Throwable e)
        {
            System.out.println(e);
        }

    }


    public String getClassename() {
        return classename;
    }
    public String Createcode() {
        return (Uml = new CreateCodeUml(this.avoirConstructeur,this.avoirChamps, this.avoirMethodes,this.classe_maq)).getChaine();
    }
    public void creationFichier() throws IOException {
        Createuml c = new Createuml(this.Createcode(),this.classename);
        c.createfile();
        c.ecrire();
    }
    public void affichercode(){
        System.out.println(this.Createcode());
    }



}
