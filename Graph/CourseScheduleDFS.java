package Graph;
import java.util.*;

public class CourseScheduleDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // Directed edge: prerequisite -> course
        }

        // Step 2: Visited arrays (boolean representation)
        boolean[] visiting = new boolean[numCourses];  // Track nodes currently in recursion stack
        boolean[] visited = new boolean[numCourses];   // Track nodes that are fully processed

        // Step 3: Check for cycles in each unvisited node
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course] && hasCycle(course, graph, visiting, visited)) {
                return false; // Cycle detected
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visiting, boolean[] visited) {
        if (visiting[course]) return true;  // Cycle detected
        if (visited[course]) return false;  // Already processed

        visiting[course] = true;  // Mark as currently being visited
        for (int neighbor : graph.get(course)) {
            System.out.println("Processing edge: " + course + " -> " + neighbor);
            if (hasCycle(neighbor, graph, visiting, visited)) {
                return true;
            }
        }

        visiting[course] = false;  // Backtrack (remove from recursion stack)
        visited[course] = true;    // Mark as fully processed
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleDFS cs = new CourseScheduleDFS();

        // Define the number of courses and prerequisites based on your given graph structure
        int numCourses = 7;
        int[][] prerequisites = {{2, 0}, {0, 1}, {3, 2}, {4, 3},{5,4},{6,4}, {0, 3}};

        System.out.println(cs.canFinish(numCourses, prerequisites)); // Output: false (cycle exists)
    }
}
