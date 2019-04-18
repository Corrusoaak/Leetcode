class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees=new int[numCourses];

        // calculate the indegree
        for(int i=0;i<prerequisites.length;i++){
        	inDegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        // Find points with zero indergees
        for(int i=0;i<numCourses;i++){
        	if(inDegrees[i]==0)queue.offer(i);
        }

        // Begin Iteration
        while(!queue.isEmpty()){
        	int cur_point=queue.poll();
        	for(int i=0;i<prerequisites.length;i++){
        		if(cur_point==prerequisites[i][1]){
        			inDegrees[prerequisites[i][0]]--;
        			if(inDegrees[prerequisites[i][0]]==0)queue.offer(prerequisites[i][0]);
        		}
        	}
        }

        // Check if all the indegrees of points is zero
        for(int i=0;i<numCourses;i++){
        	if(inDegrees[i]!=0)return false;
        }
        return true;

    }
}