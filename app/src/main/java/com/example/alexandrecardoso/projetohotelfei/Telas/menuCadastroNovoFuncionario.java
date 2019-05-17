package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.alexandrecardoso.projetohotelfei.Classes.Administrador;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.admsCadastrados;
import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.referencia;

public class menuCadastroNovoFuncionario extends AppCompatActivity {
    public static FirebaseAuth administrador_cad = FirebaseAuth.getInstance();
    public static DatabaseReference administradores = referencia.child("administradores");
    private EditText edUsuario, edNome, edCPF,edData, edEmail, edCelular, edSenha, edSenhaConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cadastro_novo_funcionario);
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

    public void cadastraFuncionario(View view){
        boolean preenchimento = false,senhas = false,caracterEspecial = false,tamanhoUserName = false,existencia = false;
        // Verifica se todos os campos estão preenchidos
        preenchimento = this.verificaPreenchimento();
        if(preenchimento){
            // Verifica veracidade da senha
            senhas = this.verificaSenha();
            if(senhas){
                // Verifica se tem acento ou ponto
                caracterEspecial = this.verificaCaracterEspecial();
                if(caracterEspecial){
                    // Verifica se o tamanho do username digitado tem 8 ou menos caracteres
                    tamanhoUserName = this.verificaTamanhoUserName();
                    if(tamanhoUserName){
                        // Verifica se já existe
                        existencia = this.verificaExistencia();
                    }
                }
            }
        }
        // Se tudo estiver ok, cria o usuário
        if(preenchimento && senhas && caracterEspecial && tamanhoUserName && existencia){
            final Administrador novoAdm = new Administrador(edUsuario.getText().toString(),edNome.getText().toString(),edCPF.getText().toString(),edData.getText().toString(),edEmail.getText().toString(),edCelular.getText().toString(),edSenha.getText().toString());
            //administradores.push().setValue(novoAdm);
            administrador_cad.createUserWithEmailAndPassword(novoAdm.getEmail(),novoAdm.getSenha())
                    .addOnCompleteListener(menuCadastroNovoFuncionario.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                tela.exibir(getApplicationContext(),"Erro ao cadastrar administrador!");
                                Log.w("O que foi", "getInstanceId failed", task.getException());

                            }
                            else{
                                administradores.push().setValue(novoAdm);
                                tela.exibir(getApplicationContext(),"Administrador cadastrado com sucesso!");
                            }
                        }
                    });

            /*Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);*/
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

    public boolean verificaSenha(){
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
    }

    public boolean verificaTamanhoUserName(){
        // Verifica se o campo username tem 8 ou menos caracteres
        if(edUsuario.getText().toString().length() > 8){
            tela.exibir(getApplicationContext(),"Username inválido (mais de 8 caracteres)");
            return false;
        }
        return true;
    }

    public boolean verificaExistencia(){
        // Verifica se aquele nome de usuário já existe
        if((admsCadastrados.busca(edUsuario.getText().toString())) != null){
            tela.exibir(getApplicationContext(),"Username já existente. Escolha outro.");
            return false;
        }
        return true;
    }

    public boolean verificaCaracterEspecial(){
        char atual;
        for (int i=0; i<edUsuario.getText().toString().length(); i++) {
            atual = edUsuario.getText().toString().charAt(i);
            // Se o char não é letra ou número, retorna falso
            if((!(Character.isLetter(atual))) && (!(Character.isDigit(atual)))){
                tela.exibir(getApplicationContext(),"O Username digitado contém caracteres especiais (" + atual + ")." );
                return false;
            }
        }
        return true;
    }
}
