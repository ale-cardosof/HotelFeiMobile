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
                            //Verificar logado
                            if(usuario_cad.getCurrentUser() != null){
                                tela.exibir(getApplicationContext(),"Usuario Logado " + usuario_cad.getCurrentUser().getEmail());
                            }
                            else{
                                tela.exibir(getApplicationContext(),"Usuario Deslogado");
                            }
                            Intent intent = new Intent(loginUser.this, UsuarioMenu.class);
                            startActivity(intent);
                        }
                    }
                });

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
