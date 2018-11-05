package luogu.LinkedStructure;

import java.util.Scanner;

class myList{
    int val;
    myList next;
    /**
     * 申明为private，只有本类的方法才能调用构造函数
     * friendly，本类，本包
     * protected，本类，本包，子类都可以调用
     * public，本类，本包，子类，外包都可以调用
     */
     myList(int val){
        this.val = val;
        this.next = null;
    }
}

public class P1996 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        myList head = new myList(1);
        myList p = head;
        for(int i = 1; i < n; i++){
            myList temp = new myList(i + 1);
            p.next = temp;
            p = temp;
        }
        p.next = head;  //完成了循环链表的创建

        int count = 1;
        while(n != 0){
            if(count == m){
                System.out.print(head.val + " ");
                p.next = head.next;
                head = p.next;  //删除节点
                count = 1;
                n--;
            }
            p = head;
            head = head.next;
            count++;
        }
    }
}
