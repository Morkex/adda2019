package us.lsi.graphs.virtual;

import java.util.Set;
/**
 * <a> El tipo representa un v�rtice de un grafo virtual no dirigido </a>
 * 
 * @author Miguel Toro
 *
 * @param <V> Tipo de los v�rtices
 * @param <E> Tipo de las aristas
 */
public interface VirtualVertex<V extends VirtualVertex<V,E>, E> {	
	/**
	 * @return Si es un valor v�lido del tipo
	 */
	boolean isValid();
	/**
	 * @return Conjunto de los v�rtices vecinos
	 */
	Set<V> getNeighborListOf();
	/**
	 * @return Conjunto de las aristas hacia los v�rtices vecinos
	 */
	Set<E> edgesOf(); 
	
	/**
	 * @param v V�rtice que se pregunta si es vecino
	 * @return Si el v�rtice es vecino
	 */
	default Boolean isNeighbor(V v) {
		return null;
	}
	
	/**
	 * @param v2 Otro v�rtice
	 * @return La arista desde this a v2
	 */
	default E getEdge(V v2) {
		return null;
	}

}
