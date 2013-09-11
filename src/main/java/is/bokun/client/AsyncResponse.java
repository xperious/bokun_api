package is.bokun.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.codehaus.jackson.type.TypeReference;

import com.ning.http.client.Response;

/**
 * Allows to retrieve client response asynchronously. Implements {@link Future}.
 * 
 * @author Saulius Maciulis
 */
public class AsyncResponse<T> implements Future<T> {


	private AbstractClient client;
	
   	private Future<Response> future;


	public AsyncResponse(Future<Response> future, AbstractClient client) {
		this.future = future;
		this.client = client;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return future.cancel(mayInterruptIfRunning);
	}

	@Override
	public boolean isCancelled() {
		return future.isCancelled();
	}

	@Override
	public boolean isDone() {
		return future.isDone();
	}

	@Override
	public T get() throws InterruptedException, ExecutionException {
		return readValue(future.get());
	}

	@Override
	public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return readValue(future.get(timeout, unit));
	}
	
	private T readValue(Response response) {
		client.validateResponse(response);
		try {
			return AbstractClient.json.readValue(response.getResponseBody("UTF-8"), new TypeReference<T>(){});
		} catch (Exception e) {
            throw client.wrapException(e);
		}
	}

}
