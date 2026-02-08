package Hashing.Need_for_it;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the size of the array: ");
        int originalLength = sc.nextInt();
        int len = originalLength;

        while(len != 0) {
            // System.out.println("Enter number: " + (originalLength - len + 1));
            // int input = sc.nextInt();
            int input = rand.nextInt(2000 - 0 + 1) + 0; 
            arr.add(input);
            len--;
        }

        ArrayList<Integer> hashArr = createHash(arr);
        System.out.println("Array Length: " + arr.size());
        System.out.println("Hash Array Length: " + hashArr.size());
        System.out.println("Hash Array: " + hashArr.toString());
        sc.close();
    }

    public static int maxElement(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        System.out.println("Max Element: " + max);
        return max;
    }

    public static ArrayList<Integer> createHash(ArrayList<Integer> arr) {
        int maxLength = maxElement(arr) + 1;
        ArrayList<Integer> hashArr = new ArrayList<>();

        // Initialize all elements to 0
        for (int i = 0; i < maxLength; i++) {
            hashArr.add(0);
        }

        // count occurences
        for (int i = 0; i < arr.size(); i++) {
            int index = arr.get(i);
            hashArr.set(index, hashArr.get(index) + 1);
        }
        
        return hashArr;
    }
}
