import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		//int[] nums = new int[]{0,1};
		
		// for(int i=0;i<removeDuplicates(nums,6);i++){
			// System.out.println(nums[i]);
		// }
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		String s = sc.nextLine();
		String a = new String("10010");
		String b = new String("11111");
		
		System.out.println(mySqrt(Integer.parseInt(s)));
	}
	
	/* 	
		20210120 leetcode 每日一题
		题目：
			给定一个二叉树，检查它是否是镜像对称的
	*/
	public static boolean isSymmetric(TreeNode root) {

    }
	
	/* 	
		20210119 leetcode 每日一题
		题目：
			给定两个二叉树，编写一个函数来检验它们是否相同。
			如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
		
		Definition for a binary tree node.
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode() {}
			TreeNode(int val) { this.val = val; }
			TreeNode(int val, TreeNode left, TreeNode right) {
				this.val = val;
				this.left = left;
				this.right = right;
			}
		}
	*/
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		boolean l=false;//记录左孩子是否相等
        boolean r=false;//记录右孩子是否相等
        if(p==null || q==null){
            return p==null && q==null;
        }
		//如果左子树不为空，递归判断左子树；如果左子树都为空，则判断为相等
        if(p.left!=null && q.left!=null){
            l= isSameTree(p.left,q.left);
        }else if(p.left==null && q.left==null){
            l=true;
        }
		//如果右子树不为空，递归判断右子树；如果右子树都为空，则判断为相等
		if(p.right!=null && q.right!=null){
            r = isSameTree(p.right,q.right);
        }else if(p.right==null && q.right==null){
            r=true;
        }
		//返回判断结果
        return p.val==q.val && l && r;
    }
		
	/**
	 * 20210118 leetcode 每日一题
	 * 题目：
	 * 	给你两个有序整数数组?nums1 和 nums2，请你将 nums2 合并到?nums1?中，使 nums1 成为一个有序数组。
	 *  初始化?nums1 和 nums2 的元素数量分别为?m 和 n 。你可以假设?nums1?有足够的空间（空间大小等于?m + n）来保存 nums2 中的元素。
	 *
	 * 参数：int[] nums1, int m, int[] nums2, int n
	 * 返回值：null
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        int index=0;
        for(int i=0,j=0;i<m || j<n;i++){
            if(i>=m || j>=n){
                if(i>m-1){
                    hs.put(index,nums2[j]);
                    j++;
                }else if(j>n-1){
                    hs.put(index,nums1[i]);                   
                }
            }else{
                if(nums1[i]<=nums2[j]){
                    hs.put(index,nums1[i]);
                }else{
                    hs.put(index,nums2[j]);
                    j++;
                    i--;                                 
                }
            }
            index++;           
        }
        for(int i=0;i<m+n;i++){
            nums1[i]=hs.get(i);
        }
    }
	
	/**
	 * 20210117 leetcode 每日一题
	 * 题目：
	 * 	给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 * 
	 * 参数：ListNode head
	 * 返回值：ListNode
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode before = head;
		ListNode l = head.next;
		do{	
			int a = before.val;
			int b = l.val;
			if(a==b){
				if(l.next==null){
                    before.next=null;
					return head;
				}else{
					before.next=l.next;
					l=l.next;
				}
			}else{
				before=l;
				l=l.next;
			}
		}while(l!=null);
		
		return head;
    }
	//注意清楚野指针
	/* class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode cur = head;
			while(cur != null && cur.next != null){
				if(cur.val == cur.next.val){
					ListNode node = cur.next; 
					cur.next = node.next;
					node.next = null;//清除野指针
				}else{
					cur = cur.next;          
				}
				
			}
			return head;
		}
	} */
	
	/**
	 * 20210114 leetcode 每日一题
	 * 题目：
	 * 	实现int sqrt(int x)?函数。
	 *	计算并返回x的平方根，其中x是非负整数。
	 *	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	 * 
	 * 参数：int x
	 * 返回值：int
	 */
	public static int mySqrt(int x) {
		long i = x/2; //注意此处如果定义为int则会出现i*i超出int范围造成运算错误
		while(i*i>x){
			i=i/2;
			System.out.println(i);
		}
		while(i*i<x){
			i+=1;
			System.out.println(i);
		}
        int ans=(int)i;
		return ans*ans==x?ans:ans-1;
	
    }
	
	/**
	 * 20210113 leetcode 每日一题
	 * 题目：
	 * 	给你两个二进制字符串，返回它们的和（用二进制表示）。
     *	输入为 非空 字符串且只包含数字 1 和 0
	 * 
	 * 参数：String a, String b
	 * 返回值：String
	 */
	public static String addBinary(String a, String b) {
		String ans = "";
		int len = Math.max(a.length(),b.length());
		int i=1;
		int q = 0;
		int r =0;
		int sum = 0;
		String s = a.length()>b.length()?a:b;
		while(i<=len){
			if(i<=Math.min(a.length(),b.length())){
				sum = (a.charAt(a.length()-i)) + (b.charAt(b.length()-i)) + q - 48*2;
				q = sum/2;
				ans = sum%2 + ans;
			}else{
				sum = Integer.valueOf(s.charAt(len-i)) + q - 48;
				q = sum/2;
				ans = sum%2 + ans;
			}if(i==len){
                if(q>0){
                    ans = q + ans;
                }
				
			}i++;		
		}
		return ans;
		
    }
	
	/**
	 * 20210112 leetcode 每日一题
	 * 题目：
	 * 	给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	 *	你可以假设除了整数 0 之外，这个整数不会以零开头。
	 * 
	 * 参数：int[] digits
	 * 返回值：int[]
	 */
	public static int[] plusOne(int[] digits){
		int q=0;//q是商
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
	
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
	  int val;
	  ListNode next;
	  ListNode() {}
	  ListNode(int val) { this.val = val; }
	  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}




