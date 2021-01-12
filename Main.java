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
	 * 20210113 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
     *	����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0
	 * 
	 * ������int[] digits
	 * ����ֵ��int[]
	 */
	public static String addBinary(String a, String b) {

    }
	
	/**
	 * 20210112 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	����һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
     *	���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
	 *	����Լ���������� 0 ֮�⣬��������������㿪ͷ��
	 * 
	 * ������int[] digits
	 * ����ֵ��int[]
	 */
	public static int[] plusOne(int[] digits){
		int q=0;//q����
		int len = digits.length;
		digits[len-1]+=1;
		q=digits[len-1]/10;
		if(q>0){
			int r=digits[len-1]%10;
			if(len==1){
				digits = new int[2];
				digits[1]=r;
				digits[0]=q;				
			}else{
				int[] ans=plusOne(Arrays.copyOfRange(digits,0,len-1));
				digits = new int[ans.length+1];
				for(int i=0;i<ans.length;i++){
					digits[i]=ans[i];
				}
				digits[ans.length]=r;
			}			
			return digits;
		}
		return digits;
	}
	
	/**
	 * 20210111 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
	 * 
	 * ������int[] nums
	 * ����ֵ��int
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
	 * �������
	 * 
	 * ������int[] nums
	 * ����ֵ��int
	 */
	public static int sum(int[] nums){
		int sum=0;
		for(int i:nums){
			sum+=i;
		}
		return sum;
	}
	
	/**
	 * 20210110 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	����һ�������� n �����������еĵ� n ��
	 * 
	 * ������int n
	 * ����ֵ��String
	 */
	public static String countAndSay(int n) {
		String ans = null;
		StringBuilder sb= new StringBuilder();
		HashMap<String,Integer> hm = new HashMap<String,Integer>(); //���ڴ��ֵ����Ӧ���ֵ�����
		String s = null;
		if(n==1){
			return String.valueOf(n);
		}else if(n>1){
			s = countAndSay(n-1);
		}
		
		//����s
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
	 * 20210109 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
	 *	���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
	 *	����Լ������������ظ�Ԫ�ء�
	 */
	public int searchInsert(int[] nums, int target) {
		int ans = 0;
		//�������飬Ѱ����ͬ��λ��
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
		}return nums.length;//���������û���ҵ���Ӧ����ĩβ
    }
	
	/**
	 * 20210109 ֮ǰ�� leetcode ÿ��һ��
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
		int ans = nums.length; //ans������ָ��ʹ��
		if(nums.length<1){
			return nums.length;
		}else{
			for(int i=0;i<ans;i++){
				if(nums[i]!=val){
					continue;
				}else{
					int tmp = nums[i];//���ظ�ֵ�������
					for(int j=i;j<ans-1;j++){
						nums[j]=nums[j+1];//���ظ�ֵ�����ֵ��ǰ�ƶ�һλ
					}
					nums[ans-1]=tmp;//���ظ�ֵ�ŵ�ĩβ
					ans--;//�Ѳ����ظ�ֵ�Ĵ�����ǰ�ƶ�һλ
					i--;
				}
			}
		}
		return ans;

	}
}




