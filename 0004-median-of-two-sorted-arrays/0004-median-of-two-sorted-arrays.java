class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        double ans = 0;
        int start = 0, end = len1;

        while (start <= end) {
            int posX = (start + end) / 2;
            int posY = (len1 + len2 + 1) / 2 - posX;

            int leftX = (posX == 0) ? Integer.MIN_VALUE : nums1[posX - 1];
            int RightX = (posX == len1) ? Integer.MAX_VALUE : nums1[posX];

            int leftY = (posY == 0) ? Integer.MIN_VALUE : nums2[posY - 1];
            int rightY = (posY == len2) ? Integer.MAX_VALUE : nums2[posY];

            if (leftX <= rightY && leftY <= RightX) {
                if ((len1 + len2) % 2 != 0) {
                    ans = Math.max(leftX, leftY);
                } else {
                    ans = (Math.max(leftX, leftY) + Math.min(RightX, rightY)) / 2.0;
                }
                break;
            } else if (leftX > rightY) {
                end = posX - 1;
            } else {
                start = posX + 1;
            }
        }

        return ans;
    }
}