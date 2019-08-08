package us.lsi.graphs.virtual;

public interface Action<V> {
	/**
	 * @pre isApplicable(a)
	 * @param v Un v�rtice
	 * @return El vecino tras tomar esa acci�n
	 */
	public V neighbor(V v);
	/**
	 * @param v Un v�rtice
	 * @return Si la acci�n es aplicable en este v�rtice
	 */
	public boolean isApplicable(V v);
}
