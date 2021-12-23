// 35. Search Insert Position

class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsertHelper(nums, target, 0, nums.length);
    }
    
    public int searchInsertHelper(int[] nums, int target, int head, int tail){
        
        int size = tail - head;
        int mid = head + size / 2;
         
        // Invalid window to search
        if(size <= 1){
            if(nums[0] == target) 
                return 0;
            else 
                return findLocation(nums, target);
        }
        
        // Target found in middle of current window
        if(nums[mid] == target) 
            return mid;
        
        // Search left side
        if(nums[mid] > target) 
            return searchInsertHelper(nums, target, 0, mid-1);
        
        // Search right side
        if(nums[mid] < target) 
            return searchInsertHelper(nums, target, mid+1, tail);
        
        // Shouldnt get here but just in case...
        return -1;
    }
    
    public int findLocation(int[] nums, int target){
        
        // find index where number should be inserted
        for(int i = 0; i < nums.length; i++){
            if(target <= nums[i]){
                return i;
            }    
        }
        
        // If here, all numbers are smaller than target so add it at the end
        return nums.length;
    }
}