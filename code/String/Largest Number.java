class Solution{
	public class newStringComparator implements Comparator<String>{
		@Override
		public int compare(String a, String b){
			return -(a+b).compareTo(b+a);
		}
	}

	public String largestNumber(int[] nums){
		String[] nums_str=new String[nums.length];
		
		/* Put the integer arrays into String array*/
		for(int i=0;i<nums.length;i++){
			nums_str[i]=String.valueOf(nums[i]);
		}
		/* Sort the array */
		Arrays.sort(nums_str,new newStringComparator());
		/* Test if all elements are zero */
		if(nums_str[0].equals("0"))return "0";

		String res="";
		for(int i=0;i<nums_str.length;i++){
			res+=nums_str[i];
		}
		return res;
	}
}