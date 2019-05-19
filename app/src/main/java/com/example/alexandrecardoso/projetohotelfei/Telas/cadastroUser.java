package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;


public class cadastroUser extends AppCompatActivity {

    public static DatabaseReference referencia  = FirebaseDatabase.getInstance().getReference();
    public static FirebaseAuth usuario_cad = FirebaseAuth.getInstance();
    public static DatabaseReference usuarios = referencia.child("usuarios");
    private EditText edUsuario, edNome, edCPF,edData, edEmail, edCelular, edSenha, edSenhaConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        edUsuario = findViewById(R.id.ednumPorta);
        edNome = findViewById(R.id.edSenhaAntiga);
        edCPF = findViewById(R.id.edSenhaNova);
        edData = findViewById(R.id.edSenhaNovaDois);
        edEmail = findViewById(R.id.edqtdChuveiro);
        edCelular = findViewById(R.id.edCelular);
        edSenha = findViewById(R.id.edSenha);
        edSenhaConf = findViewById(R.id.edSenhaConf);
    }

    public void cadastraUsuario(View view){
        boolean preenchimento = false,senhas = false,caracterEspecial = false,tamanhoUserName = false,existencia = false;
        // Verifica se todos os campos estão preenchidos
        preenchimento = this.verificaPreenchimento();
        // Se tudo estiver ok, cria o usuário
        if(preenchimento && existencia){
            final Usuario novoUser = new Usuario(edUsuario.getText().toString(),edNome.getText().toString(),edCPF.getText().toString(),edData.getText().toString(),edEmail.getText().toString(),edCelular.getText().toString(),edSenha.getText().toString());
            //usuariosCadastrados.insere(novoUser);
            usuario_cad.createUserWithEmailAndPassword(novoUser.getEmail(),novoUser.getSenha())
                    .addOnCompleteListener(cadastroUser.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                tela.exibir(getApplicationContext(),"Erro ao cadastrar usuário!");
                                Log.w("O que foi", "getInstanceId failed", task.getException());

                            }
                            else{
                                usuarios.push().setValue(novoUser);
                                tela.exibir(getApplicationContext(),"Usuário cadastrado com sucesso!");
                            }
                        }
                    });


            // Volta para tela de Login
            Intent intent = new Intent(this, loginUser.class);
            startActivity(intent);
        }
    }

    public boolean verificaPreenchimento(){
        // Verifica se todos os campos estão preenchidos corretamente
        if(edUsuario.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Username não informado.");
            return false;
        }else if(edNome.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Nome do Usuário não informado.");
            return false;
        }else if(edCPF.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"CPF não informado.");
            return false;
        }else if(edData.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Data de Nascimento não informada.");
            return false;
        }else if(edEmail.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"E-mail não informado.");
            return false;
        }else if(edCelular.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Celular não informado.");
            return false;
        }else if(edSenha.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Senha não informada.");
            return false;
        }else if(edSenhaConf.getText().toString().length() == 0){
            tela.exibir(getApplicationContext(),"Confirmação de Senha não informada.");
            return false;
        }
        return true;
    }

    /*public boolean verificaSenha(){
        // Verifica se as senhas tem mais 4 digitos
        if(edSenha.getText().toString().length() < 4){
            tela.exibir(getApplicationContext(),"Senha informada tem menos de 4 digitos.");
            return false;
        }
        // Verifica se são diferentes
        if(!(edSenha.getText().toString().equals(edSenhaConf.getText().toString()))){
            tela.exibir(getApplicationContext(),"Senha e Confirmação de Senha são diferentes. ");
            return false;
        }
        return true;
    }*/


   /* public boolean verificaExistencia(){
        // Verifica se aquele nome de usuário já existe
        if((usuariosCadastrados.busca(edUsuario.getText().toString())) != null){
            tela.exibir(getApplicationContext(),"Username já existente. Escolha outro.");
            return false;
        }
        return true;
    } */


}
