package app.easyroom.com.br;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.easyroom.com.br.Model.Oferta;
import app.easyroom.com.br.RepositorioWS.AnuncioRest;


public class CadastrarQuartoActivity extends ActionBarActivity {
    TextView descriacao;
    TextView titulo;
    TextView valor;
    Button cadastrarQuarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_quarto);
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
              titulo = (TextView) findViewById(R.id.edt_titulo_quarto);
              descriacao = (TextView) findViewById(R.id.edt_descricao_quarto);
              valor = (TextView) findViewById(R.id.edt_valor_quarto);
              Double value = Double.parseDouble(valor.getText().toString());
              Oferta ofe = new Oferta();
              ofe.setDescricao(descriacao.getText().toString());
              ofe.setTitulo(titulo.getText().toString());
              ofe.setValaor(value);

              AnuncioRest rest = new AnuncioRest();
              rest.CadastrarAnuncio(ofe);
              Toast.makeText(this,"Cadastrado",Toast.LENGTH_LONG).show();

          }catch(Exception ex){

              Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
          }

      }
}
