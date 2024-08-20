package com.jokenpo.jkp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void opcaoSelecionada(String opcaSelecionada) {


        ImageView ivComp = findViewById(R.id.ivComp);
        TextView tvResult = findViewById(R.id.tvResult);

       int numero = new Random().nextInt(3);// 0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];


        switch (opcaoApp) {
            case "pedra":
                ivComp.setImageResource(R.drawable.pedra);
                break;
            case "tesoura":
                ivComp.setImageResource(R.drawable.tesoura);
                break;
            case "papel":
                ivComp.setImageResource(R.drawable.papel);
                break;

        }
        if (opcaoApp == opcaSelecionada){
            tvResult.setText("Empate men");
            tvResult.setTextColor(Color.GRAY);
        }
        else if ((opcaoApp == "papel" && opcaSelecionada == "pedra" )||
        (opcaoApp == "pedra" && opcaSelecionada == "tesoura" )||
                (opcaoApp == "tesoura" && opcaSelecionada == "papel" )){

            tvResult.setText("Perrrdeu");
            tvResult.setTextColor(Color.RED);
        }

        else {
            tvResult.setText("Ganhou");
            tvResult.setTextColor(Color.GREEN);
        }


        /*
        if ((opcaoApp == "tesousar" && opcaSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaSelecionada == "tesora")
        ) {
            tvResult.setText("Ganhou");
            tvResult.setTextColor(Color.GREEN);

        } else if ((opcaSelecionada == "tesousar" && opcaoApp == "papel") ||
                (opcaSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaSelecionada == "pedra" && opcaoApp == "tesora")
        ) {

            tvResult.setText("Perrrdeu");
            tvResult.setTextColor(Color.RED);

        } else {

            tvResult.setText("Empate men");
            tvResult.setTextColor(Color.GRAY);
        }*/

        /*No caso escolhi java pois é uma liguagem da qual tenho um certo dominio mesmo que pouco
        é nela que consigo me virar, salva vida de tudo.

         */
    }


}
