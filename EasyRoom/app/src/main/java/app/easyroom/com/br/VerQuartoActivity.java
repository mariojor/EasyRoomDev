package app.easyroom.com.br;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.easyroom.com.br.Adapter.OfertaAdapter;
import app.easyroom.com.br.Model.Oferta;
import app.easyroom.com.br.RepositorioWS.AnuncioRest;


public class VerQuartoActivity extends ActionBarActivity {
    List<Oferta> ofertas;
    OfertaAdapter adapter;
    ListView lister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lister = new ListView(this);
        setContentView(lister);
        AnuncioRest rest = new AnuncioRest();
        ofertas = new ArrayList<Oferta>();
        try {
            ofertas =  rest.ListarOferta();
            adapter = new  OfertaAdapter(this,ofertas);
            lister.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_quarto, menu);
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
}
