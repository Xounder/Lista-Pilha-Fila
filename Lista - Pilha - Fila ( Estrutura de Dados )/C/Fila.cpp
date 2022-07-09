#include <stdio.h>
#include <stdlib.h>

typedef struct no{
	int info;
	struct no* prox;
}No;

typedef struct lista{
	No *inicio;
	No *fim;
	int tamanho;
}Lista;

Lista* inicializarLista(){
	//Alocação de Memória Dinâmica para Struct Lista
	Lista* lista = (Lista*) malloc(sizeof(Lista));
	if (lista == NULL){
		printf("Memoria insuficiente");
		exit(1);
	}
	lista->inicio = lista->fim = NULL;
	lista->tamanho = 0;
	return lista;
}

No* criarNo(int valor){
	No* novo = (No*) malloc(sizeof(No));
	if (novo == NULL){
		printf("Memoria insuficiente");
		exit(1);
	}
	novo->info = valor;
	return novo;
}

void inserir(Lista* lista, int valor){
	//Inserir o Nó no inicio da lista
	No* novo = criarNo(valor);
	novo->prox = lista->inicio;
	if (lista->inicio == NULL){
		lista->fim = novo;
	}
	lista->inicio = novo;
	lista->tamanho++;
}

void remover(Lista* lista){
	if (lista->tamanho == 0){
		printf("ERRO!!\nFila Vazia.");
		exit(1);
	}
	if (lista->tamanho == 1){
		lista->inicio = lista->fim = NULL;
		lista->tamanho--;
	}else{
		No* anterior = NULL;
		No* ultimo = lista->inicio;
		for (int i = 1; i < lista->tamanho; i++){
			anterior = ultimo;
			ultimo = ultimo->prox;
		}
		anterior->prox = NULL;
		free(ultimo);
		lista->fim = anterior;
		lista->tamanho--;
	}
}

bool buscarElemento(Lista* lista, int valor){
	No* atual = lista->inicio;
	for (int i = 1; i <= lista->tamanho; i++){
		if (atual->info == valor){
			return true;
		}
		atual = atual->prox;
	}
	return false;
}

void imprimir(Lista* lista){
	No* no;
	for (no = lista->inicio; no != NULL; no = no->prox){
		printf("%d", no->info);
		if (no->prox != NULL){
		printf(" --> ");
		}
	}
	printf("\n");
}

int main(){
	int num, opcao;
	Lista* lista;
	lista = inicializarLista();
	do{
		printf("\n-------------------------------------------------------\n");
		printf("01 - Exibir Fila\n");
		printf("02 - Inserir\n");
		printf("03 - Remover\n");
		printf("04 - Buscar Elemento\n");
		printf("05 - Tamanho da Fila\n");
		printf("0 - Sair\n");
		printf("\n-------------------------------------------------------\n");
		scanf("%d", &opcao);
		switch(opcao){
			case 1:
				imprimir(lista);
				break;
			case 2:
				printf("Insira o valor a ser inserido: ");
				scanf("%d", &num);
				inserir(lista, num);
				break;
			case 3:
				remover(lista);
				break;
			case 4:
				printf("Insira o valor a ser procurado: ");
				scanf("%d", &num);
				if(buscarElemento(lista, num)){
					printf("O elemento %d esta contido na Fila", num);
				}else{
					printf("O elemento %d nao esta na Fila", num);
				}
				break;
			case 5:
				printf("Tamanho da Fila: %d", lista->tamanho);
				break;
			default:
				printf("Opcao invalida!");
		}
	}while(opcao != 0);
	return 0;
}
