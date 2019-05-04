package com.example.alexandrecardoso.projetohotelfei;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.*;

public class UsuarioNovaReserva extends AppCompatActivity {

    private Button btnDataEntrada, btnDataSaida, btnDataReserva, btnVerificarDisp, btnReservar;
    private CalendarView cvDataReserva;
    private Quarto quartoReserva;
    private Date dataEntradaReserva, dataSaidaReserva;
    private double valDiaria = 0,valTotal;
    public static Quarto quarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_nova_reserva);
        getSupportActionBar().hide();

        // Captura o quarto recebido, passa para uma variavel privada e destroi a publica estatica
        quartoReserva = quarto;
        quarto = null;

        // Atribui os botoes à suas respectivas views
        btnDataEntrada = findViewById(R.id.btnDataEntrada);
        btnDataSaida = findViewById(R.id.btnDataSaida);
        cvDataReserva = findViewById(R.id.cvDataReserva);
        btnVerificarDisp = findViewById(R.id.btnVerificarDisp);
        btnReservar = findViewById(R.id.btnReservar);
        // Atribui o valor da diaria do quarto
        valDiaria = quartoReserva.getValorDiaria();

        // Atribui imagem do quarto recebido à ImageView
        ((ImageView)findViewById(R.id.imvQuarto)).setImageResource(quartoReserva.getImagemQuarto());
        // Atribui os textos de informações sobre o quarto
        ((TextView)findViewById(R.id.lblValorDiaria)).setText(String.valueOf(quartoReserva.getValorDiaria()));
        ((TextView)findViewById(R.id.lblValorDia)).setText(String.valueOf(valDiaria));
        ((TextView)findViewById(R.id.lblNumQuarto)).setText(String.valueOf(quartoReserva.getNumPorta()));

        // Seta o calendario como invisivel
        if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
            cvDataReserva.setVisibility(CalendarView.GONE);
        }

        // Evento de click do botão Data de entrada
        btnDataEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Caso o calendario esteja visivel, fica invisivel
                if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
                    cvDataReserva.setVisibility(CalendarView.GONE);
                } else { // Se não, o torna invisivel
                    cvDataReserva.setVisibility(CalendarView.VISIBLE);
                }
                // Define o botão Auxiliar Reserva como igual o btn da data de entrada
                btnDataReserva = btnDataEntrada;
            }
        });

        // Evento de click do botão data de Saida
        btnDataSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Caso o calendario esteja visivel, fica invisivel
                if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
                    cvDataReserva.setVisibility(CalendarView.GONE);
                } else {// Se não, o torna invisivel
                    cvDataReserva.setVisibility(CalendarView.VISIBLE);
                }
                // Define o botão Auxiliar Reserva como igual o btn da data de saida
                btnDataReserva = btnDataSaida;
            }
        });


        // Evento de seleção da data
        cvDataReserva.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                // Gera a data a partir da data selecioanda
                if (btnDataReserva == btnDataEntrada)
                    dataEntradaReserva = new Date(year - 1900, month, dayOfMonth);
                else
                    dataSaidaReserva = new Date(year - 1900, month, dayOfMonth);
                // Seta o texto do botão Auxiliar de acordo com a data selecionada
                btnDataReserva.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                cvDataReserva.setVisibility(CalendarView.GONE); // Torna o calendario invisivel
            }
        });

        // Evento de Click do botão Verificar Disponibilidade
        btnVerificarDisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    int diasHosp;

//                    String dataEntrada = btnDataEntrada.getText().toString();
//                    String dataSaida = btnDataSaida.getText().toString();
//
//                    String dataEntradaSplit[], dataSaidaSplit[];
//                    dataEntradaSplit = dataEntrada.split("/"); // retorna um vetor com o dia, mes e ano
//                    dataSaidaSplit = dataSaida.split("/");
//
//                    // Data de entrada
//                    int diaEntrada = Integer.parseInt(dataEntradaSplit[0]);
//                    int mesEntrada = Integer.parseInt(dataEntradaSplit[1]) - 1;
//                    int anoEntrada = Integer.parseInt(dataEntradaSplit[2]);
//
//                    // Data de saida
//                    int diaSaida = Integer.parseInt(dataSaidaSplit[0]);
//                    int mesSaida = Integer.parseInt(dataSaidaSplit[1]) - 1;
//                    int anoSaida = Integer.parseInt(dataSaidaSplit[2]);
//
//                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
//
//                    Date dtEntrada = new Date(anoEntrada - 1900, mesEntrada, diaEntrada);
//                    Date dtSaida = new Date(anoSaida - 1900, mesSaida, diaSaida);

                    // Caso a data de Saida seja menor que a de entrada retorna o erro
                    if(dataEntradaReserva.compareTo(dataSaidaReserva) == 1) {
                        throw new Exception("A data de entrada não pode ser maior que a data de saida!");
                    }
                    // Chama a funcao que calcula a diferença de dias
                    diasHosp = diffData(dataEntradaReserva, dataSaidaReserva);
                    valTotal = diasHosp * valDiaria; // Calcula o valor total
                    ((TextView)findViewById(R.id.lblDiasTotal)).setText(String.valueOf(diasHosp));
                    ((TextView)findViewById(R.id.lblValTotal)).setText(String.valueOf(valTotal));
                    btnReservar.setEnabled(true); // Habilita o botão de reservar

                } catch (Exception e) {
                    tela.exibir(getApplicationContext(),e.getMessage());
                    limpa();
                }
            }
        });
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Usuario)logado.user).setMinhasReservas(new Reserva(dataEntradaReserva, dataSaidaReserva,quartoReserva, valTotal ));
                tela.exibir(UsuarioNovaReserva.this, "Reserva realizada com sucesso!!");
            }
        });
    }


    // Função que calcula a diferença entre as datas
    private int diffData(Date dtEntrada, Date dtSaida){

        // Varivaies Calendario
        Calendar cDtEntrada = Calendar.getInstance();
        Calendar cDtSaida = Calendar.getInstance();

        // Atribui a data selecionada aos calendarios
        cDtEntrada.setTime(dtEntrada);
        cDtSaida.setTime(dtSaida);

        // Verifica se o ano da data de entrada é o mesmo que a data de saida
        if (cDtEntrada.get(Calendar.YEAR) == cDtSaida.get(Calendar.YEAR)){
            //Caso seja, retorna o dia do ano da saida menos o dia do ano da entrada
            return cDtSaida.get(Calendar.DAY_OF_YEAR) - cDtEntrada.get(Calendar.DAY_OF_YEAR);
        }else{
            //Caso não seja, pega o ultimo dia do ano
            Calendar cDtUltimoDiaAno = Calendar.getInstance();
            Date dtUltDia = new Date(cDtEntrada.get(Calendar.YEAR) - 1900, 11, 31);
            cDtUltimoDiaAno.setTime(dtUltDia);

            // Calcula o dias restantes da data de entrada ate o fim do ano
            int diasRest = cDtUltimoDiaAno.get(Calendar.DAY_OF_YEAR) - cDtEntrada.get(Calendar.DAY_OF_YEAR);

            // Retorna os dias restantes + os dias ate a saida
            return diasRest + cDtSaida.get(Calendar.DAY_OF_YEAR);
        }
    }

    // Metodo que limpa as informações da tela
    private void limpa(){
        btnDataSaida.setText("Data de Saida");
        btnDataEntrada.setText("Data de entrada");
        ((TextView)findViewById(R.id.lblValTotal)).setText("");
        ((TextView)findViewById(R.id.lblDiasTotal)).setText("");
        valTotal = 0;
        btnReservar.setEnabled(false);
    }
}
