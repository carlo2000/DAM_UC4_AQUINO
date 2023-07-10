package com.example.dam_uc4_aquino;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

//import com.example.dam_uc4_aquino.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapter;
    private NotasInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                //recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            //recyclerView.setAdapter(new MyNotaRecyclerViewAdapter(PlaceholderContent.ITEMS));
            notaList = new ArrayList<>();
            notaList.add(new Nota("Lista de la compra","comprar pan tostado", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Recordar", "He aparcado el coche en la calle República Argentina, no olvidarme en el parque",false, android.R.color.holo_green_light));
            notaList.add(new Nota("cumpleaños (fiesta)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", true, android.R.color.holo_orange_light));
            adapter = new MyNotaRecyclerViewAdapter(notaList,mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }

}