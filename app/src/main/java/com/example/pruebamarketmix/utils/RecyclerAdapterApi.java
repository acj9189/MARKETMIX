package com.example.pruebamarketmix.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.models.Asteroids;

import java.util.List;

public class RecyclerAdapterApi extends RecyclerView.Adapter<RecyclerAdapterApi.ContentRecyclerViewHolder> {

    private int numberOfMembers;
    private List<Asteroids> asteroidsList;

    public RecyclerAdapterApi(int numberOfMembers, List<Asteroids> asteroidsList) {
        this.numberOfMembers = numberOfMembers;
        this.asteroidsList = asteroidsList;
        setHasStableIds(true);

    }

    // inflar la vista de los obejtos creados.... llena los datos en el recyclerView con la vista unica
    @NonNull
    @Override
    public ContentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContex = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);
        View view = layoutInflater.inflate(R.layout.recycler_view_content_asteroids, parent, false);
        ContentRecyclerViewHolder contentRecyclerViewHolder = new ContentRecyclerViewHolder(view);
        return contentRecyclerViewHolder;
    }

    //Ubica la infromacion que quiero asiganar a cada vista en el metodo bind de ContentRecyclerViewHolder para que se respte en todas lo mismo, solo que con datos diferentes. //Aqui es donde va la info diferente..
    @Override
    public void onBindViewHolder(@NonNull ContentRecyclerViewHolder holder, int position) {


        //final ContentRecyclerViewHolder holderp = (ContentRecyclerViewHolder)holder;
        holder.setIsRecyclable(false);
        holder.bind(position);
    }



    // Devuelve el numero de vistas que tiene el recyclerView
    @Override
    public int getItemCount() {
        return this.numberOfMembers;
    }

    // Es el contenido de la vista que quiero analizar...
    class ContentRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView asteroidName;
        TextView asteroidDiameter;
        String textName;
        String textDiameter;
        public ContentRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            asteroidName = (TextView) itemView.findViewById(R.id.TextViewAsteroidName);
            asteroidDiameter = (TextView) itemView.findViewById(R.id.TextViewAsteroidDiameter);
            textName = asteroidName.getText().toString();
            textDiameter = asteroidDiameter.getText().toString();

        }

        public void  bind(int poslistObject){
            asteroidName.setText("");
            asteroidDiameter.setText("");
            asteroidName.setText(textName + " " + asteroidsList.get(poslistObject).getName());
            asteroidDiameter.setText(textDiameter + " " + asteroidsList.get(poslistObject).getEstimated_diameter().get("kilometers").get("estimated_diameter_max"));

        }
    }
}
