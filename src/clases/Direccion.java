package clases;

public class Direccion {
	
	String calle;
	int noCalle;
	String nomenclatura;
	String barrio;
	String ciudad;
	
	public Direccion(String calle, int noCalle, String nomenclatura, String barrio, String ciudad) {
		
		this.calle=calle;
		this.noCalle=noCalle;
		this.nomenclatura=nomenclatura;
		this.barrio=barrio;
		this.ciudad=ciudad;
		
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNoCalle() {
		return noCalle;
	}

	public void setNoCalle(int noCalle) {
		this.noCalle = noCalle;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [Calle=" + calle + ", noCalle=" + noCalle + ", nomenclatura=" + nomenclatura + ", barrio="
				+ barrio + ", ciudad=" + ciudad + "]";
	}
	
	
	
	
}
