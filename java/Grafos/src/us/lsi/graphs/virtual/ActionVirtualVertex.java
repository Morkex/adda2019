package us.lsi.graphs.virtual;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.graphs.SimpleEdge;

/**
 * @author Miguel Toro
 *
 * @param <A> Tipo de la acci�n
 * @param <V> Tipo del v�rtice
 * 
 * 
 * <a> Tipo adecuado para modelar un v�rtice de un grafo virtual simple cuyas aristas est�n 
 * definidas por un conjunto de acciones o alternativas. 
 * Cada acci�n v�lida identifica de forma �nica uno de los vecinos del v�rtice. 
 * Cada v�rtice conoce sus vecinos y la forma de llegar a ellos mediante una de las acciones v�lidas disponibles </a>
 */
public abstract class ActionVirtualVertex<V extends VirtualVertex<V,E>, E extends SimpleEdge<V>, A> 
			implements VirtualVertex<V,E> {

	public ActionVirtualVertex() {
	}
	
	/**
	 * @return Si es un valor v�lido del tipo
	 */
	public abstract boolean isValid();
	
	/**
	 * Para ser implementado por el subtipo
	 * @return Lista de acciones disponibles y adecuadas para alcanzar un v�rtice v�lido
	 */
	protected abstract List<A> actions();
	
	protected abstract V getThis();
	
	protected abstract V neighbor(A a);
	
	/**
	 * @param a Acci&oacute;n
	 * @return La arista que lleva al vecino siguiendo esta acci&oacute;n
	 */
	protected abstract E getEdge(A a);
	
	private Set<V> neighbors = null;
	private Set<E> edges = null;
	

	@Override
	public Set<V> getNeighborListOf() {
		if (this.neighbors==null) {
			this.neighbors=actions()
					.stream()
					.map(a->this.neighbor(a))
					.collect(Collectors.toSet());
		}
		return this.neighbors;
	}

	@Override
	public Set<E> edgesOf() {
		if (this.edges==null) {
			this.edges= actions()
					.stream()
					.map(a->this.getEdge(a))
					.collect(Collectors.toSet());				
		}
		return edges;
	}

	@Override
	public boolean isNeighbor(V e) {
		return this.getNeighborListOf().contains(e);
	}

	
}
