package us.lsi.astar;


import org.jgrapht.Graph;

public interface AStarGraph<V, E> extends Graph<V,E> {
	
	/**
	 * @param edge es una arista
	 * @return El peso de edge
	 */
	default double getEdgeWeight(E edge) {
		return 1.;
	}
	/**
	 * @param vertex es el v�rtice actual
	 * @return El peso de vertex
	 */
	default double getVertexWeight(V vertex) {
		return 0.;
	}
	/**
	 * @param vertex El v�rtice actual
	 * @param edgeIn Una arista entrante o incidente en el v�rtice actual. Es null en el v�rtice inicial.
	 * @param edgeOut Una arista saliente o incidente en el v�rtice actual. Es null en el v�rtice final.
	 * @return El peso asociado al v�rtice suponiendo las dos aristas dadas. 
	 */
	default double getVertexWeight(V vertex, E edgeIn, E edgeOut) {
		return 0.;
	}
	
	
}
