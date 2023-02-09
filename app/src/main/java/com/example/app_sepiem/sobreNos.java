package com.example.app_sepiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class sobreNos extends AppCompatActivity {

    TextView linkWhatsappAssis,linkWhatsappAgeu,linkFacebookAssis, linkGitHubAssis, linkGmailAssis;
    RelativeLayout layout_Assis, layout_Ageu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_info_24);
        getSupportActionBar().setTitle("Sobre Nós");


        linkWhatsappAssis = findViewById(R.id.linkWhastAppAssis);
        linkWhatsappAgeu = findViewById(R.id.linkWhastAppAgeu);
        linkFacebookAssis = findViewById(R.id.linkFacebookAssis);
        linkGitHubAssis = findViewById(R.id.linkGitHubAssis);
        linkGmailAssis = findViewById(R.id.linkGmailAssis);

        layout_Assis = findViewById(R.id.layout_Assis);
        layout_Ageu = findViewById(R.id.layout_Ageu);

        Animation animationLayoutAssis = AnimationUtils.loadAnimation(layout_Assis.getContext(), android.R.anim.slide_in_left);
        layout_Assis.startAnimation(AnimationUtils.loadAnimation(layout_Assis.getContext(), R.anim.anim_list));


        Animation animationLayoutAgeu = AnimationUtils.loadAnimation(layout_Ageu.getContext(), android.R.anim.slide_in_left);
        //layout_Ageu.startAnimation(animationLayoutAgeu);
        layout_Ageu.startAnimation(AnimationUtils.loadAnimation(layout_Ageu.getContext(), R.anim.anim_list));



        linkWhatsappAssis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://api.whatsapp.com/send?phone=926022689";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(sobreNos.this, "Erro: "+e+"\n Ou verifique a ligação à internet", Toast.LENGTH_SHORT).show();
                }

            }
        });
        linkWhatsappAgeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://api.whatsapp.com/send?phone=929861296";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(sobreNos.this, "Erro: "+e+"\n Ou verifique a ligação à internet", Toast.LENGTH_SHORT).show();
                }

            }
        });

        linkFacebookAssis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wwww.facebook.com/jesusmagrinho.magrinho"));
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(sobreNos.this, "Erro: "+e+"\n Ou verifique a ligação à internet", Toast.LENGTH_SHORT).show();

                }
               // Toast.makeText(sobreNos.this, "Serviço Indisponível", Toast.LENGTH_SHORT).show();
            }
        });
        linkGitHubAssis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/AssisMagrinho"));
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(sobreNos.this, "Erro: "+e+"\n Ou verifique a ligação à internet", Toast.LENGTH_SHORT).show();

                }
            }
        });

        linkGmailAssis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(sobreNos.this, "Serviço Indisponível", Toast.LENGTH_SHORT).show();

            }
        });




    }
}