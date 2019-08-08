package us.lsi.pd.numerodearboles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Preconditions;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.ProblemaPD;

public class NumeroDeArbolesBinarios implements ProblemaPD<Integer, Integer,NumeroDeArbolesBinarios> {

	public static NumeroDeArbolesBinarios create(Integer nv) {
		return new NumeroDeArbolesBinarios(nv);
	}

	private Integer nv;	
	
	private NumeroDeArbolesBinarios(Integer nv) {
		super();
		this.nv = nv;
	}
	
	public Integer getNv() {
		return nv;
	}

	@Override
	public us.lsi.pd.AlgoritmoPD.Tipo getTipo() {
		return AlgoritmoPD.Tipo.Sum;
	}

	@Override
	public int size() {
		return this.nv;
	}

	@Override
	public boolean esCasoBase() {
		return this.nv == 0;
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(null, 1.);
	}

	@Override
	public NumeroDeArbolesBinarios getSubProblema(Integer a, int np) {
		Preconditions.checkArgument(np<2);
		NumeroDeArbolesBinarios r = null;
		if(np==0){
			r = NumeroDeArbolesBinarios.create(a);
		} else if(np==1){
			r = NumeroDeArbolesBinarios.create(this.nv-a-1);
		}
		return r;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		return Sp.create(a, ls.get(0).valorDeObjetivo*ls.get(1).valorDeObjetivo);
	}

	@Override
	public List<Integer> getAlternativas() {
		return IntStream.range(0, nv).boxed().collect(Collectors.toList());
	}

	@Override
	public int getNumeroSubProblemas(Integer a) {
		return 2;
	}

	@Override
	public Integer getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return null;
	}

	@Override
	public Integer getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> ls) {
		return null;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nv == null) ? 0 : nv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NumeroDeArbolesBinarios))
			return false;
		NumeroDeArbolesBinarios other = (NumeroDeArbolesBinarios) obj;
		if (nv == null) {
			if (other.nv != null)
				return false;
		} else if (!nv.equals(other.nv))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NumeroDeArbolesBinarios [nv=" + nv + "]";
	}

}
