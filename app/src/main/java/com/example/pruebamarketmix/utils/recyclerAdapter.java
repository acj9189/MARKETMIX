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

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ContentRecyclerViewHolder> {

    private int numberOfMembers;
    private List<Asteroids> asteroidsList;

    public recyclerAdapter(int numberOfMembers, List<Asteroids> asteroidsList) {
        this.numberOfMembers = numberOfMembers;
        this.asteroidsList = asteroidsList;
    }

    // inflar la vista de los obejtos creados.... llena los datos en el recyclerView con la vista unica
    @NonNull
    @Override
    public ContentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContex = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);

       // View view = View.inflate(mContex, R.layout.recycler_view_content_member, parent);
        View view = layoutInflater.inflate(R.layout.recycler_view_content_member, parent, false);
        ContentRecyclerViewHolder contentRecyclerViewHolder = new ContentRecyclerViewHolder(view);
        return contentRecyclerViewHolder;
    }

    //Ubica la infromacion que quiero asiganar a cada vista en el metodo bind de ContentRecyclerViewHolder para que se respte en todas lo mismo, solo que con datos diferentes.
    @Override
    public void onBindViewHolder(@NonNull ContentRecyclerViewHolder holder, int position) {
        holder.bind(position);

        //Aqui es donde va la info diferente..

    }

    // Devuelve el numero de vistas que tiene el recyclerView
    @Override
    public int getItemCount() {
        Log.d("Hola mundo", String.valueOf(this.numberOfMembers));
        return this.numberOfMembers;
    }

    // Es el contenido de la vista que quiero analizar...
    class ContentRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView asteroidName;
        TextView asteroidDiameter;
        public ContentRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            asteroidName = (TextView) itemView.findViewById(R.id.TextViewAsteroidName);
            asteroidDiameter = (TextView) itemView.findViewById(R.id.TextViewAsteroidDiameter);

        }

        public void  bind(int poslistObject){
           // listObjectView.setText(String.valueOf(poslistObject));
            asteroidName.setText(asteroidName.getText() + " " + asteroidsList.get(poslistObject).getName());
            asteroidDiameter.setText(asteroidDiameter.getText() + " " + asteroidsList.get(poslistObject).getEstimated_diameter().toString());

        }
    }
}
