import java.util.*;
public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {

    if (this.last + 1 == this.fila.length) resize();

    if (this.head == -1) {
      this.head++;
    }

    this.last = ++this.last % this.fila.length;
    this.fila[this.last] = new Pair(elemento, prioridade);
    for (int i = this.last; i >= 1; i--) {
      if (this.fila[i].getPrioridade() >= this.fila[i - 1].getPrioridade())
        swap(this.fila, i, i - 1);
    }
    System.out.println(Arrays.toString(this.fila));

  }

  private void swap(Pair[] fila, int a, int b) {
    Pair temp = this.fila[a];
    this.fila[a] = this.fila[b];
    this.fila[b] = temp;
  }


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
    String element;
    if (this.head == this.last) {
      element = this.fila[this.head].getElemento();
      this.head = -1;
      this.last = -1;
    } else {
      element = this.fila[this.head].getElemento();
      this.head++;
    }
		return element;
	}

  private void resize() {
    Pair[] novaFila = new Pair[this.fila.length * 2];

    int i = this.head;
    int k = 0;
    while ((i) % this.fila.length != this.last) {
      novaFila[k++] = this.fila[i++];
    }
    this.fila = novaFila;
  }

}
