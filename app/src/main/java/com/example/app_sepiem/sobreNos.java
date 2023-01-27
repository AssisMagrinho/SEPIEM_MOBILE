package com.example.app_sepiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class sobreNos extends AppCompatActivity {

    TextView linkWhatsappAssis,linkFacebookAssis, linkGitHubAssis, linkGmailAssis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);

        linkWhatsappAssis = findViewById(R.id.linkWhastAppAssis);
        linkFacebookAssis = findViewById(R.id.linkFacebookAssis);
        linkGitHubAssis = findViewById(R.id.linkGitHubAssis);
        linkGmailAssis = findViewById(R.id.linkGmailAssis);

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

        linkFacebookAssis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/jesusmagrinho.magrinho"));
                    startActivity(intent);
                }catch (Exception e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:www.facebook.com/jesusmagrinho.magrinho"));
                    startActivity(intent);
                }
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
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] emails_in_to={"assisfranciscomagrinhonew@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, emails_in_to );
                intent.putExtra(Intent.EXTRA_SUBJECT,"[SEPIEM]- Contactos");
                intent.putExtra(Intent.EXTRA_TEXT, "Prezado(a), Queira informar o que lhe trouxe, por favor?!");
                intent.putExtra(Intent.EXTRA_CC,"beltoraniojose1@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(intent);
            }
        });




    }
}