public class Main {
	public static void main(String[] args) throws Exception {

		// Set a default server address if one isn't specified in the arguments
		String host = "localhost";
		int port = 50000;
		TCPClient client = new TCPClient(host, port);
		client.init();
		client.sendMsg("Hello");
		String resp;
		while(true) {
			resp = client.getNextMessage();
			if(resp == null){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Thread interrupted from sleep?" + e.getLocalizedMessage());
				}
				continue;
			} else {
				System.out.println(resp);
				
			}
		}
	}
}