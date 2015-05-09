package app.easyroom.com.br;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.easyroom.com.br.Model.Usuario;
import app.easyroom.com.br.RepositorioWS.UsuarioREST;

import static android.widget.Toast.LENGTH_SHORT;


public class CadastrarUsuarioActivity extends ActionBarActivity {
    EditText email;
    EditText fone;
    EditText login;
    EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        login =(EditText) findViewById(R.id.edt_nome_usuario);
        email = (EditText) findViewById(R.id.edt_email_usuario);
        senha= (EditText) findViewById(R.id.edt_senha_usuario);
        fone = (EditText) findViewById(R.id.edt_fone_usuario);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastrar_usuario, menu);
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

    public void cadastrarUsuario(View v){

        Usuario use = new Usuario(login.getText().toString(),senha.getText().toString() ,email.getText().toString(),fone.getText().toString());

        UsuarioREST cliREST = new UsuarioREST();

        try {
            String resposta = cliREST.cadastrarUsuario(use);

            if(resposta.equals("false")){
                Toast.makeText(this, "Usuario já existe!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                Intent telaCadastro = new Intent(CadastrarUsuarioActivity.this, LoginActivity.class);
                startActivity(telaCadastro);
            }


        } catch (Exception e) {
            Toast.makeText(this, "Erro ", LENGTH_SHORT).show();
            e.printStackTrace();
            //   gerarToast(e.getMessage());

        }

    }
}
