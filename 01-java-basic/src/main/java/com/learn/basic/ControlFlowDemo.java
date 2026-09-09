package com.learn.basic;

/**
 * Day 2 - 流程控制完整演示
 */
public class ControlFlowDemo {

    public static void main(String[] args) {

        // ==================== 1. if-else ====================
        System.out.println("=== if-else ===");
        int score = 85;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好"); // 输出这里
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // ==================== 2. switch（传统写法）====================
        System.out.println("\n=== switch 传统写法 ===");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("周一");
                break; // ⚠️ 没有 break 会穿透到下一个 case
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三"); // 输出这里
                break;
            default:
                System.out.println("其他");
        }

        // ⚠️ 演示 switch 穿透（没有 break）
        System.out.println("\n=== switch 穿透演示 ===");
        int num = 1;
        switch (num) {
            case 1:
                System.out.println("case 1"); // 输出
            case 2:
                System.out.println("case 2"); // 也输出！因为没有 break
            case 3:
                System.out.println("case 3"); // 也输出！
                break;
            case 4:
                System.out.println("case 4"); // 不输出
        }

        // ==================== 3. switch 表达式（Java 14+新写法）====================
        System.out.println("\n=== switch 新写法（Java14+）===");
        // 新写法用 -> 箭头，自动 break，不会穿透
        String dayName = switch (day) {
            case 1 -> "周一";
            case 2 -> "周二";
            case 3 -> "周三"; // 返回这个
            case 4 -> "周四";
            case 5 -> "周五";
            default -> "周末";
        };
        System.out.println("今天是: " + dayName);

        // ==================== 4. for 循环 ====================
        System.out.println("\n=== for 循环 ===");
        // 普通 for：打印 1~5
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " "); // print 不换行
        }
        System.out.println(); // 换行

        // 九九乘法表
        System.out.println("\n=== 九九乘法表 ===");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

        // ==================== 5. while 和 do-while ====================
        System.out.println("\n=== while 循环 ===");
        // while：先判断再执行，条件一开始就false则一次都不执行
        int count = 0;
        while (count < 3) {
            System.out.println("while count=" + count);
            count++;
        }

        System.out.println("\n=== do-while 循环 ===");
        // do-while：先执行再判断，至少执行一次
        int count2 = 5; // 初始值已经不满足条件
        do {
            System.out.println("do-while count=" + count2); // 至少执行一次
            count2++;
        } while (count2 < 3); // 条件false，但上面已经执行了一次

        // ==================== 6. break 和 continue ====================
        System.out.println("\n=== break 和 continue ===");
        // break：跳出整个循环
        for (int i = 0; i < 10; i++) {
            if (i == 5) break; // i=5时跳出
            System.out.print(i + " "); // 打印 0 1 2 3 4
        }
        System.out.println();

        // continue：跳过本次循环，继续下一次
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue; // 偶数跳过
            System.out.print(i + " "); // 打印 1 3 5 7 9（奇数）
        }
        System.out.println();

        // ==================== 7. 标签（多层循环break）====================
        System.out.println("\n=== 标签 break（跳出外层循环）===");
        // 普通 break 只能跳出最近一层循环
        // 标签 break 可以直接跳出指定层
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    break outer; // 直接跳出外层循环
                }
                System.out.println("i=" + i + " j=" + j);
            }
        }
    }
}