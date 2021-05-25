import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Competencia {
	private Map<Integer,Corredor> corredores;
	private TipoCategoria categoriasF;
	private TipoCategoria categoriasM;
	
	public Competencia(List<String> datos) {

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
		
		
		this.determinarOrdenLlegada(nroRegistro+cantCorredores, cantFinal, datos);
		this.insertarCorredoresEnOrden(nroRegistro, cantCorredores, datos);
		
		//System.out.println(this.corredores);
	}
	
	private void determinarOrdenLlegada(int nroRegistro,int cant,List<String> datos)
	{
		int ordenLlegada;
		for (int i = 0; i < cant; i++) {
			ordenLlegada = Integer.valueOf(datos.get(nroRegistro));
			this.corredores.put(ordenLlegada, null);
			nroRegistro++;
		}
	}
	
	private void insertarCorredoresEnOrden(int nroRegistro,int cant,List<String> datos)
	{
		String[] array;
		String sexo;
		int edad;
		
		for (int i = 0; i < cant; i++) {
			array = datos.get(nroRegistro).split(" ");
			edad = Integer.valueOf(array[0]);
			sexo = array[1];
			if(this.corredores.containsKey(i+1))
				this.corredores.put(i+1,new Corredor(i+1,edad,sexo));
			nroRegistro++;
		}
	}
	
	public String obtenerPodios()
	{
		for (Corredor corredor : this.corredores.values()) {
			if(corredor.getSexo().equals("M") == true)
				this.categoriasM.insertarEnCategoria(corredor);
			else
				this.categoriasF.insertarEnCategoria(corredor);
		}
		return this.categoriasF + "" + this.categoriasM;
	}
}
