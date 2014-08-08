package services;

import my_artifact_id.MessageProvider;

public class DefaultMessageProvider implements MessageProvider {

	private String message;

	DefaultMessageProvider(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
