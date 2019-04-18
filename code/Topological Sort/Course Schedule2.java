class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees=new int[numCourses];

        // calculate the indegree
        for(int i=0;i<prerequisites.length;i++){
        	inDegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        int[] order=new int[numCourses];

        // Find points with zero indergees
        for(int i=0;i<numCourses;i++){
        	if(inDegrees[i]==0)queue.offer(i);
        }

        // Begin Iteration
        int counter=0;
        while(!queue.isEmpty()){
        	int cur_point=queue.poll();
        	order[counter++]=cur_point;
        	for(int i=0;i<prerequisites.length;i++){
        		if(cur_point==prerequisites[i][1]){
        			inDegrees[prerequisites[i][0]]--;
        			if(inDegrees[prerequisites[i][0]]==0)queue.offer(prerequisites[i][0]);
        		}
        	}
        }

        // Check if all the indegrees of points is zero
        for(int i=0;i<numCourses;i++){
        	if(inDegrees[i]!=0)return new int[0];
        }
        return order;        
    }
}