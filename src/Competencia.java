import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Competencia {
	private Map<Integer,Corredor> corredores;
	private TipoCategoria categoriasF;
	private TipoCategoria categoriasM;
	
	public Competencia(List<String> datos) {
		
		int edad;
		String sexo;

		int nroRegistro = 0;
		String[] array = datos.get(nroRegistro++).split(" ");
		
		int cantCorredores = Integer.valueOf(array[0]);
		int cantCatF = Integer.valueOf(array[1]);
		int cantCatM = Integer.valueOf(array[2]);
		int cantFinal = Integer.valueOf(array[3]);;
		
		this.categoriasF = new TipoCategoria(datos,nroRegistro,cantCatF);
		nroRegistro += cantCatF;
		
		this.categoriasM = new TipoCategoria(datos,nroRegistro,cantCatM);
		nroRegistro += cantCatM;
		
		this.corredores = new LinkedHashMap<Integer,Corredor>();
		
		int iniRegCorredores = nroRegistro;
		nroRegistro += cantCorredores;
		
		int ordenLlegada;
		for (int i = 0; i < cantFinal; i++) {
			ordenLlegada = Integer.valueOf(datos.get(nroRegistro));
			this.corredores.put(ordenLlegada, null);
			nroRegistro++;
		}
		
		nroRegistro = iniRegCorredores;
		
		for (int i = 0; i < cantCorredores; i++) {
			array = datos.get(nroRegistro).split(" ");
			edad = Integer.valueOf(array[0]);
			sexo = array[1];
			if(this.corredores.containsKey(i+1))
				this.corredores.put(i+1,new Corredor(i+1,edad,sexo));
			nroRegistro++;
		}
		
		//System.out.println(this.corredores);
	}
	
	public String obtenerPodios()
	{
		for (Corredor corredor : this.corredores.values()) {
			if(corredor.getSexo().equals("M") == true)
				this.categoriasM.agregarCorredor(corredor);
			else
				this.categoriasF.agregarCorredor(corredor);
		}
		return this.categoriasF + "" + this.categoriasM;
	}
}
