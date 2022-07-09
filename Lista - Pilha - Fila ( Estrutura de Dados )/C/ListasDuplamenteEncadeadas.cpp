#include <stdio.h>
#include <stdlib.h>

typedef struct no{
	int info;
	struct no* anterior;
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

void inserirNoInicio(Lista* lista, int valor){
	//Inserir o Nó no inicio da lista
	No* novo = criarNo(valor);
	if (lista->inicio == NULL){
		lista->inicio = lista->fim = novo;
	}else{
		No* primeiro = lista->inicio;
		novo->prox = primeiro;
		primeiro->anterior = novo;
		lista->inicio = novo;
	}
	lista->tamanho++;
}

void inserirNoFim(Lista* lista, int valor){
	//Inserir o Nó no fim da lista
	if (lista->inicio == NULL){
		inserirNoInicio(lista, valor);
	}else{
		No* novo = criarNo(valor);
		No* ultimo = lista->fim;
		ultimo->prox = novo;
		novo->anterior = ultimo;
		novo->prox = NULL;
		lista->fim = novo;
		lista->tamanho++;
	}
}

void inserirNoMeio(Lista* lista, int valor, int posicao){
	if ((posicao > lista->tamanho+1) || (posicao < 1)){
		printf("ERRO!\n Posicao invalida");
		exit(1);
	}
	if (posicao == 1){
		inserirNoInicio(lista, valor);
	}else{
		if(posicao > lista->tamanho){
			inserirNoFim(lista, valor);
		}else{
			No* novo = criarNo(valor);
			No* anterior = NULL;
			No* atual = lista->inicio;
			for (int i = 1; i < posicao; i++){
				anterior = atual;
				atual = atual->prox;
			}
			anterior->prox = novo;
			novo->prox = atual;
			novo->anterior = anterior;
			lista->tamanho++;
		}
	}
}

void removerDoInicio(Lista* lista){
	if (lista->tamanho == 0){
		printf("ERRO!!\nLista Vazia.");
		exit(1);
	}
	No* no = lista->inicio;
	lista->inicio = no->prox;
	free(no);
	if(lista->inicio == NULL){
		lista->fim == NULL;
	}
	lista->tamanho--;
}

void removerDoFim(Lista* lista){
	if (lista->tamanho == 0){
		printf("ERRO!!\nLista Vazia.");
		exit(1);
	}
	if (lista->tamanho == 1){
		removerDoInicio(lista);
	}else{
		No* anterior = NULL;
		No* ultimo = lista->inicio;
		for (int i = 1; i < lista->tamanho; i++){
			anterior = ultimo;
			ultimo = ultimo->prox;
		}
		anterior->prox = NULL;
		ultimo->anterior = NULL;
		free(ultimo);
		lista->fim = anterior;
		lista->tamanho--;
	}
}

void removerDoMeio(Lista* lista, int posicao){
	if ((posicao > lista->tamanho+1) || (posicao < 1)){
		printf("ERRO!\n Posicao invalida");
		exit(1);
	}	
	if (lista->tamanho == 0){
		printf("ERRO!!\nLista Vazia.");
		exit(1);
	}
	if(posicao == 1){
		removerDoInicio(lista);
	}else{
		if (posicao == lista->tamanho){
			removerDoFim(lista);
		}else{
			No* anterior = NULL;
			No* atual = lista->inicio;
			for (int i = 1; i < posicao; i++){
				anterior = atual;
				atual = atual->prox;
			}
			anterior->prox = atual->prox;
			atual->anterior = NULL;
			free(atual);
			lista->tamanho--;
		}
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
	int num, posicao, opcao;
	Lista* lista;
	lista = inicializarLista();
	do{
		printf("\n-------------------------------------------------------\n");
		printf("01 - Exibir Lista\n");
		printf("02 - Inserir no Inicio\n");
		printf("03 - Inserir no Meio\n");
		printf("04 - Inserir no Fim\n");
		printf("05 - Remover do Inicio\n");
		printf("06 - Remover do Meio\n");
		printf("07 - Remover do Fim\n");
		printf("08 - Buscar Elemento\n");
		printf("09 - Tamanho da Lista\n");
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
				inserirNoInicio(lista, num);
				break;
			case 3:
				printf("Insira o valor a ser inserido: ");
				scanf("%d", &num);
				printf("Insira a posicao que deseja inserir o elemento: ");
				scanf("%d", &posicao);
				inserirNoMeio(lista, num, posicao);
				break;
			case 4:
				printf("Insira o valor a ser inserido: ");
				scanf("%d", &num);
				inserirNoFim(lista, num);
				break;
			case 5:
				removerDoInicio(lista);
				break;
			case 6:
				printf("Insira a posicao a ser removida: ");
				scanf("%d", &posicao);
				removerDoMeio(lista, posicao);
				break;
			case 7:
				removerDoFim(lista);
				break;
			case 8:
				printf("Insira o valor a ser procurado: ");
				scanf("%d", &num);
				if(buscarElemento(lista, num)){
					printf("O elemento %d esta contido na lista", num);
				}else{
					printf("O elemento %d nao esta na lista", num);
				}
				break;
			case 9:
				printf("Tamanho da Lista: %d", lista->tamanho);
				break;
			default:
				printf("Opcao invalida!");
		}
	}while(opcao != 0);
	return 0;
}
