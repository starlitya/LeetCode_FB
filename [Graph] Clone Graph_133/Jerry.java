/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    //DFS, O(N) , O(N), non-recursive
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Stack<UndirectedGraphNode> stack = new Stack<>();

        stack.push(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (!stack.isEmpty()) {
            UndirectedGraphNode search = stack.pop();
            for (UndirectedGraphNode n: search.neighbors) {
                if (!map.containsKey(n)) {
                    stack.push(n);
                    map.put(n, new UndirectedGraphNode(n.label));
                }

                map.get(search).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
    
    //DFS, O(N) , O(N)
    public UndirectedGraphNode cloneGraph_old1(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return implClone(node, map);
    }

    private UndirectedGraphNode implClone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> record) {
        if (record.containsKey(node)) {
            return record.get(node);
        }
        
        record.put(node, new UndirectedGraphNode(node.label));

        for (UndirectedGraphNode n: node.neighbors) {
            record.get(node).neighbors.add(implClone(n, record));
        }
    
        return record.get(node);
    }
    
    // BFS: O(N), O(N)
    public UndirectedGraphNode cloneGraph_old(UndirectedGraphNode node) {
        if(node == null) return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); //store visited

        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode search = queue.poll();
            for (UndirectedGraphNode n: search.neighbors) {
                if (!map.containsKey(n)) {
                    queue.offer(n);
                    map.put(n, new UndirectedGraphNode(n.label));
                }

                map.get(search).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}