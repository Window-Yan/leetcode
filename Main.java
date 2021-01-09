public class Main{
	public static void main(String[] args){
		// int[] nums = new int[]{1};

		// for(int i=0;i<removeDuplicates(nums,6);i++){
			// System.out.println(nums[i]);
		// }
		
		//System.out.println();
	}
	
	/**
	 * 20210109 leetcode 每日一题
	 * 题目：
	 * 	给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
	 *	如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 *	你可以假设数组中无重复元素。
	 */
	public int searchInsert(int[] nums, int target) {
		int ans = 0;
		//遍历数组，寻找相同的位置
		for(int i=0;i<nums.length;i++){
			if(nums[i]==target){
				ans = i;
				return ans;
			}else if(nums[i]<target){
				continue;
			}else{
				ans = i-1;
				return ans;
			}
		}return nums.length;//如果遍历完没有找到则应插入末尾
    }
	
	/**
	 * 20210109 之前的 leetcode 每日一题
	 */
	
	public static int strStr(String haystack,String needle){
		int ans=-1;
		int h=haystack.length(),n=needle.length();
		if(needle.length()==0){
			return 0;
		}else{			
			for(int i=0;i<h;i++){
				if(haystack.charAt(i)==needle.charAt(0)){
					if(h-i>=n){
						for(int j=1;j<n;j++){
							if(haystack.charAt(i+j)==needle.charAt(j)){
								if(j==n-1){
									return i;
								}
								continue;
							}else{
								break;
							}
						}
					}else
						return ans;										
				}
			}
		}return ans;
	}
	
	public static int removeDuplicates(int[] nums, int val){
		int ans = nums.length; //ans当作右指针使用
		if(nums.length<1){
			return nums.length;
		}else{
			for(int i=0;i<ans;i++){
				if(nums[i]!=val){
					continue;
				}else{
					int tmp = nums[i];//把重复值存放起来
					for(int j=i;j<ans-1;j++){
						nums[j]=nums[j+1];//把重复值后面的值往前移动一位
					}
					nums[ans-1]=tmp;//把重复值放到末尾
					ans--;//把不含重复值的窗口向前移动一位
					i--;
				}
			}
		}
		return ans;

	}
}




