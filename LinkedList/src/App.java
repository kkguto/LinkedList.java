// import ListaEncadeada.DoublyLinkedList;
// import ListaEncadeada.LinkedList;
// import ListaEncadeaCircular.CircularLinkedList;
import ListaEncadeaCircular.DoublyCircularLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        // LinkedList <Integer> lista = new LinkedList<>(); //Aqui inicializamos a lista como inteiros
        // DoublyLinkedList <Integer> lista_dupla = new DoublyLinkedList<>(); //Aqui inicializamos a lista como inteiros
        // CircularLinkedList <Integer> lista_cicular = new CircularLinkedList<>();
        DoublyCircularLinkedList <Integer> lista_dupla_circular = new DoublyCircularLinkedList<>();
        
        lista_dupla_circular.append(1);
        lista_dupla_circular.append(2);
        lista_dupla_circular.append(3);
        lista_dupla_circular.insert(4);
        lista_dupla_circular.insert(5);
        lista_dupla_circular.insert(6);
        System.out.println(lista_dupla_circular);
        lista_dupla_circular.removeHead();
        System.out.println(lista_dupla_circular);
        /*     
        lista_cicular.AddLast(1);
        lista_cicular.AddLast(2);
        lista_cicular.AddLast(3);

        lista_cicular.AddFirst(4);
        lista_cicular.AddFirst(5);
        lista_cicular.AddFirst(6);
        System.out.println(lista_cicular);
        lista_cicular.AddAfter(9, 2);
        lista_cicular.AddAfter(7,4);
        System.out.println(lista_cicular);
        */

        /*
        lista_dupla.AddLast(1);
        lista_dupla.AddLast(2);
        lista_dupla.AddLast(3);
        lista_dupla.AddLast(4);
        lista_dupla.AddLast(5);
        lista_dupla.AddLast(6);

        lista_dupla.AddFirst(9);
        lista_dupla.AddFirst(8);

        System.out.println("\nOrdem do First para o Last:");
        System.out.println(lista_dupla.toString());

        System.out.println("\nOrdem do Last para o First:");
        System.out.println(lista_dupla.toStringRever());

        System.out.println("\nRemoção");
        lista_dupla.RemoveFirst();
        System.out.println(lista_dupla);
        System.out.println("Primeiro Valor: " + lista_dupla.getFirstElem());
        System.out.println("Ultimo valor: " + lista_dupla.getLastElem());

        lista_dupla.RemoveByPosition(2);
        System.out.println(lista_dupla);
        System.out.println(lista_dupla.toStringRever());
        */


        /*
        lista.Add(6);
        System.out.println(lista);
        lista.Add(3);
        System.out.println(lista);

        lista.AddBegin(5);
        System.out.println(lista);

        lista.Add(1);
        System.out.println(lista);

        lista.SetElementInNode(2, 2);
        System.out.println(lista);

        lista.AddBefore(8, 2);
        System.out.println(lista);

        lista.RemoveInPosition(3);
        System.out.println(lista);

        System.out.println("***Busca por Elemento***");
        System.out.println(lista.SearchByElement(5));
        System.out.println(lista.SearchByElement(8));
        System.out.println(lista.SearchByElement(1));
        System.out.println(lista.SearchByElement(6));

        System.out.println("***Busca por Posição***");
        System.out.println(lista.SearchByPosition_Element(0));
        System.out.println(lista.SearchByPosition_Element(1));
        System.out.println(lista.SearchByPosition_Element(2));
        System.out.println(lista.SearchByPosition_Element(3));
        System.out.println(lista.SearchByPosition_Element(4));
        // System.out.println(lista.SearchByPosition_Element(-1));
        

        System.out.println(lista.SearchByPosition_Element(10));
        */
    }
}
