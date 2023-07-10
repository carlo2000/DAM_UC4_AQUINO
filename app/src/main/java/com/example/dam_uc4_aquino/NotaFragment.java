package com.example.dam_uc4_aquino;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
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
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth / 180);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }
            //recyclerView.setAdapter(new MyNotaRecyclerViewAdapter(PlaceholderContent.ITEMS));
            notaList = new ArrayList<>();
            notaList.add(new Nota("FPF SALUDA A LA CONMEBOL EN SUS 107 AÑOS DE VIDA INSTITUCIONAL","La Federación Peruana de Fútbol, presidida por el ingeniero Agustín Lozano Saavedra, felicita a la Confederación Sudamericana de Fútbol en su aniversario 107.\n" +
                    "\n" +
                    "La Junta Directiva, trabajadores y toda la familia de la FPF ratifican su compromiso con la CONMEBOL para seguir trabajando juntos por el desarrollo del fútbol sudamericano y seguir haciendo historia a nivel mundial.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("TABLA DE POSICIONES: TORNEO COPA FEDERACIÓN ORO, PLATA, PLATA B Y PROMOCIONAL", "*TABLA DE POSICIONES PROMOCIONAL - FECHA 113\n" +
                    "\n" +
                    "DESCARGA AQUÍ Descargar\n" +
                    "*TABLA DE POSICIONES PLATA B - FECHA 14\n" +
                    "\n" +
                    "DESCARGA AQUÍDescargar\n" +
                    "*TABLA DE POSICIONES PLATA - - FECHA 17\n" +
                    "\n" +
                    "DESCARGA AQUÍDescargar\n" +
                    "*TABLA DE POSICIONES ORO - FECHA 17\n" +
                    "\n" +
                    "DESCARGA AQUÍDescargar",false, android.R.color.holo_green_light));
            notaList.add(new Nota("LABICOLOR ESTRENARÁ RENOVADO BUS GRACIAS A DERCO CENTER","La red de concesionarios más grande del país acompañará al equipo de todos los peruanos en su camino a las Eliminatorias al Mundial 2026.\n" +
                    "Como parte del acuerdo, Derco Center ha renovado el emblemático bus especialmente equipado para trasladar localmente a LaBicolor.\n" +
                    "La Federación Peruana de Fútbol (FPF) anunció que Derco Center, la red de concesionarios más grande del Perú, renovó por cuatro años más su vínculo como patrocinador oficial de LaBicolor, la marca más querida por todos los peruanos.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("FUTEC INICIARÁ PROGRAMA DE LICENCIA C EL 17 DE JULIO","El Centro de Altos Estudios de la FPF (FUTEC) iniciará el Programa de Licencia C dirigido a personas que se desempeñan o desean desempeñarse como entrenadores / profesores de escuelas de fútbol de iniciación para niños y adolescentes. El Programa empezará el lunes 17 de julio del 2023 y tendrá una duración de 12 semanas de contenido teórico virtual, 2 semanas de contenido práctico y 1 semana de exámenes.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("CHEMO DEL SOLAR REALIZA VISORIA DE MENORES EN APURÍMAC Y CUSCO","La Unidad Técnica de Menores continúa recorriendo el Perú en busca de talentos para las selecciones. José Guillermo Del Solar, director de la UTM, se encuentra en Apurímac y Cusco realizando visorias de futbolistas como parte del ambicioso proyecto de descentralización de la Federación Peruana de Fútbol.\n" +
                            "\n" +
                            "La gira de \"Chemo\" empezó los días 3 y 4 de julio en Apurímac, donde brindó una charla a los entrenadores del Centro de Captación y Desarrollo y a diversos entrenadores de la región que compiten en menores, y luego dirigió una práctica en el Complejo Deportivo \"El Olivo\".\n" +
                            "\n" +
                            "Las actividades continuarán los días 5 y 6 de julio en la ciudad de Cusco, donde Del Solar dialogará con los entrenadores locales en la Casa de la Cultura de San Jerónimo y dirigirá una práctica en el Estadio Cajonahuaylla de San Jerónimo.\n" +
                            "\n" +
                            "El objetivo de las visorias es captar nuevos talentos para las selecciones y capacitar a los entrenadores con la metodología de trabajo de la UTM. A la fecha, \"Chemo\" Del Solar ha logrado la captación de jugadores para LaBicolor Sub - 15 que jugó amistosos internacionales ante Uruguay y que a fines de julio medirá fuerzas contra México.",true, android.R.color.background_light));
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