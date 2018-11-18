package comparable;

import java.util.Arrays;

public class Person implements Comparable<Person>{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }

    public static void main(String[] args){
        Person[] people = new Person[]{
                new Person("tt", 100),
                new Person("hy", 99)
        };
        System.out.println("排序前：");
        for(Person p : people)
            System.out.println("name: " + p.getName() + " age: " + p.getAge());

        Arrays.sort(people, new PersonComparable());


        System.out.println("排序后：");
        for(Person p : people)
            System.out.println("name: " + p.getName() + " age: " + p.getAge());

    }
}
