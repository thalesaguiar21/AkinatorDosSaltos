package font;

import java.util.HashMap;
import java.util.Map;

public class PreditorAdaptativoDeDoisNiveis extends Preditor {

	private Map<String, Character> tabelaDePredicoes;
	
	//Inicia a tabela com a predi��o padr�o 'T'
	public PreditorAdaptativoDeDoisNiveis() {
		super();
		this.tabelaDePredicoes = new HashMap<String, Character>(4);
		this.tabelaDePredicoes.put("TT", new Character('T'));
		this.tabelaDePredicoes.put("TN", new Character('T'));
		this.tabelaDePredicoes.put("NT", new Character('T'));
		this.tabelaDePredicoes.put("NN", new Character('T'));
		this.nomeDoPreditor = "Preditor adaptativo de dois n�veis";
	}
	
	@Override
	protected void reset(){
		super.reset();
		this.tabelaDePredicoes.put("TT", new Character('T'));
		this.tabelaDePredicoes.put("TN", new Character('T'));
		this.tabelaDePredicoes.put("NT", new Character('T'));
		this.tabelaDePredicoes.put("NN", new Character('T'));
	}
	
	
	@Override
	void predizer(String listaDeSaltos) {
		int counter = 0;
		int start = 0;
		while(counter < listaDeSaltos.length()){
			if(counter < 2){
				this.predicoesFeitas += this.tabelaDePredicoes.get("TT");
				if(this.tabelaDePredicoes.get("TT") == listaDeSaltos.charAt(counter))
					this.predicoesCorretas++;
			}
			else{
				this.predicoesFeitas += this.tabelaDePredicoes.get(listaDeSaltos.substring(start, counter));
				if(this.tabelaDePredicoes.get(listaDeSaltos.substring(start, counter)) == listaDeSaltos.charAt(counter))
						this.predicoesCorretas++;
				else
					this.tabelaDePredicoes.put(listaDeSaltos.substring(start, counter), listaDeSaltos.charAt(counter));
				start++;
			}
			counter++;
		}
	}

}