package 流程控制.循环;

/*
 Ø 说明：
		1.将一个循环放在另一个循环体内，就形成了嵌套循环。其中， for ,while ,do…while均可以作为外层循环或内层循环。 
		2.实质上，嵌套循环就是把内层循环当成外层循环的循环体。当只有内层循环的 循环条件为false时，才会完全跳出内层循环，才可结束外层的当次循环，开 始下一次的循环。 
		3.设外层循环次数为m次，内层为n次，则内层循环体实际上需要执行m*n次。
	
 * */
public class 嵌套循环 {
    public static void main(String[] args) {
        //九九乘法表
        //嵌套循环
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + "*" + j + "=" + i * j);
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}
