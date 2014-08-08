package services;

import java.util.HashMap;
import java.util.Map;

import my_artifact_id.MessageProvider;
import my_artifact_id.MessageRenderer;

public class Container {

	private Container() {
		// to disable the default (no-argument) public constructor.
	}

	private static Container c;

	public static Container getSingleton() {
		if (c == null) {
			c = new Container();
		}
		return c;
	}

	private Map<Object, String> components = new HashMap<Object, String>();

	{
		// This initializer block provides the same information as
		// the `app-context.xml` in Spring.
		DefaultMessageProvider dmp = new DefaultMessageProvider("Thing");
		DefaultMessageRenderer dmr = new DefaultMessageRenderer(dmp);

		this.components.put(dmp, "myDefaultMessageProvider");
		this.components.put(dmr, "myDefaultMessageRenderer");
	}

	public <T> T getService(Class<T> serviceClass) {
		if (serviceClass != null) {
			Class<T> c = serviceClass;
			for (Object o : this.components.keySet()) {
				if (serviceClass.isAssignableFrom(o.getClass())) {
					return (T) o;
				}
			}
		}
		return null;
	}

	public <T> T getService(Class<T> serviceClass, String name) {
		if (serviceClass != null) {
			Class<T> c = serviceClass;
			for (Object o : this.components.keySet()) {
				if (serviceClass.isAssignableFrom(o.getClass())
						&& this.components.get(o).equals(name)) {
					return (T) o;
				}
			}
		}
		return null;
	}

}
