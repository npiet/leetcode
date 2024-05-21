import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

//    @Test
//    void test(){
//        int[] array = new int[]{1,2,3,4,5};
//        Assertions.assertEquals(3, Solution.minSubArrayLen(11, array));
//    }
//
//    @Test
//    void longestPalindromTest() {
//        String s = "aacabdkacaa";
//        Assertions.assertEquals("aca", Solution.longestPalindrome1(s));
//    }
//
//    @Test
//    void longestPalindromTest1() {
//        String s = "aaa";
//        Assertions.assertEquals("aaa", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest2() {
//        String s = "aadfda";
//        Assertions.assertEquals("adfda", Solution.longestPalindrome1(s));
//    }
//
//    @Test
//    void longestPalindromTest3() {
//        String s = "a";
//        Assertions.assertEquals("a", Solution.longestPalindrome1(s));
//    }
//
//    @Test
//    void longestPalindromTest4() {
//        String s = "";
//        Assertions.assertEquals("", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest5() {
//        String s = "ac";
//        Assertions.assertEquals("a", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest6() {
//        String s = "abbav";
//        Assertions.assertEquals("abba", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest7() {
//        String s = "aa";
//        Assertions.assertEquals("aa", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest8() {
//        String s = "eedhqbfofmdsjbsbaaabsbyrh";
//        Assertions.assertEquals("bsbaaabsb", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest9() {
//        String s = "cbbd";
//        Assertions.assertEquals("bb", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest10() {
//        String s = "aaaa";
//        Assertions.assertEquals("aaaa", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest11() {
//        String s = "aaaaa";
//        Assertions.assertEquals("aaaaa", Solution.longestPalindrome1(s));
//    }
//    @Test
//    void longestPalindromTest12() {
//        String s = "babadada";
//        Assertions.assertEquals("adada", Solution.longestPalindrome1(s));
//    }
//
//    @Test
//    void poorPigTest() {
//        Assertions.assertEquals(2, Solution.poorPigs(4, 15, 30));
//    }
//    @Test
//    void poorPigTest1() {
//        Assertions.assertEquals(5, Solution.poorPigs(1000, 15, 60));
//    }

//    @Test
//    void countPalindromicSubsequenceTest() {
////        Assertions.assertEquals(3, Solution.countPalindromicSubsequence("aabca"));
////        Assertions.assertEquals(0, Solution.countPalindromicSubsequence("adc"));
////        Assertions.assertEquals(4, Solution.countPalindromicSubsequence("bbcbaba"));
//        Assertions.assertEquals(161, Solution.countPalindromicSubsequence("www"));
//    }

//    @Test
//    void minBitOpTest4() {
//        Assertions.assertEquals(7, Solution.minimumOneBitOperations(4));
//    }
//    @Test
//    void minBitOpTest3() {
//        Assertions.assertEquals(2, Solution.minimumOneBitOperations(3));
//    }
//
//    @Test
//    void minBitOpTest10() {
//        Assertions.assertEquals(12, Solution.minimumOneBitOperations(10));
//    }
//
//    @Test
//    void minBitOpTest14() {
//        Assertions.assertEquals(11, Solution.minimumOneBitOperations(14));
//    }
//
//    @Test
//    void minBitOpTest57() {
//        Assertions.assertEquals(46, Solution.minimumOneBitOperations(57));
//    }
//
//    @Test
//    void remoccurancesTest() {Assertions.assertEquals("dab", Solution.removeOccurrences("daabcbaabcbc", "abc"));}
//    @Test
//    void remoccurancesTest1() {Assertions.assertEquals("ab", Solution.removeOccurrences("axxxxyyyyb", "xy"));}
//    @Test
//    void remoccurancesTest3() {Assertions.assertEquals("b", Solution.removeOccurrences("xxxxyyyyb", "xy"));}
//    @Test
//    void remoccurancesTest2() {Assertions.assertEquals("hijzgaovndkjiiuwjtcpdpbkrfsi", Solution.removeOccurrences("kpygkivtlqoockpygkivtlqoocssnextkqzjpycbylkaondsskpygkpygkivtlqoocssnextkqzjpkpygkivtlqoocssnextkqzjpycbylkaondsycbylkaondskivtlqoocssnextkqzjpycbylkaondssnextkqzjpycbylkaondshijzgaovndkjiiuwjtcpdpbkrfsi", "kpygkivtlqoocssnextkqzjpycbylkaonds"));}

    @Test
    void happyTest1() {Assertions.assertEquals(true, Solution.isHappy(19));}
    @Test
    void happyTestxx8() {Assertions.assertEquals(true, Solution.isHappy(1164735058));}
    @Test
    void happyTestxx4() {Assertions.assertEquals(false, Solution.isHappy(1164735054));}
    @Test
    void happyTest10() {Assertions.assertEquals(true, Solution.isHappy(10));}


    @Test
    void foursumtest0() {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(-2,-1,1,2));
        l.add(Arrays.asList(-2,0,0,2));
        l.add(Arrays.asList(-1,0,0,1));
        Assertions.assertEquals(l , Solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }

    @Test
    void foursumtest000() {
        List<List<Integer>> l = new ArrayList<>();
        Assertions.assertEquals(l , Solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    @Test
    void foursumtest0020() {
        List<List<Integer>> l = new ArrayList<>();
        Assertions.assertEquals(l , Solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, 0));
    }
    @Test
    void decodeTest0(){
        Assertions.assertEquals("aaabcbc", Solution.decodeString("3[a]2[bc]"));
    }

    @Test
    void decodeTest1(){
        Assertions.assertEquals("accaccacceeef", Solution.decodeString("3[a2[c]]3[e]f"));
    }

    @Test
    void stairsTest0(){
        Assertions.assertEquals(14930352, Solution.climbStairs(35));
    }

    @Test
    void traptes0(){
        Assertions.assertEquals(6, Solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    @Test
    void traptes1(){
        Assertions.assertEquals(1, Solution.trap(new int[]{4, 2, 3}));
    }
}
