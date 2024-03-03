// Spring boot embedded tomcat ws scan is disabled by default, this won't work
package demo.ws;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/wsdemo1")
public class WebsocketHello {

	int count=0;
	    @OnOpen
	    public void onOpen(Session session) throws IOException {
	    	System.out.println("WS opened");
	    }

	    @OnMessage
	    public void onMessage(Session session, String message) throws IOException {

	    	System.out.println("Got "+message+"!");
	    	if(session.isOpen()) {
	    		session.getBasicRemote().sendText("Count for "+session.getId()+": "+ ++count);
	    	}
	    }

	    @OnClose
	    public void onClose(Session session) throws IOException {

	    	System.out.println("WS closed");
	    }

	    @OnError
	    public void onError(Session session, Throwable throwable) {
	    	System.out.println("WS error");

	    }
	}