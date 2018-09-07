import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        BTree t = new BTree();
        t.add(new Node(10));
        t.add(new Node(11));
        t.add(new Node(12));
        t.add(new Node(13));
        t.add(new Node(14));




        t.addRecursiveWrapper(new Node(19));
        t.addRecursiveWrapper(new Node(20));
        t.addRecursiveWrapper(new Node(21));
        t.addRecursiveWrapper(new Node(23));
        t.addRecursiveWrapper(new Node(9));
        System.out.println("Высота дерева: " + t.maxDepthRecursion(t.root));

        boolean  b =t.findRecursive(t.root,25);
        System.out.println("Есть ли элемент(рекурсией): 25 " +  b + " Сделанно шагов: " + t.stepCounter);
        b= t.findForLoop(25);
        System.out.println("Есть ли элемент(Циклом): 25 " +  b + " Сделанно шагов: " + t.stepCounter);



        ArrayList<Integer> ar = t.traverseFromZeroToMaxForLoopInOrder();

        System.out.println("");
        System.out.println("In order from zero to max FOR LOOP");
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());

        System.out.println("");
        System.out.println("In roder to max to zero FOR LOOP");
        ar = t.traverseFromMaxToZeroForLoopInOrder();
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());


        t.stepCounter=0;
        System.out.println("");
        System.out.println("In roder ZeroToMax  recursion ");
        t.results=new ArrayList<Integer>();
        t.traverseFromZeroToMaxRecurrsionInOrder(t.root);
        ar = t.results;
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());



        t.stepCounter=0;
        System.out.println("");
        System.out.println("Inorder MaxToZero recursion");
        t.results=new ArrayList<Integer>();
        t.traverseFromMaxToZeroRecurrsionInOrder(t.root);

        ar = t.results;
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());



        t.stepCounter=0;
        System.out.println("");
        System.out.println("traversePreOrderRecursion");
        t.results=new ArrayList<Integer>();
        t.traversePreOrderRecursion(t.root);
        ar = t.results;
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());


        t.stepCounter=0;
        t.results=new ArrayList<Integer>();
        System.out.println("");
        System.out.println("traversePostOrder");
        t.traversePostOrder(t.root);
        ar = t.results;
        System.out.println("Всего нод в дереве: " + t.nodeCount);
        System.out.println("Элементы в дереве: ");
        ar.forEach((i)->System.out.print(i + " "));
        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());





    }


}
