package 集合.比较器;

import java.util.Arrays;

public class Comparable接口自然排序 {
    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("《红楼梦》", 70);
        goods[1] = new Goods("《西游记》", 50);
        goods[2] = new Goods("《三国演义》", 60);
        goods[3] = new Goods("《水浒传》", 80);
        Arrays.sort(goods);// 对括号中的数组进行排序
        System.out.println(Arrays.toString(goods));
        // [Goods{name='《西游记》', price=50.0}, Goods{name='《三国演义》', price=60.0}, Goods{name='《红楼梦》', price=70.0}, Goods{name='《水浒传》', price=80.0}]
    }
}
