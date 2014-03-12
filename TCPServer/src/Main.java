

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TCPServer tcpServer = new TCPServer(50000);
		tcpServer.run();
		String query;
		System.out.println("listening ...");
		while(true) {
			query = tcpServer.getNextMessage();
	    	if(query == null){
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			System.out.println("Thread interrupted from sleep?" + e.getLocalizedMessage());
	    		}
	    		continue;
	    	} else {
	    		System.out.println(query);
	    		tcpServer.sendResult("Got Msg\n");
	    	}
		}
	}

}
