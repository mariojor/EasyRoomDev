package app.easyroom.com.br.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.easyroom.com.br.Model.Oferta;
import app.easyroom.com.br.R;
import app.easyroom.com.br.Util.Moeda;

/**
 * Created by Saulo on 18/04/2015.
 */
public class OfertaAdapter extends BaseAdapter{
     List<Oferta> ofetas;
     Context ctx;

    public OfertaAdapter(Context ctx, List<Oferta> ofetas){
        this.ctx = ctx;
        this.ofetas = ofetas;
    }

    @Override
    public int getCount() {
        return this.ofetas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ofetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Oferta anuncio = ofetas.get(position);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.lista_anuncio,null);
        TextView titulo =(TextView) linha.findViewById(R.id.editTitulo);
        TextView descricao =(TextView) linha.findViewById(R.id.editDescricao);
        TextView telefone = (TextView) linha.findViewById(R.id.editTelefone);
        TextView endereco = (TextView) linha.findViewById(R.id.editEndereco);
        TextView valor = (TextView) linha.findViewById(R.id.editValor);

        String valorEmString = String.valueOf(new Moeda(anuncio.getValor()));

        titulo.setText(anuncio.getTitulo());
        descricao.setText(anuncio.getDescricao());
        telefone.setText(anuncio.getTelefone());
        endereco.setText(anuncio.getEndereco());
        valor.setText(valorEmString);

        return linha;
    }
}
