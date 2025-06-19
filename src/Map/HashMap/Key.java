package Map.HashMap;

public class Key {
/*    Hashing is a process of converting an object into integer form by using the method hashCode().
    It’s necessary to write the hashCode() method properly for better performance of Map.HashMap.
    Here I am taking the key of my class so that I can override the hashCode() method to show different scenarios. My Key class is*/
    String key;

    public Key(String key){
        this.key=key;
    }

    /*Here override hashCode() method returns the first character’s ASCII value as hash code.
    So whenever the first character of the key is same, the hash code will be the same.
    You should not approach these criteria in your program.
    It is just for demo purposes. As Map.HashMap also allows a null key, so hash code of null will always be 0.*/
    @Override
    public int hashCode(){
        return key.charAt(0);
    }

    @Override
    public boolean equals(Object obj){
        return key.equals((String) obj);
    }

}

