package exos;

public class VerificationSuperClass {
    private String class_renvoi;
    private Class classe;
    VerificationSuperClass(Class classe)
    {
        this.classe = classe;
        class_renvoi = classe.getSuperclass().getSimpleName();
    }

    public String getClass_renvoi() {
        //superclass <|-- sousclasse
        String fleche_uml = " --|> ";
        class_renvoi = classe.getSimpleName() + fleche_uml + class_renvoi;
        return class_renvoi;
    }
}
