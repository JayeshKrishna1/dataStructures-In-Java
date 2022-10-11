import java.util.HashMap;

public class HashFunctions {
    public void demo(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "Jayesh"); // this method calles  hash function internally
        // a hash function is responsible for stroing the key  value pair
        // in genral , hash function uses array to store the value with key as index
        // in above put method , the value is stored in first index of internal array by hash function. This is the reason why the we get map elements not in an ordered way.
        map.put(123456, "Krishna");
        //if we take above case we cant make a array of 1 lakh size instead it will take the key and do modulos by the size of internal array
        // 123456 % 100 . assuming the size of internal array as 100

        // in case if the key is a string or char it will convert it to number as in programing strings are stored as numbers internaly
        //after converting it will do modulos by size of internal array
        
        String str = "jayesh";
        //every obj has hashCode() method wich will return the internal represantaion of that object value
        System.out.println(str.hashCode());  
    }
    //for integer type key
    public int hashFuncInt(int number){
        return number%100; //assuming the size of internal array as 100
        //the returning is the index 
    }

    //for string/character type key
    public int hashFuncString(String str){
        int hash = 0;
        for(char ch : str.toCharArray()){
            //as hash is declared as int ch will automatcially typecast to int
            hash  += ch; //this agumented assignment operator will do implicit typecast and convert ch to int
        }
        return hash;
    }
    
}
