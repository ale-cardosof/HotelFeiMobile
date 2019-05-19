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
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Classes.Permissao;
import com.example.alexandrecardoso.projetohotelfei.R;
import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.tela;

public class menuInsercaoQuarto extends AppCompatActivity {
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private EditText edNumPorta, edValorDiaria, edqdtCama, edqtdChuveiro;
    ImageButton imgCamera,imgCamera2,imgCamera3,imgCamera4,imgCamera5, imgGaleria, imgGaleria2, imgGaleria3, imgGaleria4,imgGaleria5;
    private ImageView imgQuarto1,imgQuarto2,imgQuarto3,imgQuarto4,imgQuarto5;
    private  static  final int SELECAO_CAMERA = 100;
    private  static  final int SELECAO_GALERIA = 200;
    Quarto novoQuarto = new Quarto();
    private static int posImg;
    private static Bitmap imagem = null;
    private  RadioGroup rgTv;
    private  boolean possuiTv=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_insercao_quarto);
        edNumPorta = findViewById(R.id.ednumPorta);
        edValorDiaria = findViewById(R.id.edValorDiaria);
        edqdtCama = findViewById(R.id.edQtdCama);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro);
        rgTv = findViewById(R.id.radioGroup);

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


        // Retira barra superior com o nome do app
        getSupportActionBar().hide();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
/*
        if(resultCode == RESULT_OK){
            imagem = null;
            novoQuarto.adicionaImagem(imagem,posImg);

            try{
                switch (requestCode){
                    case SELECAO_CAMERA:
                        imagem = (Bitmap) data.getExtras().get("data");
                        novoQuarto.adicionaImagem(imagem,posImg);

                        break;
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        // Verificar espaço
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);
                        novoQuarto.adicionaImagem(imagem,posImg);
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

        } */
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


    public void limparCampos(){
        edNumPorta.setText("");
        edValorDiaria.setText("");
        edqdtCama.setText("");
        edqtdChuveiro.setText("");
        imgQuarto1.setImageBitmap(null);
        imgQuarto2.setImageBitmap(null);
        imgQuarto3.setImageBitmap(null);
        imgQuarto4.setImageBitmap(null);
        imgQuarto5.setImageBitmap(null);
        imagem  = null;
    }

    public boolean verificaPreenchimento(){
        if(edNumPorta.getText().toString().equals("") ||edValorDiaria.getText().toString().equals("")
        || edqdtCama.getText().toString().equals("") || edqtdChuveiro.getText().toString().equals("")){
            tela.exibir(getApplicationContext(),"Todos os campos precisam ser preenchidos!");
            return  false;
        }
        else if(imgQuarto1.getDrawable()==null){
            tela.exibir(getApplicationContext(),"Erro na inserção da imagem 1.");
            return  false;
        }
        return  true;
    }
/*
    public boolean verificaPorta(){

        for(int i=0;i<Estruturas.ldeQuartos.getSize();i++){
            Quarto quarto = Estruturas.ldeQuartos.getByIndex(i);
            if(quarto.getNumPorta()== (Integer.parseInt(edNumPorta.getText().toString()))){
                tela.exibir(getApplicationContext(),"Número de porta já existente.");
                return false;
            }
        }
        return true;
    }

    public void cadastraQuarto(View view){
        if(verificaPreenchimento() && verificaPorta()){
            novoQuarto.setNumPorta(Integer.parseInt(edNumPorta.getText().toString()));
            novoQuarto.setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
            novoQuarto.setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
            novoQuarto.setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
            verificaRadioButton();
            novoQuarto.setPossuiTv(possuiTv);
            Estruturas.ldeQuartos.insere(novoQuarto);
            tela.exibir(getApplicationContext(),"Quarto cadastrado com sucesso!");
            limparCampos();
            Intent intent = new Intent(menuInsercaoQuarto.this, menuEstruturaHotel.class);
            startActivity(intent);
        }
    }*/
}
