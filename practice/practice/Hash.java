package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Hash {
    private class Entry{
        int key;
        String value;
        public Entry(int key,String value){
            this.key= key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];
    public void put(int key,String value){
        Entry entry = new Entry(key, value);
        int index = hash(key);
        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }
        for (Entry eachEntry : entries[index]) {
            if(eachEntry.key == key){
                eachEntry.value = value;
                return;
            }
        }
        entries[index].addLast(entry);
    }
    private int hash(int key){
        return (key%entries.length);
    }
    public String get(int key){
        int index = hash(key);
        for(Entry entry : entries[index]){
            if(entry.key == key){
                return entry.value;
            }
        }
        return null;
    }
    public void remove(int key){
        int index = hash(key);
        for(Entry entry : entries[index]){
            if(entry.key == key){
                entries[index].remove(entry);
                return;
            }
        }
    }
    // @override
    public void print(){
        for(LinkedList<Entry> list : entries){
            if(list == null){
                continue;
            }
            else{
                for(Entry enter : list){
                    System.out.print(enter.key+" = "+enter.value);
                }
            }
            System.out.println(" ");
        }
        // return Arrays.toString(entries);
    }
    public void mostRepeated(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                map.put(arr[i], ++count);
            }else{
                map.put(arr[i], 1);
            }
        }
        int max = map.get(arr[0]);
        int mostRepeated = 0;
        for(int keys : map.keySet()){
            if(max < map.get(keys)){
                max = map.get(keys);
                mostRepeated = keys;
            }
        }
        System.out.println(mostRepeated);
        System.out.println(map);
    }
    public int uniquePair(int[] arr,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                map.put(arr[i], ++count);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        //arr[i]-k = arr[j]
        int count = 0;
        for(int keys : map.keySet()){
            if(map.containsKey(keys-k)){
                if(k==0 && map.get(keys) == 2){
                    count++;
                }
                else{
                    count++;
                }
            }
        }
        return count;
    }
    public int[] twoSum(int[] arr,int k){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //arr[j] = k - arr][i]
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        // System.out.println(map);
        for(int keys : map.keySet()){
            if(map.containsKey(k-keys)){
                result[0] = map.get(keys);
                result[1] = map.get(k-keys);
                return result;
            }
        }
        return result; 
    }
 }