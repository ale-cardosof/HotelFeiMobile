package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Permissao;
import com.example.alexandrecardoso.projetohotelfei.R;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;
import static com.example.alexandrecardoso.projetohotelfei.Telas.menuEstruturaHotel.numeroQuarto;

public class menuAlterarQuarto extends AppCompatActivity {
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    EditText edNumPorta, edValorDiaria, edqdtCama, edqtdChuveiro;
    ImageButton imgCamera,imgCamera2,imgCamera3,imgCamera4,imgCamera5, imgGaleria, imgGaleria2, imgGaleria3, imgGaleria4,imgGaleria5;
    ImageView imgQuarto1,imgQuarto2,imgQuarto3,imgQuarto4,imgQuarto5;
    private  RadioGroup rgTv;

    private  boolean possuiTv=true;
    private  static  final int SELECAO_CAMERA = 100;
    private  static  final int SELECAO_GALERIA = 200;
    private static int posImg;
    private static boolean inserirPressionado = false;
    private static Bitmap imagem = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_alterar_quarto);
        edNumPorta = findViewById(R.id.ednumPorta);
        edValorDiaria = findViewById(R.id.edValorDiaria);
        edqdtCama = findViewById(R.id.edQtdCama);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro);
        imgCamera = findViewById(R.id.imgCamera);
        imgCamera2 = findViewById(R.id.imgCamera2);
        imgCamera3 = findViewById(R.id.imgCamera3);
        imgCamera4 = findViewById(R.id.imgCamera4);
        imgCamera5 = findViewById(R.id.imgCamera5);
        imgGaleria = findViewById(R.id.imgGaleria);
        imgGaleria2 = findViewById(R.id.imgGaleria2);
        imgGaleria3 = findViewById(R.id.imgGaleria3);
        imgGaleria4 = findViewById(R.id.imgGaleria4);
        imgGaleria5 = findViewById(R.id.imgGaleria5);
        imgQuarto1 = findViewById(R.id.imgQuarto1);
        imgQuarto2 = findViewById(R.id.imgQuarto2);
        imgQuarto3 = findViewById(R.id.imgQuarto3);
        imgQuarto4 = findViewById(R.id.imgQuarto4);
        imgQuarto5 = findViewById(R.id.imgQuarto5);
        rgTv = findViewById(R.id.radioGroup);

        //setDadosQuarto();

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        //this.setDadosQuarto();

        Permissao.validarPermissoes(permissoesNecessarias, this, 1);

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=0;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);

                }

            }
        });

        imgGaleria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=0;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });

        imgCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=1;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);

                }

            }
        });
        imgGaleria2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=1;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });
        imgCamera3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=2;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);

                }

            }
        });
        imgGaleria3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=2;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });
        imgCamera4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=3;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);

                }

            }
        });
        imgGaleria4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=3;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });
        imgCamera5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=4;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);

                }

            }
        });
        imgGaleria5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    posImg=4;
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });


    }
/*
    public void alteraImg(){
        for(int i = 0; i <= Estruturas.ldeQuartos.getSize(); i++){
            if(numeroQuarto == Estruturas.ldeQuartos.getByIndex(i).getNumPorta()){
                Estruturas.ldeQuartos.getByIndex(i).adicionaImagem(imagem,posImg);
                break;
    }
        }
    } */

    public void verificaRadioButton(){
        rgTv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton){
                    possuiTv = true;
                }else
                    possuiTv = false;
            }
        });
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            imagem = null;
            alteraImg();

            try{
                switch (requestCode){
                    case SELECAO_CAMERA:
                        imagem = (Bitmap) data.getExtras().get("data");
                        alteraImg();

                        break;
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);
                        alteraImg();
                        break;
                }

                if(imagem != null){
                    if(posImg==0) {
                        imgQuarto1.setImageBitmap(imagem);
                    }
                    if(posImg==1) {
                        imgQuarto2.setImageBitmap(imagem);
                    }
                    if(posImg==2) {
                        imgQuarto3.setImageBitmap(imagem);
                    }
                    if(posImg==3) {
                        imgQuarto4.setImageBitmap(imagem);
                    }
                    if(posImg==4) {
                        imgQuarto5.setImageBitmap(imagem);
                    }

                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int permissaoResultado : grantResults){
            if( permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    public void alertaValidacaoPermissao(){
        //informar que precisa aceitar permissao
    }

    public void limparCampos(){
        edNumPorta.setText("");
        edValorDiaria.setText("");
        edqdtCama.setText("");
        edqtdChuveiro.setText("");
    }

    public void setDadosQuarto(){
        int i;
       for(i=0; i <= Estruturas.ldeQuartos.getSize();i++){
            if(numeroQuarto == Estruturas.ldeQuartos.getByIndex(i).getNumPorta()){
                Log.d("Eita", "Diaria=" +Estruturas.ldeQuartos.getByIndex(i).getValorDiaria());
                edNumPorta.setText(""+Estruturas.ldeQuartos.getByIndex(i).getNumPorta());
                edValorDiaria.setText(""+Estruturas.ldeQuartos.getByIndex(i).getValorDiaria());
                edqdtCama.setText(""+ Estruturas.ldeQuartos.getByIndex(i).getQntdCamas());
                edqtdChuveiro.setText(""+Estruturas.ldeQuartos.getByIndex(i).getQntdChuveiros());
                imgQuarto1.setImageBitmap(Estruturas.ldeQuartos.getByIndex(i).retornaImagem(0));
                imgQuarto2.setImageBitmap(Estruturas.ldeQuartos.getByIndex(i).retornaImagem(1));
                imgQuarto3.setImageBitmap(Estruturas.ldeQuartos.getByIndex(i).retornaImagem(2));
                imgQuarto4.setImageBitmap(Estruturas.ldeQuartos.getByIndex(i).retornaImagem(3));
                imgQuarto5.setImageBitmap(Estruturas.ldeQuartos.getByIndex(i).retornaImagem(4));
                break;

            }
            else{

            }

        }
}

    public void alteraQuarto(View view){
        int i;
        for(i=0; i <= Estruturas.ldeQuartos.getSize();i++){
            if(numeroQuarto == Estruturas.ldeQuartos.getByIndex(i).getNumPorta()){
                this.verificaRadioButton();
                Estruturas.ldeQuartos.getByIndex(i).setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
                Estruturas.ldeQuartos.getByIndex(i).setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
                Estruturas.ldeQuartos.getByIndex(i).setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
                Estruturas.ldeQuartos.getByIndex(i).setPossuiTv(possuiTv);
                break;
            }
            else{

            }
        }
        tela.exibir(getApplicationContext(),"Quarto alterado com sucesso!");
        limparCampos();
        finish();
    } */
}
