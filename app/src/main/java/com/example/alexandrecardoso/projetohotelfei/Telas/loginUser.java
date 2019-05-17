package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuario_cad;

public class loginUser extends AppCompatActivity {
    TextInputEditText input_username, input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().hide();
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
    }

    public void loginUser(View view){
        int login;
        String userProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        usuario_cad.signInWithEmailAndPassword(userProcurado,senhaDigitada)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            tela.exibir(getApplicationContext(),"Erro ao cadastrar usuário!");
                            Log.w("O que foi", "getInstanceId failed", task.getException());
                            tela.exibir(getApplicationContext(),""+ task.getException());
                        }
                        else{
                            tela.exibir(getApplicationContext(),"Logado com sucesso!");
                            Intent intent = new Intent(loginUser.this, UsuarioMenu.class);
                            startActivity(intent);
                        }
                    }
                });

    }

    public int tryLogin(String userProcurado, String senhaDigitada){
        int aux = 3;
        Long userProcuradoAsc = this.geraAsc(userProcurado);
        Usuario usuarioBuscado = Estruturas.usuariosCadastrados.buscaASC(userProcuradoAsc);
        // Usuário encontrado
        if(usuarioBuscado != null){
            // Senha correta
            if(usuarioBuscado.getSenha().equals(senhaDigitada)){
                // Login efetuado
                // Guarda o usuario logado
                Estruturas.logado.user = usuarioBuscado;
                Estruturas.logado.username = userProcurado;
                Estruturas.logado.usernameASC = userProcuradoAsc;
                Estruturas.logado.tipoUser = 2;
                aux = 0;
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

    public void novoCadastro(View view){
        Intent intent = new Intent(this, cadastroUser.class);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent = new Intent(loginUser.this, menuUsuario.class);
        startActivity(intent);
    }
}
