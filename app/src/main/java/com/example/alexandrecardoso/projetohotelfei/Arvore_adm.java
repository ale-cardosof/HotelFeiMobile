package com.example.alexandrecardoso.projetohotelfei;

public class Arvore_adm{
    // Atributos
    private Administrador raiz; // Primeiro Usuario
    public int n;
    /* 0 - Construtor */
    public Arvore_adm() {
        this.raiz = null;
        this.n = 0;
    }
    /* 1 - Insere */
    public void insere(Administrador x){
        // Anterior irá guardar o possível pai
        Administrador ptrAnterior;
        ptrAnterior = null;
        // Ponteiro Atual é quem percorre de fato a árvore
        Administrador ptrAtual;
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
        Administrador pai = x.getPai();
        // Balanceia a Árvore após a inserção
        while(pai != null){
            this.balanceia(pai);
            pai = pai.getPai();
        }
        this.imprimeEDR(); // Testes, retirar na versão final
    }
    /* 2 - Busca pelo username (ASC) */
    public Administrador buscaASC(Long x){
        Administrador ptrAnterior;
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
    public Administrador busca(String x){
        return buscaASC((this.geraAsc(x)));
    }
    /* 4  - Remove pelo username (ASC) */
    public Administrador remove(Long x){
        Administrador ptrRemovido = this.buscaASC(x);
        Administrador novoFilho;
        Administrador pai;
        int qntdFilhos;
        // Se o valor for encontrado
        if(ptrRemovido != null){
            qntdFilhos = this.contaFilhos(ptrRemovido);
            if (qntdFilhos == 2){
                // Nesse Caso, tem dois filhos
                Administrador atual = ptrRemovido.getDireita();
                Administrador anterior = atual;
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
                Administrador paiD = ptrRemovido.getPai();
                // Balanceia a Árvore após a inserção
                while(paiD != null){
                    this.balanceia(pai);
                    paiD = paiD.getPai();
                }
                return ptrRemovido;
            }
            // Se o valor não for encontrado
        }else{
            return null;
        }
        return null; // Nunca cairá aqui.
    }
    /* 5 - Conta filhos */
    public int contaFilhos(Administrador ptr){
        if((ptr.getEsquerda() != null) && (ptr.getDireita() != null))
            return 2;
        else if ((ptr.getEsquerda() != null) || (ptr.getDireita() != null))
            return 1;
        else
            return 0;
    }
    /* 6 - Altura */
    int altura(Administrador no){
        if(no == null)
            return -1;
        else
            return (this.maior((this.altura(no.getEsquerda())),(this.altura(no.getDireita())))+1);
    }
    /* 7 - Função Maior */
    public int maior(int a, int b){
        if (a == b)
            return a;
        else if (a > b)
            return a;
        else
            return b;
    }
    /* 8 - Função de Fator de Balanceamento */
    int FB(Administrador no){
        return ( (this.altura(no.getDireita())) - (this.altura(no.getEsquerda())));
    }
    /* 9 - Função de Balanceamento */
    void balanceia(Administrador pai){
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
    void rightRotate(Administrador x){
        // Cria ponteiros
        Administrador y = x.getEsquerda();
        Administrador b = y.getDireita();
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
    void leftRotate(Administrador y){
        // Cria ponteiros
        Administrador x = y.getDireita();
        Administrador b = x.getEsquerda();

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
    // 12 - Imprime EDR (Criada para testes)
    void imprimeEDR(){
        System.out.println("Ola papai. Esse é o nosso tamanho: " + n + "..");
        this.imprimeEDR(raiz);
        System.out.println("");
    }
    // 13 - Imprime Recursivo EDR (Criada para testes)
    void imprimeEDR(Administrador n){
        if(n != null){
            this.imprimeEDR(n.getEsquerda());
            this.imprimeEDR(n.getDireita());
            System.out.println(n.getUsernameASC());
        }
    }
    /* 14 - Converte String pra ASC */
    public Long geraAsc(String entrada) {
        String provisorio = "";
        char[] ascii2 = entrada.toCharArray();
        for(char ch:ascii2){
            provisorio = provisorio + (int)ch;
        }
        return Long.parseLong(provisorio);
    }
}