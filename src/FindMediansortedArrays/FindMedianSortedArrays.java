package FindMediansortedArrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        // length of the first half of the merged array including the indicies needed for the median
        int len = ((x+y)/2)+1;

        // look for how many elements of nums1 are in the first half of the merged array
        // set min and max depending on the length of the first half
        int min = Math.max(0, len - y);
        int max = Math.min(x, len);


        while(true){
            // check for mid elements of nums1 in the merged array
            int mid = (min + max)/2;

            // find last and next elements of both arrays when selecting mid elements from nums1
            // for egde cases substitude for MIN or MAX values (numbers are only compared)
            int lastX = mid - 1 >= 0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int lastY = len - mid - 1 >= 0 ? nums2[len-mid-1] : Integer.MIN_VALUE;
            int nextX = mid < x ? nums1[mid] : Integer.MAX_VALUE;
            int nextY = len-mid < y ? nums2[len-mid] : Integer.MAX_VALUE;

            // check if the desired split was found
            // we are looking for a split where all selected numbers are smaller than all not selected numbers
            // since the arrays are sorted we can only check the last from nums1 < next from nums2 and the other way around
            if(lastX<=nextY && lastY<=nextX){
                if((x+y)%2==1) return Math.max(lastX, lastY);

                // if there is an even amount of elements check also second last elements (if they exist)
                int secondLastX = mid - 2 >= 0 ? nums1[mid-2] : Integer.MIN_VALUE;
                int secondLastY = len - mid - 2 >= 0 ? nums2[len-mid-2] : Integer.MIN_VALUE;
                if((lastX >= lastY && lastY >= secondLastX) || (lastY >= lastX && lastX >= secondLastY)) return (double) (lastX + lastY) / 2;
                if(lastX >= lastY && secondLastX >= lastY) return (double) (lastX + secondLastX) / 2;
                if(lastY >= lastX && secondLastY >= lastX) return (double) (lastY + secondLastY) / 2;
            }

            if(lastX > nextY){ // need less nums1, so lower the max to mid -1
                max = mid - 1;
            }
            if(lastY>nextX){ // need more nums1, so lower the min to mid +1
                min = mid + 1;
            }
        }
    }
}
