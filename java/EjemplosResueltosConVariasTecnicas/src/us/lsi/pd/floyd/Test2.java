package us.lsi.pd.floyd;


import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.views.IntegerMappingGraphView;
import us.lsi.pd.AlgunosTestsPD;
import us.lsi.pd.floyd.FloydPD.Alternativa;
import us.lsi.tiposrecursivos.Tree;

public class Test2 {

	public static void main(String[] args) {
		GrafoDelMapa g = GrafoDelMapa.create("./ficheros/andalucia.txt");
		
		System.out.println(g.getGraph());
		
		IntegerMappingGraphView<Ciudad,Carretera> gv = IntegerMappingGraphView.of(g.getGraph());
		
		Integer origen = gv.getIndex(Ciudad.ofName("Cadiz"));
		Integer destino = gv.getIndex(Ciudad.ofName("Almeria"));
		
		FloydPD<Ciudad,Carretera> p = FloydPD.create(origen,destino,gv);
		
		
		Tree<Alternativa> t = AlgunosTestsPD.test2(p);
		AlgunosTestsPD.test1(p,t);

	}

}
