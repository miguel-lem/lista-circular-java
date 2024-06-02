package m_04_listacircular;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listacircular listacircular = new Listacircular();
		Scanner teclado = new Scanner(System.in);
		int paso;
		int interno;
		do {
			System.out.println("------Opciones------");
			System.out.println("1 para poder ingresar datos en la lista circular");
			System.out.println("2 si desea saber a quien apunta un numero");
			System.out.println("3 si desea editar un numero");
			System.out.println("4 eliminar un numero de la lista");
			System.out.println("0 si desea salir del programa");
			paso = teclado.nextInt();
			switch (paso) {
				case 1:
					do {
						System.out.println("");
						System.out.println("Ingrese elementos en la lista");
						int dato = teclado.nextInt();
						listacircular.insertar(dato);
						System.out.println("Datos almacenados");
						listacircular.leerdatos();
						System.out.println("");
						System.out.println("1 si desea continuar, 0 si desea salir");
						interno = teclado.nextInt();
						System.out.println("");
					}while(interno!=0);
					break;
				case 2:
					do {
						System.out.println("");
						System.out.println("Ingrese el numero del cual quiere saber quien es su siguiente");
						int dato = teclado.nextInt();
						listacircular.siguientedenumero(dato);
						System.out.println("Datos almacenados");
						listacircular.leerdatos();
						System.out.println("");
						System.out.println("1 si desea continuar, 0 si desea salir");
						interno = teclado.nextInt();
						System.out.println("");
					}while(interno!=0);
					break;
				case 3:
					do {
						System.out.println("");
						System.out.println("Ingrese el numero que quiere editar");
						int numero = teclado.nextInt();
						System.out.println("Ingrese el nuevo numero");
						int dato = teclado.nextInt();
						listacircular.editarnumero(numero, dato);
						System.out.println("Datos almacenados");
						listacircular.leerdatos();
						System.out.println("");
						System.out.println("1 si desea continuar, 0 si desea salir");
						interno = teclado.nextInt();
						System.out.println("");
					}while(interno!=0);
					break;
				case 4:
					do {
						System.out.println("");
						System.out.println("Ingrese el numero que quiere eliminar");
						int numero = teclado.nextInt();
						listacircular.eliminar(numero);
						System.out.println("Datos almacenados");
						listacircular.leerdatos();
						System.out.println("");
						System.out.println("1 si desea continuar, 0 si desea salir");
						interno = teclado.nextInt();
						System.out.println("");
					}while(interno!=0);
					break;
			}
			System.out.println("");
			System.out.println("Tamaño de la lista: "+listacircular.tamanio());
			System.out.println("");
		}while(paso!=0);
		teclado.close();
	}

}
