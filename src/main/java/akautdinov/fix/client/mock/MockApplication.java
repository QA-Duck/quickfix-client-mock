package akautdinov.fix.client.mock;

import akautdinov.fix.client.mock.fix.FixReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import quickfix.*;

import static java.lang.Thread.sleep;


@Slf4j
@SpringBootApplication
public class MockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("GI");
		SpringApplication.run(MockApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("GI");

		new Thread(() -> {
			try {
				Application application = new FixReceiver();
				SessionSettings settings = new SessionSettings("receiver.cfg");
				MessageStoreFactory storeFactory = new FileStoreFactory(settings);
				LogFactory logFactory = new FileLogFactory(settings);
				MessageFactory messageFactory = new DefaultMessageFactory();
				Acceptor acceptor = new SocketAcceptor
						(application, storeFactory, settings, logFactory, messageFactory);
				acceptor.start();
			} catch (Exception e) {
				log.error(e.getLocalizedMessage());
			}
		}).run();

		sleep(100000);
//		acceptor.stop();
	}
}
