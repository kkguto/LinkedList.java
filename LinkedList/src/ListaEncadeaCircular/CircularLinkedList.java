package ListaEncadeaCircular;

import ListaEncadeada.Node;

public class CircularLinkedList <Type> {
    private Node <Type> first;
    private Node <Type> last;
    private int size = 0;

    private final int NAO_ENCONTRADO = -1;

    //Metodos de Inserção
    public void AddFirst(Type element){
        Node <Type> newNode = new Node<>(element);

        if(isEmpty()){
            this.last = newNode;
        }else{
            newNode.setNextNode(this.first); // Faz o newNode apontar para o primeiro nó
        }

        this.first = newNode; //Atualiza o novo primeiro nó
        this.last.setNextNode(this.first); //Faz o ultimo nó apontar para o novo primeiro nó

        this.size++;
    }

    public void AddLast(Type element){
        Node <Type> newNode = new Node<>(element);

        if(isEmpty()){
            this.first = newNode;
        }else{
            this.last.setNextNode(newNode); //Faz o ultimo nó atual apontar para o newNode
        }
        
        this.last = newNode; //Atualiza o novo ultimo nó
        this.last.setNextNode(this.first); //Faz o novo ultimo nó apontar para o novo primeiro nó

        this.size++;
    }

    public void AddAfter(Type element, int pos){
        Node <Type> target = SearchByPosition_Node(pos);
        Node <Type> newNode = new Node <> (element);

        newNode.setNextNode(target.getNextNode());
        target.setNextNode(newNode);

        if (target == this.last) {
            this.last = newNode; // atualiza o último se o elemento foi inserido após o último
        }

        this.size++;
        
    }

    public void AddBefore(Type element, int pos){
        
        if (pos == 0){
            AddFirst(element);
        }else{
            Node <Type> newNode = new Node <> (element);
            Node <Type> prevNode = SearchByPosition_Node(pos - 1);
            Node <Type> target = prevNode.getNextNode();

            prevNode.setNextNode(newNode);
            newNode.setNextNode(target);

            this.size++;
        }
    }
    //Metodos de Remover
    public void RemoveFirst(){
        if(!isEmpty()){
            if (this.size == 1) {
                this.first = null;
                this.last = null;
            }else{
                Node <Type> nextNode = this.first.getNextNode();

                this.first.setElement(null); //Limpa o elemento do Nó
                this.first.setNextNode(null); // Desconecta o nó 
    
                this.first = nextNode; //Atualiza o novo primeiro nó
                this.last.setNextNode(this.first); //Conecta o ultimo nó ao esse novo primeiro nó
            }
            this.size --;
        }
    }

    public void RemoveLast(){
        if(!isEmpty()){
            if(this.size == 1){
                this.first = null;
                this.last = null;

            }else{
                Node <Type> current = this.first;

                for(int i = 0; i < this.size - 2; i++){ //Pegar o penultimo nó
                    current = current.getNextNode(); 
                }
    
                this.last.setElement(null);
                this.last.setNextNode(null);
    
                this.last = current;
                this.last.setNextNode(this.first);
            }
            this.size--;
        }
    }

    public void RemoveInPosition(int pos){

        Node <Type> target = SearchByPosition_Node(pos);
        
        if(pos == 0){
            RemoveFirst();
        }else if(pos == this.size - 1){
            RemoveLast();
        }else{
            Node <Type> aux = SearchByPosition_Node(pos - 1); //Guarda o nó anterior no aux
            aux.setNextNode(target.getNextNode()); //Faz o nó anterior apontar para o proximo do nó do target

            //Aqui limpa e desconecta o nó
            target.setElement(null);
            target.setNextNode(null);

            this.size--;
        }
    }

    public void Clear(){
        if(isEmpty()){
            System.out.println("Lista vazia!");
        }else{
            while(!isEmpty()){
                RemoveFirst();
            }
        }
    }

    //Metodos de Buscas
    private Node<Type> SearchNode(int pos){

        if(!(pos >= 0 && pos < this.size)) throw new IllegalArgumentException("Posição Invalida");

        Node <Type> atual = this.first;

        for(int i = 0; i < pos; i++){
            atual = atual.getNextNode();
        }

        return atual;
    }

    public Node<Type> SearchByPosition_Node(int pos){
        return this.SearchNode(pos);
    }

    public Type SearchByPosition_Element(int pos){
        return this.SearchNode(pos).getElement();
    }

    public int SearchByElement(Type element){
        Node <Type> atual = this.first;
        int pos = 0;

        for(int i = 0; i < this.size; i++){
            if(atual.getElement().equals(element)){//Verifica se o elemento do Nó atual eh igual ao elemento
                return pos; //retorna o indice da lista
            }
            pos++;
            atual = atual.getNextNode(); //Passa para o proximo Nó
        }
        return NAO_ENCONTRADO;
    }

    public boolean Contains(Type element){ //Verifica se o elemento existe ou não da lista
        Node <Type> atual = this.first;

        for(int i = 0; i < this.size; i++){
            if(atual.getElement().equals(element)){//Verifica se o elemento do Nó atual eh igual ao elemento
                return true;
            }
            atual = atual.getNextNode(); //Passa para o proximo Nó
        }
        return false;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString(){

        if(this.size == 0) return "[]";

        StringBuilder builder = new StringBuilder();

        Node <Type> current = this.first;
        
        for(int i = 0; i < this.size; i++){
            builder.append(current.getElement()).append(" -> ");
            current = current.getNextNode();
        }
        builder.append("(volta ao início)");
        
        return builder.toString();
    }
}
