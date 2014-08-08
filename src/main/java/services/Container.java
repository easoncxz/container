package services;

import java.util.HashMap;
import java.util.Map;

public class Container {

	private Container() {
		// to disable the default (no-argument) public constructor.
	}

	private static Container theSingleton;

	public static Container getSingleton() {
		if (theSingleton == null) {
			theSingleton = new Container();
		}
		return theSingleton;
	}

	/**
	 * Maintains a collection of components. Maps components (Object objects) to
	 * component names (String objects).
	 */
	private Map<Object, String> components = new HashMap<Object, String>();

	{
		// This initializer block provides the same information as
		// the `app-context.xml` in Spring.
		DefaultMessageProvider dmp = new DefaultMessageProvider("Thing");
		DefaultMessageRenderer dmr = new DefaultMessageRenderer(dmp);

		this.components.put(dmp, "myDefaultMessageProvider");
		this.components.put(dmr, "myDefaultMessageRenderer");
	}

	/**
	 * @param serviceClass
	 * @return The first (or only) service of class serviceClass.
	 */
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

	/**
	 * @param serviceClass
	 * @param name
	 * @return The exact component specified by the class serviceClass and the
	 *         name name.
	 */
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
