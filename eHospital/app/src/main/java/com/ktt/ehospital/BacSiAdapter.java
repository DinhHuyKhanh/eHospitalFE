package com.ktt.ehospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BacSiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<infoBacSi> dsBacSi;

    public BacSiAdapter(Context context, int layout, List<infoBacSi> dsBacSi) {
        this.context = context;
        this.layout = layout;
        this.dsBacSi = dsBacSi;
    }

    @Override
    public int getCount() {
        return dsBacSi.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        //ánh xạ - get view
        TextView txtTen = (TextView) view.findViewById(R.id.tvTen);
        TextView txtHV = (TextView) view.findViewById(R.id.tvHV);
        TextView txtKN = (TextView) view.findViewById(R.id.tvKN);
        TextView txtGia = (TextView) view.findViewById(R.id.tvGia);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.ivHinh);

        //gán giá trị
        infoBacSi bacSi = dsBacSi.get(i);
        txtTen.setText(bacSi.getName());
        txtHV.setText(bacSi.getHocvi());
        txtKN.setText(bacSi.getKnghiem());
        txtGia.setText(bacSi.getPrice());
        imgHinh.setImageResource(bacSi.getImg());

        return view;
    }
}
