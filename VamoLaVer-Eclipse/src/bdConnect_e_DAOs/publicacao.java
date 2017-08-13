package bdConnect_e_DAOs;

public class publicacao {
	String evId, usuEmail,data;
	public publicacao(String i, String e, String d){
		evId = i;
		usuEmail = e;
		data = d;
	}
	public String getEvId(){
		return evId;
	}
	public String getUsuEmail(){
		return usuEmail;
	}
	public String getData(){
		return data;
	} 
	

}
