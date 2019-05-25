package com.example.alexandrecardoso.projetohotelfei.Classes;

abstract public class Pessoa {
    private String codPessoa;
    private String username;
    private Long usernameASC; // Chave
    private String senha;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String celular;


    public Pessoa() {
    }

    public Pessoa(String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        this.username = username;
        this.senha = senha;
        this.usernameASC = this.geraAsc(this.username);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.celular = celular;

    }
    public Pessoa(String codPessoa,String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        this.codPessoa = codPessoa;
        this.username = username;
        this.senha = senha;
        this.usernameASC = this.geraAsc(this.username);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.celular = celular;

    }

    public Long geraAsc(String entrada) {
        if(entrada.length() > 8){
            return Long.parseLong("0");
        }
        /* Converte String pra ASC */
        String provisorio = "";
        char[] ascii2 = entrada.toCharArray();
        for(char ch:ascii2){
            provisorio = provisorio + ((int)ch - 48); // Fazemos -47 pois queremos a tabela ASC a partir do 0
        }
        return Long.parseLong(provisorio);
    }

    public Long getUsernameASC() {
        return usernameASC;
    }

    public void setUsernameASC(Long usernameASC) {
        this.usernameASC = usernameASC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(String codPessoa) {
        this.codPessoa = codPessoa;
    }
}
