package modelo;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(20);
		arvore.inserir(40);
		arvore.inserir(60);
		arvore.inserir(80);

		System.out.println("Altura da árvore: " + arvore.altura());

		System.out.println("É estritamente binária? " + arvore.ehEstritamenteBinaria());
		System.out.println("É completa? " + arvore.ehCompleta());
		System.out.println("É cheia? " + arvore.ehCheia());

		System.out.println("Elementos em nível de ordem:");
		arvore.imprimirNivelOrdem();
	}
}
