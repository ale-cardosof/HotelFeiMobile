package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Usuario;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.referencia;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuario_cad;
import static com.example.alexandrecardoso.projetohotelfei.Telas.cadastroUser.usuarios;

public class usuario_editarinfo extends AppCompatActivity {
    private EditText edNome, edCPF,edData, edEmail, edCelular;
    private TextView edUsuario;
    //usuario_cad.getCurrentUser().getEmail().toString()
    DatabaseReference usuariose = referencia.child("usuarios").child("email");
    Query usuarioPesquisa = usuarios.orderByChild("email").equalTo(usuario_cad.getCurrentUser().getEmail().toString());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_editarinfo);
        getSupportActionBar().hide();
        this.atualizaInfo();
     }

     public void atualizaInfo(){
         edUsuario = findViewById(R.id.nomeDoUser);
         // Cria referencia para cada uma das caixas
         edNome = findViewById(R.id.edSenhaAntiga);
         edCPF = findViewById(R.id.edSenhaNova);
         edData = findViewById(R.id.edSenhaNovaDois);
         edEmail = findViewById(R.id.edqtdChuveiro);
         edCelular = findViewById(R.id.edCelular);

         // Edita as caixas com os valores atuais do usuário logado
        /* edUsuario.setText("Alterando as informações de: " + logado.user.getUsername());
         edNome.setText(logado.user.getNome());
         edCPF.setText(logado.user.getCpf());
         edData.setText(logado.user.getDataNascimento());
         edEmail.setText(logado.user.getEmail());
         edCelular.setText(logado.user.getCelular()); */

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario alt_User = new Usuario();
                // usando o for abaixo impede que o objeto jogador retorne nulo
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    alt_User = childSnapshot.getValue(Usuario.class);
                }
                edUsuario.setText("Alterando as informações de: " + alt_User.getUsername());
                edNome.setText(alt_User.getNome());
                edCPF.setText(alt_User.getCpf());
                edData.setText(alt_User.getDataNascimento());
                edEmail.setText(alt_User.getEmail());
                edCelular.setText(alt_User.getCelular());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

     }

    public void editaInfo(View view){
         Usuario muda_user = new Usuario();
         muda_user.setNome(edNome.getText().toString());
         muda_user.setCpf(edCPF.getText().toString());
         muda_user.setDataNascimento(edData.getText().toString());
         muda_user.setEmail(edEmail.getText().toString());
         muda_user.setCelular(edCelular.getText().toString());
         tela.exibir(getApplicationContext(),"Informações atualizadas com sucesso.");
         this.atualizaInfo();
     }

     public void alteraSenha(View view){
         Intent intent = new Intent(this, usuario_editarSenha.class);
         startActivity(intent);

     }
}
