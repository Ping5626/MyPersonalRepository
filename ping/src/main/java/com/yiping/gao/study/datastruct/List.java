package com.yiping.gao.study.datastruct;

/**
 * FileName: List
 * Author: 高一平
 * Date: 2017/12/19 10:14
 * Description: 线性表的抽象数据类型
 * Date：线性表的数据对象集合为{a1,a2,……,an}
 *       每个元素的类型均为DataType
 *       其中，除第一个元素a1外，每一个元素有且只有一个直接前驱元素
 *       除最后一个元素an外，每一个元素有且只有一个直接后继元素
 *       数据元素之间的关系是一对一的关系
 */

public interface List<E> {

    /**
     * 初始化操作，建立一个空的线性表
     */
    public void InitList();

    /**
     * 若线性表为空，返回true，否则返回false
     * @return 是否为空
     */
    public boolean ListEmpty();

    /**
     * 将线性表清空
     * @return 是否成功
     */
    public boolean ClearList();

    /**
     * 将线性表L中的第i个位置元素返回给e
     * @param i 位置
     * @return 第i个位置元素
     */
    public E GetElem(int i);

    /**
     * 在线性表L中查找与给定值e相等的元素
     * 如果查找成功，返回该元素在表中序号表示成功
     * 否则，返回0表示失败
     * @param e 定值
     * @return 该元素在表中序号
     */
    public int LocateElem(E e);

    /**
     * 在线性表L中的第i个位置插入新元素e
     * @param e 新元素
     * @param i 位置
     * @return 是否成功
     */
    public int ListInsert(E e, int i);

    /**
     * 删除线性表L中第i个位置元素，并返回其值
     * @param i 位置
     * @return 原第i个位置元素
     */
    public E ListDelete(int i);

    /**
     * 返回线性表L的元素个数
     * @return 元素个数
     */
    public int ListLength();

}
