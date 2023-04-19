package ejercicioobligatorio;

import java.util.Arrays;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Listado")
@XmlType(propOrder = { "registros" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Listado {

	@XmlElementWrapper(name = "Registros")
	@XmlElement(name = "Registro")
	private Registry[] registros;

	public Listado() {
		this.registros = new Registry[0];
	}

	public void nuevoRegistro(Registry nuevo) {
		registros = Arrays.copyOf(registros, registros.length + 1);
		registros[registros.length - 1] = nuevo;
	}

	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i < registros.length; i++) {
			cadena += registros[i]+"\n";
		}
		return cadena;
	}

}
