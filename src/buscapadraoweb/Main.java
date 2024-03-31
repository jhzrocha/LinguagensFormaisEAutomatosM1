/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }

    

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://guides.lib.montana.edu/citation/doi#:~:text=doi%3A%200000000%2F000000000000%20(access%20date%20if%20necessary).&text=Child%20%26%20Adolescent%20Psychiatry%2019%2C%20no,-010-0130-8.");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);

        //mapa do alfabeto
        char[] alfabeto = new char[38];
        alfabeto[0] = '0';
        alfabeto[1] = '1';
        alfabeto[2] = '2';
        alfabeto[3] = '3';
        alfabeto[4] = '4';
        alfabeto[5] = '5';
        alfabeto[6] = '6';
        alfabeto[7] = '7';
        alfabeto[8] = '8';
        alfabeto[9] = '9';
        alfabeto[10] = '.';
        alfabeto[11] = '/';
        alfabeto[12] = 'A';
        alfabeto[13] = 'B';
        alfabeto[14] = 'C';
        alfabeto[15] = 'D';
        alfabeto[16] = 'E';
        alfabeto[17] = 'F';
        alfabeto[18] = 'G';
        alfabeto[19] = 'H';
        alfabeto[20] = 'I';
        alfabeto[21] = 'J';
        alfabeto[22] = 'K';
        alfabeto[23] = 'L';
        alfabeto[24] = 'M';
        alfabeto[25] = 'N';
        alfabeto[26] = 'O';
        alfabeto[27] = 'P';
        alfabeto[28] = 'Q';
        alfabeto[29] = 'R';
        alfabeto[30] = 'S';
        alfabeto[31] = 'T';
        alfabeto[32] = 'U';
        alfabeto[33] = 'V';
        alfabeto[34] = 'W';
        alfabeto[35] = 'X';
        alfabeto[36] = 'Y';
        alfabeto[37] = 'Z';


        //mapa de estados
        String[] estados = new String[9];
        estados[0] = "q0";
        estados[1] = "q1";
        estados[2] = "q2";
        estados[3] = "q3";
        estados[4] = "q4";
        estados[5] = "q5";
        estados[6] = "q6";
        estados[7] = "q7";
        estados[8] = "q8";

        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = new String[1];
        estados_finais[0] = "q8";

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[9][38];
        //transições de q0
        matriz[get_string_ref(estados, "q0")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q1");

        //transições de q1
        matriz[get_string_ref(estados, "q1")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q2");

        //transições de q2
        matriz[get_string_ref(estados, "q2")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "q3");

        //transições de q3
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q4");
        matriz[get_string_ref(estados, "q3")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q4");

        //transições de q4
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q5");
        matriz[get_string_ref(estados, "q4")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q5");
        
        //transições de q5
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q6");
        matriz[get_string_ref(estados, "q5")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q6"); 

        //transições de q6
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "q7");
        matriz[get_string_ref(estados, "q6")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "q7"); 
        
        
        //transições de q7
        
        matriz[get_string_ref(estados, "q7")][get_char_ref(alfabeto, '/')] = get_string_ref(estados, "q8");


        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'A')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'B')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'C')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'D')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'E')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'F')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'G')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'H')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'I')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'J')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'K')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'L')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'M')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'N')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'O')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'P')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'Q')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'R')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'S')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'T')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'U')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'V')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'W')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'X')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'Y')] = -1;
        matriz[get_string_ref(estados, "q8")][get_char_ref(alfabeto, 'Z')] = -1;


      
        int estado = get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();


        String palavra = "";

        //varre o código-fonte de um código
        for (int i=0; i<codigoHTML.length(); i++){

            estado_anterior = estado;
            estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
            //se o não há transição
            if (estado == -1){
                //pega estado inicial
                estado = get_string_ref(estados, estado_inicial);
                // se o estado anterior foi um estado final
                if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                    //se a palavra não é vazia adiciona palavra reconhecida
                    if ( ! palavra.equals("")){
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                //zera palavra
                palavra = "";
                
            }else{
                //se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }


        //foreach no Java para exibir todas as palavras reconhecidas
        for (String p: palavras_reconhecidas){
            System.out.println (p);
        }


    }



}
