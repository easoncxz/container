package services;

import my_artifact_id.MessageProvider;
import my_artifact_id.MessageRenderer;

public class DefaultMessageRenderer implements MessageRenderer {

	private MessageProvider mp;

	/**
	 * Constructor injection intended.
	 * 
	 * @param mp
	 */
	public DefaultMessageRenderer(MessageProvider mp) {
		this.mp = mp;
	}

	public void render() {
		System.out.println(mp.getMessage());
	}

}
