package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.Classes.Administrador;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;

public class loginAdm extends AppCompatActivity {
    TextInputEditText input_username, input_password;
    // teste
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adm);
        getSupportActionBar().hide();
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
    }

    public void loginAdm(View view){
        int login;
        String admProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        login = tryLogin(admProcurado,senhaDigitada);

        // Caso o login seja efetuado abre o menu principal
        if(login == 0){
            tela.exibir(getApplicationContext(),"Logado com sucesso!");
            Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);
        }else if(login == 1){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Senha Incorreta). Tente novamente");
        }else if(login == 2){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Usuário Inválido). Tente novamente");
        }else if(login == 3){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Erro Inesperado). Tente novamente");
        }
    }

    public int tryLogin(String admProcurado, String senhaDigitada){
        int aux = 3;
        Long admProcuradoAsc = this.geraAsc(admProcurado);
        Administrador admBuscado = Estruturas.admsCadastrados.buscaASC(admProcuradoAsc);
        // Usuário encontrado
        if(admBuscado != null){
            // Senha correta
            if(admBuscado.getSenha().equals(senhaDigitada)){
                // Login efetuado
                // Guarda o usuario logado
                Estruturas.logado.user = admBuscado;
                Estruturas.logado.username = admProcurado;
                Estruturas.logado.usernameASC = admProcuradoAsc;
                Estruturas.logado.tipoUser = 1;
                aux = 0;
                Log.d("UsuarioLogado", "Antes de criar user");
            }else{// Senha incorreta
                // Aviso sobre senha incorreta
                aux = 1;
            }
        }else{ // Usuário não existe
            // Aviso sobre usuario não existente
            aux = 2;
        }return aux;
    }

    public Long geraAsc(String entrada) {
        if(entrada.equals("")){
            return Long.parseLong("0");
        }else{
            /* Converte String pra ASC */
            String provisorio = "";
            char[] ascii2 = entrada.toCharArray();
            for(char ch:ascii2){
                provisorio = provisorio + ((int)ch - 48);
            }
            return Long.parseLong(provisorio);
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(loginAdm.this, menuUsuario.class);
        startActivity(intent);
    }
}
