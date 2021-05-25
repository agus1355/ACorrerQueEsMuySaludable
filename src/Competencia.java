import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Competencia {
	private List<Corredor> corredores;
	//private List<Categoria> categoriasF;
	//private List<Categoria> categoriasM;
	private TipoCategoria categoriasF;
	private TipoCategoria categoriasM;
	
	public Competencia(List<String> datos) {
		
		int nroRegistro = 0;
		
		String[] array = datos.get(nroRegistro++).split(" ");
		
		int cantCorredores = Integer.valueOf(array[0]);
		int cantCatF = Integer.valueOf(array[1]);
		int cantCatM = Integer.valueOf(array[2]);
		int cantFinal = Integer.valueOf(array[3]);;
		int edad;
		String sexo;
		
		this.categoriasF = new TipoCategoria(datos,nroRegistro,cantCatF);
		nroRegistro += cantCatF;
		
		this.categoriasM = new TipoCategoria(datos,nroRegistro,cantCatM);
		nroRegistro += cantCatM;
		
		this.corredores = new ArrayList<Corredor>(cantCorredores);
		
		for (int i = 0; i < cantCorredores; i++) {
			array = datos.get(nroRegistro).split(" ");
			edad = Integer.valueOf(array[0]);
			sexo = array[1];
			
			this.corredores.add(new Corredor(i+1,edad,sexo));
			nroRegistro++;
		}
		
		int ordenLlegada;
		for (int i = 0; i < cantFinal; i++) {
			array = datos.get(nroRegistro).split(" ");
			ordenLlegada = Integer.valueOf(array[0]);
			this.corredores.get(ordenLlegada-1).setOrdenLlegada(i+1);
			nroRegistro++;
		}
		
	}
	
	public String obtenerPodios()
	{
		Collections.sort(this.corredores);
		for (Corredor corredor : this.corredores) {
			if(corredor.getSexo().equals("M") == true)
				this.categoriasM.agregarCorredor(corredor);
			else
				this.categoriasF.agregarCorredor(corredor);
		}
		return this.categoriasF + "" + this.categoriasM;
	}
}
