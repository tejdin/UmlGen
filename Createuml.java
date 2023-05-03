package exos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Createuml {

    private File fichier;
    private String chaine;
    private String nom;
    public Createuml(String chaine,String nom){
        this.chaine=chaine;
        this.nom=nom;

    }
    public void createfile() throws IOException {
        fichier = new File("../diagramme"+"_"+this.nom+".puml");
        String reponse;
        if(fichier.exists()){
            System.out.println("la fichier existe deja, voulez vous supprimer ? (o/n)");
            Scanner sc = new Scanner(System.in);
            reponse = sc.nextLine();
            if (reponse=="o"){
                fichier.delete();
                fichier.createNewFile();
                System.out.println("fichier cree");


            }
            else if (reponse=="n"){
            }
            else{
                System.out.println("Fin");
            }
        }
        else {
            fichier.createNewFile();
            System.out.println("fichier cree");
        }
    }

public void ecrire() throws IOException {
    FileWriter fw = new FileWriter(fichier);
    BufferedWriter bw = new BufferedWriter(fw);
        try{
            bw.write(chaine);
            bw.close();
        }
        catch (IOException e)
        {
            System.out.println();
        }

}
    }





