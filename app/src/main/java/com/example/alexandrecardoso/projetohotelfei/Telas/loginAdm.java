package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.Classes.Administrador;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuario_cad;
import static com.example.alexandrecardoso.projetohotelfei.Telas.menuCadastroNovoFuncionario.administrador_cad;

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
        final int login;
        String admProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        // Caso o login seja efetuado abre o menu principal

        administrador_cad.signInWithEmailAndPassword(admProcurado,senhaDigitada)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                tela.exibir(getApplicationContext(),"Erro ao logar adm!");
                                Log.w("O que foi", "getInstanceId failed", task.getException());
                                tela.exibir(getApplicationContext(),""+ task.getException());
                            }
                            else{
                                tela.exibir(getApplicationContext(),"Logado com sucesso!");
                                Intent intent = new Intent(loginAdm.this, menuAdministrador.class);
                                startActivity(intent);
                            }
                        }
                    });

    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(loginAdm.this, menuUsuario.class);
        startActivity(intent);
    }
}
