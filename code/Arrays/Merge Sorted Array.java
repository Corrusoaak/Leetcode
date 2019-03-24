class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int prt1=0;
        int ptr1_begin=n,ptr1_end=n,ptr2=0;
        while(ptr1<m && ptr2<n){
        	if(nums1[ptr1]<=nums2[ptr2]){
        		if(ptr1_begin>=m){
        			ptr1_end++;
        			nums1[ptr1_end]=nums1[counter];
        			nums1[counter]=nums1[ptr1_begin];
        			ptr1_begin++;
        		}else{
        			ptr1_begin=m;
        		}
        		
        	}else{
        	    ptr1_end++;
        	    nums1[ptr1_end]=nums1[counter];
        	    nums1[counter]=nums2[ptr2];
        	    ptr2++;
        	}
        	counter++;
        }
        if(ptr1_begin>=ptr1_end){
        	for(int i=ptr2;i<n;i++){
        		nums1[counter++]=nums2[i];
        	}
        }
        if(ptr2>=n){
       		if(counter<m){
       			for(int i=ptr1_begin;i<ptr1_end;i++){
       				int tmp=nums1[counter];
       				nums1[counter++]=nums1[i];
       				nums1[i]=tmp;
       			}
       		}
        }
    }
}