package clases;

public class Fecha {
	
	int dd;
	int mm;
	int aa;
	
	public Fecha(int dd, int mm, int aa) {
		
		this.dd=dd;
		this.mm=mm;
		this.aa=aa;
		
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

	@Override
	public String toString() {
		return "Fecha [dd=" + dd + ", mm=" + mm + ", aa=" + aa + ", getDd()=" + getDd() + ", getMm()=" + getMm()
				+ ", getAa()=" + getAa() + "]";
	}
	
	

}
