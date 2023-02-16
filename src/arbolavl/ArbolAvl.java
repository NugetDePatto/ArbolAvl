package arbolavl;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolAvl {

    Nodo raiz;

    void insertarBin(int num) {
        if (raiz == null) {
            raiz = new Nodo(num);
        } else {
            insertarBin(raiz, num);
        }
    }

    Nodo insertarBin(Nodo aux, int num) {
        if (aux == null) {
            return new Nodo(num);
        } else if (num < aux.num) {
            aux.izq = insertarBin(aux.izq, num);
        } else {
            aux.der = insertarBin(aux.der, num);
        }
        
        
        //int altura_der = altura(aux.der);
        //int altura_izq = altura(aux.izq);
        
        //aux.altura = max(altura_der,altura_izq) //completa esto ^_- creo en java hay una funcion max checala
        
        //ya con esto cada nodo retornado es por donde navegaste, entonces conforme regresa
            // pues va calculando la altura para cada uno checale y me dices
        
        return aux;
    }

    void imprimir() {
        Queue<Nodo> cola = new LinkedList<Nodo>();

        if (raiz != null) {
            cola.add(raiz);

            while (!cola.isEmpty()) {
                if (cola.element().izq != null) {
                    cola.add(cola.element().izq);
                }

                if (cola.element().der != null) {
                    cola.add(cola.element().der);
                }

                System.out.print("[" + cola.element().num + " " + cola.poll().altura + "]");

            }
        }

        System.out.println("");

    }
/*
    
    int altura(nodo n) {
        if(n!=null) //soy hijo
        {
            return n.altura;
        }else return 0; //tengo altura 0 porque no soy hijo valido
    }
    */
    
    void altura(){
        System.out.println(altura(raiz));
    }
    
    int altura (Nodo nodo){
        if(nodo != null){
            int izq = altura(nodo.izq);
            int der = altura(nodo.der);
            
            int mayor = Integer.max(izq, der);
            nodo.altura = mayor + 1;
            return nodo.altura;
        } else {
            return 0;
        }
    }
}
