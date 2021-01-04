import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Node newN = new Node();
        Queue<Node> queue = new LinkedList<>();
        List<Node> subList = new LinkedList<>();
        Node root = node;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node head = queue.element();
            List<Node> li = head.neighbors;
            for(int i = 0;i<li.size();i++){
                queue.add(li.get(i));
             }
            subList.add(queue.poll());
        }
        for(int i = 0;i<subList.size();i++){
            Node n = subList.get(i);
            Node now = new Node();
            now.val = n.val;
            List<Node> li = n.neighbors;
            for(int j = 0;j<li.size();j++){
                Node nei = new Node();
                nei.val = 
            }
            
        }
        

    }
}

