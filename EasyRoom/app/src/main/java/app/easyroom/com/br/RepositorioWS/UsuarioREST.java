package app.easyroom.com.br.RepositorioWS;

import com.google.gson.Gson;

import app.easyroom.com.br.ConexaoWS.WebServiceCliente;
import app.easyroom.com.br.Model.Usuario;

/**
 * Created by Saulo on 22/03/2015.
 */
public class UsuarioREST {
    private static final String URL_WS = "http://192.168.43.84:8080/ExConsumirWS/cliente/";

      public String inserirCliente(Usuario usuario) throws Exception {

        Gson gson = new Gson();
        String usaurioJSON = gson.toJson(usuario);




        String[] resposta = new WebServiceCliente().post(URL_WS + "cadastrarContato", usaurioJSON);
        if (resposta[0].equals("200")) {


            return resposta[1];
       } else {
            throw new Exception(resposta[1]);

        }
    }

}