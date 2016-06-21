package com.juanjosegallego.lineasalud;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class datoseps extends Fragment {

    String url="https://www.cafesalud.com.co/";
    WebView pagina;
    //Button pagina;


    public datoseps() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_datoseps, container, false);

        pagina=(WebView) root.findViewById(R.id.pagina);
        //pagina=(Button)root.findViewById(R.id.pagina);

        //pagina.getSettings().setJavaScriptEnabled(true);
        pagina.loadUrl(url);

        return root;
    }



}
