package app.easyroom.com.br.Util;

import java.text.DecimalFormat;
import java.util.Currency;

/**
 * Created by Mario on 10/05/2015.
 */
public class Moeda {

    private static Currency currency = Currency.getInstance("BRL");
    private static DecimalFormat formato = new DecimalFormat("#,##0.00");
    private double valor;

    public Moeda(String valor) {
        this.valor = Double.parseDouble(valor.replaceAll("\\.", "").replaceAll(",", "."));
    }

    public Moeda(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return currency.getSymbol() + formato.format(valor);
    }

}
