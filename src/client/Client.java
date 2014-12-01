package client;

public class Client {

	ClientWriter writer;

	public static void main(String[] args) {
		SocketAddress adr1 = new SocketAddress("localhost", 7897);
		SocketAddress adr2 = new SocketAddress("localhost", 7898);
		SocketAddress[] addresses = new SocketAddress[2];
		addresses[0] = adr1;
		addresses[1] = adr2;
		ClientMonitor mon = new ClientMonitor(1, addresses);
		ClientReader cReader0 = new ClientReader(mon, 0);
		ClientReader cReader1 = new ClientReader(mon, 1);
		ClientWriter cWriter = new ClientWriter(mon, null);

	}
}