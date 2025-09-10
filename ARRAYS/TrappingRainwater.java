import java.lang.reflect.Array;
import java.util.*;
public class TrappingRainwater{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of Array:");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter The Elements of Array");
        for(int i=0;i<size;i++){
            System.out.print("Value at index "+i+" is equal to: "); 
            arr[i] = sc.nextInt();
        }
        System.out.println("Following Array Has been Created:" + Arrays.toString(arr));
}    
}