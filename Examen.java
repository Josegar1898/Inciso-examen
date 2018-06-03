package CONCEPTOBS;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import nuevo1.Cola;
import nuevo1.Muestras;


public class Examen {
	public static void main(String[]args) throws IOException {
		Cola co= new Cola();
		Examen x = new Examen();
		Muestras md = new Muestras();
		Scanner sc = new Scanner(System.in);
		try {
		RandomAccessFile raf = new RandomAccessFile("datos.dat","rw");
		RandomAccessFile raf2 = new RandomAccessFile("historicoAtendigos.dat","rw");
		long actual,fin;
		
			actual= raf.getFilePointer();
			fin   = raf.length();
			
			while(actual!=fin) {
				
				System.out.println(raf.readInt());
				System.out.println(raf.readUTF());
				System.out.println(raf.readChar());
				md.setCodigo(raf.readInt());
				md.setNombre(raf.readUTF());
				
				System.out.println("la muestra ya fue procesada ingrese la letra a ");
				char c= sc.next().charAt(0);
				md.setEstatus(c);
				System.out.println("-------------");
				
				if(c=='a') {
					raf2.seek(raf2.length());
					raf2.writeInt(md.getCodigo());
					raf2.writeUTF(md.getNombre());
					raf2.writeChar(c);
					co.insertar(md);
				}else {
					System.out.println("atender el caso los mas antes posible");
				}
				actual= raf.getFilePointer();
			}
			System.out.println("");
			raf.close();
			raf2.close();
		}catch(Exception e) {
			System.out.println("no se pudo abrir el archivo de datos ");
		}
		x.cuerpo();
		
	}
	
	
	public void  cuerpo() throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while (opcion < 1 || opcion > 2) {
			System.out.println("Laboratorios angel ");
			System.out.println("bienvenido al sistema de registo ");
			System.out.println("----------------------------------");
			System.out.println("2...........iniciar el proceso");
			opcion = sc.nextInt();
		}
		int salir = 0;
		Muestras ms = new Muestras();
		
		Cola cola = null;
		do {
			System.out.println("1 .......... Insertar");
			System.out.println("2 .......... Eliminar");
			System.out.println("3 .......... Listar");
			System.out.println("4 .......... Vaciar");
			System.out.println("0 .......... salir del aplicativo");
			System.out.println("ingrese opcion a realizar");
			salir = sc.nextInt();
			
			if (cola == null && opcion == 2) {
				cola = new Cola();
			}
			switch (salir) {
			case 0:
				System.out.println("");
				break;
			case 1:
				int op=0;
				while(op!=1) {
				System.out.println("Ingrese el dato a agregar: ");
				System.out.println("ingrese codigo");
				ms.setCodigo(sc.nextInt());
				sc.nextLine();
				System.out.println("ingrese nombre de la muestra");
				ms.setNombre(sc.nextLine());
				char st = 's';
				ms.setEstatus(st);
				if (opcion == 2) {
					
					cola.insertar(ms);
					System.out.println("desea salir");
					op=sc.nextInt();
				}
				}
				break;
			case 2:
				
					cola.quitar();
				
				break;
			case 3:
				
					cola.listar();
				
				break;
			case 4:
				
					cola.vaciar();
				
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (salir != 0);
}



	}

