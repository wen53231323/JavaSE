package 集合.比较器;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator接口定制排序 {
    public static void main(String[] args) {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("《红楼梦》", 70);
        goods[1] = new Goods("《西游记》", 50);
        goods[2] = new Goods("《三国演义》", 60);
        goods[3] = new Goods("《水浒传》", 80);
        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return g1.getName().compareTo(g2.getName());
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
