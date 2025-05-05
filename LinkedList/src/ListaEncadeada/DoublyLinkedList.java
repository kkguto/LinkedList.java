package ListaEncadeada;

public class DoublyLinkedList <Type> {
    
    private Node<Type> first;
    private Node<Type> last;
    private int size = 0;

    private final int NAO_ENCONTRADO = -1;

    //Metodos de Adicionar
    public void AddFirst(Type element){
        Node <Type> newNode = new Node<>(element);

        if(isEmpty()){
            this.first = newNode;
            this.last = newNode; 
        }else{
            newNode.setNextNode(this.first); //Faz o primeiro nó ser proximo nó do newnode 
            this.first.setPrevNode(newNode); // Faz o newNode ser o nó anterior do primeiro nó
            this.first = newNode; //Aqui atualiza qual eh o primeiro nó para o newnode
        }

        this.size++;
    }

    public void AddLast(Type element){

        Node <Type> newNode = new Node <> (element); //Criou um novo Nó

        if(isEmpty()){
            this.first = newNode; 
        }else{
            newNode.setPrevNode(this.last); // Faz o this.last ser o nó anterior do newNode
            this.last.setNextNode(newNode); //Faz o newNode ser proximo nó do antigo ultimo
        }

        this.last = newNode; //Aqui atualiza qual eh o ultimo nó que eh esse newNode
        this.size++;

    }

    public void AddAfter(Type element, int pos){
        if(isEmpty() || pos == this.size - 1){
            AddLast(element);
        }else{
            Node <Type> target = SearchByPosition_Node(pos); //Pega o nó da posição objetiva
            Node <Type> targetNextNode = target.getNextNode();

            Node <Type> newNode = new Node <> (element);

            newNode.setNextNode(targetNextNode); //newNode passa a fazer referencia para o proximo nó do target
            targetNextNode.setPrevNode(newNode );

            target.setNextNode(newNode);
            newNode.setPrevNode(target);

            this.size ++;
        }
    }

    public void AddBefore(Type element, int pos){
        if(isEmpty()){
            AddLast(element);
        }else{
            if(pos == 0){
                AddFirst(element);
            }else{
                Node <Type> target = SearchByPosition_Node(pos);
                Node <Type> targetPrevNode = target.getPrevNode();
                Node <Type> newNode = new Node <> (element); 
                
                newNode.setNextNode(target);
                newNode.setPrevNode(targetPrevNode);
                targetPrevNode.setNextNode(newNode);

                target.setPrevNode(newNode);
                
                this.size++;
            }
        }
    }

    //Metodos de Remover
    public void RemoveFirst(){
        if(!isEmpty()){
            if(this.size == 1){
                this.first = null;
                this.last = null;
            } else {
                Node <Type> aux = this.first.getNextNode();

                this.first.setElement(null);
                this.first.setNextNode(null);

                this.first = aux;
                this.first.setPrevNode(null);
            }

            this.size--;
        }
    }

    public void RemoveLast(){
        if(!isEmpty()){
            if(this.size == 1){
                this.first = null;
                this.last = null;
            }else{
                Node <Type> aux = this.last.getPrevNode();

                this.last.setElement(null);
                this.last.setPrevNode(null);

                this.last = aux; //Atualiza o novo ultimo nó
                this.last.setNextNode(null);
            }
            this.size --;
        }
    }

    public void RemoveByPosition(int pos){
        if(!isEmpty()){
            if(pos == 0){
                RemoveFirst();
            }else if(pos == this.size - 1){
                RemoveLast();
            }else{
                Node <Type> target = SearchByPosition_Node(pos);
                Node <Type> targetPrevNode = target.getPrevNode();
                Node <Type> targetNextNode = target.getNextNode();
    
                targetNextNode.setPrevNode(targetPrevNode);
                targetPrevNode.setNextNode(targetNextNode);
    
                target.setElement(null);
                target.setNextNode(null);
                target.setPrevNode(null);
                
                this.size--;
            }
        }
    }

    public boolean RemoveByElement(Type element){
        if(!isEmpty()){
            if(SearchByElement(element) != NAO_ENCONTRADO){
                RemoveByPosition(SearchByElement(element));
                return true;
            }
        }
        return false;
    }

    public void Clear(){
        if(!isEmpty()){
            Node <Type> current = this.first;

            while(current != null){
                Node <Type> next = current.getNextNode(); //Guarda o nó seguinte no next
                current.setElement(null); //Limpa o elemento do nó atual
    
                //Limpa as conexões com proximo nó e com o nó anterior
                current.setNextNode(null);
                current.setPrevNode(null);
    
                current = next; //Atualiza o nó atual
            }
    
            this.first = this.last = null;
            this.size = 0;
        } else {
            System.out.println("Lista Vazia!");
        }
        
    }

    private Node <Type> SearchNode(int pos){

        if(!(pos >= 0 && pos < this.size)){ //Verifica se a posição buscada existe
            throw new IllegalArgumentException("Posição não existe");
        }

        Node <Type> atual = this.first;

        for(int i = 0; i < pos; i++){ // o i vai até a posição buscada
            atual = atual.getNextNode(); //Atualiza o valor de atual
        }

        return atual; //Retorna o Nó da posiçao
        
    }

    public Node <Type> SearchByPosition_Node(int pos){
        return SearchNode(pos); //Retorna o nó
    }

    public Type SearchByPosition_Element(int pos){
        return SearchNode(pos).getElement();
    }
    
    //Metodos de Buscar
    public int SearchByElement(Type element){

        Node <Type> current = this.first;
        int pos = 0;

        while(current != null){
            if(current.getElement().equals(element)){
                return pos; //Retorna a posição desse elemento
            }

            current = current.getNextNode();

            pos++;
        }

        return NAO_ENCONTRADO; //retorna -1
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    //Getters
    public Type getFirstElem(){
        return this.first.getElement();
    }

    public Type getLastElem(){
        return this.last.getElement();
    }

    public int getSize(){
        return this.size;
    }

    //toString
    @Override
    public String toString(){

        if(isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder();

        Node <Type> atual = this.first;

        for(int i = 0; i < this.size - 1; i++){
            builder.append(atual.getElement()).append(" <-> "); //Adciona o elemento do
            atual = atual.getNextNode();
        }
        builder.append(atual.getElement()); //Adiciona o ultimo elemento no builder

        
        return builder.toString(); //Retorna a String
    }

    public String toStringRever(){

        if(isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder();

        Node <Type> atual = this.last;

        while(atual.getPrevNode() != null){
            builder.append(atual.getElement()).append(" <-> "); //Adciona o elemento do
            atual = atual.getPrevNode();
        }
        builder.append(atual.getElement()); //Adiciona o ultimo elemento no builder

        
        return builder.toString(); //Retorna a String
    }
}

