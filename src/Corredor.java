
public class Corredor implements Comparable<Corredor>{
	private String sexo;
	private int edad;
	private int nroId;
	private int ordenLlegada;

	public Corredor(int id,int edad, String sexo) {
		this.edad = edad;
		this.sexo = sexo;
		this.nroId = id;
		this.ordenLlegada = 0;
	}

	public int getEdad() {
		return edad;
	}

	public String getSexo() {
		return sexo;
	}
	
	public int getNroId()
	{
		return this.nroId;
	}
	
	public int getOrdenLlegada() {
		return this.ordenLlegada;
	}	

	public void setOrdenLlegada(int ordenLlegada) {
		this.ordenLlegada = ordenLlegada;
	}

	@Override
	public int compareTo(Corredor o) {
		return this.ordenLlegada - o.ordenLlegada;
	}
//
//	@Override
//	public String toString() {
//		return "Corredor [sexo=" + sexo + ", edad=" + edad + ", nroId=" + nroId + ", ordenLlegada=" + ordenLlegada
//				+ "]";
//	}
	
	@Override
	public String toString() {
		return this.nroId + " ";
	}

}
