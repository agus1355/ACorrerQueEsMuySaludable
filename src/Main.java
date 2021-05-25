import java.util.List;

public class Main {
	public static void main(String[] args) {
		Archivo a = new Archivo();
		
		List<String> datos = a.leer("in\\caso_pdf.in");
		
		Competencia c = new Competencia(datos);
		
		System.out.println(c.obtenerPodios());
	}
}
