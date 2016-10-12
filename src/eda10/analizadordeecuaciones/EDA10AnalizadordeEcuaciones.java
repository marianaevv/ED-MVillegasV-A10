/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda10.analizadordeecuaciones;

import java.util.Scanner;
import ED.Stack;

/**
 *
 * @author Mariana Villegas
 */
public class EDA10AnalizadordeEcuaciones<T> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp;
        exp = solicitaExpresion();//A exp se le dará el valor que devuelva el metodo

        if (evaluarexpresion(exp) == true) {//Preguntamos por el resultado que haya mandado el metodo evaluador, si es verdadero la expresión esta balanceada
            System.out.println("La expresión esta balanceada");
        } else {
            System.out.println("La expresión NO esta balanceada");
        }
    }
/**
 * Metodo que pide al usuario la expresión a evaluar
 * @return e
 */
    public static String solicitaExpresion() {
        String e;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la expresión a evaluar");
        e = entrada.nextLine();
        return e;
    }
/**
 * Método que evalua la expresión dada por el usuario
 * @param exp
 * @return valor booleano
 */
    public static boolean evaluarexpresion(String exp) {
        Stack p = new Stack();// creamos un objeto de tipo Stack
        int i = 0;//contador
        while (i < exp.length()) {  // Mientras el contador sea menor que el tamaño de la expresión recorreremos el arreglo
            //Comenzamos a preguntar si el valor de la posicion es alguno de los siguientes caracteres, si es asi, los pondremos en la pila
            if (exp.charAt(i) == '(') {
                p.push('(');
                
            } else if (exp.charAt(i) == '{') {
                p.push('{');
                
            } else if (exp.charAt(i) == '[') {
                p.push('[');
            
            } else if (exp.charAt(i) == ')') {// Este if pregunta si el caracter en tal posición es parentesis derecho entonces
                if (p.getTop().getData().equals('(')){ // preguntará si la data que esta al tope de la fila es igual a un parentesis izquierdo, lo sacará 
                          p.pop();
                } else {// sino meterá en la pila el parentesis derecho
                    p.push(')');
                    
                }
            } else if (exp.charAt(i) == '}') {//Este if pregunta si el caracter en tal posición es llave derecha entonces
                if (p.getTop().getData().equals('{')){// preguntará si la data que esta al tope de la fila es igual a una llave izquierdo, la sacará 
                          p.pop();
                } else {
                    p.push('}');//sino meterá en la pila la llave derecha
                    
                }
            } else if (exp.charAt(i) == ']') {//Este if pregunta si el caracter en tal posición es corchete derecho entonces
                 if (p.getTop().getData().equals('[')){// preguntará si la data que esta al tope de la fila es igual a una corchete izquierdo, lp sacará 
                          p.pop();
                } else {
                    p.push(']');//sino meterá en la pila la corchete derecho
                    
                }// Preguntamos si el parentesis o corchete o llave son de cierre y se hará lo siguiente
            }

            i++;//se le suma 1 al contador para que avance a la siguiente posición
        }

        if (p.isEmpty()) {//preguntamos si la pila esta vacia, si es asi significa que no se quedarón caracteres en esta por lo que  esta balanceada
            return true;
        } else {//Si se quedo algun elemento en la pila significa que no esta balanceada
            return false;
        }
    }//fin del metodo

}
