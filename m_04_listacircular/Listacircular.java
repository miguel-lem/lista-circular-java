package m_04_listacircular;

public class Listacircular {
	Nodo cabeza;
	public Listacircular() {
		//lo inicializo en nulo el valor de la cabeza
		this.cabeza=null;
	}
	
	//funcion para insertar datos en la lista
	public void insertar(int dato) {
		Nodo nodo = new Nodo(dato);
		if(cabeza==null) {
			cabeza=nodo;
		}else {
			nodo.siguiente = cabeza.siguiente;
			//es decir tengo 5 y su apuntador que es a si mismo de acuerdo al diseño de la clase nodo
			//igreso 6 y como al venir se apunta a si mismo, quiero que su apuntado 6.siguiente vaya a 5.siguiente
			//entonces 6-->5
			cabeza.siguiente = nodo;
			//cabeza vale 5 le digo que 5.siguiente apunte a 6 
		}
	}
	
	//funcion para poder saber si existe un numero en la lista
	public int existenumero(int numero) {
		//cargo la lista en una nueva
		Nodo auxiliarNodo = cabeza.siguiente;
		if (auxiliarNodo==null) {
			//si esta vacia me retorna cero
			return 0;
		}else {
			do {
				if(auxiliarNodo.getDato()==numero) {
					//compara los valores en busca y si lo encuentra me retorna 1
					return 1;
				}
				//le hago recorrer con el puntero de siguiente
				auxiliarNodo=auxiliarNodo.siguiente;
			}
			//este bucle se ejecuta mientras no sea igual a la cabeza, ya que por ser circular creamos un dato de partida
			while(auxiliarNodo!=cabeza.siguiente);
			//si no lo a encontrado igual me retorna cero
			return 0;
		}
	}
	
	//funcion para pdoer ver cual es el siguiente de un numero
	public void siguientedenumero(int numero) {
		//cargo los datos en una nueva lista
		Nodo auxiliarNodo = cabeza.siguiente;
		//comrpuebo si la lista lo contiene a ese numero
		if(existenumero(numero)==1) {
			do {
				//recorro la lista en busca del valor
				if(auxiliarNodo.getDato()==numero) {
					//si lo encuentra debo imprimir el apuntador a siguiente ya que ese dato necesito
					System.out.println("el numero ["+numero+"] apunta en su siguiente a ["+auxiliarNodo.siguiente.getDato()+"]");
					//cumplida la labor le digo que me retorne
					return;
				}
				//debo recorrer el nodo con su puntero a siguiente
				auxiliarNodo=auxiliarNodo.siguiente;
			}while(auxiliarNodo!=cabeza.siguiente);
		}
		else {
			System.out.println("no existe el numero dentro de la lista");
		}
	}
	
	//funcion para editar un numero dentro de la lista
	public void editarnumero(int numero,int dato) {
		//creo el nuevo nodo con el dato que me envian
		Nodo nodo = new Nodo(dato);
		//cargo los datos en un nuevo nodo
		Nodo auxiliar = cabeza.siguiente;
		//compruebo que exista el numero dentro de la lista
		if(existenumero(numero)==1) {
			do {
				if(auxiliar.getDato()==numero) {
					//si al comparar el dato ya lo encuentra que lo reemplace
					auxiliar.setDato(nodo.getDato());
					//hecho el trabajo le digo que se salga de la funcion
					return;
				}
				//recorro con el apuntador de la lista
				auxiliar=auxiliar.siguiente;
				//en el while le digo que cuando aya girado otra vez se van a parecer entonces alli termine de girar
			}while(auxiliar!=cabeza.siguiente);
		}
		else {
			System.out.println("no existe el numero");
		}
	}
	
	//funcion para medir el tamaño de la lista
	public int tamanio() {
		//en esta funcion lo que hago es recorrer toda la lista y el contador ir aumentando
		//luego hago regresar el valor que acumule
		int contador = 0;
		if(cabeza==null) {
			return 0;
		}else {
			Nodo auxiliaNodo = cabeza.siguiente;
			do {
				contador++;
				auxiliaNodo=auxiliaNodo.siguiente;
			}while(auxiliaNodo!=cabeza.siguiente);
			return contador;
		}
	}
	
	//funcion para eliminar un elemento
	public void eliminar(int numero) {
		//compruebo si existe el numero dentro de la lista
		if(existenumero(numero)==1) {
			//cargo la cabeza con una posicion adelante en el auxiliar
			Nodo auxiliarNodo = cabeza.siguiente;
			//en el auxiliar 2 le cargo normal, porque quiero que dentro del bucle vaya una posicion por detras
			//del aux para asi cambiar el apuntador
			Nodo auxiliar2 = cabeza;
			//si hay un solo elemento entonces no queda mas para aliminar
			if(tamanio()==1) {
				cabeza=null;
				return;
			}else {
				//estos dos int es para controlar cuando quieran eliminar la cabeza y no permitirle porque es la referencia
				//mientras ayan datos
				int cantidad=0;
				int tamanio=tamanio();
				do {
					cantidad++;
					if(auxiliarNodo.getDato()==numero) {
						//cuando lo encuentra le cambio el apuntador del que viene atras
						//hacia el siguiente de la posicion y asi le elimino al nodo
						auxiliar2.siguiente=auxiliarNodo.siguiente;
						//luego igualo el aux1 con el aux2
						auxiliarNodo=auxiliar2;
						//terminado el trabajo le regreso
						return;
					}
					//movimiento de posiciones para el que va atras
					auxiliar2 = auxiliar2.siguiente;
					//movimiento de posiciones para el que va adelante
					auxiliarNodo=auxiliarNodo.siguiente;
					//control en caso de que quieran eliminar la cabeza
					if(auxiliarNodo.getDato()==numero && cantidad == (tamanio-1)) {
						System.out.println("La cabeza no puedes eliminar mientras hay otros elementos aun");
					}
					//control de condicion para terminar de recorrer la lista
				}while(auxiliarNodo!=cabeza);
			}
		}else {
			System.out.println("no existe ese numero dentro de la lista");
		}
	}
	
	//funcion para leer los datos de la lista
	public void leerdatos() {
		if(cabeza==null) {
			System.out.println("la lista circular esta vacia");
		}else {
			//cargo la lista en una nueva
			Nodo auxiliarNodo = cabeza.siguiente;
			//imprimo la referencia para saber quien es la cabeza
			System.out.println("la cabeza vale: "+cabeza.getDato());
			do {
				//recorro los datos e imprimo cada uno
				System.out.print("["+auxiliarNodo.getDato()+"]"+"-->");
				//hago que el apuntador señale al siguiente
				auxiliarNodo=auxiliarNodo.siguiente;
			}while(auxiliarNodo!=cabeza.siguiente);
		}
	}
	
}
