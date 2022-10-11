public class Main{
    public static void main(String[] args) {
        // Hashing is a technique or process of mapping keys, values into the hash table by using a hash function 

        // FirstNonRepeatingChar charFinder  = new FirstNonRepeatingChar();
        // String str = "a green apple";
        // System.out.println(charFinder.CharFinder(str));  

        // RemovingDuplicatesInArray removeduplicate = new RemovingDuplicatesInArray();
        // int[] arr = {1,3,3,4,1,5,2,5,2};
        // removeduplicate.removeDuplicate(arr);

        FirstRepeatedCharacter firstRepeatedCharacter = new FirstRepeatedCharacter();
         String str = "green apple";
        System.out.println(firstRepeatedCharacter.charFinder(str));  
    }
}