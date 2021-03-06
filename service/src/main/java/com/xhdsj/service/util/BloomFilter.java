package com.xhdsj.service.util;

import java.util.BitSet;

/**
 * 功能描述: 布隆过滤器
 *          将爬取的数据放入布隆过滤器中，按照一定规则进行过滤
 *
 * @auther: njw
 * @date: 2018/4/17 
 */

public class BloomFilter {

    public static void main(String[] args) {

        BloomFilter b = new BloomFilter();
        b.addValue("www.baidu.com");
        b.addValue("www.sohu.com");

        System.out.println(b.contains("www.baidu.com"));
        System.out.println(b.contains("www.sina.com"));
    }

    //二进制向量的位数，相当于能存储1000万条url左右，误报率为千万分之一

    private static final int BIT_SIZE = 2 << 28;

    //用于生成信息指纹的8个随机数，最好选取质数

    private static final int[] seeds = new int[]{3, 5, 7, 11, 13, 31, 37, 61};

    private BitSet bits = new BitSet(BIT_SIZE);

    //用于存储8个随机哈希值对象

    private Hash[] func = new Hash[seeds.length];

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new Hash(BIT_SIZE, seeds[i]);
        }
    }

    /**
     * 像过滤器中添加字符串
     */
    public void addValue(String value) {
        //将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
        if (value != null) {
            for (Hash f : func) {
                bits.set(f.hash(value), true);
            }
        }

    }

    /**
     * 判断字符串是否包含在布隆过滤器中
     */
    public boolean contains(String value) {

        if (value == null) {
            return false;
        }

        boolean ret = true;

        //将要比较的字符串重新以上述方法计算hash值，再与布隆过滤器比对
        for (Hash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }


    /**
     * 随机哈希值对象
     */

    public static class Hash{
        //二进制向量数组大小

        private int size;

        //随机数种子
        private int seed;

        public Hash(int cap, int seed){
            this.size = cap;
            this.seed = seed;
        }

        /**
         * 计算哈希值(也可以选用别的恰当的哈希函数)
         */
        public int hash(String value){
            int result = 0;
            int len = value.length();
            for(int i = 0; i < len; i++){
                result = seed * result + value.charAt(i);
            }
            return (size - 1) & result;
        }
    }

}