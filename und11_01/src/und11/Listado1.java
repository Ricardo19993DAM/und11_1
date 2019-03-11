package und11;

import java.util.ArrayList;

public class Listado1 implements Comparable <Listado1> {
	private int annio;
	private ArrayList<String>nombres=new ArrayList <String>();
	public int getAnnio() {
		return annio;
	}
	public void setAnnio(int annio) {
		this.annio = annio;
	}
	public ArrayList<String> getNombre() {
		return nombres;
	}
	public void setNombre(ArrayList<String> nombre) {
		this.nombres = nombre;
	}

	public Listado1(int annio, ArrayList<String> nombre) {
		super();
		this.annio = annio;
		this.nombres = nombre;

	}
	public Listado1() {
		super();
	}
	public int getCont() {
		return nombres.size();
	}
	public void addNombre(String e) {
		nombres.add(e);
	}
	@Override
	public int compareTo(Listado1 arg0) {
		return annio-arg0.getAnnio();
	}
	public void muestraNombre() {
		for(String n:nombres) {
			System.out.println(n);
		}
	}
	
}
