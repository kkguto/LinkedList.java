package ListaEncadeada;

public class Node <Type>{ //<Type> eh um tipo generico, pode ser qualquer tipo de dados
    
    //Esse type vai ser declarado quando a lista for criada
    private Type element; 
    private Node <Type> nextNode; //next_node guarda a referencia do proximo Nó
    private Node <Type> prevNode; //previous_node guarda a referencia do Nó anterior

    public Node(Type element) {
        this.element = element;
        this.nextNode = null;
        this.prevNode = null;
    }

    public Node(Type element, Node<Type> nextNode, Node<Type> prevNode) {
        this.element = element;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public void setElement(Type element){
        this.element = element; //Define um novo valor para element
    }
    
    public void setNextNode(Node <Type> nextNode){
        this.nextNode = nextNode; //Define uma nova referencia do proximo Nó
    }
    
    public void setPrevNode(Node <Type> prevNode){
        this.prevNode = prevNode; //Define uma nova referencia do Nó anterior
    }

    public Type getElement(){
        return element; //Retorna o valor do elemento
    }

    public Node <Type> getNextNode(){
        return nextNode; // Retorna a referencia do proximo Nó
    }

    public Node <Type> getPrevNode(){
        return prevNode; // Retorna a referencia do Nó anterior
    }
    
}
