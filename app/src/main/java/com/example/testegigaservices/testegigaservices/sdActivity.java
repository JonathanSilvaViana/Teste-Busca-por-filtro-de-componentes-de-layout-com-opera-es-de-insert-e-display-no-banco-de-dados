package com.example.testegigaservices.testegigaservices;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class sdActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "TesteGigaservicesAPP";

    //list view dos produtos
    public ListView lv;

    //list view adapter
    ArrayAdapter<String> adapter;

    //barra de busca
    AutoCompleteTextView inputSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);

        //produtos da busca
       String[] produtos = {
               "Produto 1",
               "Produto 2",
               "Produto 3",
               "Produto 4",
               "Produto 5"
       };

       lv = (ListView)findViewById(R.id.listaDProdutos);
       inputSearch = (AutoCompleteTextView)findViewById(R.id.barradepesquisa);

       //popula a lista
       adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, produtos);
       lv.setAdapter(adapter);


       //chama a view de produto
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String mString = (String) parent.getAdapter().getItem(position);

               //pegar nome do array passando para outra activity

               String produtoClasse = "produtoActivity.class";

               Intent intent = new Intent(sdActivity.this, produtoActivity.class);
               intent.putExtra(produtoActivity.EXTRA_PRODUTO, mString);
               startActivity(intent);

           }
       });



       //aciona a barra de buscas

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void beforeTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            sdActivity.this.adapter.getFilter().filter(cs);
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //botão que volta a página anterior
        Button btVoltarUm = (Button)findViewById(R.id.btVoltarUm);

        btVoltarUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sdActivity.this, MainActivity.class));
            }
        });
    }



}
