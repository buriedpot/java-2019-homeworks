# 南京大学Java程序设计作业2-OOP-Basics

* 姓名：郭睿杰
* 班级：计算机系2班
* 学号：171860541
* 邮箱：1091378351@qq.com
* 报告阶段：OOP-Basics
* 完成日期：2019.9.10

## 目录

[TOC]

## 分析题目涉及的类和类的方法

本题目涉及到：

1. 七个葫芦娃的颜色不同，使用**枚举类型**来表示这七种颜色。
2. 首先有七个葫芦娃，虽颜色、排行不同，但可以认为同属于**葫芦娃类**。题干中提到在排序的时候，要求葫芦娃报告自己的位置转移情况，并且在排序结束之后要求依次报数，因此葫芦娃类对象应该能够说话——即可以**报告位置转移情况**，也可以**报告自己的名字或颜色**。这就意味着**葫芦娃类**应该有以上两种**公共的“说话”接口**。
3. 然后题目要求对葫芦娃进行排序，在**面向过程**程序设计思想中，则往往会认为排序是一个**过程**，应该仅仅由某个**函数**完成即可。而基于**面向对象**的思想，排序工作应该由某种**排序器**来完成。因此应该构造**排序器类**。而根据题目要求，需要实现**冒泡排序**以及**二分法插入排序**，因此该排序器应该实现这两种公共接口。
4. 涉及到本题目的各个“零部件”类已经分析完毕，现在要让整个过程运行起来，由面向对象思想，则需要一个**指挥者**。因此构建**指挥者类** `Main` 。程序运行则需要调用 `Main` 类的 `main` 函数。由题意，该类应该能够：
   * 指挥七个葫芦娃**随机站队**
   * 指挥排序器对站好队的葫芦娃进行**排序**
   * 排序结束后指挥各葫芦娃进行**报数**



## 各类的设计

根据上文的分析，分别定义如下类。

* 枚举类型 `Color` ：其中应包含七种颜色属性。

  ```java
  /*七种颜色的枚举类型Color*/
  enum Color { red, orange, yellow, green, cyan, blue, purple }
  ```

* 葫芦娃类 `CalabashBaby` ：该类应该有 *颜色* 和 *排行* 两种**私有**属性其中实现报告自己身份，报告自己颜色、报告自己身份的**公共接口**。由于排序需要涉及到私有属性的比较问题，而私有属性其他类不可以访问，因此需要编写**比较函数接口**。

  ```java
  public class CalabashBaby {
      private Color color;//颜色
      private int range;//排行
      /*构造器*/
      public CalabashBaby(){}
      public CalabashBaby(Color color){...}
      /*按颜色来比较的函数*/
      public boolean cmpcolor(CalabashBaby baby) {...}
      /*按排行来比较的函数*/
      public boolean cmprange(CalabashBaby baby) {...}
      /*更改值*/
      public void set(Color color) {...}
      /*获取值*/
      public Color getcolor() {...}
      /*report number -> number when changing the location*/
      public void reportchange(int src, int dest) {...}
      /*自报姓名*/
      public void reportrange() {...}
      /*自报顏色*/
      public void reportcolor() {...}
      /*测试类的正常工作*/
      public static void main(String[] args) {...}
  }
  ```

* 排序器类 `Sort` ：要实现**冒泡排序**以及**二分法排序**两个公共接口，用于对葫芦娃排序。其中有要求葫芦娃自报位置转移信息的功能。二分法查找位置由二分排序使用，不应作为公共接口。

  ```java
  public class Sort {
      /*二分法查找插入位置*/
      private int binarysearch(CalabashBaby[] babies, int left, int right, CalabashBaby x) {...}
      /*冒泡，根据排行排序*/
      public void bubblesort(CalabashBaby[] babies, int n){...}
      /*二分排序，理解为插入排序的查找过程使用二分查找，根据颜色排序*/
      public void binarysort(CalabashBaby[] babies, int n)  {...}
  }
  ```

* 指挥类 `Main` ：要指挥整个过程的运转。其中有要求葫芦娃**依次报数**的公共接口。

  ```java
  import java.util.Random;
  public class Main {
      /*要求各葫芦娃报排行*/
      private void reportrange(CalabashBaby[] babies, int n){...}
      /*要求各葫芦娃报颜色*/
      private void reportcolor(CalabashBaby[] babies, int n){...}
      /*此函数用于产生一个随机站队方法*/
      public int[] producerand(int n){...}
      /*主函数，执行用*/
      public static void main(String[] args) {...}
  }
  ```

  

## 整体运转（类间协作）

![1568198718523](C:\Users\1091378351\AppData\Roaming\Typora\typora-user-images\1568198718523.png)


## 总结

结合具体问题，分析出参与改问题的各个角色（对象），构建出类，模拟出问题中各个类各个对象的交互关系和流程。面向对象的思想是对现实世界的模拟。

