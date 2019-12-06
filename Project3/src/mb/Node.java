/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;


/**
 *
 * @author user
 */
public class Node implements Comparable<Node> {
    int left;
    int right;
    int up;
    int down;
    int d;
    int mark;
    Node pred;
    int x,y;
    public Node()
    {
        left =0;
        right=0;
        up=0;
        down =0;
        mark =0;//undiscover
        pred=null;
        d = Integer.MAX_VALUE;
       
    }

    public int compareTo(Node o) {
        return this.d - o.d;
    }


 

}
