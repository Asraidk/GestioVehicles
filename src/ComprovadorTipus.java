import java.util.Scanner;

public class ComprovadorTipus {

	Scanner teclat = new Scanner(System.in);
	
	public int comprovarInt(String missatge){
		
		int valor;
		System.out.println(missatge);
		while(!teclat.hasNextInt()){
			teclat.nextLine();
			System.out.println("No has introduit un valor enter."+missatge);
		}
		valor = teclat.nextInt();
		teclat.nextLine();
		
		return valor;
	}
	
	public double comprovarDouble(String missatge){
		
		double valor;
		
		System.out.println(missatge);
		while(!teclat.hasNextDouble()){
			teclat.nextLine();
			System.out.println("No has introduit una valor real."+missatge);
		}
		valor = teclat.nextDouble();
		teclat.nextLine();
		
		return valor;
	}
	public String comprovarString(String missatge){
		
		String valor;
		System.out.println(missatge);
			while(!teclat.hasNext()){
				teclat.nextLine();
				System.out.println("No has introduit una cadena de caracters."+missatge);
			}
		valor= teclat.next();
		teclat.nextLine();
		
		return valor;
	}
	
	public boolean comprovarData(int dia,int mes,int any){
		
		boolean dataCorrecta=true;
		
		switch(mes){
		case 1:	case 3: case 5: case 7: case 8: case 9: case 12:
			dataCorrecta=comprovarDias31(dia,mes,any);
			break;
		case 4: case 6: case 10: case 11:
			dataCorrecta=comprovarDias30(dia,mes,any);
			break;
		case 2:
			dataCorrecta=comprovarDiasFebrer(dia,mes,any);
			break;		
		default:
			dataCorrecta=false;
			break;
		}
		return dataCorrecta;
	}
	
	public boolean comprovarDiasFebrer(int dia,int mes,int any){
		boolean dataCorreta=false;
		if ((dia>0 && dia<30)&&(any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))){
			dataCorreta=true;		
		}				
		return dataCorreta;
	}
	public boolean comprovarDias31(int dia,int mes,int any){
		boolean dataCorreta=false;
			
		if(dia>0 && dia<32){
			dataCorreta=true;
		}
		return dataCorreta;
	}
	public boolean comprovarDias30(int dia,int mes,int any){
		boolean dataCorreta=false;
		
		if(dia>0 && dia<31){
			dataCorreta=true;
		}
		return dataCorreta;
	}
	
}
