//class filla de vehicle
public class Aeri extends Vehicle {
	//variables uniques per clase filla
	private int numeroMotors;
	private int tempsDeFuncionament;
	//contructor de el fill vehicle aeri
	public Aeri(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant,int numeroMotors,
			int tempsDeFuncionament) {
		super(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
				idTripulant);
		this.numeroMotors=numeroMotors;
		this.tempsDeFuncionament=tempsDeFuncionament;
	}
	//clase abstracta implementada per el fill utilitza una logica diferent per cada override
	@Override
	public double consumVehicle() {
		if(this.capacitatMaxima!=0){
			return Math.round(this.consumMinim+((this.carregaActual/this.capacitatMaxima)*this.consumPerKilometre)+
					(this.numeroMotors*this.tempsDeFuncionament));
		}
		else{
			return 0;
		}
	}
	//Ampliacio al metode de informacio de vehicle del pare per tal de mostrar tambe nova info del fill
	public String informacioVehicle(){
		return(super.informacioVehicle()+
				"| Numero de motors: "+this.numeroMotors+"\n"+
				"| Temps de funcionament: "+this.tempsDeFuncionament+"\n");
	}
	//GET I SET\\
	public int getNumeroMotors() {
		return numeroMotors;
	}
	public void setNumeroMotors(int numeroMotors) {
		this.numeroMotors = numeroMotors;
	}
	public int getTempsDeFuncionament() {
		return tempsDeFuncionament;
	}
	public void setTempsDeFuncionament(int tempsDeFuncionament) {
		this.tempsDeFuncionament = tempsDeFuncionament;
	}
}
