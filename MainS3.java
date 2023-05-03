package exos;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;


public class MainS3 {

    public static void main(String[] args) throws IOException {
        // write your code here
        Class classe;
        try {
//            Scanner scanner = new Scanner(System.in);
//            out.println("Entrez le nom de la classe (avoir parametrer la classpath d'abord) : ");
//            String nomClasse = scanner.nextLine();
          String nomClasse = args[0];
            classe = Class.forName(nomClasse);
            Maquette maquette = new Maquette(classe);

            maquette.Createcode();
            maquette.affichercode();
            maquette.creationFichier();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }






    }
}




