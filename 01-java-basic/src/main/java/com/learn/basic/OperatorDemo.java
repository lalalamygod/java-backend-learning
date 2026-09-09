package com.learn.basic;

/**
 * Day 2 - 运算符完整演示
 */
public class OperatorDemo {

    public static void main(String[] args) {

        // ==================== 1. 算术运算符 ====================
        int a = 10, b = 3;
        System.out.println("=== 算术运算符 ===");
        System.out.println("加: " + (a + b));         // 13
        System.out.println("减: " + (a - b));         // 7
        System.out.println("乘: " + (a * b));         // 30
        System.out.println("整除: " + (a / b));       // 3，注意不是3.33
        System.out.println("取余: " + (a % b));       // 1

        // ⚠️ 陷阱：整数除法会丢弃小数部分
        // 如果想得到 3.33，必须有一个数是浮点数
        System.out.println("浮点除法: " + (10.0 / 3)); // 3.3333...

        // 前自增 vs 后自增
        int x = 5;
        System.out.println("\n=== 自增运算符 ===");
        System.out.println("++x = " + (++x));   // 先加1变6，再打印：6
        System.out.println("x = " + x);          // 6

        int y = 5;
        System.out.println("y++ = " + (y++));   // 先打印5，再加1：5
        System.out.println("y = " + y);          // 6

        // ==================== 2. 比较运算符 ====================
        System.out.println("\n=== 比较运算符 ===");
        int p = 10, q = 20;
        System.out.println("p > q: " + (p > q));   // false
        System.out.println("p < q: " + (p < q));   // true
        System.out.println("p == q: " + (p == q)); // false
        System.out.println("p != q: " + (p != q)); // true

        // ==================== 3. 逻辑运算符 ====================
        System.out.println("\n=== 逻辑运算符（短路）===");
        int n = 0;

        // &&短路与：左边为false，右边直接不执行
        // 所以 10/n 不会执行，不会抛出除零异常
        boolean r1 = (n != 0) && (10 / n > 1);
        System.out.println("短路与(安全): " + r1);  // false

        // ||短路或：左边为true，右边直接不执行
        boolean r2 = (n == 0) || (10 / n > 1);
        System.out.println("短路或(安全): " + r2);  // true

        // ==================== 4. 位运算符 ====================
        System.out.println("\n=== 位运算符 ===");
        // 0b 开头表示二进制
        int m1 = 0b1010; // 十进制 10
        int m2 = 0b1100; // 十进制 12

        System.out.println("按位与 &: " + (m1 & m2));  // 1000 = 8
        System.out.println("按位或 |: " + (m1 | m2));  // 1110 = 14
        System.out.println("按位异或^: " + (m1 ^ m2)); // 0110 = 6

        // 左移1位 = 乘以2，效率比乘法高
        System.out.println("左移 10<<1: " + (10 << 1)); // 20
        System.out.println("左移 10<<2: " + (10 << 2)); // 40
        // 右移1位 = 除以2
        System.out.println("右移 10>>1: " + (10 >> 1)); // 5

        // 实用技巧：判断奇偶
        System.out.println("\n=== 位运算实用技巧 ===");
        System.out.println("10是偶数: " + ((10 & 1) == 0)); // true
        System.out.println("7是奇数:  " + ((7 & 1) == 1));  // true

        // 实用技巧：不用临时变量交换两个数
        int v1 = 3, v2 = 5;
        v1 = v1 ^ v2;
        v2 = v1 ^ v2;
        v1 = v1 ^ v2;
        System.out.println("异或交换: v1=" + v1 + " v2=" + v2); // v1=5 v2=3

        // ==================== 5. 三元运算符 ====================
        System.out.println("\n=== 三元运算符 ===");
        int age = 20;
        String result = (age >= 18) ? "成年" : "未成年";
        System.out.println("年龄判断: " + result); // 成年

        // 三元运算符可以嵌套，但不推荐超过2层，可读性差
        int score = 85;
        String grade = score >= 90 ? "优秀" : score >= 60 ? "及格" : "不及格";
        System.out.println("成绩等级: " + grade); // 及格

        // ==================== 6. String拼接性能对比 ====================
        System.out.println("\n=== String vs StringBuilder 性能 ===");
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += "a"; // 每次都创建新对象，非常慢
        }
        System.out.println("String 耗时: " + (System.currentTimeMillis() - start1) + "ms");

        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("a"); // 在原有数组上追加，非常快
        }
        System.out.println("StringBuilder 耗时: " + (System.currentTimeMillis() - start2) + "ms");
    }
}