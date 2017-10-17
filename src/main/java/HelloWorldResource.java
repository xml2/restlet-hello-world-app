import org.restlet.data.Status;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {

	@Get
	public String represent() {
		String who = getQueryValue("who");
		if (who == null) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Required parameter 'who' is missing");
		}
		return String.format("Hello, %s!", who);
	}

}