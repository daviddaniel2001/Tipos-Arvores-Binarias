package modelo;

import java.util.LinkedList;
import java.util.Queue;

class ArvoreBinaria {
	private NoArvore raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void inserir(int valor) {
		this.raiz = inserirRecursivo(this.raiz, valor);
	}

	private NoArvore inserirRecursivo(NoArvore no, int valor) {
		if (no == null) {
			return new NoArvore(valor);
		}

		if (valor < no.valor) {
			no.esquerda = inserirRecursivo(no.esquerda, valor);
		} else if (valor > no.valor) {
			no.direita = inserirRecursivo(no.direita, valor);
		}

		return no;
	}

	public int altura() {
		return alturaRecursiva(this.raiz);
	}

	private int alturaRecursiva(NoArvore no) {
		if (no == null) {
			return 0;
		}

		int alturaEsquerda = alturaRecursiva(no.esquerda);
		int alturaDireita = alturaRecursiva(no.direita);

		return Math.max(alturaEsquerda, alturaDireita) + 1;
	}

	public boolean ehEstritamenteBinaria() {
		return ehEstritamenteBinariaRecursiva(this.raiz);
	}

	private boolean ehEstritamenteBinariaRecursiva(NoArvore no) {
		if (no == null) {
			return true;
		}

		if (no.esquerda == null && no.direita == null) {
			return true;
		}

		if (no.esquerda != null && no.direita != null) {
			return ehEstritamenteBinariaRecursiva(no.esquerda) && ehEstritamenteBinariaRecursiva(no.direita);
		}

		return false;
	}

	public boolean ehCompleta() {
		return ehCompletaRecursiva(this.raiz, 0, tamanho());
	}

	private boolean ehCompletaRecursiva(NoArvore no, int indice, int tamanho) {
		if (no == null) {
			return true;
		}

		if (indice >= tamanho) {
			return false;
		}

		return ehCompletaRecursiva(no.esquerda, 2 * indice + 1, tamanho)
				&& ehCompletaRecursiva(no.direita, 2 * indice + 2, tamanho);
	}

	public boolean ehCheia() {
		int altura = altura();
		return ehCheiaRecursiva(this.raiz, altura);
	}

	private boolean ehCheiaRecursiva(NoArvore no, int altura) {
		if (no == null) {
			return true;
		}

		if (no.esquerda == null && no.direita == null) {
			return altura == 1;
		}

		if (no.esquerda != null && no.direita != null) {
			return ehCheiaRecursiva(no.esquerda, altura - 1) && ehCheiaRecursiva(no.direita, altura - 1);
		}

		return false;
	}

	public int tamanho() {
		return tamanhoRecursivo(this.raiz);
	}

	private int tamanhoRecursivo(NoArvore no) {
		if (no == null) {
			return 0;
		}

		return 1 + tamanhoRecursivo(no.esquerda) + tamanhoRecursivo(no.direita);
	}

	public void imprimirNivelOrdem() {
		Queue<NoArvore> fila = new LinkedList<>();
		fila.add(this.raiz);

		while (!fila.isEmpty()) {
			NoArvore noAtual = fila.poll();
			System.out.print(noAtual.valor + " ");

			if (noAtual.esquerda != null) {
				fila.add(noAtual.esquerda);
			}

			if (noAtual.direita != null) {
				fila.add(noAtual.direita);
			}
		}

		System.out.println();
	}
}
