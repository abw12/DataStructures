package Map.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomHashTable {
    private static class BucketHash extends ArrayList<Bucket>{}

    public int length;
    public BucketHash[] data;

    public CustomHashTable(int capacity){
        this.length=capacity;
        this.data=new BucketHash[length];
    }

    public void set(String key,int value){
        int address= generateHash(key);
        if(data[address] == null){
            data[address]=new BucketHash();
        }
        data[address].add(new Bucket(key,value));
        System.out.println("Set: " + Arrays.toString(data));
    }

    public int get(String key){
        int address=generateHash(key);

        if(data[address] == null)
            return 0;

        for(Bucket bucket:data[address]){
            if(bucket.getKey().equals(key)){
                System.out.println("Bucket: " + " Key:" + bucket.getKey() + " value:" + bucket.getValue());
                return bucket.getValue();
            }
        }
        return 0;
    }

    public void getKeys(){
        List<String> keyList= new ArrayList<>();
        for(int i=0 ; i < data.length ; i ++){
            if(data[i]!=null){
                for(int j=0; j < data[i].size();j++){
                    keyList.add(data[i].get(j).getKey());
                }
            }
        }
        System.out.println("KetSet : "+ keyList.toString());

    }

    public int generateHash(String key){
        int hash=0;
        for(int i=0; i < key.length() ; i++){
            hash=(hash + key.charAt(i) * i) % key.length();
        }
        return hash;
    }

    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable(10);
        hashTable.set("abhishek",1);
        hashTable.set("vedant",2);
        hashTable.set("sarang",3);
        hashTable.set("Vicky",4);
        hashTable.set("Krishna",5);
        hashTable.set("Akshay",6);
        hashTable.set("Prateek",7);

        hashTable.getKeys();
        System.out.println("Get method: " + hashTable.get("abhishek"));
    }

}
