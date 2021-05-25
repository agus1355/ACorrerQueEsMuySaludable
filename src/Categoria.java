import java.util.LinkedList;
import java.util.List;

public class Categoria {
	
	private Rango rango;
	private int numCat;
	private List<Corredor> podio;
	
	public Categoria(int id,int edadMin, int edadMax) {
		this.rango = new Rango(edadMin,edadMax);
		this.numCat = id;
		this.podio = new LinkedList<Corredor>();
	}

	public boolean agregarCorredor(Corredor c)
	{
		if(this.rango.correspondeARango(c) && this.podio.size() < 3 )
		{
			this.podio.add(c);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		int i = 0;
		String corredores = this.numCat + " ";
		for (Corredor corredor : podio) {
			corredores += corredor.getNroId() + " ";
		}
		
		while(i < (3 - podio.size()))
		{
			corredores += "0" + " ";
			i++;
		}
		
		return corredores;
	}
}
