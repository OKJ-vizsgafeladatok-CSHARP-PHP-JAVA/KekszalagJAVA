
public class Hajo {

	private int helyezes;
	private String kategoria;
	private String hajo;
	private String klub;
	private String kormanyos;
	private int nap;
	private int ora;
	private int perc;
	public Hajo(int helyezes, String kategoria, String hajo, String klub, String kormanyos, int nap, int ora,
			int perc) {
		super();
		this.helyezes = helyezes;
		this.kategoria = kategoria;
		this.hajo = hajo;
		this.klub = klub;
		this.kormanyos = kormanyos;
		this.nap = nap;
		this.ora = ora;
		this.perc = perc;
	}
	public int getHelyezes() {
		return helyezes;
	}
	public void setHelyezes(int helyezes) {
		this.helyezes = helyezes;
	}
	public String getKategoria() {
		return kategoria;
	}
	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}
	public String getHajo() {
		return hajo;
	}
	public void setHajo(String hajo) {
		this.hajo = hajo;
	}
	public String getKlub() {
		return klub;
	}
	public void setKlub(String klub) {
		this.klub = klub;
	}
	public String getKormanyos() {
		return kormanyos;
	}
	public void setKormanyos(String kormanyos) {
		this.kormanyos = kormanyos;
	}
	public int getNap() {
		return nap;
	}
	public void setNap(int nap) {
		this.nap = nap;
	}
	public int getOra() {
		return ora;
	}
	public void setOra(int ora) {
		this.ora = ora;
	}
	public int getPerc() {
		return perc;
	}
	public void setPerc(int perc) {
		this.perc = perc;
	}
	@Override
	public String toString() {
		return "Hajo [helyezes=" + helyezes + ", kategoria=" + kategoria + ", hajo=" + hajo + ", klub=" + klub
				+ ", kormanyos=" + kormanyos + ", nap=" + nap + ", ora=" + ora + ", perc=" + perc + "]";
	}
	
	
}
