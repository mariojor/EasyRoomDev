package app.easyroom.com.br;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.easyroom.com.br.Model.Usuario;
import app.easyroom.com.br.RepositorioWS.UsuarioREST;

import static android.widget.Toast.LENGTH_SHORT;


public class LoginActivity extends ActionBarActivity {

    EditText etEmail;
    EditText etSenha;
    Button btnEntrar;
    TextView tvCadastro;
    TextView tvEsqueciSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.telaLoginCampoEmail);
        etSenha = (EditText) findViewById(R.id.telaLogincampoSenha);
        btnEntrar = (Button) findViewById(R.id.telaLoginBtnEntrar);
        tvCadastro = (TextView) findViewById(R.id.telaLoginBtnCadastro);
        tvEsqueciSenha = (TextView) findViewById(R.id.telaLoginBtnEsqueciSenha);


        tvEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent esqueciSenha = new Intent(LoginActivity.this, EsqueciMinhaSenhaActivity.class);
                startActivity(esqueciSenha);
            }
        });

        tvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaCadastro = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
                startActivity(telaCadastro);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void validarLogin(View v){

        Usuario use = new Usuario(etEmail.getText().toString(),etSenha.getText().toString());

        UsuarioREST cliREST = new UsuarioREST();

        try {
            String resposta = cliREST.validarLogin(use);

            if(resposta.equals("true")){
                Intent verQuarto = new Intent(LoginActivity.this, VerQuartoActivity.class);
                startActivity(verQuarto);
            }else{
                Toast.makeText(this, "Login ou senha imcompativeis!!!", LENGTH_SHORT).show();
                Intent telaCadastro = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
                startActivity(telaCadastro);
            }

        } catch (Exception e) {
            Toast.makeText(this, "Erro ao efetuar login login ou senha não conferem", LENGTH_SHORT).show();
            e.printStackTrace();
            //   gerarToast(e.getMessage());

        }
    }
   }
