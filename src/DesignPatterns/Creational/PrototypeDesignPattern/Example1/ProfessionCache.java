package DesignPatterns.Creational.PrototypeDesignPattern.Example1;

import java.util.HashMap;

public class ProfessionCache {

    private static HashMap<Integer,Profession> map = new HashMap<>();

    public static Profession getProfessionClone(int id){
        Profession obj = map.get(id);
        return (Profession) obj.cloneMethod();
    }

    public static  void loadProfessionCache(){
        Doctor doc =new Doctor();
        doc.id=1;
        map.put(doc.id, doc);

        Teacher teacher =new Teacher();
        teacher.id=2;
        map.put(teacher.id, teacher);

        Engineer engineer =new Engineer();
        engineer.id=3;
        map.put(engineer.id,engineer);
    }
}
