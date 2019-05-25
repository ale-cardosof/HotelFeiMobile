package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

public class LES<Bitmap>{
    public Bitmap v[] = (Bitmap[]) new Object[5];
    public int n;
    /* 0 - Construtor */
    public LES(){
        this.n = 0;
    }

    /* 1 - Método de inserção */
    public boolean insere(Bitmap x, int posicao){
        if (n == 5 || posicao > 4){
            return false; // Não admite mais que 5 imagens
        }

        /*
        if(this.busca(x) != -1){
            return false; // Não admite duas imagens iguais no vetor
        }*/

        /* Joga o valor inserido na posição de inserção e aumenta o total de números inseridos */
        v[posicao] = x;
        n++;
        return true;
    }

    /* 2 - Método de busca */
    public Bitmap busca(int x){
        return v[x];
    }

    /* 3 - Método de impressão */
    public void imprime(){
        if (n == 0){
            System.out.println("LES vazia! Insira novos numeros.\n");
        }else{
            int i;
            System.out.println("[");
            for(i=0;i<n;i++){
                if (i==0){
                    System.out.println(v[i]);
                }else{
                    System.out.println(",");
                    System.out.println(v[i]);
                }
            }
            System.out.println("]");
            System.out.println("Numeros inseridos: " + n);
        }
    }

    /* 4 - Método Remove */
    boolean removeI(int idx){
        if(idx > n || idx < 0){
            // Indice Inválido
            return false;
        }else{
            // Se o indice for menor que o total de números inseridos - 1, joga o indice pra frente
            // Fazemos isso, para mover da direita p/ esquerda os valores da lista
            for(; idx < n-1 ;idx++){
                v[idx] = v[idx+1];
            }
            // Ao fim do laço, removemos 1 do total de números inseridos
            n--;
            return true;
        }
    }

}