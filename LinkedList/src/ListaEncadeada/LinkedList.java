package ListaEncadeada;

//LinkedList - Estrutura Dinamica -> elementos ficam espalhados memoria e essa lista liga esses elementos

public class LinkedList <Type>{

    private Node <Type> head; // Referencia para primeiro Nó
    private Node <Type> tail; // Referencia para o Ultimo Nó
    private int tam = 0;

    private final int NAO_ENCONTRADO = -1;
//Metodos de Adicionar ou Inserir.
    public void Add(Type element){
        Node <Type> newNode = new Node <> (element); //Criou um novo Nó

        if(isEmpty()){ //Caso a lista esteja vazia
            this.head = newNode; //Aqui aponta para o novo nó
        }else{
              this.tail.setNextNode(newNode); //Aqui faz com que o proximo nó, depois do Ultimo, seja o novo nó
        }
        this.tail = newNode; //Faz o ultimo elemento apontar para o novo nó
        this.tam++; 
    }

    public void AddBegin(Type element){
        if(isEmpty()){
            Add(element);
        }else{
            Node <Type> newNode = new Node <> (element); //Cria o nó

            newNode.setNextNode(this.head); //Seta o o proximo Nó do novo Nó como o head
            this.head = newNode; // head aponta para o novo Nó
    
            this.tam ++;
        }
    }

    public void AddBefore(Type element, int pos){
        if(isEmpty()){
            Add(element);
        }else{
            if(pos == 0){
                AddBegin(element);
            }else{
                Node <Type> newNode = new Node <> (element); //Cria o nó

                Node <Type> target = SearchByPosition_Node(pos); //Pega o nó da posição desejada e o nó da posição anterior
                Node <Type> ant = SearchByPosition_Node(pos - 1);
    
                ant.setNextNode(newNode); // Faz o nó anterior fazer referencia ao novo nó
                newNode.setNextNode(target); // Faz o novo nó fazer referencia ao nó target 

            }

            this.tam++;
        }   
    }

    public void AddAfter(Type element, int pos){
        if(isEmpty() || pos == this.tam){
            Add(element);
        }else{
            if(pos == 0){
                AddBegin(element);
            }else{ 
                Node <Type> target = SearchByPosition_Node(pos); //Pega o nó da posição desejada

                if (target == null) {
                    System.out.println("Posição inválida.");
                    return;
                }
                Node <Type> newNode = new Node <> (element); //Cria o nó

                newNode.setNextNode(target.getNextNode());
                target.setNextNode(newNode);
                this.tam++;
            }
        }   
    }

    public void SetElementInNode(Type element, int pos){

        if(isEmpty()){
            System.out.println("Não é possivel inserir esse elemento.");
        }else{
            Node <Type> aux = SearchByPosition_Node(pos); // Guarda o Nó da posição;
            aux.setElement(element);
        }

    }

//Metodos de Remover ou Limpar
    public void RemoveBegin(){
        if(!isEmpty()){
            Node <Type> next = head.getNextNode();

            this.head.setElement(null); //Limpa o valor
            this.head.setNextNode(null); //Limpa o link para o proximo nó

            this.head = next;

            if(this.tam == 1){
                this.tail = null;
            }

            this.tam --;
        }
    }

    public void RemoveEnd(){
        if(!isEmpty()){
            if(this.tam == 1){
                this.tail = null;
                this.head = null;
            }else{
                
                Node <Type> next = this.head; //Next inicializa como o primeiro nó


                //Aqui busca o penultimo Nó e guarda no next
                for(int i = 0; i < this.tam - 2; i++){
                    next = next.getNextNode(); //Avança para o proximo
                }

                //Aqui pega o ultimo nó e limpa ele
                this.tail.setElement(null);
                this.tail.setNextNode(null);

                this.tail = next; //Aqui faz o tail aponta para o penultimo elemento
                this.tail.setNextNode(null); //Desconecta com o antigo nó

            }

            this.tam--;
        }
    }

    public void RemoveInPosition(int pos){
        Node <Type> target = SearchByPosition_Node(pos);

        if(pos == 0){
            RemoveBegin();
        }else{
            Node <Type> ant = SearchByPosition_Node(pos - 1);
            ant.setNextNode(target.getNextNode());

            target.setElement(null);
            target.setNextNode(null);
                    
            this.tam--;
        }
    }

    public void Clear(){
        /*
        //Forma Simples de limpar a lista
        this.head = null;
        this.tail = null;
        this.tam = 0;
        */
        
        /*
        //Essa forma limpa cada nó da lista
        Node <Type> atual = this.head; //Atual recebe o primeiro Nó

        for(int i = this.tam; i > 0; i--){
            atual.setElement(null); //Limpa o valor
            atual.setNextNode(null); //Limpa o link para o proximo nó

            atual = atual.getNextNode(); //Aqui faz como atual pega o proximo Nó
        }

        this.head = null;
        this.tail = null;
        this.tam = 0;
        */

        for(Node <Type> atual = head; atual != null;){
            Node <Type> next = atual.getNextNode(); // next guarda o proximo nó

            //Limpa o primeiro elemento
            atual.setElement(null); //Limpa o valor do Nó
            atual.setNextNode(null); //Aqui limpa a referencia que atual faz para o proximo nó, no caso tira o link entre o nó do atual para o proximo 

            atual = next; //Aponta para o proximo Nó
        }

        this.head = null;
        this.tail = null;
        this.tam = 0;
    }

//Metodos de Buscar 
    private Node<Type> SearchNode(int pos){
        if(!(pos >= 0 && pos < this.tam)){ //Verifica se a posição buscada existe
            throw new IllegalArgumentException("Posição não existe");
        }

        Node <Type> atual = this.head;

        //Aqui vai pegar o elemento da posição correta
        for(int i = 0; i < pos; i++){
            atual = atual.getNextNode();
        }

        return atual; //Retorna o Nó atual
    }

    public Type SearchByPosition_Element(int pos){
        return this.SearchNode(pos).getElement(); //Retorna o elemento do Nó da posição buscada
    }
  
    public Node<Type> SearchByPosition_Node(int pos){
        return this.SearchNode(pos); //Retorna Nó da posição buscada
    }

    public int SearchByElement(Type element){ //Vai retornar a posição Caso o elemento existe
        Node <Type> atual = this.head;
        int pos = 0;

        while (atual != null){
            if(atual.getElement().equals(element)){ //Verifca se o elemento do Nó atual é igual ao elemento buscado
                return pos; //Retorna a posição
            }

            atual = atual.getNextNode(); //Avança para o proximo elemento
            pos++; //Incremento posição
        }

        return NAO_ENCONTRADO; //Retorna -1

    }

//Metodos Auxiliares
    public boolean isEmpty(){
        return this.tam == 0; //Retorna true ou false
    }

    public int getTam(){
        return this.tam; //Retorna o valor do tamanho do nó
    }

    @Override
    public String toString() { 

        if(isEmpty()){
            return "[]";
        }

        StringBuilder builder = new StringBuilder();

        Node <Type> atual = head; //atual recebe o primeiro Nó

        /* 
        builder.append(atual.getElement()).append(" -> "); //Adciona o elemento do

        while(atual.getNextNode() != null){
            atual = atual.getNextNode(); // Atual move o ponteiro para o proximo elemento
            builder.append(atual.getElement()).append(" -> "); //Adciona o elemento do
        }
        */

        for(int i = 0; i < this.tam - 1; i++){
            builder.append(atual.getElement()).append(" -> "); //Adciona o elemento do
            atual = atual.getNextNode();
        }
        builder.append(atual.getElement()); //Adiciona o ultimo elemento no builder

        
        return builder.toString(); //Retorna a String
    }

    
    
}
