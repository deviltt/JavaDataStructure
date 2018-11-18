/**
 * 功能：对类进行排序，先按照年龄排序，年龄相同则按照分数排序
 */
package comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person1 implements Comparable<Person1>{
    private int age;
    private int score;

    public Person1(int age, int score){
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Person1 o) {
//        if(this.age > o.age)
//            return 1;
//        else if(this.age < o.age)
//            return -1;
//        else {
//            if(this.score > o.score)
//                return 1;
//            else if(this.score < o.score)
//                return -1;
//            else
//                return 0;
//        }
        if(Integer.compare(this.age, o.age) > 0)
            return 1;
        else if(Integer.compare(this.age, o.age) < 0)
            return -1;
        else {
            if(Integer.compare(this.score, o.score) > 0)
                return 1;
            else if(Integer.compare(this.score, o.score) < 0)
                return -1;
            else
                return 0;
        }
    }

    @Override
    public String toString() {
        return "age: " + age + " score: " + score;
    }

    public static void main(String[] args){
        Person1[] p = new Person1[]{new Person1(22, 39),
                new Person1(25, 54),
                new Person1(22, 32),
                new Person1(14, 34),
                new Person1(25, 32)
        };
        List<Person1> list = new ArrayList<>();

        for(int i = 0; i < p.length; i++)
            list.add(p[i]);

        Arrays.sort(p);
        Collections.sort(list);

        for(Person1 pp : p)
            System.out.println(pp.toString());
        System.out.println(list);
    }
}
