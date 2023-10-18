/*
-----------------------Problem Statement-----------------------
You are given an integer n, which indicates that there are n courses labeled from 1 to n. 
You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has 
to be completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.

Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).

-----------------------COde-----------------------
*/

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(next).add(prev);
        }

        int[] memo = new int[n];
        int overallMinTime = 0;

        for (int i = 0; i < n; i++) {
            overallMinTime = Math.max(overallMinTime, calculateTime(i, graph, time, memo));
        }

        return overallMinTime;
    }

    private int calculateTime(int course, List<List<Integer> > graph, int[] time, int[] memo) {
        if (memo[course] != 0) {
            return memo[course];
        }

        int maxPrerequisiteTime = 0;
        for (int prereq : graph.get(course)) {
            maxPrerequisiteTime = Math.max(maxPrerequisiteTime, calculateTime(prereq, graph, time, memo));
        }

        memo[course] = maxPrerequisiteTime + time[course];
        return memo[course];
    }
}
