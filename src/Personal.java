
public class Personal {

	private String NIF;
	private String nom;
	private Data dataNaixement;
	private char especialitatVehicle;
	private boolean assignat;//aquest por ser public!
	
	public Personal(String NIF,String nom, char especialitatVehicle,boolean assignat,int dia,int mes,int any){
		
		this.NIF=NIF;
		this.nom=nom;
		this.especialitatVehicle=especialitatVehicle;
		this.assignat=assignat;
		
		Data dataTemporal=new Data(dia,mes,any);
		this.dataNaixement=dataTemporal;
	}
	
	
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Data getDataNaixement() {
		return dataNaixement;
	}
	public void setDataNaixement(Data dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	public char getEspecialitatVehicle() {
		return especialitatVehicle;
	}
	public void setEspecialitatVehicle(char especialitatVehicle) {
		this.especialitatVehicle = especialitatVehicle;
	}
	public boolean isAssignat() {
		return assignat;
	}
	public void setAssignat(boolean assignat) {
		this.assignat = assignat;
	}
}
