class Solution {
    
    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for (int[] edge : prerequisites) {
            int start = edge[0];
            int end = edge[1];
            // check for duplicate edge
            if (graph[start][end] == 0) {
                graph[start][end] = 1;
            }
        }
    
        int refers [] = new int[numCourses];
        for (int [] edge : prerequisites) {
            refers[edge[1]]++;
        }
        
        Queue<Integer> canFinishCourse = new LinkedList<>();
        for (int index=0; index <numCourses; index++) {
            if (refers[index] == 0) {
                canFinishCourse.offer(index);
                refers[index] = -1;
            }
        }
        
        // check all vertex
        int [] finishList = new int[numCourses];
        int count = numCourses;
        while(!canFinishCourse.isEmpty()) {
            int start = canFinishCourse.poll();
            for (int next=0; next<numCourses; next++) {
                if (graph[start][next] == 1) {
                    refers[next]--;
                    if(refers[next] == 0) {
                        canFinishCourse.offer(next);
                        refers[next] = -1;
                    }
                }
            }
            
            finishList[--count] = start;
        }
        
        return count == 0 ? finishList: new int[0];
    }
}