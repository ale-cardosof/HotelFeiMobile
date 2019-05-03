package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class usuario_editarSenha extends AppCompatActivity {
    private EditText edSenhaAntiga, edSenhaNova,edSenhaNovaDois;
    private TextView edUsuario;
    Usuario meuUsuario = Estruturas.usuariosCadastrados.busca(Estruturas.logado.username);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_editar_senha);
        getSupportActionBar().hide();

        edUsuario = findViewById(R.id.nomeDoUser);
        // Cria referencia para cada uma das caixas
        edSenhaAntiga = findViewById(R.id.edSenhaAntiga);
        edSenhaNova = findViewById(R.id.edSenhaNova);
        edSenhaNovaDois = findViewById(R.id.edSenhaNovaDois);
    }

    public void alteraSenha(View view){
        // Verifica se a senha atual está correta
        if(edSenhaAntiga.getText().toString().equals(meuUsuario.getSenha())){
            // Verifica se as novas senhas são iguais
            if(edSenhaNova.getText().toString().equals(edSenhaNovaDois.getText().toString())){
                // Altera a senha
                meuUsuario.setSenha(edSenhaNova.toString());
                tela.exibir(getApplicationContext(),"Senha Alterada com sucesso.");
                Intent intent = new Intent(this, usuario_editarinfo.class);
                startActivity(intent);
            }else{
                tela.exibir(getApplicationContext(),"A nova senha não confere com a confirmação.");
            }
        }else{
            tela.exibir(getApplicationContext(),"Senha Atual Incorreta!");
        }
    }

    public void voltar(View view){
        Intent intent = new Intent(this, usuario_editarinfo.class);
        startActivity(intent);
    }

}
