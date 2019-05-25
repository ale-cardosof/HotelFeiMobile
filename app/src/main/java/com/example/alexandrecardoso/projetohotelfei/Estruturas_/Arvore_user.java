package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;

public class Arvore_user{
    // Atributos
    private Usuario raiz; // Primeiro Usuario
    public int n;
    /* 0 - Construtor */
    public Arvore_user() {
        this.raiz = null;
        this.n = 0;
    }

    /* 1 - Insere */
    public void insere(Usuario x){
        System.out.println("Inserindo o user: " + x.getUsername() + "..");
        // Anterior irá guardar o possível pai
        Usuario ptrAnterior;
        ptrAnterior = null;
        // Ponteiro Atual é quem percorre de fato a árvore
        Usuario ptrAtual;
        ptrAtual = raiz;
        // Procura quem vai ser o pai e armazena em Ponteiro Anterior
        while(ptrAtual != null){
            ptrAnterior = ptrAtual;
            if(x.getUsernameASC() < ptrAtual.getUsernameASC()){
                ptrAtual = ptrAtual.getEsquerda();
            }else{
                ptrAtual = ptrAtual.getDireita();
            }
        }
        if(ptrAnterior != null){
            if(x.getUsernameASC() < ptrAnterior.getUsernameASC()){
                ptrAnterior.setEsquerda(x);
            }else{
                ptrAnterior.setDireita(x);
            }
        }else{
            raiz = x;
        }
        x.setPai(ptrAnterior);
        n++;
        // Referencia o ponteiro pai para balancear
        Usuario pai = x.getPai();
        // Balanceia a Árvore após a inserção
        while(pai != null){
            this.balanceia(pai);
            pai = pai.getPai();
        }this.imprimeEDR(); // Testes, retirar na versão final
    }

    /* 2 - Busca pelo username (ASC) */
    public Usuario buscaASC(Long x){
        Usuario ptrAnterior;
        ptrAnterior = raiz;
        while(ptrAnterior != null){
            if(x.equals(ptrAnterior.getUsernameASC())){
                return ptrAnterior;
            }
            if(x > ptrAnterior.getUsernameASC()){
                ptrAnterior = ptrAnterior.getDireita();
            }else{
                ptrAnterior = ptrAnterior.getEsquerda();
            }
        }
        return null;
    }

    /* 3 - Busca pelo username (CHAR) */
    public Usuario busca(String x){
        return buscaASC((this.geraAsc(x)));
    }

    /* 4  - Remove pelo username (ASC) */
    public Usuario remove(Long x){
        Usuario ptrRemovido = this.buscaASC(x);
        Usuario novoFilho;
        Usuario pai;
        int qntdFilhos;
        // Se o valor for encontrado
        if(ptrRemovido != null){
            qntdFilhos = this.contaFilhos(ptrRemovido);
            if (qntdFilhos == 2){
                // Nesse Caso, tem dois filhos
                Usuario atual = ptrRemovido.getDireita();
                Usuario anterior = atual;
                // Acha o menor sucessor
                while(atual != null){
                    anterior = atual;
                    atual = atual.getEsquerda();
                }
                // Reposiciona filhos do que irá substituir o removido
                this.remove(anterior.getUsernameASC());
                // Substiui o removido pelo antecessor
                // ptrRemovido.setValor(anterior->getValor());
                // -- Aqui ao invés de fazer a linha acima, eu copiei o Usuário
                ptrRemovido.copiaUser(anterior);
            }else if(qntdFilhos == 1){
                // Nesse Caso, tem apenas 1 filho
                // Verifica se é o da esquerda
                if(ptrRemovido.getEsquerda() != null){
                    // Muda o endereçamento do pai
                    pai = ptrRemovido.getPai();
                    // Muda o endereçamento do filho direito
                    novoFilho = ptrRemovido.getEsquerda();
                    // Troca os endereçamentos do pai e do filho
                    pai.setEsquerda(novoFilho);
                    novoFilho.setPai(pai);
                    // Retorna o filho removido
                    return ptrRemovido;
                }else{
                    // Nesse Caso, tem apenas o da direita
                    // Muda o endereçamento do pai
                    pai = ptrRemovido.getPai();
                    // Muda o endereçamento do filho direito
                    novoFilho = ptrRemovido.getDireita();
                    // Troca os endereçamentos do pai e do filho
                    pai.setDireita(novoFilho);
                    novoFilho.setPai(pai);
                    // Returna o filho removido
                    return ptrRemovido;
                }
            }else{
                // Nesse Caso, não tem filhos, portanto, é só remover
                // Antes, verifica qual filho do pai será apontado para Null
                pai = ptrRemovido.getPai();
                if(pai != null){
                    if(x >= pai.getUsernameASC()){
                        pai.setDireita(null);
                    }else{
                        pai.setEsquerda(null);
                    }
                }else{
                    // Caso o Pai seja nulo, atribumos raiz para nulo e a arvore fica vazia
                    raiz = null;
                }
                // Referência o ponteiro pai
                Usuario paiD = ptrRemovido.getPai();
                // Balanceia a Árvore após a inserção
                while(paiD != null){
                    this.balanceia(pai);
                    paiD = paiD.getPai();
                }
                // Returna o filho removido
                return ptrRemovido;
            }
            // Se o valor não for encontrado
        }else{
            return null;
        }
        return null; // Nunca cairá aqui.
    }

    /* 5 - Conta filhos */
    public int contaFilhos(Usuario ptr){
        if((ptr.getEsquerda() != null) && (ptr.getDireita() != null))
            return 2;
        else if ((ptr.getEsquerda() != null) || (ptr.getDireita() != null))
            return 1;
        else
            return 0;
    }

    /* 6 - Altura */
    int altura(Usuario no){
        if(no == null)
            return -1;
        else
            return (this.maior((this.altura(no.getEsquerda())),(this.altura(no.getDireita())))+1);
    }

    /* 7 - Método Maior */
    public int maior(int a, int b){
        if (a == b)
            return a;
        else if (a > b)
            return a;
        else
            return b;
    }

    /* 8 - Método de Fator de Balanceamento */
    int FB(Usuario no){
        return ( (this.altura(no.getDireita())) - (this.altura(no.getEsquerda())));
    }

    /* 9 - Método de Balanceamento */
    void balanceia(Usuario pai){
        int fb = this.FB(pai);
        int fbdireita, fbesquerda;
        // Árvore já balanceada
        if (fb == -1 && fb == 1 && fb == 0)
            return;
        else if(fb == 2){
            // 1º Caso
            if(this.FB(pai.getDireita()) >= 0 ){
                this.leftRotate(pai);
                // 2º Caso
            }else if (this.FB(pai.getDireita()) < 0 ){
                this.rightRotate(pai.getDireita());
                this.leftRotate(pai);
            }
        }
        if(fb == -2){
            // 3º Caso
            if(this.FB(pai.getEsquerda()) <= 0 ){
                this.rightRotate(pai);
                // 4º Caso
            }else if (this.FB(pai.getEsquerda()) > 0 ){
                this.leftRotate(pai.getEsquerda());
                this.rightRotate(pai);
            }
        }
    }

    /* 10 - Right Rotate */
    void rightRotate(Usuario x){
        // Cria ponteiros
        Usuario y = x.getEsquerda();
        Usuario b = y.getDireita();
        // Y
        y.setPai(x.getPai());
        y.setDireita(x);
        // Muda filho do Pai do número rodado
        if (x.getPai() == null){
            // Não faz nada
        }
        else if(x.getPai().getDireita() == x){
            x.getPai().setDireita(y);
        }else{
            x.getPai().setEsquerda(y);
        }

        // X
        x.setPai(y);
        x.setEsquerda(b);
        // Se b existe, troca o pai
        if(b != null){
            b.setPai(x);
        }
        // Verifica se o pai é nulo, se for, fizemos left rotate na raiz
        if(y.getPai() == null){
            raiz = y;
        }
    }

    /* 11 - Left Rotate */
    void leftRotate(Usuario y){
        // Cria ponteiros
        Usuario x = y.getDireita();
        Usuario b = x.getEsquerda();

        // X
        x.setPai(y.getPai());
        x.setEsquerda(y);

        // Muda filho do Pai do número rodado
        if (y.getPai() == null){
            // Não faz nada
        }
        else if(y.getPai().getDireita() == y){
            y.getPai().setDireita(x);
        }else{
            y.getPai().setEsquerda(x);
        }

        // Y
        y.setPai(x);
        y.setDireita(b);

        // Se b existe, troca o pai
        if(b != null){
            b.setPai(y);
        }

        // Verifica se o pai é nulo, se for, fizemos left rotate na raiz
        if(x.getPai() == null){
            raiz = x;
        }
    }

    /* 12 - Imprime EDR (Criada para testes) */
    void imprimeEDR(){
        System.out.println("Ola papai. Esse é o nosso tamanho: " + n + "..");
        this.imprimeEDR(raiz);
        System.out.println("");
    }

    /* 13 - Imprime Recursivo EDR (Criada para testes) */
    void imprimeEDR(Usuario n){
        if(n != null){
            this.imprimeEDR(n.getEsquerda());
            this.imprimeEDR(n.getDireita());
            System.out.println(n.getUsernameASC());
        }
    }

    /* 14 - Converte String pra ASC */
    public Long geraAsc(String entrada) {
        if(entrada.length() > 8){
            return Long.parseLong("0");
        }
        String provisorio = "";
        char[] ascii2 = entrada.toCharArray();
        for(char ch:ascii2){
            provisorio = provisorio + ((int)ch - 48);
        }
        return Long.parseLong(provisorio);
    }
}