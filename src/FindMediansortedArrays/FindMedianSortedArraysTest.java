package FindMediansortedArrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindMedianSortedArraysTest {
    @Test
    void test(){
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{-2, -1};
        Assertions.assertEquals(-1, FindMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test1(){
        int[] nums1 = new int[]{1,2,4,6,15};
        int[] nums2 = new int[]{3,5,7,21,25};
        Assertions.assertEquals(5.5, FindMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}