class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        
        while(mid<=high){
            if(nums[mid] == 1)
                mid = mid+1;
            else {
                int temp = 0;
                if(nums[mid] == 2){
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high = high-1;
                }else{
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low = low+1;
                    ++mid;
                }
            }
        }
    }
}