import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exceptions {
    public static void call1(){
        try {
            FileReader text = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
        call2(null);
    }
    public static void call2(String str){
        
        try(FileReader text = new FileReader("file.txt");){
            System.out.println(str.toLowerCase());
            System.out.println("i got executed");
            
        } catch(NullPointerException | IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void deposit(float f) throws IOException{
      if(f < 0){
          throw new IOException();
      }
      System.out.println("Im executed.");   
    }
}
