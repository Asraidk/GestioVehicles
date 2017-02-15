//clase data per genera objectes data, utilitzat a diferent calses com atributs
public class Data {
	//variables corresponent a el que seria una data
	private int dia;
	private int mes;
	private int any;
	//constructor
	public Data(int dia,int mes,int any){
		this.setDia(dia);
		this.setMes(mes);
		this.setAny(any);
	}
	//GET Y SET\\
	public String infoData(){
		return(dia+"/"+mes+"/"+any);
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAny() {
		return any;
	}
	public void setAny(int any) {
		this.any = any;
	}
}
