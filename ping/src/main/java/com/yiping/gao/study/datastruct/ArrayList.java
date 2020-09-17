package com.yiping.gao.study.datastruct;

/**
 * FileName: ArrayList
 * Author: 高一平
 * Date: 2017/12/19 11:35
 * Description: 线性表的顺序存储结构
 * 描述顺序存储结构需要三个属性
 * 1、存储空间的起始位置：数组data，它的存储位置就是存储空间的存储位置
 * 2、线性表的最大存储容量：数组长度MaxSize（存放线性表的存储空间的长度，存储后这个量一般不变）
 * 3、线性表的当前长度：length
 * （在任意时刻，线性表的长度应该小于等于数组的长度）
 *
 * 假设单个数据元素占用c个存储单元
 * 那么线性表中第i+1个数据元素的存储位置和第i个数据元素的存储位置满足下列关系
 * （LOC表示获得存储位置的函数）
 * LOC(ai+1)=LOC(ai)+c  ======》》》   LOC(ai)=LOC(a1)+(i-1)*c
 *
 * 优点：
 * 1、无须为表示表中元素之间的逻辑关系而增加额外的存储空间
 * 2、可以快速地存取表中任一位置的元素
 * 缺点：
 * 1、插入和删除操作需要移动大量元素
 * 2、当线性表长度变化较大时，难以确定存储空间的容量
 * 3、造成存储空间的“碎片”
 *
 * 【官方ArrayList】
 * 非线程安全
 * 基于对象数组
 * get(int index)不需要遍历数组，速度快；
 * iterator()方法中调用了get(int index)，所以速度也快
 * set(int index, E e)不需要遍历数组，速度快
 * add方法需要考虑扩容与数组复制问题，速度慢
 * remove(Object o)需要遍历数组，并复制数组元素，速度慢
 * remove(int index)不需要遍历数组，需要复制数组元素，但不常用
 * contain(E)需要遍历数组
 * 【官方Vector（线程安全的ArrayList）】
 * 线程安全
 * 扩容机制与ArrayList不同
 */

public class ArrayList<E> implements List<E> {

    private Object[] data = {};

    private final int OK = 1;
    private final int ERROR = 0;
    private final int TRUE = 1;
    private final int FALSE = 0;

    /**
     * 存储空间初始分配量
     */
    private int MAXSIZE = 20;


    /**
     * 初始化操作，建立一个空的线性表
     */
    public void InitList() {
        this.data = new Object[MAXSIZE];
    }

    /**
     * 若线性表为空，返回true，否则返回false
     * @return 是否为空
     */
    public boolean ListEmpty() {
        if (data.length == 0) {
            return false;
        } else if (data.length > 0){
            return true;
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * 将线性表清空
     * @return 是否成功
     */
    public boolean ClearList() {
        return false;
    }

    /**
     * 将线性表L中的第i个位置元素返回给e
     * @param i 位置
     * @return 第i个位置元素
     */
    public E GetElem(int i) {
        if (data.length == 0 || i < 1 || i > data.length) {
            throw new IndexOutOfBoundsException();
        } else {
            Object e = data[i];
            return (E) e;
        }
    }

    /**
     * 在线性表L中查找与给定值e相等的元素
     * 如果查找成功，返回该元素在表中序号表示成功
     * 否则，返回0表示失败
     * @param e 定值
     * @return 该元素在表中序号
     */
    public int LocateElem(E e) {
        return 0;
    }

    /**
     * 在线性表L中的第i个位置插入新元素e
     * @param e 新元素
     * @param i 位置
     * @return 是否成功
     *
     * 思路：
     * 1、如果插入位置不合理，抛出异常
     * 2、如果线性表长度大于等于数组长度，则抛出异常或动态增加容量
     * 3、从最后一个元素开始向前遍历到第i个位置，分别将它们都向后移动一个位置
     * 4、将要插入元素填入位置i处
     * 5、表长加1
     */
    public int ListInsert(E e, int i) {
        if (data.length == MAXSIZE) {
            return ERROR;
        }
        return OK;
    }

    /**
     * 删除线性表L中第i个位置元素，并返回其值
     * @param i 位置
     * @return 原第i个位置元素
     *
     * 思路：
     * 1、如果删除位置不合理，抛出异常
     * 2、取出删除元素
     * 3、从删除元素位置开始遍历到最后一个元素位置，分别将它们都向前移动一个位置
     * 4、表长减1
     */
    public E ListDelete(int i) {

        return null;
    }

    /**
     * 返回线性表L的元素个数
     * @return 元素个数
     */
    public int ListLength() {

        return 0;
    }

}
