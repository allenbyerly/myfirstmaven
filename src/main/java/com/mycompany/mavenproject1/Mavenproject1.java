/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.math.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Stack; 

/**
 *
 * @author me
 */
public class Mavenproject1 {

    public static void main(String[] args) {
         
        String[] y = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        numUniqueEmails(y);
        List<List<Integer>> queries = new ArrayList();
         List<Integer> query = new ArrayList();
         String s= "";
         s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> l = new ArrayList<>(); 
        
        char[] ch = s.toCharArray();
        //ch.length;
       Set<String> x = new HashSet<String>();
       
        query.add(2);
        query.add(6);
        query.add(8);
        
        queries.add(new ArrayList(query));
     
        
        query.set(0, 3);
        query.set(1, 5);
        query.set(2, 7);
        
        queries.add(new ArrayList(query));
        
        query.set(0, 1);
        query.set(1, 8);
        query.set(2, 1);
        
        queries.add(new ArrayList(query));
        
        query.set(0, 5);
        query.set(1, 9);
        query.set(2, 15);
        
        queries.add(new ArrayList(query));
        
        
        
        
        arrayManipulation(10, queries);
        
        
        long res = repeatedString("ababa", 3);
                
      //  boolean res = isValid("()[]{}");
        
        System.out.println("Hello World!");
        
        
        Scanner scan = new Scanner(System.in);
        long sum = 0;
        long min = 100;
        long max = 0;
        while(scan.hasNext()) {
            long n = scan.nextLong();
            sum = sum + n;
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        scan.close();
        
        System.out.println((sum - max) + " " + (sum - min));
        
        
       // String apple = new String();
        HashMap<Integer, String> apples = new HashMap();
        apples.put(1, "alice");
        apples.put(2, "bob");
        apples.put(3, "malorie");
        apples.put(4, "eve");
       
        
        for (Map.Entry<Integer, String> apple : apples.entrySet())
        {
            System.out.println(apple.getValue()); 
        }
        
        String input = "3[abc]4[ab]c";
        String num = "";
        String str = "";
        
        char[] chars = input.toCharArray();
        
      /*  for (char c : chars) {
            
            if (Character.isDigit(c)){
                num = num + c;
            }
            else if (Character.isAlphabetic(c)){
                str = "";
            }
            else if (c == '[') {
                str = 
            }
        }
        
        */
      
       List<Integer> list = new ArrayList<Integer>();
    
            list.add(793810624);
            list.add(895642170);
            list.add(685903712);
            list.add(623789054);
            list.add(468592370);
            
            miniMaxSum(list);
            
    }
    
    public static int numUniqueEmails(String[] emails) {
    
        Set<String> results = new HashSet<String>();
        
        for (String email : emails){
            //HashMap<Integer, char> c = new HashMap<Integer, char>();
            int index = email.indexOf('@');
            char[] local =  email.substring(0, index).toCharArray();
            String domain = email.substring(index+1, email.length());
            String res = "";                      
            
            for (int i = 0; i < local.length; i++){
                if (local[i] != '.' && local[i] != '+') res = res + local[i];
                else if (local[i] == '+') i = local.length;
            }
            
            results.add(res + '@' + domain);

                        
        }
        
        return results.size();
    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
        long result = 0;

        List<List<Integer>> list = new ArrayList<>();
        List<Long> rec = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        
        for (int i = 0; i < n; i++  ){
            index.add( i+1);
            rec.add(result);
        }  
        
   //     list.add(index);
     //   list.add(rec);
    
        for (int i = 0; i < queries.size(); i++  ){
            Long a, b, k;
                
            a = (long) queries.get(i).get(0);
            b = (long) queries.get(i).get(1);
            k = (long) queries.get(i).get(2);
            
            for (Long j = a - 1; j < b; j++  ){
                Long v = (long) rec.get(j.intValue());
                v = v + k; 
                rec.set(j.intValue(), v);
                
                if (result < v ){
                    result = v;
                }
            }
        }
        return result;
      
    }
        
        
        
        
        
        
        
    

    
    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        
        //minimum is the combination of min values
        //maximum is the comnination of max values
        
        //sort the values to process for min and max
        sort(arr);
        String result = sortedMin(arr, 4) + " " + sortedMax(arr, 4);
        
        System.out.println(result);
        
    }
    
    public static BigInteger sortedMin (List<Integer> list, int number){
        BigInteger result = new BigInteger("0");
        
        for (int i = 0; i < list.size()-1; i++){
            result = result.add(BigInteger.valueOf(list.get(i))); 
        }
        
        return result;
    }
    
    public static BigInteger sortedMax (List<Integer> list, int number){
        BigInteger result = new BigInteger("0");
        
        for (Integer i = list.size() - 1 ; i >= 1; i--){
            result = result.add(BigInteger.valueOf(list.get(i))); 
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
    
    public static long repeatedString(String s, long n) {
    // Write your code here
        String st = s;
        int size = s.length();
        //int count = s.indexOf(ch)
      /*  while (st.length() < n ){
            st = st + s;
        }*/
        long count = (long) 0;
        Map<Character, Long> map = new HashMap<>();
        int[] indexes = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a') {
                count++;
                indexes[i] = 1;
            }
            else
            {
                indexes[i] = 0;
            }
        }
        
        long reps = n / s.length() ;
        
        long rem = (s.length() * reps) % n;
        if (reps == 0){
           rem = n;
        }
        long sh = (long) 0;
        if (reps == 0){
            sh = n % s.length();
        }
        else {
                sh = n % (s.length() * reps);
                }
        if (rem == 0 )
        {
            return count * reps;
        }
        else if (rem > 0 )
        {
            count = count * reps;
            int j = 0;
            while (j < rem){
                if (s.charAt(j) == 'a'){
                    count ++;
                }
                j++;
            }
            return count;
        }
        else if (sh > 0 )
        {
            count = count * reps;
            int j = s.length()-1;
            while (j >= 0) {
                if (s.charAt(j) == 'a'){
                    count --;
                }
            }
            return count;
        }
        
        return count;
    
    }
    
     public static boolean isValid(String s) {
        Stack<Character> parStack = new Stack<>();
        Stack<Character> brackStack = new Stack<>();
        Stack<Character> braceStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            
            if (chars[i] == '[') {
               brackStack.push('[');
            }
            if (chars[i] == '(') {
                brackStack.push('(');
            }
            if (chars[i] == '{') {
                brackStack.push('{');
            }
            if (chars[i] ==']') {
                if (brackStack.empty()){ 
                    return false;
                }
                else if (brackStack.pop() != '['){
                    return false;
                }
            }
            if (chars[i] == ')') {
                 if (brackStack.empty()){ 
                    return false;
                }
                else if (brackStack.pop() != '('){
                    return false;
                }
            }
            if (chars[i] == '}') {
                 if (brackStack.empty()){ 
                    return false;
                }
                else if (brackStack.pop() != '{'){
                    return false;
                }
            }
 
        }
        
        if (!brackStack.empty() ){
            return false;
            
        }
        else
        {
            return true;
        }
    }
    
    
    //3[abc]4[ab]c
    
    public String decompress(String input){
        String result = "";
        
        String substring = input; 
        while (substring.contains("]")) 
        {
            substring = input.substring(substring.lastIndexOf(substring, substring.lastIndexOf(']'))+1, input.lastIndexOf(']')-1);
            substring = input.substring(input.indexOf('['), input.lastIndexOf(']')-1); 
            while (substring.contains(result))
            result = decompress(substring);
        }
        return result;
     
    }
}
