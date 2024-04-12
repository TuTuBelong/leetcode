package com.dao.zang;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;

public class Animal {
    private String name = "animal";

    public String getName() {
        return name;
    }

    public Animal(String name){
        this.name=name;
    }
}
   class Monkey extends Animal{
     private String name;
     private String f_name;

     public int age;

     @Override
     public String getName(){
         return name;
     }
     public Monkey(String name, String name1) {
         super(name);
         String name2 = super.getName();
         this.name = name1;
         this.f_name = name2;
     }

     public void test(){
         System.out.println(name);
         System.out.println(f_name);
         System.out.println(super.getName());
    }
}
class Test{
    public static void main(String[] args) {
        Monkey monkey = new Monkey("animal","monkey");

        System.out.println(monkey.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}