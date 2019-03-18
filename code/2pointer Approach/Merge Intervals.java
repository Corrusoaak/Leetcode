class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        int[] start_points=new int[intervals.size()];
        int[] end_points=new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
        	start_points[i]=intervals.get(i).start;
        	end_points[i]=intervals.get(i).end;
        }
        Arrays.sort(start_points);
        Arrays.sort(end_points);
        int i=0,j=0;
        int num_start=0;
        int sp=0;
        while(i<intervals.size() || j<intervals.size()){
        	if(num_start==0){
        		sp=start_points[i];
        	}
        	if(i<intervals.size() && start_points[i]<=end_points[j]){
        		num_start++;
        		i++;
        	}else{
        		num_start--;
        		j++;
        	}
        	if(num_start==0){
        		res.add(new Interval(sp,end_points[j-1]));
        	}
        }
        return res;
    }
}