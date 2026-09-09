package com.learn.basic;

public class Day1Exam {
    public static void main(String[] args) {
        // ========== 考核题 1 ==========
        // 定义一个 long 类型变量存储你的手机号，打印出来
        // 提示：long 类型赋值需要注意什么？
        // 你的代码写在这里：
     long phoneNumber;
     phoneNumber=18181818181l;
        System.out.println(phoneNumber+ "这是long的电话号码");

        // ========== 考核题 2 ==========
        // 定义 byte 类型 b1=100, b2=100
        // 把 b1+b2 的结果打印出来
        // 提示：直接写 byte b3 = b1+b2 会怎样？怎么解决？
        // 你的代码写在这里：
    byte b1=100;
    byte b2=100;
    int b=b1+b2;
        System.out.println(b);

        // ========== 考核题 3 ==========
        // 用 StringBuilder 拼接字符串 "Java" + "后端" + "学习"
        // 最终打印结果，并打印 StringBuilder 的长度
        // 你的代码写在这里：
    StringBuilder a=new StringBuilder("java");
    a.append("后端").append("学习");
        System.out.printf(a+"a的长度为"+a.length());

        // ========== 考核题 4 ==========
        // 定义 Integer i1 = 100, i2 = 100
        // 定义 Integer i3 = 200, i4 = 200
        // 分别用 == 和 equals 比较，打印结果
        // 并在注释里解释为什么结果不同
        // 你的代码写在这里：
    Integer i1=100,i2=100;
    Integer i3=200,i4=200;
        System.out.println(i1==i2);//是true
        System.out.println(i1.equals(i2));//是true
        System.out.println(i3==i4);//是false 因为超过了Integer 的缓存池
        System.out.println(i3.equals(i4));//是true



        // ========== 考核题 5 ==========
        // 定义两个 int 变量 a=7, b=3
        // 不使用 if，用三元运算符判断 a 和 b 谁大，打印"较大的数是:X"
        // 你的代码写在这里：
        int aa=7,bb=3;
        int c=aa>bb?aa:bb;
        System.out.println("较大的数是："+c);
    }
}
