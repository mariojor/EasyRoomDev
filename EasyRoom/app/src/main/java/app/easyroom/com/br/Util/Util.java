package app.easyroom.com.br.Util;

/**
 * Created by Mario on 10/05/2015.
 */
public class Util {
    /**
     * Remover caracteres de um numero
     */

    private static String REGEX = "[^0123456789]";
    public static String removerCaracteresDeNumeros(String valor) {

        if (valor != null) {
            return valor.replaceAll(REGEX, "");
        } else {
            return "";
        }
    }

}
