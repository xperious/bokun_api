package is.bokun.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.JavaType;

import com.ning.http.client.Response;

/**
 * Allows to retrieve client response asynchronously. Implements {@link Future}.
 * 
 * @author Saulius Maciulis
 */
public class AsyncResponse<T> implements Future<T> {


	private AbstractClient client;
	
   	private Future<Response> future;
   	
   	private JavaType responseType;

   	/**
   	 * @param future Async http client response 
   	 * @param client Reference to the client that provides the response
   	 * @param responseType Return type, required because of generic type erasure
   	 */
	public AsyncResponse(Future<Response> future, AbstractClient client, JavaType responseType) {
		this.future = future;
		this.client = client;
		this.responseType = responseType;
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
			return AbstractClient.json.readValue(response.getResponseBody("UTF-8"), responseType);
		} catch (Exception e) {
            throw client.wrapException(e);
		}
	}

}
