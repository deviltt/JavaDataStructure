public class BST<E extends Comparable<E>> {
    class Node{
        public E e;
        public Node left, right;

        //有参构造函数
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;  //BST的根节点
    private int size;   //BST的大小

    //无参构造函数，初始化
    public BST(){
        root = null;
        size = 0;
    }

    //返回BST大小
    public int size(){
        return size;
    }

    ///返回BST是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    private void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size++; //每插入一个元素就要维护一下size
//        }
//        else
//            add(root, e);
        root = add(root, e);
    }

    //以node为根的二分搜索树中插入元素E，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        //递归终止的条件：相等；左子树为空；右子树为空
//        if(e.equals(node.e))
//            return;
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    //看二分搜索树种是否包含元素e
    public boolean contains(E e){
        return contains(root, e);   //从根节点中开始查询
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }
}
