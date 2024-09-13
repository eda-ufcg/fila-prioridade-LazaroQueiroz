import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
    this.fila.add(new Pair(elemento, prioridade));
  }


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {

    int maxIndex = -1;
    for (int i = 0; i < this.fila.size(); i++) {
      if (maxIndex == -1 || this.fila.get(i).getPrioridade() > this.fila.get(maxIndex).getPrioridade())  
        maxIndex = i;
    }

    String element = this.fila.get(maxIndex).getElemento();
    this.fila.remove(maxIndex);
		return element;
	}

}
