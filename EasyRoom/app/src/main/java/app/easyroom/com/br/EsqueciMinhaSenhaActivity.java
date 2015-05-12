package app.easyroom.com.br;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.easyroom.com.br.Model.Usuario;
import app.easyroom.com.br.RepositorioWS.UsuarioREST;

import static android.widget.Toast.LENGTH_SHORT;


public class EsqueciMinhaSenhaActivity extends ActionBarActivity {

    Button btnRecuperarSenhaEmail;
    EditText edtEmailRecuperarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_minha_senha);

        edtEmailRecuperarSenha = (EditText) findViewById(R.id.edEmailParaRecuperarSenha);
        btnRecuperarSenhaEmail = (Button) findViewById(R.id.telaEsqueciSenhaBtnEnviar);

           }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_esqueci_minha_senha, menu);
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

    public void esqueciMinhaSenha(View v){
        Usuario use = null;
        UsuarioREST cliREST = new UsuarioREST();
        String resposta = null;
        try {

            if(edtEmailRecuperarSenha.getText().toString().equals("")
               || edtEmailRecuperarSenha.getText().toString() == null
               || edtEmailRecuperarSenha.getText().toString().isEmpty()){

            }
            if (resposta.equals("false")) {
                Toast.makeText(this, "Email não existe!", Toast.LENGTH_LONG).show();
            }else {

                use = new Usuario(edtEmailRecuperarSenha.getText().toString());
                resposta = cliREST.esqueciMinhaSenha(use);
                Toast.makeText(this, "Uma nova senha foi enviada para seu email.", Toast.LENGTH_LONG).show();
                Intent telaLogin = new Intent(EsqueciMinhaSenhaActivity.this, LoginActivity.class);
                startActivity(telaLogin);
            }

        }catch(NullPointerException e){
            Toast.makeText(this, "Por favor, campo email deve ser preenchido.", Toast.LENGTH_LONG).show();

        }catch (Exception e) {
            Toast.makeText(this, "Erro ", LENGTH_SHORT).show();
            e.printStackTrace();
            //   gerarToast(e.getMessage());

        }

    }

    }


