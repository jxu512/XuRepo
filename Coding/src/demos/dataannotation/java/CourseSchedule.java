/*
https://leetcode.com/problems/course-schedule/description/
*/
package demos.dataannotation.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    // This function uses HashMap, which is not as effifient as ArrayList used by function canFinishB
    public boolean canFinishA(int numCourses, int[][] prerequisites) {

        // Create an adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Initialize visited and recursion stacks
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        // Perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(graph, i, visited, recursionStack)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(Map<Integer, List<Integer>> graph, int node, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true; // Cycle detected
        }
        if (visited[node]) {
            return false; // Already visited and not part of a cycle
        }

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (isCyclic(graph, neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[node] = false; // Remove from recursion stack
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {2, 3},
                {3, 4}
                //,{4, 0}
        };
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean canFinish = courseSchedule.canFinishA(numCourses, prerequisites);
        System.out.println("Number of courses: " + numCourses);
        courseSchedule.printPrereq(prerequisites);
        System.out.println("Can finish: " + canFinish);
    }
    private void printPrereq(int[][] prerequisites) {
        System.out.print("Prerequisites:");
        for (int i=0;i<prerequisites.length;i++) {
            System.out.print(prerequisites[i][0] + "->" + prerequisites[i][1] + ", ");
        }
        System.out.println();
    }

    public boolean canFinishB(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph
        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[numCourses];
        // Array to detect cycles
        boolean[] recursionStack = new boolean[numCourses];

        // Check for cycles starting from each course
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, recursionStack)) {
                return false;
            }
        }

        return true;
    }
    private boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recursionStack) {
        // If the course is already in the recursion stack, we've found a cycle
        if (recursionStack[course]) {
            return true;
        }

        // If we've already visited this course and found no cycle, return false
        if (visited[course]) {
            return false;
        }

        // Mark the current course as visited and add to recursion stack
        visited[course] = true;
        recursionStack[course] = true;

        // Check all prerequisites of the current course
        for (int prereq : graph.get(course)) {
            if (hasCycle(prereq, graph, visited, recursionStack)) {
                return true;
            }
        }

        // Remove the course from recursion stack
        recursionStack[course] = false;

        return false;
    }

}
