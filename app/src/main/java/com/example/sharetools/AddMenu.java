package com.example.sharetools;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class AddMenu extends BottomSheetDialog {

    private final List<Button> AddButtonList;
    public AddMenu(Context context) {
        super(context);

        AddButtonList = new ArrayList<>();

        AddButtonList.add(new Button(context));
        AddButtonList.get(0).setText(R.string.option_1);

        AddButtonList.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter l'événement pour le bouton Item 1
            }
        });

        AddButtonList.add(new Button(context));
        AddButtonList.get(1).setText("Option 2");
        AddButtonList.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter l'événement pour le bouton Item 2
            }
        });

        AddButtonList.add(new Button(context));
        AddButtonList.get(2).setText("Option 3");
        /*AddButtonList.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Traiter l'événement pour le bouton Item 3

            }
        });*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_add, null);

        RelativeLayout layout = view.findViewById(R.id.list_view);
        for (Button button : AddButtonList) {
            layout.addView(button);
        }

        setContentView(view);

    }
}
//TODO: Modifier la façon dont le menu s'affiche. Il faut que le bas du menu commence au sommet du BottomBarMenu.