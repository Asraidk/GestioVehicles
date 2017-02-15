import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

public class GestionarLlistes {
	//llistas que necesitem
	private ComprovadorTipus lectorTipus= new ComprovadorTipus();
	private ArrayList<Vehicle> llistaVehicles= new ArrayList<Vehicle>();
	private ArrayList<Personal> llistaPersonal= new ArrayList<Personal>();
	//private int contadorPersonal=0;
	//METODES PER EL TRACTAMENT DE L?INTRODUICIO DELS VEHICLES DELS DIFERENTS TIPUS\\
	
	//metode cridat desde el menu el qual cridar metodes que posibilitaran l'entrada de dades per teclat
	//per par del usuari, ames de comprovar tipus, depenen de el tipus que arribi es cridaran un dels 3 metodes 
	//que generen el objecte vehicle
	public void afegirVehicle(int tipusEscollit){
		//variables que comparteixen tots els vehicles
		double consumMinim;
		double carregaActual;
		double capacitatMaxima;
		double consumPerKilometre;
		char tipusVehicle;
		String identificador;
		double velocitatMitja;
		String idTripulant;
		/** Lecturas de teclat!! */
		consumMinim=lectorTipus.comprovarDouble("Digues el consum minim del vehicle: ");		
		capacitatMaxima=lectorTipus.comprovarDouble("Digues la carrega maxima: ");		
		carregaActual=lectorTipus.comprovarDouble("Digues la carrega actual: ");		
		consumPerKilometre=lectorTipus.comprovarDouble("Posa el consum per kilometre del vehicle: ");		
		identificador=lectorTipus.comprovarString("Identificador del vehicle: ");		
		velocitatMitja=lectorTipus.comprovarDouble("Velocitat mitja del vehicle: ");		
		idTripulant="";
		//menu per determinar si el vehicle es T, A o M
		switch (tipusEscollit){
			case 1: 
				tipusVehicle='T';
				afegirTerrestre(consumMinim,carregaActual,capacitatMaxima,consumPerKilometre,tipusVehicle,identificador,
						velocitatMitja, idTripulant);
				break;
			case 2: 
				tipusVehicle='M';
				afegirMaritim(consumMinim,carregaActual,capacitatMaxima,consumPerKilometre,tipusVehicle,identificador,
						velocitatMitja, idTripulant);
				break;
			case 3: 
				tipusVehicle='A';
				afegirAeri(consumMinim,carregaActual,capacitatMaxima,consumPerKilometre,tipusVehicle,identificador,
						velocitatMitja, idTripulant);
				break;
		}		
	}
	//metode cridat desde el metode general de vehicle, per genera e introduir a l'array list un vehicle de tipus terrestre
	private void afegirTerrestre(double consumMinim, double carregaActual, double capacitatMaxima,
			double consumPerKilometre, char tipusVehicle, String identificador, double velocitatMitja,
			String idTripulant) {
		//variables uniques per el terrestre
		int numeroCavalls;
		int numeroAveries;
		int costAveries;
		Vehicle tempVehicleTerrestre;
		/** lectures per el teclat amb la clase creada per les lecltures i comprovacions*/
		numeroCavalls=lectorTipus.comprovarInt("Digues le numero de caballs del vehicle: ");
		numeroAveries=lectorTipus.comprovarInt("Digues le numero d'averies del vehicle: ");
		costAveries=lectorTipus.comprovarInt("Digues el cost de les averies del vehicle: ");
		//control que es genera correctament el objecte
		try{
			tempVehicleTerrestre = new Terrestre(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,numeroCavalls,numeroAveries,costAveries);
			llistaVehicles.add(tempVehicleTerrestre);
			System.out.println("Vehicle del tipus terrestre introduit satisfactoriament");
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus terrestre, no sera introduit al sistema");
	    }		
	}
	//metode cridat desde el metode general de vehicle, per genera e introduir a l'array list un vehicle de tipus maritim
	private void afegirMaritim(double consumMinim, double carregaActual, double capacitatMaxima,
			double consumPerKilometre, char tipusVehicle, String identificador, double velocitatMitja,
			String idTripulant) {
		//variables per el tipus maritim
		String data;
		int eslora;
		int manega;
		int anyFlotacio;
		int dia=0;
		int mes=0;
		int any=0;
		boolean dataCorrecta=true;
		Vehicle tempVehicleMaritim;
		/** lectures per el teclat amb la clase creada per les lecltures i comprovacions*/
		eslora=lectorTipus.comprovarInt("Digues el numero d'eslora: ");
		manega=lectorTipus.comprovarInt("Digues el tamany de la manega: ");
		anyFlotacio=lectorTipus.comprovarInt("Quin va ser el any de flotacio: ");
		data=lectorTipus.comprovarString("Quina es la data de construcio !recorda mode (dd/mm/aaaa): ");
		//funcio java que trenca un string, amb el caracter que lindiquem-> meu cas trenquem per les /
		StringTokenizer st = new StringTokenizer(data,"/");
		try{
			dia=Integer.parseInt(st.nextToken());
			mes=Integer.parseInt(st.nextToken());
			any=Integer.parseInt(st.nextToken());
			dataCorrecta=lectorTipus.comprovarData(dia,mes,any);
		}catch(Exception e){
    	   dataCorrecta=false;
		}
		//si tot esta be intentarem afegui crea i afegui el objete
		if(dataCorrecta){
		try{
			tempVehicleMaritim = new Maritim(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,eslora,manega,anyFlotacio,dia,mes,any);
			llistaVehicles.add(tempVehicleMaritim);
			System.out.println("Vehicle del tipus maritim introduit satisfactoriament");
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus maritim, no sera introduit al sistema");
	    }	
		}else{
			System.out.println("Error al inicialitzar el vehicle del tipus maritim, no sera introduit al sistema");
			System.out.println("La data de construcio esta introduida incorectament");
		}
		
		
	}
	//metode cridat desde el metode general de vehicle, per genera e introduir a l'array list un vehicle de tipus aeri
	private void afegirAeri(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant) {
		//variables uniques del objecte aeri
		int numeroMotors;
		int tempsDeFuncionament;
		Vehicle tempVehicleAeri;
		/** lectures per el teclat amb la clase creada per les lecltures i comprovacions*/
		numeroMotors=lectorTipus.comprovarInt("Digues el numero de motors que te el vehicle");
		tempsDeFuncionament=lectorTipus.comprovarInt("Digues el temps de funcionament del vehicle");
		//si tot funciona introduirem el vehicle
		try{
			tempVehicleAeri = new Aeri(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,numeroMotors,tempsDeFuncionament);
			llistaVehicles.add(tempVehicleAeri);
			System.out.println("Vehicle del tipus aeri introduit satisfactoriament");
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus aeri, no sera introduit al sistema");
	    }	
		
	}
	//METODES PER CONTROLS DEL PERSONAL\\
	//metode que crida el menu de test donan quin es la ruta(mes o mensy) que te que utilitzar, nomes  conte un metode de crida
	public void ActivarUsuaris(String arxiuProperties) {
			lleguirArxiu(arxiuProperties);
	}
	//metode que conte la logica cridada per metode ativarUsuari, per tal de lleguir el archiu properties que tenim
	//y posar les dades del usuari al nostre clase personal
	private void lleguirArxiu(String arxiuProperties) {
		try {
			boolean dataCorrecta=true;
			int dia=0;
			int mes=0;
			int any=0;
			/**Creamos un Objeto de tipus Properties*/
			Properties propietats = new Properties();
    
			/**Carregem el arxi desde la ruta especificada*/
			propietats.load(new FileInputStream("C:/Users/Portatil/workspace/GestioVehicles/src/properties/"+arxiuProperties+".properties"));
 
			/**obtenim els parametres del arxiu*/
			String codi = propietats.getProperty("NIF");
			String nom = propietats.getProperty("nom");
			String especialitat = propietats.getProperty("especialitatVehicle");
			char especialitatParse= especialitat.charAt(0);
			/**boolean assignat = propietats.getProperty("assignat") != null; Tinc problemsa par agafar el false del propertyes y el forço al contructor**/
			String data = propietats.getProperty("dataNaixement");
			StringTokenizer st = new StringTokenizer(data,"/");

			try{
				dia=Integer.parseInt(st.nextToken());
				mes=Integer.parseInt(st.nextToken());
				any=Integer.parseInt(st.nextToken());
				dataCorrecta=lectorTipus.comprovarData(dia,mes,any);//metode per combrova les dates son correctas
			}catch(Exception e){
				dataCorrecta=false;
			}
			//si la data es coorecta, pasarem a introduir al Personal 
			if(dataCorrecta){
				Personal tempPersonal= new Personal(codi,nom,especialitatParse,false,dia,mes,any);
				llistaPersonal.add(tempPersonal);
			}else{
				System.out.println("Problemes en les dates que tenim en els arxius properties");
		    }
 
	  	} catch (FileNotFoundException e) {
		  		System.out.println("Error, El archivo no exite");
	  	} catch (IOException e) {
		  		System.out.println("Error, No se puede leer el archivo");
	  	}
	}
	//metode que ens serveix per fer l'assignacio de un objecte personal amb un objecte del tipus vehicle
	//utilitzem les id del usuari per relaciona els dos objectes
	public void assignarUsuris(){
		//part 1 recorem el array list de personal y agaem 1 objecte
		 for(int x=0;x<llistaPersonal.size();x++) {;
		    	Personal personaEnTractament = (Personal)llistaPersonal.get(x);
		    	//si no esta assignat encara, pasarem a intenta assignarlo
		    	if(personaEnTractament.isAssignat()==false){
		    		//recorem el array list del objectes vehicles i agafem un dels objectes
		    		for(int z=0;z<llistaVehicles.size();z++) {
		    	    	Vehicle vehicleTemporal = (Vehicle)llistaVehicles.get(z);
		    	    	//si es cumplex que el vechicle no te id, que el pesonal pot conduir aquell vehicle y l'usuari no estigui ja asignat posarem l'assignacio
		    	    	if(vehicleTemporal.getIdTripulant().equals("")&&(vehicleTemporal.getTipusVehicle()==personaEnTractament.getEspecialitatVehicle())
		    	    			&&(personaEnTractament.isAssignat()==false)){  	    		
		    	    	
		    	    		vehicleTemporal.setIdTripulant(personaEnTractament.getNIF());
		    	    		personaEnTractament.setAssignat(true);
		    	    		System.out.println("El conductor "+personaEnTractament.getNom()+" assignat al vehicle "+ vehicleTemporal.getIdentificador());
		    	    	}
		    	      }
		    		
		    	}else{
		    		System.out.println("El conductor "+personaEnTractament.getNom()+" ja esta assignat.");
		    	}
		    	
		 }	
	}
	//Metode per agafar un objecte del array list, y mostrar totas les informacions qu disposem
	public void mostrarInformacioVehicles(){
		
		System.out.println("+--------------------------------------+");
	    for(int x=0;x<llistaVehicles.size();x++) {
	    	Vehicle vehicleTemporal = (Vehicle)llistaVehicles.get(x);
	    	System.out.print(vehicleTemporal.informacioVehicle());
	    	System.out.println("| El vehicle consumeix: "+vehicleTemporal.consumVehicle());
	    	
	    	for(int y=0;y<llistaPersonal.size();y++) {
		    	Personal persona = (Personal)llistaPersonal.get(y);
		    	if(vehicleTemporal.getIdTripulant().equals(persona.getNIF())){
		    		System.out.println(persona.informacioPersonal());
		    	}
		      }
	    	System.out.println("+--------------------------------------+");
	      }
	}
}
