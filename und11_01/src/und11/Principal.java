package und11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		ArrayList <Alumno>alumnos=new ArrayList <Alumno>();
		int opc;
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta(alumnos);
				break;
			case 2:
				listar(alumnos);
				break;
			case 3:
				Collections.sort(alumnos);
				listar(alumnos);
				break;
			case 4:
				alumnos.clear();
				break;
			case 5:
				borrar(alumnos);
				break;
			case 6:
				modificar(alumnos);
				break;
			case 7:
				listar2(alumnos);
				break;
			case 8:
				nomApe(alumnos);
				break;
			case 9:
				listar9(alumnos);
				break;
			}
		}while(opc!=10);


	}

	private static int menu() {
		System.out.println("//////////////////MENU/////////////////");
		System.out.println("1.alta");
		System.out.println("2.Listar alumnos");
		System.out.println("3.Ordenar");
		System.out.println("4.Borrar todos");
		System.out.println("5.Borrar alumno");
		System.out.println("6.Modificar alumno");
		System.out.println("7.Listar por annio");
		System.out.println("8.Mostrar por año");
		System.out.println("9.Tercer listado");
		System.out.println("10.Salir");
		return Util.leerInt(1,10);
	}

	private static void alta(ArrayList<Alumno> alumnos) {
		char opc;
		do {
			Alumno aux=new Alumno();
			aux.setDatos();
			alumnos.add(aux);
			System.out.println("Quieres introducir más alumnos?");
			opc=Util.respCharList("SN");
		}while(opc=='S');

	}

	private static void listar(ArrayList<Alumno> alumnos) {
		//For
		for(int i=0;i<alumnos.size();i++) {
			alumnos.get(i).getDatos();
		}
		//For-each
		/*
		 for(Alumno a:alumnos) {
			a.getDatos();
		}
		 */
		//iterartor
		/*
		Iterator<Alumno> al=alumnos.iterator();
		while(al.hasNext()) {
			al.next().getDatos();
		}
		 */
		//List Iterator
		/*
		ListIterator<Alumno> al=alumnos.listIterator();
		while(al.hasNext()) {
			al.next().getDatos();
		}
		 */

	}

	private static void borrar(ArrayList<Alumno> alumnos) {

		System.out.println("Introduce dni: ");
		String auxDni=Util.introducirCadena();
		//For-each
		/*for(Alumno a:alumnos) {
			if(a.getDni().equalsIgnoreCase(x)) {
				alumnos.remove(alumnos.indexOf(a));
				System.out.println("Alumno eliminado");
				break;
			}
		}*/
		//ListIterator
		ListIterator<Alumno>al=alumnos.listIterator();
		while(al.hasNext()) {
			Alumno aux=al.next();
			if(aux.getDni().equalsIgnoreCase(auxDni)) {
				System.out.println(aux.getNombre()+" "+aux.getApellido()+" "+aux.getClasificacion());
				System.out.println("Quieres borrarlo? (S/N)");
				char opc=Util.respCharList("SN");
				if(opc=='S') {
					al.remove();
					System.out.println("Alumno eliminado");
				}else {
					System.out.println("Alumno salvado");
				}
				
			}
		}


	}

	private static void modificar(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce dni: ");
		String auxDni=Util.introducirCadena();
		for(Alumno a:alumnos) {
			if(a.getDni().equalsIgnoreCase(auxDni)) {
				a.getDatos();
				System.out.println("Queires modificar la clasificacion: ");
				char opc=Util.respCharList("SN");
				if(opc=='S') {
					a.setClasificacion(Util.leerInt());
				}

			}
		}

	}

	private static void listar2(ArrayList<Alumno> alumnos) {
		Alumno alu[]=new Alumno[alumnos.size()];
		alumnos.toArray(alu);
		for(int i=0;i<alumnos.size();i++) {
			for(int j=i+1;j<alumnos.size();j++) {
				if(alu[i].getAnnio()>alu[j].getAnnio()) {
					Alumno aux=alu[i];
					alu[i]=alu[j];
					alu[j]=aux;
				}
			}
		}
		for(Alumno al:alu) {
			al.getDatos();
		}

	}



	private static void nomApe(ArrayList<Alumno> alumnos) {
		boolean repe;
		ArrayList <Listado1>li=new ArrayList <Listado1>();
		for(int i=0;i<alumnos.size();i++) {
			repe=false;
			for(int j=0;j<li.size();j++) {
				if(alumnos.get(i).getAnnio()==li.get(j).getAnnio()) {
					repe=true;
				}
			}
			if(!repe) {
				Listado1 aux=new Listado1();
				aux.setAnnio(alumnos.get(i).getAnnio());
				ListIterator <Alumno> alu=alumnos.listIterator();
				while(alu.hasNext()) {
					Alumno auxAlu=alu.next();
					if(auxAlu.getAnnio()==aux.getAnnio()) {
						aux.addNombre(auxAlu.getNombre());

					}

				}
				li.add(aux);
			}
		}
		Collections.sort(li);
		for(Listado1 l:li) {
			System.out.println("Año "+l.getAnnio());
			l.muestraNombre();
			System.out.println("Total: "+l.getCont());
		}

	}

	private static void listar9(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce un año: ");
		int auxAnnio=Util.leerInt();
		Listado2 li[]=new Listado2[4];
		li[0]=new Listado2();
		li[1]=new Listado2();
		li[2]=new Listado2();
		li[3]=new Listado2();
		li[0].setTipo("Insuficiente");
		li[1].setTipo("Bien");
		li[2].setTipo("Notable");
		li[3].setTipo("Sobresaliente");
		for(Alumno a:alumnos) {
			if(a.getAnnio()==auxAnnio) {
				if(a.getClasificacion()<5) {
					li[0].masCont();
					li[0].masEdad(a.getEdad());
				}else if(a.getClasificacion()<6) {
					li[1].masCont();
					li[1].masEdad(a.getEdad());
				}else if(a.getClasificacion()<8) {
					li[2].masCont();
					li[2].masEdad(a.getEdad());
				}else if(a.getClasificacion()<=10) {
					li[3].masCont();
					li[3].masEdad(a.getEdad());
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<4;j++) {
				if(li[i].getMedia()>li[j].getMedia()) {
					Listado2 aux=li[i];
					li[i]=li[j];
					li[j]=aux;
				}
			}
		}
		System.out.println("Clasificacion     Edad Media");
		for(Listado2 l:li) {
			System.out.println(l.getTipo()+"  "+l.getMedia());
		}

	}

}
