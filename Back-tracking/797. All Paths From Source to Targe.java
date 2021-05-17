// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

// The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
// 0 -> 1
// |    |
// v    v
// 2 -> 3
//given graph = [[1,2],[3],[3],[]]
//result = [[0,1,3],[0,2,3]]

//Solution of this problem is
//Using BFS along with backtracking to make sure every node can be accessed 
//to find the solution
//Recursion implemented
public class Solution{
    public static List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int [][] graph){
        result = new ArrayList<List<Integer>>();
        ArrayList<Integer>temp = new ArrayList<Integer>();
        temp.add(0);
        helper(0,graph.length-1,graph,temp);
        return result;
    }
    private void helper(int start, int end, int[][]graph, ArrayList<Integer>temp){
        if (start==end){
            result.add(temp);
            return;
        }
        for (int i;i<graph[start].length-1;i++){
            temp.add(graph[start][i]);
            helper(graph[start][i],end,graph,temp);
            temp.remove(temp.size()-1);
        }
    }

}

