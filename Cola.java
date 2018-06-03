package nuevo1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Cola {
	 private Nodo raiz, cima;
	    
	    public Cola() {
	        raiz = null;
	        cima = null;
	    }
	    
	    public boolean colaVacia (){
	        if (raiz == null)
	            return true;
	        else
	            return false;
	    }

	    public void insertar (Muestras dato) throws IOException
	    {
	    	RandomAccessFile raf = new RandomAccessFile("datos.dat","rw");
	    	raf.seek(raf.length());
	        Nodo nuevo = new Nodo(dato);        
	        nuevo.siguiente = null;
	        if (colaVacia ()) {
	            raiz = nuevo;
	            cima = nuevo;
	        } else {
	            cima.siguiente = nuevo;
	            cima = nuevo;
	            }
	        raf.writeInt(nuevo.elemento.getCodigo());
	        raf.writeUTF(nuevo.elemento.getNombre());
	        raf.writeChar(nuevo.elemento.getEstatus());
	        raf.close();
	    }

	    public Muestras quitar(){
	        if (colaVacia()) {
	        	System.out.println("La cola esta vacia");
	        	return null;
	        } 
	        Muestras aux = raiz.elemento;
	        if (raiz == cima){
	            raiz = null;
	            cima = null;
	        } else {
	            raiz = raiz.siguiente;
	        }
	        System.out.println("Dato eliminado: " + aux);
	        return aux;
	    }

	    public void listar() {
	        Nodo t = raiz;
	        while (t != null) {
	            System.out.println("Dato: " + t.elemento.getCodigo());
	            System.out.println("Dato: " + t.elemento.getNombre());
	            System.out.println("Dato: " + t.elemento.getClass());
	            t = t.siguiente;
	        }
	    }
	    
	    public void vaciar() {
			while (!colaVacia()) {
				raiz = raiz.siguiente;
			}
	    }
	    
}
