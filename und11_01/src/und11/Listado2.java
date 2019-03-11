package und11;

public class Listado2{
	private String tipo;



	private int cont=0;
	private int edad;
	public Listado2(int cont, int edad) {
		super();
		this.cont = cont;
		this.edad = edad;
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public int getEdad() {
		return edad;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Listado2() {
		super();
	}
	public void masCont() {
		cont++;
	}

	public float getMedia() {
		return (float)edad/cont;
	}
	public void masEdad(int e) {
		edad=this.edad+e;
	}

}
