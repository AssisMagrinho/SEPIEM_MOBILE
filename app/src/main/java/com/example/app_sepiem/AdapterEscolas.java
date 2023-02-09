package com.example.app_sepiem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterEscolas extends RecyclerView.Adapter<AdapterEscolas.ViewHolderEscolas> {

    Context context;
    ArrayList<Escolas> list;

    public AdapterEscolas(Context context, ArrayList<Escolas> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderEscolas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_layout_escolas, parent, false);
        return new ViewHolderEscolas(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEscolas holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);

        Escolas escolas = list.get(position);

        holder.designacao.setText(escolas.getDesignacao());
        holder.localizacao.setText(escolas.getLocalizacao());

       // holder.itemView.startAnimation(animation);

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_list));


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, perfilEscola.class);

                intent.putExtra("designacao", escolas.getDesignacao());
                intent.putExtra("localizacao", escolas.getLocalizacao());
                intent.putExtra("descricao", escolas.getDescricao());



                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);










            }
        });


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class ViewHolderEscolas extends RecyclerView.ViewHolder{

       TextView designacao,localizacao;
       View v;
       CardView cardView;

        public ViewHolderEscolas(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewEscola);
            designacao = itemView.findViewById(R.id.txtDesignacaoEscola);
            localizacao = itemView.findViewById(R.id.txtLocalizacaoEscola);



            v = itemView;
        }
    }
}
