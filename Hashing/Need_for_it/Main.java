package Hashing.Need_for_it;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] queryArray = {5, 200, 415, 1000, 1569, 1832};

        System.out.println("Enter the size of the array: ");
        int originalLength = sc.nextInt();
        int len = originalLength;

        while(len != 0) {
            // System.out.println("Enter number: " + (originalLength - len + 1));
            // int input = sc.nextInt();
            int input = rand.nextInt(15 - 0 + 1) + 0; 
            arr.add(input);
            len--;
        }

        ArrayList<Integer> hashArr = createHash(arr);
        System.out.println("Array Length: " + arr.size());
        System.out.println("Hash Array Length: " + hashArr.size());
        System.out.println("Array: " + arr.toString() + "\n");
        System.out.println("Hash Array: " + hashArr.toString() + "\n");

        // for (int i = 0; i < queryArray.length; i++) {
        //     System.out.printf("Count of %d in the array: %d", queryArray[i], countOccurences(arr, queryArray[i]));
        //     System.out.println();
        // }
        for (int i = 0; i < queryArray.length; i++) {
            System.out.println("Count of " + queryArray[i] + " : " + countOccurenceHash(hashArr, queryArray[i]));
        }


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

    // Only if array is used.
    public static int countOccurences(ArrayList<Integer> arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == target) {
                count++;
            }
        }
        return count;
    }

    // if hash is used
    public static int countOccurenceHash(ArrayList<Integer> hashArr, int target) {
        if (target < 0 || target > hashArr.size()) {
            return 0;
        }
        int num = Math.min(100, 10);
        System.out.println(num);
        int count = hashArr.get(target);
        return count != 0 ? count : 0;

    }
}




// class Solution {
//     public int mostFrequentElement(int[] nums) {
//         if (nums.length == 0) return -1;

//         int maxOccuring = 1;
//         int maxOccuringNum = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             int count = 0;
//             for (int j = 0; j < nums.length; j++) {
//                 if (nums[j] == nums[i]) {
//                     count++;
//                 }
//             }
//             if (count > maxOccuring) {
//                 maxOccuring = count;
//                 maxOccuringNum = nums[i];
//             } else if (count == maxOccuring) {
//                 maxOccuringNum = Math.min(nums[i], maxOccuringNum);
//             }
//         }

//         return maxOccuringNum;
//     }
// }
