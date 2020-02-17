package us.lsi.astar.jarras;

import us.lsi.graphs.virtual.ActionSimpleEdge;

public class EdgeJarras extends ActionSimpleEdge<VertexJarras,ActionJarras> {

	/**
	 * 
	 */

	/**
	 * @param c1 Un v�rtice
	 * @param c2 Un segundo v�rtice
	 * @param a Una acci�n
	 * @return Una arista del problema
	 */
	public static EdgeJarras create(VertexJarras c1, VertexJarras c2, ActionJarras a) {
		return new EdgeJarras(c1, c2, a);
	}

	private ActionJarras accion;

	public ActionJarras getAccion() {
		return accion;
	}

	private EdgeJarras(VertexJarras c1, VertexJarras c2, ActionJarras a) {
		super(c1, c2);
		this.accion = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof EdgeJarras))
			return false;
		EdgeJarras other = (EdgeJarras) obj;
		if (accion == null) {
			if (other.accion != null)
				return false;
		} else if (!accion.equals(other.accion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EdgeJarras [accion=" + accion + ", source=" + getSource()
				+ ", target=" + getTarget() + "]";
	}
	
	
	
}
