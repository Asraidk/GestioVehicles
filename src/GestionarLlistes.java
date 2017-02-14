import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

public class GestionarLlistes {

	private ComprovadorTipus lectorTipus= new ComprovadorTipus();
	private ArrayList<Vehicle> llistaVehicles= new ArrayList<Vehicle>();
	private ArrayList<Personal> llistaPersonal= new ArrayList<Personal>();
	private int contadorPersonal=0;
	
	public void afegirVehicle(int tipusEscollit){
		
		double consumMinim;
		double carregaActual;
		double capacitatMaxima;
		double consumPerKilometre;
		char tipusVehicle;
		String identificador;
		double velocitatMitja;
		String idTripulant;
		
		consumMinim=lectorTipus.comprovarDouble("Digues el consum minim del vehicle:");			
		
		capacitatMaxima=lectorTipus.comprovarDouble("Digues la carrega maxima.");
		
		carregaActual=lectorTipus.comprovarDouble("Digues la carrega actual");
		
		consumPerKilometre=lectorTipus.comprovarDouble("Posa el consum per kilometre del vehicle.");
		
		identificador=lectorTipus.comprovarString("Identificador del vehicle");
		
		velocitatMitja=lectorTipus.comprovarDouble("Velocitat mitja del vehicle.");
		
		idTripulant="";
		
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
	
	private void afegirTerrestre(double consumMinim, double carregaActual, double capacitatMaxima,
			double consumPerKilometre, char tipusVehicle, String identificador, double velocitatMitja,
			String idTripulant) {
		
		int numeroCavalls;
		int numeroAveries;
		int costAveries;
		Vehicle tempVehicleTerrestre;
		
		numeroCavalls=lectorTipus.comprovarInt("Digues le numero de caballs del vehicle");
		numeroAveries=lectorTipus.comprovarInt("Digues le numero d'averies del vehicle");
		costAveries=lectorTipus.comprovarInt("Digues el cost de les averies del vehicle");
	
		try{
			tempVehicleTerrestre = new Terrestre(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,numeroCavalls,numeroAveries,costAveries);
			llistaVehicles.add(tempVehicleTerrestre);
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus terrestre, no sera introduit al sistema");
	    }		
	}

	private void afegirMaritim(double consumMinim, double carregaActual, double capacitatMaxima,
			double consumPerKilometre, char tipusVehicle, String identificador, double velocitatMitja,
			String idTripulant) {
		
		String data;
		int eslora;
		int manega;
		int anyFlotacio;
		int dia=0;
		int mes=0;
		int any=0;
		boolean dataCorrecta=true;
		Vehicle tempVehicleMaritim;
		
		eslora=lectorTipus.comprovarInt("Digues el numero d'eslora");
		manega=lectorTipus.comprovarInt("Digues el tamany de la manega");
		anyFlotacio=lectorTipus.comprovarInt("Quin va ser el any de flotacio");
		data=lectorTipus.comprovarString("Quina es la data de construcio recorda indtroduir: dd/mm/aaaa");
		
		StringTokenizer st = new StringTokenizer(data,"/");

        System.out.println("Hay un total de: "+st.countTokens()+" tokens.");
       try{
    	   dia=Integer.parseInt(st.nextToken());
           mes=Integer.parseInt(st.nextToken());
           any=Integer.parseInt(st.nextToken());
           dataCorrecta=lectorTipus.comprovarData(dia,mes,any);
       }catch(Exception e){
    	   dataCorrecta=false;
       }
		
		if(dataCorrecta){
		try{
			tempVehicleMaritim = new Maritim(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,eslora,manega,anyFlotacio,dia,mes,any);
			llistaVehicles.add(tempVehicleMaritim);
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus maritim, no sera introduit al sistema");
	    }	
		}else{
			System.out.println("Error al inicialitzar el vehicle del tipus maritim, no sera introduit al sistema");
			System.out.println("La data de construcio esta introduida incorectament");
		}
		
		
	}

	private void afegirAeri(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant) {
		
		int numeroMotors;
		int tempsDeFuncionament;
		Vehicle tempVehicleAeri;
		
		numeroMotors=lectorTipus.comprovarInt("Digues el numero de motors que te el vehicle");
		tempsDeFuncionament=lectorTipus.comprovarInt("Digues el temps de funcionament del vehicle");
		
		try{
			tempVehicleAeri = new Aeri(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
					idTripulant,numeroMotors,tempsDeFuncionament);
			llistaVehicles.add(tempVehicleAeri);
	    } catch(Exception e) { 
	    	System.out.println("Error al inicialitzar el vehicle del tipus aeri, no sera introduit al sistema");
	    }	
		
	}
	
	public void ActivarUsuaris(String arxiuProperties) {
		
		if(contadorPersonal<4){
			lleguirArxiu(arxiuProperties);
			contadorPersonal++;
		}
		
	}
	
	private void lleguirArxiu(String arxiuProperties) {
		  try {
			 boolean dataCorrecta=true;
			 int dia=0;
			 int mes=0;
			 int any=0;
			/**Creamos un Objeto de tipo Properties*/
			 Properties propietats = new Properties();
			    
			/**Cargamos el archivo desde la ruta especificada*/
			 propietats.load(new FileInputStream("C:/Users/Portatil/workspace/GestioVehicles/src/properties/"+arxiuProperties+".properties"));
			 
			/**Obtenemos los parametros definidos en el archivo*/
			String codi = propietats.getProperty("NIF");
			String nom = propietats.getProperty("nom");
			String especialitat = propietats.getProperty("especialitatVehicle");
			char especialitatParse= especialitat.charAt(0);
			boolean assignat = propietats.getProperty("assignat") != null;
			String data = propietats.getProperty("dataNaixement");
		   
		   	StringTokenizer st = new StringTokenizer(data,"/");

		   	try{
		 	   	dia=Integer.parseInt(st.nextToken());
		        mes=Integer.parseInt(st.nextToken());
		        any=Integer.parseInt(st.nextToken());
		        dataCorrecta=lectorTipus.comprovarData(dia,mes,any);
		    }catch(Exception e){
		 	   dataCorrecta=false;
		    }
		    
		   if(dataCorrecta){
		    	Personal tempPersonal= new Personal(codi,nom,especialitatParse,assignat,dia,mes,any);
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
	
	public void mostrarInformacioVehicles(){
		
	    for(int x=0;x<llistaVehicles.size();x++) {
	        //System.out.println(llistaVehicles.get(x));
	    	Vehicle v = (Vehicle)llistaVehicles.get(x);
	    	System.out.println(v.informacioVehicle());
	    	System.out.println("El vehicle consumeix: "+v.consumVehicle());
	    	
	      }
	    
	    for(int x=0;x<llistaPersonal.size();x++) {
	        //System.out.println(llistaVehicles.get(x));
	    	Personal v = (Personal)llistaPersonal.get(x);
	    	System.out.println(v.getNIF());
	    	System.out.println(v.getNom());
	    	System.out.println(v.getEspecialitatVehicle());
	    	
	      }
	}
	
	public void assignarUsuris(){
		
		 for(int x=0;x<llistaPersonal.size();x++) {;
		    	Personal personaEnTractament = (Personal)llistaPersonal.get(x);
		    	
		    	if(personaEnTractament.isAssignat()!=false){
		    		
		    		for(int z=0;z<llistaVehicles.size();z++) {
		    	    	Vehicle vehicleTemporal = (Vehicle)llistaVehicles.get(z);
		    	    	
		    	    	if(vehicleTemporal.getIdTripulant().equals("")&&(vehicleTemporal.getTipusVehicle()==personaEnTractament.getEspecialitatVehicle())){
		    	    		
		    	    		
		    	    		vehicleTemporal.setIdTripulant(personaEnTractament.getNIF());
		    	    		
		    	    		
		    	    		personaEnTractament.setAssignat(true);
		    	    	}
		    	      }
		    	
		    		
		    		
		    		
		    		
		    	}else{
		    		System.out.println("El conductor "+personaEnTractament.getNom()+" ja esta assignat.");
		    	}
		    	
		 }
		
		
		
		
		
	}
	
}
