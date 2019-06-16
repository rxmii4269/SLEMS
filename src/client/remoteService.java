package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("RemoteService")
public interface remoteService extends RemoteService {
	/**
	 * Utility/Convenience class.
	 * Use RemoteService.App.getInstance() to access static instance of RemoteServiceAsync
	 */
	public static class App {
		private static final remoteServiceAsync ourInstance = (remoteServiceAsync) GWT.create(RemoteService.class);

		public static remoteServiceAsync getInstance() {
			return ourInstance;
		}
	}
}
