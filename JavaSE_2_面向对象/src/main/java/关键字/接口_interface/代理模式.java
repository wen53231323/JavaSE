package 关键字.接口_interface;
/*
 * 接口的应用：代理模式
 * 
 * */
public class 代理模式 {
	public static void main(String[] args) {
		Server server=new Server();
		ProxyServer proxyServer=new ProxyServer(server);
		proxyServer.browse();
	}

}

//接口
interface NetWork{
	public void browse();
}

//实现(被代理类)
class Server implements NetWork{
	@Override
	public void browse() {
		System.out.println("真实的服务器访问网络");
	}
}

//实现(代理类)
class ProxyServer implements NetWork{
	private NetWork work;
	//构造器
	public ProxyServer(NetWork work) {
		this.work=work;
	}
	//方法
	public void check() {
		System.out.println("联网之前的检查工作");
	}
	@Override
	public void browse() {
		check();
		
		work.browse();
	}
}