//clase filla de vehicle
public class Maritim extends Vehicle {
	//variables que nomes te el fill maritim
	private int eslora;
	private int manega;
	private int anyFlotacio;
	private Data dataDeConstruccio;
	//constructo de clase filla maritim, cridan tambe al pare
	public Maritim(double consumMinim, double carregaActual, double capacitatMaxima, double consumPerKilometre,
			char tipusVehicle, String identificador, double velocitatMitja, String idTripulant,
			int eslora,int manega,int anyFlotacio,int dia,int mes,int any) {
		super(consumMinim, carregaActual, capacitatMaxima, consumPerKilometre, tipusVehicle, identificador, velocitatMitja,
				idTripulant);
		this.eslora=eslora;
		this.manega=manega;
		this.anyFlotacio=anyFlotacio;
		//clase data constructor
		Data dataTemporal=new Data(dia,mes,any);
		this.dataDeConstruccio=dataTemporal;
	}
	//clase abstracta implementada per el fill utilitza una logica diferent per cada override
	@Override
	public double consumVehicle() {
		if(this.capacitatMaxima!=0){
			return Math.round(this.consumMinim+((this.carregaActual/this.capacitatMaxima)*this.consumPerKilometre)+(this.eslora+
					this.manega+this.anyFlotacio)-(dataDeConstruccio.getDia()+dataDeConstruccio.getMes()+dataDeConstruccio.getAny()));
		}
		else{
			return 0;
		}
		
	}
	//Ampliacio al metode de informacio de vehicle del pare per tal de mostrar tambe nova info del fill
	public String informacioVehicle(){
		return(super.informacioVehicle()+
				"| Tamany de la eslora: "+this.eslora+"\n"+
				"| Tamany de la manega: "+this.manega+"\n"+
				"| Any de flotacio: "+this.anyFlotacio+"\n"+
				"| Data construcio["+this.dataDeConstruccio.getDia()+"/"+this.dataDeConstruccio.getMes()+"/"+this.dataDeConstruccio.getAny()+"]\n");
	}
	//GET Y SET\\
	public int getEslora() {
		return eslora;
	}
	public void setEslora(int eslora) {
		this.eslora = eslora;
	}
	public int getManega() {
		return manega;
	}
	public void setManega(int manega) {
		this.manega = manega;
	}
	public int getAnyFlotacio() {
		return anyFlotacio;
	}
	public void setAnyFlotacio(int anyFlotacio) {
		this.anyFlotacio = anyFlotacio;
	}
	public Data getDataDeConstruccio() {
		return dataDeConstruccio;
	}
	public void setDataDeConstruccio(Data dataDeConstruccio) {
		this.dataDeConstruccio = dataDeConstruccio;
	}
}
