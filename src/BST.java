import java.util.Stack;

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

    public void add(E e){
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

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历的非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);

        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //中序遍历的非递归实现
    //将T入栈，然后访问T的左子树，访问完T的左子树后将T出栈访问T，然后访问T的右子树
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                Node node1 = stack.peek();
                System.out.println(node1.e);
                stack.pop();            //访问完中间节点后就出栈，但在出栈之前还要保留，因为还要访问右节点
                node = node1.right;
            }
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}
