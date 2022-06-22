import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
     public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        
        //minimum is the combination of min values
        //maximum is the comnination of max values
        
        //sort the values to process for min and max
        sort(arr);
        String result = Integer.toString(sortedMin(arr, 4)) + " " + Integer.toString(sortedMax(arr, 4));
        
        System.out.println(result);
        
    }
    
    public static int sortedMin (List<Integer> list, int number){
        int result = 0;
        
        for (int i = 0; i < list.size()-1; i++){
            result = result + list.get(i); 
        }
        
        return result;
    }
    
    public static int sortedMax (List<Integer> list, int number){
        int result = 0;
        
        for (int i = list.size() - 2 ; i >= 0; i--){
            result = result + list.get(i); 
        }
        
        return result;
    }
    
    public static void sort(List<Integer> list) {

        //List<Integer> list = new ArrayList<Integer>() ;
       // list = list;
        
        int n = list.size();
        
        for (int i = 1; i < n; i++) {
            int key = list.get(i);
            int j = i-1;
            
            while (j >= 0 && list.get(j) > key) {
                list.set(j+1, list.get(j));
                j--;
            }
            
            list.set(j+1, key);
        }
    }

}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
*/