class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low  = 0;
        int high = n-1;
        int mid = 0;
        
        while(low<high){
            mid = low+(high-low)/2;
            if(nums[mid]>nums[low])
                low = mid;
            else if(nums[high]>nums[mid])
                high = mid;
            else    
                break;
                
        }
        if(nums[high]<=target && nums[n-1]>= target)
            return binarySearch(high, n-1, nums,target);
        return binarySearch(0, high-1,nums,target);
    }
    
    
    public int binarySearch(int low, int high, int[] nums,int target){
        int mid = 0;
        
        while(low<=high){
            mid = low+(high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}