package com.learn.basic;

/**
 * Day 1 - Java 8种基本数据类型演示
 * 运行方法：右键 → Run 'DataTypeDemo.main()'
 */
public class DataTypeDemo {

    public static void main(String[] args) {

        // ==================== 1. 整数类型 ====================
        // byte：1个字节，范围 -128 ~ 127，用于节省内存（如文件读取）
        byte b = 100;
        System.out.println("byte 最大值: " + Byte.MAX_VALUE);   // 127
        System.out.println("byte 最小值: " + Byte.MIN_VALUE);   // -128

        // short：2个字节，范围 -32768 ~ 32767，很少使用
        short s = 30000;
        System.out.println("short 最大值: " + Short.MAX_VALUE); // 32767

        // int：4个字节，最常用的整数类型
        int i = 2147483647;
        System.out.println("int 最大值: " + Integer.MAX_VALUE); // 2147483647
        System.out.println("int 最小值: " + Integer.MIN_VALUE); // -2147483648

        // long：8个字节，数字后面必须加 L，用于大数（如时间戳、数据库ID）
        long l = 9999999999L;
        System.out.println("long 最大值: " + Long.MAX_VALUE);   // 9223372036854775807

        // ==================== 2. 浮点类型 ====================
        // float：4个字节，精度约7位，数字后必须加 f，很少用
        float f = 3.14f;
        System.out.println("float 值: " + f);                   // 3.14

        // double：8个字节，精度约15位，默认浮点类型
        double d = 3.141592653589793;
        System.out.println("double 值: " + d);

        // ⚠️ 浮点数精度问题：永远不要用 == 比较浮点数
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));      // 0.30000000000000004

        // ==================== 3. 字符类型 ====================
        // char：2个字节，存单个字符，本质是0~65535的整数（Unicode编码）
        char c = 'A';
        System.out.println("char 值: " + c);                    // A
        System.out.println("char 转 int: " + (int) c);          // 65（ASCII码）
        char c2 = '中';
        System.out.println("汉字 char: " + c2);                  // 中

        // ==================== 4. 布尔类型 ====================
        // boolean：只有 true 和 false，不能用0和1代替（不像C语言）
        boolean flag = true;
        System.out.println("boolean 值: " + flag);

        // ==================== 5. 自动类型提升 ====================
        // 小类型和大类型运算，结果自动提升为大类型
        int x = 10;
        long y = 20L;
        long result1 = x + y;   // int + long → long
        System.out.println("int + long = " + result1);

        int x2 = 10;
        double y2 = 3.14;
        double result2 = x2 + y2; // int + double → double
        System.out.println("int + double = " + result2);

        // ⚠️ 陷阱：byte + byte → int，不是 byte！
        byte byteb1 = 10;
        byte byteb2 = 20;
        // byte byteb3 = byteb1 + byteb2; // 编译错误！结果是 int
        int byteb3 = byteb1 + byteb2;
        System.out.println("byte + byte = int: " + byteb3);

        // ==================== 6. 装箱与拆箱 ====================
        // 装箱：基本类型 → 包装类型（自动）
        Integer i1 = 127;   // 等价于 Integer.valueOf(127)
        Integer i2 = 127;
        // ⚠️ Integer缓存池：-128~127 范围内的Integer对象会复用，== 返回 true
        System.out.println("127 == 127: " + (i1 == i2));       // true（同一个对象）

        Integer i3 = 128;
        Integer i4 = 128;
        // 128 超出缓存范围，new了两个不同对象，== 比较地址返回 false
        System.out.println("128 == 128: " + (i3 == i4));       // false！
        System.out.println("128 equals 128: " + i3.equals(i4));// true（比较值）

        // ==================== 7. String不变性 ====================
        // String 是不可变的，每次修改都创建新对象
        String str1 = "hello";
        String str2 = "hello";
        // 字符串常量池：相同内容的字符串字面量指向同一个对象
        System.out.println("str1 == str2: " + (str1 == str2)); // true（常量池同一对象）

        String str3 = new String("hello"); // 强制在堆上创建新对象
        System.out.println("str1 == str3: " + (str1 == str3)); // false（不同对象）
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true（值相同）

        // ==================== 8. StringBuilder 性能对比 ====================
        // 用 String 拼接：每次 + 都创建新对象，10000次循环非常慢
        long start1 = System.currentTimeMillis();
        String s1 = "";
        for (int n = 0; n < 10000; n++) {
            s1 += "a"; // 每次都 new 一个新 String，产生大量垃圾对象
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String 拼接耗时: " + (end1 - start1) + "ms");

        // 用 StringBuilder：内部维护字符数组，append 不创建新对象
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < 10000; n++) {
            sb.append("a");
        }
        String s2 = sb.toString();
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder 拼接耗时: " + (end2 - start2) + "ms");
        // 结论：StringBuilder 比 String 拼接快几十到几百倍
    }
}