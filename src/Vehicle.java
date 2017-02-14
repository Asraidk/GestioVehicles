
public abstract class Vehicle {

	protected double consumMinim;
	protected double carregaActual;
	protected double capacitatMaxima;
	protected double consumPerKilometre;
	protected char tipusVehicle;
	protected String identificador;
	protected double velocitatMitja;
	protected String idTripulant;
	
	public Vehicle(double consumMinim,double carregaActual, double capacitatMaxima, double consumPerKilometre,char tipusVehicle,String identificador,double velocitatMitja,String idTripulant){
		this.consumMinim=consumMinim;
		this.carregaActual=carregaActual;
		this.capacitatMaxima=capacitatMaxima;
		this.consumPerKilometre=consumPerKilometre;
		this.tipusVehicle=tipusVehicle;
		this.identificador=identificador;
		this.velocitatMitja=velocitatMitja;
		this.idTripulant=idTripulant;		
	}
	
	
	public String informacioVehicle(){
		return("Tipus de vehicle: "+this.tipusVehicle+"\n"+
				"Identificador vehicle: "+this.identificador+"\n"+
				"Consum minim. Vehicle: "+this.consumMinim+"\n"+
				"Carrega actual del vehicle: "+this.carregaActual+"\n"+
				"Capacitat Max del vehicle: "+this.capacitatMaxima+"\n"+
				"Consum per KM: "+this.consumPerKilometre+"\n"+
				"ID del tripulant: "+this.idTripulant+"\n"				
				);
	}
	
	abstract public double consumVehicle();

	public double getConsumMinim() {
		return consumMinim;
	}

	public void setConsumMinim(double consumMinim) {
		this.consumMinim = consumMinim;
	}

	public double getCarregaActual() {
		return carregaActual;
	}

	public void setCarregaActual(double carregaActual) {
		this.carregaActual = carregaActual;
	}

	public double getCapacitatMaxima() {
		return capacitatMaxima;
	}

	public void setCapacitatMaxima(double capacitatMaxima) {
		this.capacitatMaxima = capacitatMaxima;
	}

	public double getConsumPerKilometre() {
		return consumPerKilometre;
	}

	public void setConsumPerKilometre(double consumPerKilometre) {
		this.consumPerKilometre = consumPerKilometre;
	}

	public char getTipusVehicle() {
		return tipusVehicle;
	}

	public void setTipusVehicle(char tipusVehicle) {
		this.tipusVehicle = tipusVehicle;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getVelocitatMitja() {
		return velocitatMitja;
	}

	public void setVelocitatMitja(double velocitatMitja) {
		this.velocitatMitja = velocitatMitja;
	}

	public String getIdTripulant() {
		return idTripulant;
	}

	public void setIdTripulant(String idTripulant) {
		this.idTripulant = idTripulant;
	}
}
