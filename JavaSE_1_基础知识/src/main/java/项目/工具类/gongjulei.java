package 项目.工具类;

import java.util.Scanner;


//将不同的功能封装为方法，就是可以直接使用它的功能，而无需考虑具体的功能实现细节

public class gongjulei {
	
	
	private static Scanner scanner=new Scanner(System.in);
	//用于界面选择，输入1-5则方法返回，否则返回提示
	public static char readMenuSelection(){
		char c;
		for (;;) {
			String str=randKeyBoard(1,false);
			c=str.charAt(0);
			if (c!='1' && c!='2'&&c!='3'&&c!='4'&&c!='5') {
				System.out.println("输入错误,请重新输入：");
			}else break;
		}
		return c;
		}
	
	//从键盘读取一个字符，并将其作为方法的返回值
	public static char readChar() {
		String str=randKeyBoard(1,false);
		return str.charAt(0);
		
	}
	//从键盘读取一个字符，并将其作为方法的返回值
	//如果用户直接回车，方法将以defaultValue作为返回值
	public static char readChar(char defaultValue) {
		String str=randKeyBoard(1,true);
		return (str.length()==0)?defaultValue:str.charAt(0);
		
	}
	
	//从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
	public static int readInt(){
		int n;
		for (;;) {
			String str=randKeyBoard(2,false);
			try {
				n=Integer.parseInt(str);
					break;
			}catch (NumberFormatException e) {
				System.out.println("输入错误,请重新输入：");
				}
			}
		return n;
		}
	//从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
	//如果用户直接回车，方法将以defaultValue作为返回值
	public static int readInt(int defaultValue){
		int n;
		for (;;) {
			String str=randKeyBoard(2,true);
			if (str.equals("")) {
				return defaultValue;
			}try {
				n=Integer.parseInt(str);
					break;
			}catch (NumberFormatException e) {
				System.out.println("输入错误,请重新输入：");
				}
			}
		return n;
		}
	
	//从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值
	
	public static String readString(int limit) {
		return randKeyBoard(limit,false);
	}
	//从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值
	//如果用户直接回车，方法将以defaultValue作为返回值
	public static String readString(int limit,String defaultValue) {
		String str=randKeyBoard(limit,true);
	return str.equals("")?defaultValue:str;
	}
	
	//用于确认选择的输出，该方法从键盘读取“Y”或“N”,并将其作为方法的返回值
	public static char readConfirmSelection(){
		char c;
		for (;;) {
			String str=randKeyBoard(1,false).toUpperCase();
			c=str.charAt(0);
			if (c=='X'||c=='Y'){
				break;
			}else {
				System.out.println("输入错误,请重新输入：");
		}
		}
		return c;
		}
	
	//从键盘获取值
	private static String randKeyBoard(int limit,boolean blackRetur){
		String line="";
		while (scanner.hasNextLine()) {
			line=scanner.nextLine();
			if (line.length()==0) {
				if (blackRetur) return line;
				else continue;
			}
			if (line.length()<1||line.length()>limit){
				System.out.println("输入长度(不大于"+limit+")错误，请重新输入");
				continue;
			}
			break;
		}
		return line;
		}
	
	
	
}
