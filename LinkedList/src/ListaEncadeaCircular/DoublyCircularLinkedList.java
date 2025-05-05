package ListaEncadeaCircular;

public class DoublyCircularLinkedList <Type> {
    private Node <Type> first;
    private Node <Type> last;
    private int count = 0;

    public void insert(Type element){
        Node <Type> new_node = new Node<>(element);

        if(count == 0){
            this.last = new_node;
            //Esse unico nó vai apontar para si mesmo
            new_node.setNextNode(new_node); 
            new_node.setPrevNode(new_node);
        }else{

            new_node.setNextNode(this.first); //O proximo nó do novo primeiro nó vai ser o antigo primeiro nó
            new_node.setPrevNode(this.last); //o nó anterior do novo primeiro nó vai ser o ultimo nó

            this.first.setPrevNode(new_node); //O nó anterior ao antigo primeiro nó vai ser o novo primeiro nó
            this.last.setNextNode(new_node); //O proximo nó do ultimo nó vai ser o novo primeiro nó;
        }

        this.first = new_node; //Atualiza o novo primeiro nó

        this.count++;
    }

    public void append(Type element){
        Node <Type> new_node = new Node<>(element);

        if(count == 0){
            this.first = new_node;
            
        }else{
            this.last.setNextNode(new_node); 
            new_node.setPrevNode(this.last); //O nó anterior do novo nó eh o ultimo nó atual
        }

        this.last = new_node; //Atualiza o novo ultimo nó

        this.last.setNextNode(this.first); //Ultimo nó faz o primeiro nó ser o seu proximo nó
        this.first.setPrevNode(this.last); //primeiro nó faz o ultimo nó ser o seu nó antecessor

        this.count ++;
    }

    public Node <Type> removeHead(){
        if(isEmpty()){
            return null;
        }
        Node <Type> target = this.first;
        Node <Type> next = this.first.getNextNode();
            
        this.last.setNextNode(next);
        next.setPrevNode(this.last);

        //Limpa e Desconecta o antigo primeiro nó com a lista
        this.first.setElement(null);
        this.first.setNextNode(null);
        this.first.setPrevNode(null);

        this.first = next; // Atualiza o novo primeiro nó (Que vai ser o nó seguinte )
        
        this.count--;

        return target; //Retorna a referencia   
    }
    
    public Node<Type> removeTail(){
        if(isEmpty()){
            return null;
        }
        Node <Type> target = this.last;
        Node <Type> prev = this.last.getPrevNode();

        this.first.setPrevNode(prev);
        prev.setNextNode(this.first);
        
        //Limpa e Desconecta o antigo ultimo nó com a lista
        this.last.setElement(null);
        this.last.setNextNode(null);
        this.last.setPrevNode(null);
        
        this.last = prev;
        this.count--;

        return target;
    }

    public Node<Type> removeNode(Type element){

        if(isEmpty()) return null;

        Node <Type> target = getNode(element);

        if(target == null){
            return null;
        }

        if (target == this.first) return removeHead();
        if (target == this.last) return removeTail();

        Node <Type> prev = target.getPrevNode();
        Node <Type> next = target.getNextNode();

        prev.setNextNode(next);
        next.setPrevNode(prev);

        target.setElement(null);
        target.setNextNode(null);
        target.setPrevNode(null);

        this.count--;

        return target;
    }

    public Node<Type> getHead(){
        if(!isEmpty()){
            return this.first;
        }

        return null;
    }

    public Node<Type> getTail(){
        if(!isEmpty()){
            return this.last;
        }

        return null;
    }

    public Node<Type> getNode(Type element){
        Node <Type> current = this.first;

        for(int i = 0; i < this.count; i++){
            if(current.getElement().equals(element)){
                return current;
            }
            current = current.getNextNode();
        }

        return null;
    }

    public int count(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count == 0;
    }

    public void clear(){
        if(this.count == 0){
            System.out.println("Lista vazia");
        }else{
            while(!isEmpty()){
                removeHead();
            }
        }
    }

    @Override
    public String toString(){

        if(isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder();

        Node <Type> atual = this.first;
        for(int i = 0; i < this.count; i++){
            builder.append(atual.getElement()).append(" <-> ");
            atual = atual.getNextNode();
        }
        builder.append("(volta ao início)");

        return builder.toString();
    }
}
