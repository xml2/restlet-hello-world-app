import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class HelloWorldApplication extends Application {

	static {
		System.setProperty("org.restlet.engine.loggerFacadeClass", "org.restlet.ext.slf4j.Slf4jLoggerFacade");
	}

	public static void main(String[] args) {
		Server server = new Server(Protocol.HTTP, 8111);
		server.setNext(new HelloWorldApplication());
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.setDefaultMatchingQuery(true);
		router.attach("http://localhost:8111/hello?{query}", HelloWorldResource.class);
		return router;
	}

}
