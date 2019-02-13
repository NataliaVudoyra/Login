package login.natalia.edu.cecyt9.ipn.mx.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    EditText usuario, password;
    TextView intentos;
    Button login;
    private int contador = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        intentos = (TextView) findViewById(R.id.intentos);
        login = (Button) findViewById(R.id.iniciar);

        intentos.setText("Intentos restantes: 5");

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            validar(usuario.getText().toString(),password.getText().toString());
            }
        });



    }

    private void validar(String user, String pass){
        if((user.equals("Natalia")) && (pass.equals("1234"))){
            Intent intent = new Intent(MainActivity.this,Bienvenida.class);
            startActivity(intent);
        }
        else{
            contador--;
            intentos.setText("Intentos restantes: " + String.valueOf(contador));
            if(contador == 0){
                login.setEnabled(false);
            }
        }
    }



}
