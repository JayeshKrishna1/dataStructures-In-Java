import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {
    //we need to store both key and value in array but both of them are of different data types
    //we can create a class and store the instance in the array. As class is a type.we can make array type as class
    public class Entry{
        int key;
        String value;
        //constructor 
        //to store the key and value that the user passes
         public  Entry(int key,String value){
             this.key = key;
             this.value=value;
        }
    }
    //we neeed to create a array of which values of linkedlist
    //array of linked list
    private LinkedList<Entry>[] entries = new LinkedList[5];
    //similar to int[] entry = new int[5].  here we store int type in array
    //but we store linked list in array. as there is LinkedList class in java we can use that class as type of array.
    //as that LinkedList class is generic we need to specify the type of linkedlist.

    public void put(int key,String str){
        //we need to find where to store this new entry.
        //as we seen we get the index by doing modulo of inddex by the array size. this is doe coz if key is very large we cant make such big array
        int index = hash(key);
        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }
        //as we seen hash map should not allow dupliactes instead it wil update
        for(HashTable.Entry entry : entries[index]){ //type of the value store in linkd list is Entry. type of array is LinkedList
            //we want the type of value in that particular index which is Entry class. As it is subClass of HashTable we specify like this
            //we cant say type of array is array same like this we cant say type of linked list is linkedlist
            if(entry.key == key){
                // entry.key = key;
                entry.value = str;
            }
        }
        //we need to add them to entry class 
        Entry entry = new Entry(key, str);
        entries[index].add(entry);
    }
    public String get(int key){
        int index = hash(key);
        if(entries[index] != null){

            for(HashTable.Entry entry : entries[index]){
                if(entry.key == key){
                    return entry.value;
                }
            }
        }
        return null;
    }
    public void remove(int key){
        int index = hash(key);
        if(entries[index] != null){
            for(HashTable.Entry entry : entries[index]){
                if(entry.key == key){
                    entries[index].remove(entry); //entry is the value in the linked list
                    return;
                }
            }
        }
        throw new NoSuchElementException();
    }
    private int hash(int key){
        return key%entries.length;//returns the index where we can store our entry
    }
    
}
