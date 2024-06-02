package m_04_listacircular;

public class Nodo {
	//creo el dato
	int dato;
	//creo el dato de mismo que clase para pasarle los valores de apuntar
	Nodo siguiente;
	public Nodo(int dato) {
		//en el contructor debo apuntar hacia el dato que viene
		this.dato=dato;
		//y el otro le apunto hacia si mismo debido a que es una lista circular
		siguiente=this;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	

}
