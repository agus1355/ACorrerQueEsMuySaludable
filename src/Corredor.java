
public class Corredor {
	private String sexo;
	private int edad;
	private int nroId;

	public Corredor(int id,int edad, String sexo) {
		this.edad = edad;
		this.sexo = sexo;
		this.nroId = id;
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

	
	@Override
	public String toString() {
		return this.nroId + " ";
	}

//	@Override
//	public String toString() {
//		return "Corredor [sexo=" + sexo + ", edad=" + edad + ", nroId=" + nroId + ", ordenLlegada=" + ordenLlegada
//				+ "]";
//	}

}
