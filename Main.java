public class Main{
	public static void main(String[] args){
		// int[] nums = new int[]{1};
		// System.out.println(nums.length+","+removeDuplicates(nums,6));//1,3,4,5,6,7
		// for(int i=0;i<removeDuplicates(nums,6);i++){
			// System.out.println(nums[i]);
		// }
		String h="";
		String n="fessgd";
		int index = strStr(h,n);
		//System.out.println(h.substring(index,h.length()));
		
		System.out.println(index);
	}
	
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




