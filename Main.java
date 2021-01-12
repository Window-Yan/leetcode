import java.util.HashMap;
import java.util.Arrays;

public class Main{
	public static void main(String[] args){
		int[] nums = new int[]{0,1};
		
		// for(int i=0;i<removeDuplicates(nums,6);i++){
			// System.out.println(nums[i]);
		// }
		
		
		System.out.println(Arrays.toString(arrayAddOne(nums)));
	}
	
	/**
	 * 20210112 leetcode 每日一题
	 * 题目：
	 * 	
	 * 
	 * 参数：int[] nums
	 * 返回值：int[] nums
	 */
	public static int[] arrayAddOne(int[] nums){
		int q=0;//q是商
		int len = nums.length;
		nums[len-1]+=1;
		q=nums[len-1]/10;
		if(q>0){
			int r=nums[len-1]%10;
			if(len==1){
				nums = new int[2];
				nums[1]=r;
				nums[0]=q;				
			}else{
				int[] ans=arrayAddOne(Arrays.copyOfRange(nums,0,len-1));
				nums = new int[ans.length+1];
				for(int i=0;i<ans.length;i++){
					nums[i]=ans[i];
				}
				nums[ans.length]=r;
			}			
			return nums;
		}
		return nums;
	}
	
	/**
	 * 20210111 leetcode 每日一题
	 * 题目：
	 * 	给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 * 
	 * 参数：int[] nums
	 * 返回值：int
	 */
	public static int maxSubArray(int[] nums) {
		if (nums.length == 1) {
            return nums[0];
        } else {
            int max = Math.max(maxSubArray(Arrays.copyOfRange(nums, 0, nums.length - 1)), maxSubArray(Arrays.copyOfRange(nums, 1, nums.length)));
            int sumNums = sum(nums);
//            System.out.println(max + "max:");
            return Math.max(max, sumNums);
        }
    }
	
	/**
	 * 数组求和
	 * 
	 * 参数：int[] nums
	 * 返回值：int
	 */
	public static int sum(int[] nums){
		int sum=0;
		for(int i:nums){
			sum+=i;
		}
		return sum;
	}
	
	/**
	 * 20210110 leetcode 每日一题
	 * 题目：
	 * 	给定一个正整数 n ，输出外观数列的第 n 项
	 * 
	 * 参数：int n
	 * 返回值：String
	 */
	public static String countAndSay(int n) {
		String ans = null;
		StringBuilder sb= new StringBuilder();
		HashMap<String,Integer> hm = new HashMap<String,Integer>(); //用于存放值和相应出现的数量
		String s = null;
		if(n==1){
			return String.valueOf(n);
		}else if(n>1){
			s = countAndSay(n-1);
		}
		
		//遍历s
		for(int i=0; i<s.length(); i++){
			String c = String.valueOf(s.charAt(i));
			if(hm.containsKey(c)){
				int num = hm.get(c);
				hm.put(c,num+1);
			}else{
				sb.append(c);
				if(hm.size()==1){
					sb.insert(sb.length()-2,hm.get(String.valueOf(s.charAt(i-1))));	
					hm.clear();
				}			
				hm.put(c,1);
			}
			if(i==s.length()-1){
				sb.insert(sb.length()-1,hm.get(c));	
				hm.clear();
			}
		}
		
		ans = sb.toString();
		
		return ans;
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




