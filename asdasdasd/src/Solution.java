class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean x = false;
        boolean descending = false;
        boolean ascending = false;
        if(nums.length == 1){
            x = true;
        }
        if ((nums[0] >= nums[nums.length / 2]) && (nums[nums.length / 2] >= nums[nums.length - 1])) {
            descending = true;
        } else if ((nums[0] <= nums[nums.length / 2]) && (nums[nums.length / 2] <= nums[nums.length - 1])) {
            ascending = true;
        }


        if (ascending) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    x = false;
                    break;
                } else {
                    x = true;
                }

            }
        } else if (descending) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    x = false;
                    break;
                } else {
                    x = true;
                }
            }

        }
        return x;
    }
}
