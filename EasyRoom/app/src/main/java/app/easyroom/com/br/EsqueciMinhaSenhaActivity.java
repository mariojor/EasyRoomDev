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
    EditText edEmailRecuperarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_minha_senha);

        edEmailRecuperarSenha = (EditText) findViewById(R.id.edEmailParaRecuperarSenha);
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

    public void recuperarSenha(View v){
        Usuario use = null;
        UsuarioREST cliREST = new UsuarioREST();
        String resposta = null;
        try {

            if (resposta.equals("false")) {
                Toast.makeText(this, "Usuario já existe!", Toast.LENGTH_LONG).show();
            }else if(resposta.equals("emailInvalido")){
                Toast.makeText(this, "E-mail invalido!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                Intent telaCadastro = new Intent(EsqueciMinhaSenhaActivity.this, LoginActivity.class);
                startActivity(telaCadastro);
            }

        }catch(NullPointerException e){
            Toast.makeText(this, "Por favor, todos os campos devem ser preenchidos.", Toast.LENGTH_LONG).show();

        }catch (Exception e) {
            Toast.makeText(this, "Erro ", LENGTH_SHORT).show();
            e.printStackTrace();
            //   gerarToast(e.getMessage());

        }

    }

    }


