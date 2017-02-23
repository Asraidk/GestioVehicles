
public class Amfibi extends Terrestre{
	Maritim tambeMaritim= new Maritim();
	public Amfibi(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant, int numeroCavalls,
			int numeroAveries, int costAveries) {
		super(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
				idTripulant, numeroCavalls, numeroAveries, costAveries);
		
		assignacions();
	}

	public String informacioVehicle(){
		return(tambeMaritim.informacioVehicle());
	}	
	public double consumVehicle() {
		if(this.capacitatMaxima!=0){
			return Math.round(this.consumMinim+((this.carregaActual/this.capacitatMaxima)*this.consumPerKilometre)+
					(this.numeroAveries*this.costAveries)-tambeMaritim.consumVehicle());
		}
		else{
			return 0;
		}
	}
	public void assignacions(){
		//necesari para que no quede muy mal!
		tambeMaritim.setConsumMinim(this.consumMinim);
		tambeMaritim.setCarregaActual(this.carregaActual);
		tambeMaritim.setCapacitatMaxima(this.capacitatMaxima);
		tambeMaritim.setConsumPerKilometre(this.consumPerKilometre);
		tambeMaritim.setTipusVehicle(this.tipusVehicle);
		tambeMaritim.setIdentificador(this.identificador);
		tambeMaritim.setVelocitatMitja(this.velocitatMitja);		
		//un poco de cosecha propia para mejorar /*
		tambeMaritim.setEslora(3);
		tambeMaritim.setAnyFlotacio(1980);
		tambeMaritim.setManega(3);
		Data dataTemporal=new Data(02,11,1998);
		tambeMaritim.setDataDeConstruccio(dataTemporal);
		
	}
}
