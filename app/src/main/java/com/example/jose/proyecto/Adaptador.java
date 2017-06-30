package com.example.jose.proyecto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 29/06/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder>{

    private List<Persona> mLstPersona = new ArrayList<>();



    public void addOrUpdate(Persona persona){
        boolean isUpdate = false;
        for(int i=0;i<mLstPersona.size();i++){
            if (mLstPersona.get(i).getId().equals(persona.getId())){
                update(mLstPersona.get(i),persona,i);
                isUpdate=true;
                break;
            }
        }
        if(!isUpdate)
            add(persona);
    }

    private void add(Persona persona) {
        mLstPersona.add(persona);
        notifyItemInserted(mLstPersona.size() - 1);
    }

    private void update(Persona personaOld, Persona persona, int position) {
        personaOld.setNombre(persona.getNombre());
        personaOld.setApellido(persona.getApellido());
        personaOld.setDireccion(persona.getDireccion());
        personaOld.setEdad(persona.getEdad());
        personaOld.setActivo(persona.isActivo());
        personaOld.setTipo(persona.getTipo());
        personaOld.setFecha(persona.getFecha());

        notifyItemChanged(position);
    }

    public void remove(Persona persona){
        mLstPersona.remove(persona);
    }

    @Override
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent,false);
        AdaptadorViewHolder adaptadorViewHolder = new AdaptadorViewHolder(view);
        return adaptadorViewHolder;
    }

    @Override
    public void onBindViewHolder(AdaptadorViewHolder holder, int position) {

        Persona persona = mLstPersona.get(position);
        holder.itemView.setTag(persona);
        holder.tvNombre.setText(persona.getNombre());
        holder.tvDireccion.setText(persona.getDireccion());
        holder.tvEdad.setText(String.valueOf(persona.getEdad()));
        holder.chActivo.setChecked(persona.isActivo());
    }

    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }

    public class AdaptadorViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre, tvDireccion, tvEdad;
        CheckBox chActivo;

        public AdaptadorViewHolder(View itemView){
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvDireccion = (TextView) itemView.findViewById(R.id.tvDireccion);
            tvEdad = (TextView) itemView.findViewById(R.id.tvEdad);
            chActivo = (CheckBox) itemView.findViewById(R.id.chActivo);
        }
    }
}
