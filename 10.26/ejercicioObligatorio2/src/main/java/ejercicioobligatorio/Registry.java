package ejercicioobligatorio;

import javax.xml.bind.annotation.*;

/**
 * 
 * @author Dani Dom
 * 
 * 
 */
@XmlRootElement(name = "registro")
@XmlType(propOrder = { "date", "tempMax", "tempMin" })
@XmlAccessorType(XmlAccessType.FIELD)

public class Registry {
	/** Record date */
	@XmlElement(name = "fecha")
	private String date;
	/** Record Max temperature */
	@XmlElement(name = "Maxima")
	private int tempMax;
	/** Record Min temperature */
	@XmlElement(name = "Minima")
	private int tempMin;

	/**
	 * Constructor basico
	 */
	public Registry() {
	}
/**
 * Constructor con parametros
 * @param date
 * @param tempMax
 * @param tempMin
 */
	public Registry(String date, int tempMax, int tempMin) {
		this.date = date;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTempMax() {
		return tempMax;
	}

	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}

	public int getTempMin() {
		return tempMin;
	}

	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}

	@Override
	public String toString() {
		return "Fecha: " + date + ", temperatura Maxima: " + tempMax + ", temperatura Minima: " + tempMin;
	}
}
