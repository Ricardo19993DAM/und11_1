package und11;

public class Alumno implements Comparable <Alumno> {
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private int clasificacion;
	private int annio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}
	public int getAnnio() {
		return annio;
	}
	public void setAnnio(int annio) {
		this.annio = annio;
	}
	public Alumno(String nombre, String apellido, String dni, int edad, int clasificacion, int annio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.clasificacion = clasificacion;
		this.annio = annio;
	}
	public Alumno() {
		super();
	}
	public void setDatos() {
		System.out.println("Introduce nombre: ");
		nombre=Util.introducirCadena();
		System.out.println("Itroduce apellido: ");
		apellido=Util.introducirCadena();
		System.out.println("Introduce DNI: ");
		dni=Util.introducirCadena();
		System.out.println("Introduce edad: ");
		edad=Util.leerInt();
		System.out.println("Introduce clasificacion: ");
		clasificacion=Util.leerInt();
		System.out.println("Introduce año: ");
		annio=Util.leerInt();
	}
	@Override
	public int compareTo(Alumno a) {
		return apellido.compareToIgnoreCase(a.getApellido());
	}
	public void getDatos() {
		System.out.println(nombre+" "+apellido+" "+dni+" "+edad+" "+clasificacion+" "+annio);
	}

}
