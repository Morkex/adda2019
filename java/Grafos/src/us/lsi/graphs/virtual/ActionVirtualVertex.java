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
public abstract class ActionVirtualVertex<V extends VirtualVertex<V,E>, E extends SimpleEdge<V>, A> implements VirtualVertex<V,E> {

	public ActionVirtualVertex() {
	}
	
	/**
	 * @return Si es un valor v�lido del tipo
	 */
	public abstract Boolean isValid();
	
	/**
	 * Para ser implementado por el subtipo
	 * @return Lista de acciones disponibles y adecuadas para alcanzar un v�rtice v�lido
	 */
	protected abstract List<A> actions();
	
	/**
	 * @param a Una acci&oacute;n
	 * @return El vecino del v&eacute;rtice siguiendo esa acci&oacute;n
	 * @pre La acci�n a debe ser aplicable
	 * @post El v�rtice retornada debe ser distinto al original y v�lido
	 */
	protected abstract V neighbor(A a);
	
	/**
	 * Este m�todo debe ser sobrescrito en la clase que refine el tipo
	 * @param a Acci&oacute;n
	 * @return La arista que lleva al vecino siguiendo esta acci&oacute;n
	 */
	@SuppressWarnings("unchecked")
	public E getEdgeFromAction(A a) {
		V v = this.neighbor(a);
		return (E) ActionSimpleEdge.of(this,v,a);
	}
	
	private Set<V> neighbors = null;
	private Set<E> edges = null;
	
	/**
	 * Este m�todo podr�a ser sobrescrito en la clase que refine al tipo
	 * @param v Otro v�rtice
	 * @return La arista desde this a v2
	 */
	@Override
	public E getEdge(V v) {
		E edge = null;
		if (this.isNeighbor(v)) {
			edge = this.edgesOf()
					.stream()
					.filter(e->e.getSource().equals(v) || e.getTarget().equals(v))
					.findFirst()
					.get();
		}
		return edge;
	}

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
					.map(a->this.getEdgeFromAction(a))
					.collect(Collectors.toSet());				
		}
		return edges;
	}

	@Override
	public Boolean isNeighbor(V e) {
		return this.getNeighborListOf().contains(e);
	}
	
}
