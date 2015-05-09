package app.easyroom.com.br.RepositorioWS;

import com.google.gson.Gson;

import app.easyroom.com.br.ConexaoWS.WebServiceCliente;
import app.easyroom.com.br.Model.Usuario;

/**
 * Created by Saulo on 22/03/2015.
 */
public class UsuarioREST {
    private static final String URL_WS = "http://192.168.0.106:8080/ExConsumirWS/cliente/";

      public String cadastrarUsuario(Usuario usuario) throws Exception {

        Gson gson = new Gson();
        String usaurioJSON = gson.toJson(usuario);
        String[] resposta = new WebServiceCliente().post(URL_WS + "cadastrarUsuario", usaurioJSON);
        if (resposta[0].equals("200")) {
            return resposta[1];
       } else {
            throw new Exception(resposta[1]);
        }
    }
    public String validarLogin(Usuario usuario) throws Exception {

        Gson gson = new Gson();
        String usuarioJSON = gson.toJson(usuario);
        String[] resposta = new WebServiceCliente().post(URL_WS + "validarLogin", usuarioJSON);
        if (resposta[0].equals("200")) {
            return resposta[1];
        } else {
            throw new Exception(resposta[1]);
        }
    }


}