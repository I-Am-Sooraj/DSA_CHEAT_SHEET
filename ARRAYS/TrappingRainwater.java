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
public static int trap(int[] height) {
    int n = height.length;
    if (n == 0) return 0;

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    rightMax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
    }

    int totalWater = 0;
    for (int i = 0; i < n; i++) {
        totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return totalWater;
}
}