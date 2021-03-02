package com.keceli.imcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calc_imc = null;
    private EditText taille = null;
    private EditText poids = null;
    private TextView res = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère la variable taille à l'aide de son Id
        // On utilise la fonction findById(id de l'élément)
        taille = (EditText) findViewById(R.id.taille_value);
        poids = (EditText) findViewById(R.id.poids_value);
        calc_imc = (Button) findViewById(R.id.calc_imc);
        res = (TextView) findViewById(R.id.res_imc);

        // On calcul notre IMC en utilisant la formule suivante
        // IMC =  poids / taille au carré
        // Action lorsque nous cliquons sur le bouton
        calc_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double t = Double.parseDouble(taille.getText().toString());
                Double p = Double.parseDouble(poids.getText().toString());
                Double r = p/ (t*t);
                String res_txt = "";
                if (r>40){
                    res_txt = "Obésité mordide ou massive";
                }else if (r<=40 && r > 35){
                    res_txt = "Obésité sévère";
                }else if(r <35 && r>=30){
                    res_txt = "Obésité modérée";
                }else if(r<30 && r>=25){
                    res_txt = "Surpoids";
                }else if (r<25 && r>=18.5){
                    res_txt = "Corpulance normale";
                }else if (r<18.5 && r>=16.5){
                    res_txt = "Maigreur";
                }else{
                    res_txt = "Famine";
                }

                // Afin d'afficher notre resultat sur notre view on utilise la focntion
                // setText()
                res.setText(res_txt);
            }
        });



    }
}