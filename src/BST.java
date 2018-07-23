import java.util.LinkedList;
import java.util.Queue;
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
    //访问T节点，然后入栈，访问左节点，接着访问右节点
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node node = root;
//        stack.push(root);
//        while(!stack.isEmpty()){
//            Node cur = stack.pop();
//            System.out.println(cur.e);
//
//            if(cur.right != null)
//                stack.push(cur.right);
//            if(cur.left != null)
//                stack.push(cur.left);
//        }
        while(node != null || !stack.isEmpty()){
            if(node != null){
                System.out.println(node.e);
                stack.push(node);
                node = node.left;
            }
            else{
                Node node1 = stack.peek();
                stack.pop();
                node = node1.right;
            }
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

    //后序遍历非递归算法
    public void postOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node temp = null;   //初始化为null是因为第一个访问的叶子节点的右子树一定是空的

        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.peek();
                if(node.right != null && node.right != temp)    //如果右子树在且未被访问过
                    node = node.right;
                else{
                    stack.pop();
                    System.out.println(node.e);
                    temp = node;    //记录最近访问过的节点
                    node = null;    //node要重置
                }
            }
        }
    }

    //BST层序遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.e);

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }

    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;

        return minimum(node.left);
    }

    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");

        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null)
            return node;

        return maximum(node.right);
    }

    //删除二分搜索树的最小值并返回
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;        //保留最左节点的右节点
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树的最大值并返回
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    public Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if(node == null)
            return null;

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null){
                Node leftNode = node.right;
                node.left = null;
                size--;
                return leftNode;
            }

            //如果左右子树都不为空，则找到该节点右子树中的最小节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
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
