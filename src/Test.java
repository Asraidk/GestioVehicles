
public class Test {
	//Static que usarem com clases per cridar els seus metodes
	static ComprovadorTipus sc;
	static GestionarLlistes gestorVehicles;
	public static void main(String[] args) {
		//Variables i instancias pera crear nuestro menu de trabajo
		boolean bandera=true;
		int i;
		sc = new ComprovadorTipus();
		gestorVehicles=new GestionarLlistes();
		/*Menu recurente en el que comprovamos el valor que introduce un usuario y llamaremos de la clase gestioLListas un metodo que
		usaremos para esa funcion que quiere el usuari
		*case1to3-> afegir vehicles/depend tipus
		*case4-> afegir els arxius propertiees
		*case5-> gestio de vehicles amb usuari els junten
		*case6-> mostrara tota la info de vehicle mes el su conductor adjuntat
		****case7 (por implementar el amfibio)*****
		*/
		do{
			System.out.println("+===========================================+");
			System.out.println("Escull una opció de les següents:");
			System.out.println("1.- Afegir vehicle Terrestre.");
			System.out.println("2.- Afegir vehicle Marítim.");
			System.out.println("3.- Afegir vehicle aeri.");
			System.out.println("4.- Capturar les dades del personal.");
			System.out.println("5.- Assignar personal disponible als vehicles.");
			System.out.println("6.- Mostrar les dades dels vehicles.");
			System.out.println("0.- Sortir");
			System.out.println("+===========================================+");
			
		    i = sc.comprovarInt();
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
		    	System.out.println("Personal introduit satisfactoriament.");//conforme em introduit
		    	bandera=false;}else{
		    		System.out.println("Ja em introduit al personal al sistema anteriorment.");//si ja els tenim posat o diem
		    	}
		    break;
		    
		    case 5: gestorVehicles.assignarUsuris(); break;
		    
		    case 6: gestorVehicles.mostrarInformacioVehicles();break;
		    case 7:  gestorVehicles.afegirVehicle(i);break;
		    }
		}while (i!=0);			
	}
}
