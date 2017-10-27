package cn.mldn.mldnzk.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

public class TestZooKeeperConnect {
	// 定义要连接所有的主机名称（是在一个ZooKeeper集群之中的主机）
	private static final String ZK_SERVER_URL = "192.168.68.136:2181,192.168.68.137:2181,192.168.68.138" ;
	private static final int SESSION_TIMEOUT = 100 ;	// 设置统一的超时时间
	@Test
	public void testConnect() throws Exception {	// 连接的时候一定会出现异常信息
		ZooKeeper zkClient = new ZooKeeper(ZK_SERVER_URL, SESSION_TIMEOUT, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				System.err.println(event); // 输出连接的事件信息
			}}) ;
		System.out.println("*** " + zkClient);
		zkClient.close(); 	// 关闭ZkServer连接 
	}
}
