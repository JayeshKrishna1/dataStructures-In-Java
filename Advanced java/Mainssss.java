import java.io.IOException;

public class Mainssss{
    public static void main(String[] args) {
        Exceptions.call1();
        Exceptions e = new Exceptions();
        try {
          e.deposit(-1);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("hi");
  }  
}