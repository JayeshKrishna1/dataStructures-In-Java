import java.util.*;
import java.io.*;
public class Mai
{
	public static void main(String[] args) throws IOException {
// 		System.out.println("Hello World");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] name;
    name = reader.readLine().split(" ");
    Scanner sc = new Scanner(System.in);
    int destinationD = Integer.parseInt(name[0]);
    int NoOfCars = Integer.parseInt(name[1]);
    List<int[]> cars = new ArrayList<>();
    for(int i=0;i<NoOfCars;i++){
        int carIntialPos = 0; 
        int carSpeed = 0;
        String[] name1;
        name1 = reader.readLine().split(" ");
        carIntialPos = Integer.parseInt(name1[0]);
        carSpeed = Integer.parseInt(name1[1]);
        cars.add(new int[]{carIntialPos,carSpeed});
    }
    Collections.sort(cars,(a,b)->a[0]-b[0]);//sorting the list according to the inital distance of each cars
    //by doing so we can itrerate from right and calculate the time for neighbour cars we gonna take the minimum time car as the constant speed and we gonn do this for all cars. by end we will get constant speed
      int MaxTime = 0;
      for(int[] arr : cars){
          int time =0;
          time = (destinationD-arr[0])/arr[1];
          MaxTime = Math.max(MaxTime,time);
      }
      int finalSpeed = destinationD/MaxTime;
      System.out.println(finalSpeed);
	}
}
