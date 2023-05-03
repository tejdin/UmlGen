package exos;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Type {
    private String[] type;
    private String _collections = "AbstractCollection, AbstractList, AbstractQueue, AbstractSequentialList, AbstractSet, ArrayBlockingQueue, ArrayDeque, ArrayList, AttributeList, BeanContextServicesSupport, BeanContextSupport, ConcurrentHashMap.KeySetView, ConcurrentLinkedDeque, ConcurrentLinkedQueue, ConcurrentSkipListSet, CopyOnWriteArrayList, CopyOnWriteArraySet, DelayQueue, EnumSet, HashSet, JobStateReasons, LinkedBlockingDeque, LinkedBlockingQueue, LinkedHashSet, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, RoleList, RoleUnresolvedList, Stack, SynchronousQueue, TreeSet, Vector";
    private String _map = "AbstractMap, Attributes, AuthProvider, ConcurrentHashMap, ConcurrentSkipListMap, EnumMap, HashMap, Hashtable, IdentityHashMap, LinkedHashMap, PrinterStateReasons, Properties, Provider, RenderingHints, SimpleBindings, TabularDataSupport, TreeMap, UIDefaults, WeakHashMap";
    private ArrayList<String> liens = new ArrayList<>();

    public Type(Field[] fields)
    {
        type = new String[fields.length];
        for(int i=0; i< fields.length; i++)
        {
            type[i] = verifType(fields[i]);
        }
    }
    public Type(Method[] methods)
    {
        type = new String[methods.length];
        for(int i=0; i<methods.length; i++)
        {
            type[i] = verifType(methods[i]);
        }

    }
    public Type(Parameter[] parameters)
    {
        type = new String[parameters.length];
        for(int i=0; i< parameters.length; i++)
        {
            type[i] = verifType(parameters[i]);
        }
    }

    public ArrayList<String> getLiens() {

        return liens;
    }

    public String[] getType() {
        return type;
    }

    private String verifType(Field type_elem)
    {
        String type;
        if(type_elem.getType().getName()=="int")
        {
            type = ": Integer";
        }
        else if(type_elem.getType().getName()=="java.lang.String")
        {
            type = ": String";
        }
        else if(type_elem.getType().getName()=="boolean")
        {
            type = ": Boolean";
        }
        else if(type_elem.getType().getName()=="long")//facultatif
        {
            type = ": Long";
        }
        else if(type_elem.getType().getName()=="void")
        {
            type = "";
        }
        else if(type_elem.getType().isArray())
        {
            type = " : ";
            type += type_elem.getType().componentType().getSimpleName();
            type += "[*]";

//            Class<?> obj = type_elem.getType().componentType();
//            while(obj.isArray())//si c'est une arraylist d'arraylist
//            {
//                //changer type_elem
//                type += "[*]";
//                obj = obj.getComponentType();
//            }
        }
        else if(_collections.contains(type_elem.getType().getSimpleName()))//toutes les collections
        {
            type = " : ";
            ParameterizedType liste_type = (ParameterizedType) type_elem.getGenericType();
            Class<?> integerListClass = (Class<?>) liste_type.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
        }
        else if(_map.contains(type_elem.getType().getSimpleName()))//tous les maps
        {
            type = " : ";
            ParameterizedType pt = (ParameterizedType)type_elem.getGenericType();
            Class<?> integerListClass = (Class<?>) pt.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
//            for(Object t : pt.getActualTypeArguments()) {
//                System.out.println(t.toString());
//            }
        }
        else{
            type = " : ";
            type  += type_elem.getType().getSimpleName();
            if(!type_elem.getType().isPrimitive())
            {
                String ajout = "..>"+type_elem.getType().getSimpleName() + " <<use>>";
                liens.add(ajout);
            }
        }
        return type;
    }
    private String verifType(Parameter type_elem)
    {
        String type;
        if(type_elem.getType().getName()=="int")
        {
            type = " : Integer";
        }
        else if(type_elem.getType().getName()=="java.lang.String")
        {
            type = " : String";
        }
        else if(type_elem.getType().getName()=="boolean")
        {
            type = " : Boolean";
        }
        else if(type_elem.getType().getName()=="void")
        {
            type = "";
        }
        else if(type_elem.getType().isArray())
        {
            type = " : ";
            type += type_elem.getType().componentType().getSimpleName();
            type += "[*]";
        }
        else if(_collections.contains(type_elem.getType().getSimpleName()))//toutes les collections
        {
            type = " : ";
            ParameterizedType liste_type = (ParameterizedType) type_elem.getParameterizedType();
            Class<?> integerListClass = (Class<?>) liste_type.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
        }
        else if(_map.contains(type_elem.getType().getSimpleName()))//tous les maps
        {
            type = " : ";
            ParameterizedType pt = (ParameterizedType)type_elem.getParameterizedType();
            Class<?> integerListClass = (Class<?>) pt.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
//            for(Object t : pt.getActualTypeArguments()) {
//                System.out.println(t.toString());
//            }
        }

        else{
            type = " : ";
            type  += type_elem.getType().getSimpleName();
            if(!type_elem.getType().isPrimitive())
            {
                String ajout = "..>"+type_elem.getType().getSimpleName() + " <<use>>";
                liens.add(ajout);
            }
        }
        return type;
    }
    private String verifType(Method type_elem)
    {
        String type;
        if(type_elem.getReturnType().getName()=="int")
        {
            type = " : ";
            type += "Integer";
        }
        else if(type_elem.getReturnType().getName()=="java.lang.String")
        {
            type = " : ";
            type += "String";
        }
        else if(type_elem.getReturnType().getName()=="boolean")
        {
            type = " : ";
            type += "Boolean";
        }
        else if(type_elem.getReturnType().getName()=="void")
        {
            type = "";
        }
        else if(type_elem.getReturnType().isArray())
        {
            type = " : ";
            type += type_elem.getReturnType().getTypeName();
            type += "[*]";
        }
        else if(_collections.contains(type_elem.getReturnType().getSimpleName()))//toutes les collections
        {
            type = " : ";
            ParameterizedType liste_type = (ParameterizedType) type_elem.getGenericReturnType();
            Class<?> integerListClass = (Class<?>) liste_type.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
        }
        else if(_map.contains(type_elem.getReturnType().getSimpleName()))//tous les maps
        {
            type = " : ";
            ParameterizedType pt = (ParameterizedType)type_elem.getGenericReturnType();
            Class<?> integerListClass = (Class<?>) pt.getActualTypeArguments()[0];
            type += integerListClass.getSimpleName();
            type += "[*]";
//            for(Object t : pt.getActualTypeArguments()) {
//                System.out.println(t.toString());
//            }
        }
        else{
            type = " : ";
            type  += type_elem.getReturnType().getSimpleName();
            if(!type_elem.getReturnType().isPrimitive())
            {
                String ajout = "..>"+type_elem.getReturnType().getSimpleName() + " <<use>>";
                liens.add(ajout);
            }
        }
        return type;
    }
}
