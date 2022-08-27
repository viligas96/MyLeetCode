public class LC088MerSorArr {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)return;

        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums3 = new int[m];

        System.arraycopy(nums1, 0, nums3, 0, m);
        while (i < m+n) {
            if (k == m){
                nums1[i] = nums2[j];
                i++;
                j++;
                continue;
            }
            if (j == n){
                nums1[i] = nums3[k];
                i++;
                k++;
                continue;
            }
            if (nums3[k] > nums2[j]){
                nums1[i] = nums2[j];
                j++;
            } else{
                nums1[i] = nums3[k];
                k++;
            }
            i++;
        }
    }
}
