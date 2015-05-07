package app.easyroom.com.br;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity {

    TextView btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnCadastro = (TextView) findViewById(R.id.telaLoginBtnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaCadastro = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
                startActivity(telaCadastro);
            }
        });
    }
}
