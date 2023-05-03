package exos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Classifiers extends Visibilite {
    private String[] visibilite = super.getVisibilite();

    public Classifiers(Constructor[] constructor) {
        super(constructor);
        try {
            for (int i = 0; i < constructor.length; i++) {
                int mod = constructor[i].getModifiers();
                if (Modifier.isStatic(mod)) {
                    visibilite[i] += "{static} ";
                }
                if (Modifier.isFinal(mod)) {
                    visibilite[i] += "{readOnly} ";
                }
                if (Modifier.isAbstract(mod)) {
                    visibilite[i] += "{abstract} ";
                }
            }

        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    public Classifiers(Method[] methods) {
        super(methods);
        try {
            for (int i = 0; i < methods.length; i++) {
                int mod = methods[i].getModifiers();
                if (Modifier.isStatic(mod)) {
                    visibilite[i] += "{static} ";
                }
                if (Modifier.isFinal(mod)) {
                    visibilite[i] += "{readOnly} ";
                }
                if (Modifier.isAbstract(mod)) {
                    visibilite[i] += "{abstract} ";
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Classifiers(Field[] fields) {
        super(fields);
        try {
            for (int i = 0; i < fields.length; i++) {
                int mod = fields[i].getModifiers();
                if (Modifier.isStatic(mod)) {
                    visibilite[i] += "{static} ";
                }
                if (Modifier.isFinal(mod)) {
                    visibilite[i] += "{readOnly} ";
                }
                if (Modifier.isAbstract(mod)) {
                    visibilite[i] += "{abstract} ";
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
