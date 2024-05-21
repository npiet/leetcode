import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.function.ToIntFunction;
import java.lang.Integer;
import java.util.stream.Collectors;

class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int end_index = -1;
        int start_index = 0;
        int min_length = Integer.MAX_VALUE;
        while (sum<target && end_index<nums.length-1){
            end_index++;
            sum += nums[end_index];
        }
        if(end_index==nums.length-1 && sum<target) return 0;
        if(end_index==nums.length-1 && sum==target) return end_index+1;
        outerloop:
        while(start_index<nums.length){
            while(sum>=target){
                min_length = Math.min(min_length, end_index-start_index+1);
                if(end_index-start_index==0){
                    return 1;
                }
                sum -= nums[start_index];
                start_index++;


            }
            while (sum<target){
                if(end_index==nums.length-1){
                    break outerloop;
                }
                sum += nums[end_index+1];
                end_index++;
            }
            min_length = Math.min(min_length, end_index-start_index+1);
        }
        return min_length;
    }

    public static String longestPalindrome1(String s) {
        int pointer = (s.length()/2);
        String res = "";
        char[] chars = s.toCharArray();
        boolean direction = true;
        int directionCount = 1;
        while (pointer >= 0 && pointer < chars.length) {

            //aba
            if (pointer > 0 && pointer < chars.length - 1 && chars[pointer - 1] == chars[pointer + 1]) {
                int count = 1;
                while (pointer - count - 1 >= 0 && pointer + 1 + count < chars.length && chars[pointer - count - 1] == chars[pointer + 1 + count]) {
                    count++;
                }
                if (count * 2 >= res.length()) res = s.substring(pointer - count, pointer + count + 1);
            }
            //aa
            if (pointer < chars.length - 1 && chars[pointer] == chars[pointer + 1]) {
                int count = 1;
                while (pointer - count >= 0 && pointer + 1 + count < chars.length && chars[pointer - count] == chars[pointer + 1 + count]) {
                    count++;
                }
                if (count * 2 >= res.length()) res = s.substring(pointer - count + 1, pointer + count + 1);
            }
            if (direction) {
                direction = false;
                pointer -= directionCount;
                directionCount++;
            } else {
                direction = true;
                pointer += directionCount;
                directionCount++;
            }
        }
        if(res.length()==0 && s.length()>0) res = String.valueOf(s.charAt(0));
        return res;
    }

    public static String longestPalindrome(String s) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        StringBuilder sbSame = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            sbSame.append(c);
            while(i<s.length()-1 && s.charAt(i+1)==c){
                sbSame.append(c);
                i++;
            }
            String sameSeq = sbSame.toString();
            if(res.length()<sameSeq.length()){
                res = sameSeq;
            }
            sbSame = new StringBuilder();

            if(stack.isEmpty()){
                if(res.length()<sb.length()){
                    res = sb.toString();
                }
                sb = new StringBuilder();
                stack.push(sameSeq);
                continue;
            }
            String last = stack.pop();
            if(last.equals(sameSeq)){
                sb.append(sameSeq);
                sb.insert(0, last);

            } else if (!stack.isEmpty() && sameSeq.equals(stack.peek()) && sb.length()==0){
                sb.append(sameSeq);
                sb.append(last);
                sb.append(sameSeq);
                stack.pop();
            } else {
                if(res.length()<sb.length()){
                    res = sb.toString();
                }
                if(sb.length()>0) {
                    sb = new StringBuilder();
                    stack = new Stack<>();
                } else {
                    stack.push(last);
                    stack.push(sameSeq);
                }

            }
        }
        if(res.length()<sb.length()){
            res = sb.toString();
        }
        if(res.length()<sbSame.length()){
            res = sbSame.toString();
        }
        if(res.length()==0 && s.length()>0) res = String.valueOf(s.charAt(0));
        return res;
    }
    public int countVowelPermutation(int n) {
        return countVowelPermutationHelper(n, (char)0);
    }

    private int countVowelPermutationHelper(int n, char prev){
        if(n==0){
            return 1;
        }

        switch(prev) {
            case 'a':
                return (int) ((countVowelPermutationHelper(n-1, 'e'))% (Math.pow(10, 9) + 7));
            case 'e':
                return (int) ((countVowelPermutationHelper(n-1, 'a') + countVowelPermutationHelper(n-1, 'i'))% (Math.pow(10, 9) + 7));
            case 'i':
                return (int) ((countVowelPermutationHelper(n-1, 'a') + countVowelPermutationHelper(n-1, 'e')
                                        + countVowelPermutationHelper(n-1, 'o') + countVowelPermutationHelper(n-1, 'u'))% (Math.pow(10, 9) + 7));
            case 'o':
                return (int) ((countVowelPermutationHelper(n-1, 'u') + countVowelPermutationHelper(n-1, 'i'))% (Math.pow(10, 9) + 7));
            case 'u':
                return (int) ((countVowelPermutationHelper(n-1, 'a'))% (Math.pow(10, 9) + 7));
            case 0:
                return (int) (countVowelPermutationHelper(n-1, 'a') + countVowelPermutationHelper(n-1, 'e')
                                        + countVowelPermutationHelper(n-1, 'o') + countVowelPermutationHelper(n-1, 'u')
                                        +countVowelPermutationHelper(n-1, 'i')% (Math.pow(10, 9) + 7));

            default: return 0;
        }
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest/minutesToDie + 1;
        int pow = rounds;
        int x = 1;
        while(rounds<buckets){
            rounds *= pow;
            x++;
        }
        return x;
    }

//    public int[] sortByBits(int[] arr) {
//        Comparator<Integer> customComparator = new CustomComparator();
////        Arrays.sort(arr, customComparator);
////        return arr;
////        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
////        Arrays.sort(input, Comparator.comparingInt(a -> Integer.bitCount((Integer) a)).thenComparing(a -> a));
////        return Arrays.stream(arr).boxed()
////                .sorted(new Comparator<Integer>() {
////                    @Override
////                    public int compare(Integer o1, Integer o2) {
////                        int bitComp = Integer.compare(Integer.bitCount(o1), Integer.bitCount(o2));
////                        if (bitComp==0) return Integer.compare(o1, o2);
////                        return bitComp;
////                    }
////                }).mapToInt(i -> i)
////                .toArray();
//        Arrays.sort(arr, (a, b) -> comp(a, b));
//    }

    public int[] sortByBits(int[] arr) {
        if(arr.length<2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = sortByBits(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortByBits(Arrays.copyOfRange(arr, mid, arr.length));
        int countLeft = 0;
        int countRight = 0;
        int countRes = 0;
        int[] res = new int[arr.length];
        while(countLeft<left.length && countRight<right.length){
            int comp = comp(left[countLeft], right[countRight]);
            if(comp<0){
                res[countRes] = right[countRight];
                countRight++;
            } else {
                res[countRes] = left[countLeft];
                countLeft++;
            }
            countRes++;
        }
        while(countLeft<left.length){
            res[countRes] = left[countLeft];
            countLeft++;
            countRes++;
        }
        while(countRight<right.length){
            res[countRes] = right[countRight];
            countRight++;
            countRes++;
        }
        return res;


    }
    private int comp(int a, int b){
        int bitComp = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
        if (bitComp==0) return Integer.compare(a, b);
        return bitComp;
    }

    public static int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for(int i=0; i<s.length()-1; i++){
            char c = chars[i];
            int j = i+1;
            if(map.containsKey(c) && map.get(c).size()==26) continue;
            while(j<chars.length && chars[j]!=c){
                j++;
            }
            if(j==chars.length) continue;
            if(map.containsKey(c)){
                map.get(c).add(c);
                for(int k = i+1; k<j; k++){
                    map.get(c).add(chars[k]);
                }
            }
            else {
                Set<Character> set = new HashSet<>();
                for (int k = i + 1; k < j; k++) {
                    set.add(chars[k]);
                }

                map.put(c, set);
            }
        }
        int res = 0;
        for(char c: map.keySet()){
            res += map.get(c).size();
        }
        return res;
    }

    public static int minimumOneBitOperations(int n) {
        int i = 1;
        int count = 0;
        int res = 0;
        while(n>=i){
            int r = i & n;
            i = i*2;
            count++;
            if(r > 0){
                res = ((int) Math.pow(2, count)) - 1 - res;
            }
        }
        return res;
    }

    public static String removeOccurrences(String s, String part) {
        outerwhile:
        while(true){
            int partCount = 0;
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == part.charAt(partCount)) {
                    partCount++;
                } else {
                    i = i-partCount;
                    partCount = 0;
                }
                if(partCount == part.length()){
                    s = (s.substring(0, i-partCount+1)).concat(s.substring(i+1));
                    continue outerwhile;
                }
            }
            break;
        }
        return s;
    }




    public static boolean isHappy(int n) {
        if(n==1 || n == 7) return true;

        return isHappyHelper(new HashSet<Integer>(), n);
    }

    public static boolean isHappyHelper(Set<Integer> set, int n){
        int newN = 0;
        while(n>0){
            int divRes = (n%10);
            newN += Math.pow(divRes, 2);
            n /= 10;
        }
        if(newN==1 || newN==7) return true;
        if(set.contains(newN)) return false;
        set.add(newN);
        return isHappyHelper(set, newN);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        for(int i = 0; i<nums.length-3; i++){
            // if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1; j<nums.length-2; j++){
                // if(j>i+1 && nums[j]==nums[j-1]) continue;
                long t = nums[i] + nums[j];
                HashSet<Long> set = new HashSet<>();
                for(int k = j+1; k<nums.length; k++){
                    if(set.contains(target-t - nums[k])) {
                        Integer[] arr = new Integer[]{nums[i], nums[j], nums[k], (int)(target-t - nums[k])};
                        Arrays.sort(arr);
                        res.add(Arrays.asList(arr));
                    }

                    set.add((long)(nums[k]));
                }
            }

        }
        return new ArrayList<>(res);
    }

    public static String decodeString(String s) {
        // int i = 0;

        // while(i<s.length && s.charAt(i)!='['){
        //     i++;
        // }
        // if(i==s.length) return s;

        int open = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!='['){
                if(s.charAt(i)>65) {
                    sb.append(s.charAt(i));
                } else {
                    num *= 10;
                    num += Character.getNumericValue(s.charAt(i));
                }
            } else {
                int start = i;
                do{
                    if(s.charAt(i)=='['){
                        open++;
                    }
                    else if (s.charAt(i)==']'){
                        open--;
                    }
                    i++;
                } while (open>0);
                String sub = decodeString(s.substring(start+1, i-1));
                sb.append(sub.repeat(Math.max(0, num)));
                num = 0;
                i--;
            }
        }
        return sb.toString();
    }

    public static int climbStairs(int n) {
        return 0;
    }

    public static int trap(int[] height) {
        boolean up = false;
        int lastHigh;
        int lastHighIndex;
        int i = 0;
        int res = 0;
        while(height[i]<height[i+1]) i++;
        lastHigh = height[i];
        lastHighIndex = i;
        i++;
        int tempRes = 0;
        while(i<height.length){
            if(!up && height[i]<lastHigh && i!=height.length-1) {
                tempRes += lastHigh - height[i];
                i++;
            }
            else if(!up && height[i]>=lastHigh) {
                up = true;
                res += tempRes;
                tempRes = 0;
                lastHigh = height[i];
                lastHighIndex = i;
                i++;
            }
            else if(up && height[i]>=lastHigh) {
                lastHigh = height[i];
                lastHighIndex = i;
                i++;
            }
            else if (up && height[i]<lastHigh){
                up = false;
            }
            else if(!up && i==height.length-1){
                up = true;
                tempRes = 0;
                i = lastHighIndex +1;
                lastHigh -= 1;


            }
        }
        return res;
    }
}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int bitComp = Integer.compare(Integer.bitCount(o1), Integer.bitCount(o2));
        if (bitComp==0) return Integer.compare(o1, o2);
        return bitComp;
    }
}