
public class Rango {
	private int edadMin;
	private int edadMax;
	
	Rango(int edadMin,int edadMax)
	{
		this.edadMax = edadMax;
		this.edadMin = edadMin;
	}
	
	public boolean correspondeARango(Corredor c)
	{
		int edadCorredor = c.getEdad();
		return edadCorredor >= this.edadMin && edadCorredor <= this.edadMax; 
	}

	@Override
	public String toString() {
		return "Rango [edadMin=" + edadMin + ", edadMax=" + edadMax + "]";
	}
	
}
