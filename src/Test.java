import java.util.Scanner;

public class Test {

	static Scanner sc;
	static GestionarLlistes gestorVehicles;
	public static void main(String[] args) {
	boolean bandera=true;
		int i;
		sc = new Scanner(System.in);
		gestorVehicles=new GestionarLlistes();
		do{
			System.out.println("Escull una opció de les següents:");
			System.out.println("1.- Afegir vehicle Terrestre.");
			System.out.println("2.- Afegir vehicle Marítim.");
			System.out.println("3.- Afegir vehicle aeri.");
			System.out.println("4.- Capturar les dades del personal.");
			System.out.println("5.- Assignar personal disponible als vehicles.");
			System.out.println("6.- Mostrar les dades dels vehicles.");
			System.out.println("0.- Sortir");
			
		    i = sc.nextInt();
		    switch (i){
		    case 1:  gestorVehicles.afegirVehicle(i);break;
		    	
		    case 2:  gestorVehicles.afegirVehicle(i);break;
		    	
		    case 3:  gestorVehicles.afegirVehicle(i);break;
		    
		    case 4:  
		    	if(bandera){
		    	gestorVehicles.ActivarUsuaris("Carlos");
		    	gestorVehicles.ActivarUsuaris("Joan");
		    	gestorVehicles.ActivarUsuaris("Loli");
		    	gestorVehicles.ActivarUsuaris("Manel");
		    	bandera=false;}else{
		    		System.out.println("Ja em introduit al personal al sistema.");
		    	}
		    break;
		    
		    case 5: gestorVehicles.assignarUsuris(); break;
		    
		    case 6: gestorVehicles.mostrarInformacioVehicles();break;
		    }
		}while (i!=0);	
		
	}
}
