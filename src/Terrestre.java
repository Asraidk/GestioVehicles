//clase filla de vehicle
public class Terrestre extends Vehicle  {
	//variables que nomes te el fill
	private int numeroCavalls;
	private int numeroAveries;
	private int costAveries;
	//constructor
	public Terrestre(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant, int numeroCavalls
			,int numeroAveries,int costAveries) {
		super(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
				idTripulant);
		this.numeroCavalls=numeroCavalls;
		this.numeroAveries=numeroAveries;
		this.costAveries=costAveries;
	}
	//clase abstracta implementada per el fill utilitza una logica diferent per cada override
	@Override
	public double consumVehicle() {
		if(this.capacitatMaxima!=0){
			return Math.round(this.consumMinim+((this.carregaActual/this.capacitatMaxima)*this.consumPerKilometre)+
					(this.numeroAveries*this.costAveries));
		}
		else{
			return 0;
		}
	}
	//Ampliacio al metode de informacio de vehicle del pare per tal de mostrar tambe nova info del fill
	public String informacioVehicle(){
		return(super.informacioVehicle()+
				"| Numero de cavalls del vehicle: "+this.numeroCavalls+"\n"+
				"| Numero de averies: "+this.numeroAveries+"\n"+
				"| Cost total de les averies: "+this.costAveries+"\n");
	}	
	//GET Y SET\\
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
