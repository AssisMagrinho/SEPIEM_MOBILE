package com.example.app_sepiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class perfilEscola extends AppCompatActivity {

    TextView designacao, localizacao, descricao, linkInscricao, totInscritos;
    DatabaseReference refTotalInscritos;
    int totalInscritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_escola);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SEPIEM");
        checkConnection();

        designacao = findViewById(R.id.txtPerfilNomeEscola);
        localizacao = findViewById(R.id.txtPerfilLocalizacao);
        descricao = findViewById(R.id.txtPerfilDescricao);
        linkInscricao = findViewById(R.id.linkInscrever);
        totInscritos = findViewById(R.id.txtTotalInscritos);


        designacao.setText(getIntent().getStringExtra("designacao"));
        localizacao.setText(getIntent().getStringExtra("localizacao"));
        descricao.setText(getIntent().getStringExtra("descricao"));

        Animation animation = AnimationUtils.loadAnimation(designacao.getContext(), android.R.anim.slide_out_right);
        designacao.startAnimation(animation);

        refTotalInscritos = FirebaseDatabase.getInstance().getReference();
        refTotalInscritos.child("Inscritos").orderByChild("escola").equalTo(""+designacao.getText()+"").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    totalInscritos = (int) snapshot.getChildrenCount();

                    totInscritos.setText(Integer.toString(totalInscritos)+" Inscritos");

                    // Toast.makeText(pesquisarInscricao.this, "1000 Inscrito(s)"+Integer.toString(totalInscritos), Toast.LENGTH_LONG).show();

                }else {
                    // Toast.makeText(pesquisarInscricao.this, "0 Inscritos", Toast.LENGTH_LONG).show();

                    totInscritos.setText("0 Inscritos");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        linkInscricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(perfilEscola.this, Cadastrar.class));

            }
        });





    }

    public void checkConnection(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if (null != activeNetwork){

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                // Toast.makeText(this, "Wifi Habilitado !!!", Toast.LENGTH_LONG).show();
            }
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                // Toast.makeText(this, "Dados Móveis Habiltados !!!", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            showDialogInterConnection();
            //Toast.makeText(this, "Sem Ligação à Internet !!!", Toast.LENGTH_LONG).show();
        }
    }

    private void showDialogInterConnection() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.internetconnection);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}