package ED;

public class ListaEncadeada{
	
	public class No{
		private int dado;
		private No prox;
		
		public int getDado() {
			return dado;
		}

		public void setDado(int dado) {
			this.dado = dado;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}

		public No() {
			prox = null;			
		}
	}
	
	private No primeiro;
	private int tamanho;
	
	// 1. Criação de lista vazia.
	public ListaEncadeada() {
		primeiro = null;
		tamanho = 0;
	}
	
	// 2. Verificar se a lista está vazia.
	public void listaVazia() {
		if(tamanho == 0) {
			System.out.println("A lista está vazia!");
		}else{
			System.out.println("A lista não está vazia!");
		}
	}
	
	// 3. Obter o tamanho da lista
	public int tamanhoLista() {
		return tamanho;
	}
	
	// 4.1 Obter o valor do elemento de uma determinada posição.
	public boolean obterValor(int pos) {
		No aux = primeiro;
		
		if(tamanho == 0) {
			return false; // Lista vazia.
		}
		if((pos < 1) || (pos > tamanho)) {
			return false; // Posição inválida.
		}
		
		for(int i = 1; i < pos; i++) {
			aux = aux.getProx();
		}
		
		System.out.println("Valor encontrado: " + aux.getDado());
		return true; // Busca finalizada.	
	}
	
	//4.2 Modificar o valor do elemento de uma determinada posição.
	public boolean modificarValor(int pos, int valor) {
		No aux = primeiro;
		
		if((pos < 1) || (pos > tamanho)) {
			return false; // Posição inválida.
		}
		
		for(int i = 1; i < pos; i++) {
			aux = aux.getProx();
		}
		
		aux.setDado(valor);
		
		System.out.println("Valor modificado com sucesso!");
		return true;
	}
	
	// 5. Inserir valor na lista.
	public boolean inserirValor(int pos, int valor) {
		if((pos < 1) && (tamanho == 0)) {
			System.out.println("Posição inválida!");
			return false;
		}
		else if(pos == 1) { // Início da lista.
			
			No novoNo = new No();
			novoNo.setDado(valor);
			novoNo.setProx(primeiro);
			primeiro = novoNo;
			tamanho++;
			return true;
		
		}
		else if(pos == tamanho + 1) { // Fim da lista.
			
			No novoNo = new No();
			novoNo.setDado(valor);
			
			No aux = primeiro;
			while(aux.getProx() != null) {
				aux = aux.getProx();
		}	
			
		novoNo.setProx(null);
		aux.setProx(novoNo);
		tamanho++;
		return true;
		
		}
		else{
			
			No novoNo = new No();
			novoNo.setDado(valor);
			
			No aux = primeiro;
			for(int i = 1; i < pos; i++) {
				aux = aux.getProx();		
			}
			
			novoNo.setProx(aux.getProx());
			aux.setProx(novoNo);
			tamanho++;
			return true;
			
		}
		
	}
	
	// 6. Retirar um elento de uma determinada posição.
	
	public boolean removerValor(int pos) {
		if((tamanho == 0) ||(pos > tamanho)) {
			System.out.println("Posição inválida!");
			return false;
		}
		if(pos == 1) {
			primeiro = primeiro.prox;
			return true;
		}
		else {
			No atual = null, antecessor = null;
			int valor = -1;
			int i = 1;
			
			atual = primeiro;
			while(i < pos){
				antecessor = atual;
				atual = atual.getProx();
				i++;
			}
			
			valor = atual.getDado();
			antecessor.setProx(atual.getProx());
			tamanho--;
			
			System.out.println("Dado removido com sucesso!");
			return true;
			
		}
		
	}
	
	// 7. Imprimir os elementos de toda a lista.
	
		public boolean imprimirLista() {
			if(tamanho == 0) {
				System.out.println("Lista está vazia!");
				return true;
			}
			
			No aux = primeiro;
			
			for(int i = 1; i <= tamanho; i++) {
				System.out.print(" " +aux.getDado());
				aux = aux.prox;
			}
			System.out.println("");
			return true;
		}
	
	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		
		// Testando...
		
		lista.inserirValor(1, 4);
		lista.inserirValor(2, 5);
		lista.inserirValor(3, 6);
		lista.inserirValor(4, 8);
		lista.inserirValor(5, 47);
		lista.inserirValor(6, 37);
		lista.imprimirLista();
		lista.removerValor(4);
		lista.imprimirLista();
	}		
}
