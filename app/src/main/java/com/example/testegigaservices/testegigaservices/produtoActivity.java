package com.example.testegigaservices.testegigaservices;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.testegigaservices.testegigaservices.DatabaseHelper.DATABASE_NAME;
import static com.example.testegigaservices.testegigaservices.DatabaseHelper.TABLE_1_C_ID;
import static com.example.testegigaservices.testegigaservices.DatabaseHelper.TABLE_1_C_QTD;


public class produtoActivity extends AppCompatActivity {

    DatabaseHelper meuBD;

    public static final String EXTRA_PRODUTO = "extra_produto";

    public static String sobrevalor = "Ultimo valor salvo: ";

    private EditText mQuantidade;

    Button exibesql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        meuBD = new DatabaseHelper(this);

        //nomeia a activity
        Intent anterior = getIntent();
        final String stringTitle = anterior.getStringExtra(EXTRA_PRODUTO);
        this.setTitle(stringTitle);



        //pega o número digitado

        mQuantidade = (EditText)findViewById(R.id.quantidade);

        Button salvar = (Button)findViewById(R.id.btSalvar);

        final TextView registro = (TextView)findViewById(R.id.Registro);

        //condiciona o salvamento conforme o título

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String calculo = mQuantidade.getText().toString();

                    if (!TextUtils.isEmpty(calculo)) {

                        mQuantidade.getText().clear();
                        Toast.makeText(getApplicationContext(), "Quantidade solicitada salva: " + calculo, Toast.LENGTH_SHORT).show();
                        registro.setText(sobrevalor + calculo);

                        //seleciona o valor e insere no banco de dados
                        boolean inserido = meuBD.insereDados_na_TABLE_1(calculo);

                        if (inserido = true) {

                            Toast.makeText(produtoActivity.this, "dados inseridos: " + calculo, Toast.LENGTH_SHORT).show();
                            String valor_final = "Valor final: " + inserido;
                        }
                        else{ Toast.makeText(produtoActivity.this , "dados não inseridos", Toast.LENGTH_SHORT).show();}



                    } else {

                        Toast.makeText(getApplicationContext(), "Valor invalido ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Nenhuma alteração no banco de dados ", Toast.LENGTH_SHORT).show();
                        mQuantidade.getText().clear();
                    }

                    Button exibesql = (Button)findViewById(R.id.btExibirRegistros);





                    exibesql.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    //exibe os dados da tabela 1

                                    final Cursor cursor1 = meuBD.pegaTodosDados_1();

                                    if (meuBD.TABLE_1_C_ID != null)
                                    {
                                        cursor1.moveToLast();
                                        Toast.makeText(produtoActivity.this, "não nulo, " + cursor1.getString(cursor1.getColumnIndex("quantidade_produto_1")), Toast.LENGTH_SHORT).show();
                                        registro.setText(String.format("Ultima quantidade: %s" , cursor1.getString(cursor1.getColumnIndex("quantidade_produto_1"))));
                                    }

                                    else if (meuBD.TABLE_1_C_ID == null)
                                    {
                                        Toast.makeText(produtoActivity.this, "Banco de dados vazio", Toast.LENGTH_SHORT).show();
                                    }

                                    else
                                    {
                                        Toast.makeText(produtoActivity.this, "deu erro", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                    );


                }

            });


    }

}
