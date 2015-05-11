package app.easyroom.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import app.easyroom.com.br.Model.Oferta;
import app.easyroom.com.br.RepositorioWS.AnuncioRest;
import app.easyroom.com.br.Util.Util;


public class CadastrarQuartoActivity extends ActionBarActivity {
    EditText descriacao;
    EditText titulo;
    EditText telefone;
    EditText endereco;
    EditText valor;
    Button cadastrarQuarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_quarto);

        valor = (EditText) findViewById(R.id.edt_valor_quarto);
        valor.setInputType(InputType.TYPE_CLASS_NUMBER);
        valor.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;
            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {
                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {
                    isUpdating = false;
                    return;
                }
                isUpdating = true;
                String str = s.toString();
                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
                        (str.indexOf(".") > -1 || str.indexOf(",") > -1));
                // Verificamos se existe máscara
                if (hasMask) {
                    // Retiramos a máscara.
                    str = str.replaceAll("[R$]", "").replaceAll("[,]", "")
                            .replaceAll("[.]", "");
                }

                try {
                    // Transformamos o número que está escrito no EditText em
                    // monetário.
                    str = nf.format(Double.parseDouble(str) / 100);
                    valor.setText(str);
                    valor.setSelection(valor.getText().length());
                } catch (NumberFormatException e) {
                    s = "";
                }
            } @Override
              public void beforeTextChanged(CharSequence s, int start, int count,
                                            int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastrar_quarto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

      public void CadastrarOferta(View v){
          try {
              titulo = (EditText) findViewById(R.id.edt_titulo_quarto);
              descriacao = (EditText) findViewById(R.id.edt_descricao_quarto);
              telefone = (EditText) findViewById(R.id.edt_telefone_quarto);
              endereco = (EditText) findViewById(R.id.edt_endereco_quarto);

              String valorSemCaracteres = Util.removerCaracteresDeNumeros(valor.getText().toString());

              Double valorReal = Double.parseDouble(valorSemCaracteres);
              Oferta ofe = new Oferta();

              ofe.setDescricao(descriacao.getText().toString());
              ofe.setTitulo(titulo.getText().toString());
              ofe.setTelefone(telefone.getText().toString());
              ofe.setEndereco(endereco.getText().toString());
              ofe.setValor(valorReal/100);

              AnuncioRest rest = new AnuncioRest();
              rest.CadastrarAnuncio(ofe);
              Toast.makeText(this,"Cadastrado",Toast.LENGTH_LONG).show();

          }catch(Exception ex){

              Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
          }

      }
}
