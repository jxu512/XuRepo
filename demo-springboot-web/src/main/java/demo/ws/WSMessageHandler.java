package demo.ws;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WSMessageHandler extends TextWebSocketHandler {

	int count=0;
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		log.info("Got mesage from "+session.getId()+": "+message);
		session.sendMessage(new TextMessage("Count for "+session.getId()+":" + ++count));
	}

}