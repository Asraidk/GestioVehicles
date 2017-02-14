
public class Terrestre extends Vehicle  {
	
	private int numeroCavalls;
	private int numeroAveries;
	private int costAveries;

	public Terrestre(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant, int numeroCavalls
			,int numeroAveries,int costAveries) {
		super(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
				idTripulant);
		this.numeroCavalls=numeroCavalls;
		this.numeroAveries=numeroAveries;
		this.costAveries=costAveries;
	}
	
	@Override
	public double consumVehicle() {
		if(this.capacitatMaxima==0){
			return Math.round(this.consumMinim+((this.carregaActual/this.capacitatMaxima)*this.consumPerKilometre)+
					(this.numeroAveries*this.costAveries));
		}
		else{
			return 0;
		}
		
	}
	public String informacioVehicle(){
		return(super.informacioVehicle()+
				"Numero de cavalls del vehicle: "+this.numeroCavalls+"\n"+
				"Numero de averies: "+this.numeroAveries+"\n"+
				"Cost total de les averies: "+this.costAveries+"\n");
	}
	

	public int getNumeroCavalls() {
		return numeroCavalls;
	}

	public void setNumeroCavalls(int numeroCavalls) {
		this.numeroCavalls = numeroCavalls;
	}

	public int getNumeroAveries() {
		return numeroAveries;
	}

	public void setNumeroAveries(int numeroAveries) {
		this.numeroAveries = numeroAveries;
	}

	public int getCostAveries() {
		return costAveries;
	}

	public void setCostAveries(int costAveries) {
		this.costAveries = costAveries;
	}
}
