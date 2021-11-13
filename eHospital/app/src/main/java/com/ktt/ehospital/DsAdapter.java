package com.ktt.ehospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<LichKham> lichKhamList;

    public DsAdapter(Context context, int layout, List<LichKham> lichKhamList) {
        this.context = context;
        this.layout = layout;
        this.lichKhamList = lichKhamList;
    }

    @Override
    public int getCount() {
        return lichKhamList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        //ánh xạ
        TextView tvTenBN = (TextView) convertView.findViewById(R.id.tvTenBN);
        TextView tvSDTBN = (TextView) convertView.findViewById(R.id.tvSDTBN);
        TextView tvTenBS = (TextView) convertView.findViewById(R.id.tvTenBS);
        TextView tvKhoaK = (TextView) convertView.findViewById(R.id.tvKhoaK);
        TextView tvDateK = (TextView) convertView.findViewById(R.id.tvDateK);
        TextView tvGioK = (TextView) convertView.findViewById(R.id.tvGioK);
        TextView tvGiaK = (TextView) convertView.findViewById(R.id.tvGiaK);
        TextView tvTT = (TextView) convertView.findViewById(R.id.tvTT);
        //gán gtri
        LichKham lichKham = lichKhamList.get(position);
        tvTenBN.setText(lichKham.getTenBN());
        tvSDTBN.setText(lichKham.getSdtBN());
        tvTenBS.setText(lichKham.getTenBS());
        tvKhoaK.setText(lichKham.getKhoaKham());
        tvDateK.setText(lichKham.getNgayKham());
        tvGioK.setText(lichKham.getGioKham());
        tvGiaK.setText(lichKham.getGiaKham());
        tvTT.setText(lichKham.getStatus());
        return convertView;
    }
}
