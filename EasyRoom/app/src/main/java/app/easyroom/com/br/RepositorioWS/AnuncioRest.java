package app.easyroom.com.br.RepositorioWS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.easyroom.com.br.ConexaoWS.WebServiceCliente;
import app.easyroom.com.br.Model.Oferta;

/**
 * Created by Saulo on 11/04/2015.
 */
public class AnuncioRest {
    private static final String URL_WS = "http://192.168.43.84:8080/ExConsumirWS/cliente/";
    public String CadastrarAnuncio(Oferta anuncio) throws Exception{
        Gson gson = new Gson();
        String anuncioJSON = gson.toJson(anuncio);
        String[] resposta = new WebServiceCliente().post(URL_WS + "CadastrarOferta", anuncioJSON);

        if (resposta[0].equals("200")) {
            return resposta[1];
        } else {
            throw new Exception(resposta[1]);

        }

    }
    public List<Oferta> ListarOferta()throws Exception{

        List<Oferta> ofetas = new ArrayList<Oferta>();
        String[] resposta = new WebServiceCliente().get(URL_WS + "buscarAnuncios");

        //converte para objeto
        Gson gson = new Gson();
        Type lisata = new TypeToken<Map<String,List<Oferta>>>(){}.getType();
        Map<String,List<Oferta>> mapa = gson.fromJson(resposta[1],lisata);
        List<Oferta> ofestas = null;
         for(String key: mapa.keySet()){
             ofestas = mapa.get(key);
         }

        if (resposta[0].equals("200")) {
            return ofestas;
        } else {
            throw new Exception(resposta[1]);

        }

    }



}
