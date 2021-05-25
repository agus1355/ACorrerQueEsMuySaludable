import java.util.ArrayList;
import java.util.List;

public class TipoCategoria {
	private List<Categoria> categorias;
	
	public TipoCategoria(List<String> datos,int nroRegistro,int cantCat) {
		String [] array;
		int edadMin;
		int edadMax;
		
		this.categorias = new ArrayList<Categoria>(cantCat);
		
		for (int i = 0; i < cantCat; i++) {
			
			array = datos.get(nroRegistro).split(" ");
			edadMin = Integer.valueOf(array[0]);
			edadMax = Integer.valueOf(array[1]);
			
			this.categorias.add(new Categoria(i+1,edadMin,edadMax));
			nroRegistro++;
		}
	}
	
	public void agregarCorredor(Corredor c)
	{
		if(c.getOrdenLlegada() == 0)
			return;
		for (Categoria categoria : categorias) {
			if(categoria.agregarCorredor(c) == true)
				return;
		}
	}
	
	@Override
	public String toString() {
		String categorias = "";
		
		for (Categoria categoria : this.categorias) {
			categorias += categoria + "\n";
		}
		
		return categorias;
	}
}
