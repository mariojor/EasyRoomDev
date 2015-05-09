package app.easyroom.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity{

    LinearLayout btnVerQuarto, btnCadastraquarto, btnLoginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btnVerQuarto = (LinearLayout) findViewById(R.id.btn_ver_quarto_main);
        btnCadastraquarto = (LinearLayout) findViewById(R.id.btn_cadastrar_quarto_main);
        btnLoginUsuario = (LinearLayout) findViewById(R.id.btn_login_usuario_main);

        btnVerQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verQuarto = new Intent(MainActivity.this, VerQuartoActivity.class);
                startActivity(verQuarto);
            }
        });

        btnCadastraquarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrarQuarto = new Intent(MainActivity.this, CadastrarQuartoActivity.class);
                startActivity(cadastrarQuarto);
            }
        });

        btnLoginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrarUsuario = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(cadastrarUsuario);
            }
        });

    }
}

