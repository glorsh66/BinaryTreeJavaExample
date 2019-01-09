import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class BTree {
    public Node root;
    public int stepCounter =0;
    public int nodeCount=0;
    public ArrayList<Integer> results = new ArrayList<Integer>();

    public BTree() {
        this.root = null;
    }

    public void add(Node n)
    {
        if (this.root==null) {this.root=n; this.nodeCount++; return;}

        boolean flag=true;
        Node cur = this.root;
        do {
            //if there already exist this element
            if (cur.i==n.i) {flag=false;break;}

            //If n is less than root
            if (n.i< cur.i) {
                if (cur.left==null) {cur.left=n; this.nodeCount++; flag=false;break;}
                else {cur=cur.left;flag=true; continue;}
            }
            //If n is less than root
            if (n.i> cur.i) {
                if (cur.right==null) {cur.right=n; this.nodeCount++; flag=false;break;}
                else {cur=cur.right;flag=true; continue;}
            }

        }while (flag);
    }




    public boolean findForLoop(int i)
    {
        this.stepCounter =0;
        Node cur = this.root;
        boolean flag = true;

        do {
            this.stepCounter++;
            if (cur==null) return false;
            if (cur.i==i) return true;


            if (i<cur.i) cur=cur.left;
            else  cur=cur.right;

        }while (flag);
        return false;
    }


    public boolean findRecursive(Node cur, int i)
    {
        if (cur==null) return false;

        if (cur.i==i) return true;

        boolean b;
        if (i<cur.i) {
            b=findRecursive(cur.left,i);
            return b;
        }
        else  {
            b=findRecursive(cur.right,i);
            return b;
        }


    }




    public void addRecursiveWrapper(Node value)    {
        this.root=addRecursive(this.root,value, this);
    }



    //Don't increment coutn of elements in the BTree
    private Node addRecursive(Node cur, Node value, BTree t)
    {
        if (cur== null) {
            this.nodeCount++;
            return value;
        }

        if (value.i < cur.i) {
            cur.left = addRecursive(cur.left,value,t);
        } else if (value.i > cur.i)
        {
            cur.right= addRecursive(cur.right,value,t);
        }
        return cur;
    }



    public int maxDepthRecursion(Node n)
    {
        if (n==null) return 0;

        int maxleft = maxDepthRecursion(n.left);
        int maxright = maxDepthRecursion(n.right);

        int biggest = Math.max(maxleft,maxright);
        return biggest+1;
    }


    public ArrayList<Integer> traverseFromZeroToMaxForLoopInOrder()
    {
        this.stepCounter=0;
        Node cur = this.root;
        if (cur==null) return null;

        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        //s.push(cur);

        do {


         if (cur!=null)
         {
             s.push(cur);
             cur=cur.left;
         }else {
           Node el = s.pop();
           this.stepCounter++;
           ret.add(el.i);
           cur = el.right;
         }
        }while ((cur!=null) || (!(s.size()==0)));
        return ret;

    }

    public void traverseFromZeroToMaxRecurrsionInOrder(Node n) {
        if (n != null) {
            traverseFromZeroToMaxRecurrsionInOrder(n.left);
            this.results.add(n.i);
            this.stepCounter++;
            traverseFromZeroToMaxRecurrsionInOrder(n.right);
        }
    }


    public void traverseFromMaxToZeroRecurrsionInOrder(Node n) {
        if (n != null) {
            traverseFromMaxToZeroRecurrsionInOrder(n.right);
            this.results.add(n.i);
            this.stepCounter++;
            traverseFromMaxToZeroRecurrsionInOrder(n.left);


        }
    }


    public ArrayList<Integer> traverseFromMaxToZeroForLoopInOrder()
    {
        this.stepCounter=0;
        Node cur = this.root;
        if (cur==null) return null;

        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();
        //s.push(cur);

        do {
            if (cur!=null)
            {
                s.push(cur);
                cur=cur.right;
            }else {
                Node el = s.pop();
                this.stepCounter++;
                ret.add(el.i);
                cur = el.left;
            }
        }while ((cur!=null) || (!(s.size()==0)));
        return ret;

    }

//Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree:
    public void traversePreOrderRecursion(Node n) {
        if (n != null) {
            this.results.add(n.i);
            this.stepCounter++;
            traversePreOrderRecursion(n.left);
            traversePreOrderRecursion(n.right);
        }
    }
//Post-order traversal visits the left subtree, the right subtree, and the root node at the end:
    public void traversePostOrder(Node n) {
        if (n != null) {
            traversePostOrder(n.left);
            traversePostOrder(n.right);
            this.results.add(n.i);
            this.stepCounter++;
        }
    }



    public void printTreePostOrder(Node n, int indentation ) {
        if (n!=null)
        {
                StringBuilder str = new StringBuilder(indentation+1);
                Stream.generate(() -> ' ').limit(indentation+1).forEach(str::append);
                System.out.print(str.toString());
                System.out.println(n.i);

            if (n.left!=null) printTreePostOrder(n.left,indentation+4);
            if (n.right!=null) printTreePostOrder(n.right,indentation-4);
        }
    }

    public void myPrint(Node n, int level, int pos, String[][] num)
    {
        if (n!=null) {
            System.out.println(n.i + " level: " + level + " pos: " + pos + " max elems " + Math.pow(2, level));

            //Пишем в массив.
            num[level][pos] = Integer.toString(n.i);

            //Делаем стрелочки

            if (n.left != null) num[level+1][pos-1] = "/";
            if (n.right != null) num[level+1][pos+1] = "\\";



            if (n.left != null) myPrint(n.left, level+2, pos-(1*level+1), num);
            if (n.right != null) myPrint(n.right, level+2, pos+(1*level+1), num);
        }
    }



}
