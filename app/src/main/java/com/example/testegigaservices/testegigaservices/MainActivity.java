package com.example.testegigaservices.testegigaservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ação do primeiro botão que chama o intent da página do menu 1
        Button btn1 = (Button)findViewById(R.id.bt1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, sdActivity.class));
            }
        });



        //ação do segundo botão
        Button btn2 = (Button)findViewById(R.id.bt2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Nenhuma página definida",Toast.LENGTH_LONG).show();
                //exibe se a página for incluida no contexto do app
            }
        });

        Button btn3 = (Button)findViewById(R.id.bt3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Nenhuma página definida", Toast.LENGTH_LONG).show();
            }
        });

    }


}
