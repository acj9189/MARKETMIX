package com.example.pruebamarketmix.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.models.Asteroids;

import java.util.List;

public class RecyclerAdapterApiSelectedItemShopingCar extends RecyclerView.Adapter<RecyclerAdapterApiSelectedItemShopingCar.ContentRecyclerViewHolder> {

    private int numberOfMembers;                 // Cantidad de elementos que contendrá el recyclerview
    private List<Asteroids> asteroidsList;       // Objeto lista de asteroides.
    final private ClickLisener clickListener;     // Interfaz que escuchar cuando se hace clic sobre cada una de las tarjetas.

    /***
     *      Implementación de la interfaz que escucha cuando se hace clic sobre una única tarjeta del recyclerview.
     */
    public interface ClickLisener{

        void onClickLisener(int itemClicked);

    }


    /***
     *        Implementación del Adaptador, el cual se encarga de alojar en cada una de las tarjetas la interfaz especificada.
     * @param numberOfMembers   // Cantidad de elementos que contendrá el recyclerview
     * @param asteroidsList     // Objeto lista de asteroides.
     * @param clickListener     // Interfaz que escuchar cuando se hace clic sobre cada una de las tarjetas.
     */
    public RecyclerAdapterApiSelectedItemShopingCar(int numberOfMembers, List<Asteroids> asteroidsList , ClickLisener clickListener) {
        this.numberOfMembers = numberOfMembers;
        this.asteroidsList = asteroidsList;
        this.clickListener = clickListener ;
    }

    /***
     *        Infla la vista de los objetos creados.... llena los datos en el recyclerView con la vista única.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ContentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContex = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContex);

       // View view = View.inflate(mContex, R.layout.recycler_view_content_asteroids, parent);
        View view = layoutInflater.inflate(R.layout.recycler_view_content_asteroids, parent, false);
        ContentRecyclerViewHolder contentRecyclerViewHolder = new ContentRecyclerViewHolder(view);
        return contentRecyclerViewHolder;
    }



    /***
     *        //Ubica la información que quiero asignar en la vista a través del método bind de el ContentRecyclerViewHolder para que se respete la misma vista, solo que con datos diferentes. Aqui es donde va la info diferente..
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ContentRecyclerViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.bind(position);



    }

    /***
     *  Devuelve el número de vistas que tiene el recyclerView.
     * @return
     */
    @Override
    public int getItemCount() {
        return this.numberOfMembers;
    }



    /***
     *  Es el contenido que le quiero colocar a cada uno de los viewHolder, misma vista diferente contenido en ella.
     */
    class ContentRecyclerViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView asteroidName;
        TextView asteroidDiameter;
        public ContentRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            asteroidName = (TextView) itemView.findViewById(R.id.TextViewAsteroidName);
            asteroidDiameter = (TextView) itemView.findViewById(R.id.TextViewAsteroidDiameter);
            itemView.setOnClickListener(this);
        }

        public void  bind(int poslistObject){
            asteroidName.setText(asteroidName.getText() + " " + asteroidsList.get(poslistObject).getName());
            asteroidDiameter.setText(asteroidDiameter.getText() + " " + asteroidsList.get(poslistObject).getAbsolute_magnitude_h());

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            clickListener.onClickLisener(position);
        }
    }
}
