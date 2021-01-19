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
		System.out.println("�����룺");
		String s = sc.nextLine();
		String a = new String("10010");
		String b = new String("11111");
		
		System.out.println(mySqrt(Integer.parseInt(s)));
	}
	
	/* 	
		20210120 leetcode ÿ��һ��
		��Ŀ��
			����һ����������������Ƿ��Ǿ���ԳƵ�
	*/
	public static boolean isSymmetric(TreeNode root) {

    }
	
	/* 	
		20210119 leetcode ÿ��һ��
		��Ŀ��
			������������������дһ�����������������Ƿ���ͬ��
			����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
		
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
		boolean l=false;//��¼�����Ƿ����
        boolean r=false;//��¼�Һ����Ƿ����
        if(p==null || q==null){
            return p==null && q==null;
        }
		//�����������Ϊ�գ��ݹ��ж��������������������Ϊ�գ����ж�Ϊ���
        if(p.left!=null && q.left!=null){
            l= isSameTree(p.left,q.left);
        }else if(p.left==null && q.left==null){
            l=true;
        }
		//�����������Ϊ�գ��ݹ��ж��������������������Ϊ�գ����ж�Ϊ���
		if(p.right!=null && q.right!=null){
            r = isSameTree(p.right,q.right);
        }else if(p.right==null && q.right==null){
            r=true;
        }
		//�����жϽ��
        return p.val==q.val && l && r;
    }
		
	/**
	 * 20210118 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	��������������������?nums1 �� nums2�����㽫 nums2 �ϲ���?nums1?�У�ʹ nums1 ��Ϊһ���������顣
	 *  ��ʼ��?nums1 �� nums2 ��Ԫ�������ֱ�Ϊ?m �� n ������Լ���?nums1?���㹻�Ŀռ䣨�ռ��С����?m + n�������� nums2 �е�Ԫ�ء�
	 *
	 * ������int[] nums1, int m, int[] nums2, int n
	 * ����ֵ��null
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
	 * 20210117 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
	 * 
	 * ������ListNode head
	 * ����ֵ��ListNode
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
	//ע�����Ұָ��
	/* class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode cur = head;
			while(cur != null && cur.next != null){
				if(cur.val == cur.next.val){
					ListNode node = cur.next; 
					cur.next = node.next;
					node.next = null;//���Ұָ��
				}else{
					cur = cur.next;          
				}
				
			}
			return head;
		}
	} */
	
	/**
	 * 20210114 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	ʵ��int sqrt(int x)?������
	 *	���㲢����x��ƽ����������x�ǷǸ�������
	 *	���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
	 * 
	 * ������int x
	 * ����ֵ��int
	 */
	public static int mySqrt(int x) {
		long i = x/2; //ע��˴��������Ϊint������i*i����int��Χ����������
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
	 * 20210113 leetcode ÿ��һ��
	 * ��Ŀ��
	 * 	���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
     *	����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0
	 * 
	 * ������String a, String b
	 * ����ֵ��String
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




