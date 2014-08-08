package my_artifact_id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import services.Container;

public class Main {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);
		logger.info("Hello log!");
		Container c = Container.getSingleton();

		MessageRenderer mp = c.getService(MessageRenderer.class,
				"myDefaultMessageRenderer");
		mp.render();
	}

}
