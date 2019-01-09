import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        BTree t = new BTree();
        t.add(new Node(8));
        t.add(new Node(4));
        t.add(new Node(12));
        t.add(new Node(13));


//        t.add(new Node(2));
//        t.add(new Node(6));
//        t.add(new Node(10));
//        t.add(new Node(14));
//        t.add(new Node(1));
//        t.add(new Node(3));
//        t.add(new Node(5));
//        t.add(new Node(7));
//        t.add(new Node(9));
//        t.add(new Node(11));
//        t.add(new Node(13));
//        t.add(new Node(15));






//
//        t.add(new Node(16));
//        t.add(new Node(8));
//        t.add(new Node(6));
//
//        t.add(new Node(11));
//        t.add(new Node(12));
//        t.add(new Node(13));





        //Парметры дерева
        int tree_height = t.maxDepthRecursion(t.root);
        int max_elemtns = (int)Math.pow(2, tree_height);


        System.out.println();
        System.out.println("Параметры дерева");
        System.out.println("Максимальная глубина " + tree_height);
        System.out.println("Максимальная ширина " + max_elemtns);
        System.out.println();


        //Делаем массив
        String[][] num = new String[tree_height*2+50][max_elemtns*2];

        //Заполняем массив пробелами
        for (int i =0; i<num.length;i++)
        {
            for (int y=0; y<num[0].length;y++)
            {
                num[i][y] = " ";
            }
        }


        t.myPrint(t.root,0,(int)(max_elemtns*2)/2+1,num);


        System.out.println("Печатаем массив");

        //Печатаем итоговый массив
        for (int i =0; i<num.length;i++)
        {
            for (int y=0; y<num[0].length;y++)
            {
                System.out.print(num[i][y]);
            }
            System.out.println();
        }






//        t.add(new Node(12));
//        t.add(new Node(13));
//        t.add(new Node(14));
//
//
//
//
//        t.addRecursiveWrapper(new Node(19));
//        t.addRecursiveWrapper(new Node(20));
//        t.addRecursiveWrapper(new Node(21));
//        t.addRecursiveWrapper(new Node(23));





//        System.out.println("Высота дерева: " + t.maxDepthRecursion(t.root));
//
//        boolean  b =t.findRecursive(t.root,25);
//        System.out.println("Есть ли элемент(рекурсией): 25 " +  b + " Сделанно шагов: " + t.stepCounter);
//        b= t.findForLoop(25);
//        System.out.println("Есть ли элемент(Циклом): 25 " +  b + " Сделанно шагов: " + t.stepCounter);
//
//
//
//        ArrayList<Integer> ar = t.traverseFromZeroToMaxForLoopInOrder();
//
//        System.out.println("");
//        System.out.println("In order from zero to max FOR LOOP");
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());
//
//        System.out.println("");
//        System.out.println("In roder to max to zero FOR LOOP");
//        ar = t.traverseFromMaxToZeroForLoopInOrder();
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());
//
//
//        t.stepCounter=0;
//        System.out.println("");
//        System.out.println("In roder ZeroToMax  recursion ");
//        t.results=new ArrayList<Integer>();
//        t.traverseFromZeroToMaxRecurrsionInOrder(t.root);
//        ar = t.results;
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());
//
//
//
//        t.stepCounter=0;
//        System.out.println("");
//        System.out.println("Inorder MaxToZero recursion");
//        t.results=new ArrayList<Integer>();
//        t.traverseFromMaxToZeroRecurrsionInOrder(t.root);
//
//        ar = t.results;
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());
//
//
//
//        t.stepCounter=0;
//        System.out.println("");
//        System.out.println("traversePreOrderRecursion");
//        t.results=new ArrayList<Integer>();
//        t.traversePreOrderRecursion(t.root);
//        ar = t.results;
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());
//
//
//        t.stepCounter=0;
//        t.results=new ArrayList<Integer>();
//        System.out.println("");
//        System.out.println("traversePostOrder");
//        t.traversePostOrder(t.root);
//        ar = t.results;
//        System.out.println("Всего нод в дереве: " + t.nodeCount);
//        System.out.println("Элементы в дереве: ");
//        ar.forEach((i)->System.out.print(i + " "));
//        System.out.println("Сделано шагов, что бы обойти дерево: " + t.stepCounter + " Размер итогового массива: "  + ar.size());












    }


}
