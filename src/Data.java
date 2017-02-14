
public class Data {

	private int dia;
	private int mes;
	private int any;
	
	public Data(int dia,int mes,int any){
		this.setDia(dia);
		this.setMes(mes);
		this.setAny(any);
	}
	
	
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
