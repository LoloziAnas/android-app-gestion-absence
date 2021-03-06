package com.lzi.gestionabsence.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.lzi.gestionabsence.R;
import com.lzi.gestionabsence.SeanceActivity;
import com.lzi.gestionabsence.entities.Classe;

import java.util.List;

public class ClasseAdapter extends BaseAdapter  {

    private Activity activity;
    private List<Classe> classeList;
    private LayoutInflater layoutInflater;

    public ClasseAdapter(Activity activity, List<Classe> classeList) {
        this.activity = activity;
        this.classeList = classeList;
    }

    @Override
    public int getCount() {
        return classeList.size();
    }

    @Override
    public Classe getItem(int position) {
        return classeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null)
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.activity_classe_items,null);

        TextView tv_intitule = convertView.findViewById(R.id.tv_intitule);
        CardView cardView = convertView.findViewById(R.id.cv_classe);

        final Classe classe = classeList.get(position);
        tv_intitule.setText(classe.getIntitule());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SeanceActivity.class);
                intent.putExtra("classe",classe.toJson());
                activity.startActivity(intent);
                activity.finish();
            }
        });

        return convertView;
    }
}
