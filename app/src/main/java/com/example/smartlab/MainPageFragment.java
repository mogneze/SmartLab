package com.example.smartlab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainPageFragment newInstance(String param1, String param2) {
        MainPageFragment fragment = new MainPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ArrayList<NewsItem> newsItemArrayList;
    private ArrayList<CatalogItem> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        initNews(); //новости кароч
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        NewsAdapter newsAdapter = new NewsAdapter(newsItemArrayList);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false));

        // Inflate the layout for this fragment
        initCatalog(); //и типа эти как их там
        CatalogAdapter catalogAdapter = new CatalogAdapter(getActivity().getApplicationContext(), list);
        ListView catalogList = view.findViewById(R.id.catalogListView);
        catalogList.setAdapter(catalogAdapter);
        return view;
    }
    public void initNews(){
        newsItemArrayList = new ArrayList<>();
        newsItemArrayList.add(new NewsItem("Чек-ап для мужчин", "9 исследований", 8000));
        newsItemArrayList.add(new NewsItem("Подготовка к вакцинации", "Комплексное обследование перед вакцинацией", 4000));
        newsItemArrayList.add(new NewsItem("назв", "камент", 10.0));
        newsItemArrayList.add(new NewsItem("назв", "камент", 10.0));
    }
    private void initCatalog(){
        list = new ArrayList<CatalogItem>();
        list.add(new CatalogItem(1, "name", "des", 10.0, "1 d", "prep", "bio"));
        list.add(new CatalogItem(1, "name", "des", 10.0, "1 d", "prep", "bio"));
        list.add(new CatalogItem(1, "name", "des", 10.0, "1 d", "prep", "bio"));
    }
}