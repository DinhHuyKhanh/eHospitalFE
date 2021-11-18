package com.ktt.ehospital;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ktt.response.AppointmentResponse;

import java.io.Serializable;
import java.util.List;

public class DsAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<AppointmentResponse> appointmentResponseList;

    public DsAdapter(Context context, int layout, List<AppointmentResponse> appointmentResponseList) {
        this.context = context;
        this.layout = layout;
        this.appointmentResponseList = appointmentResponseList;
    }

    @Override
    public int getCount() {
        return appointmentResponseList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    private class ViewHolder{
//        TextView txName, tvDate,tvStatus;
//        Button btnDetail;
//    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ViewHolder viewHolder;
//        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
//            viewHolder = new ViewHolder();

            //ánh xạ
        TextView txName = (TextView) convertView.findViewById(R.id.col2Name);
        TextView tvDate = (TextView) convertView.findViewById(R.id.col2Date);
            TextView tvStatus = (TextView) convertView.findViewById(R.id.col2Status);
//            convertView.setTag(viewHolder);
//        }else{
//            viewHolder = (ViewHolder) convertView.getTag();
//        }


        //gán gtri
        AppointmentResponse lichKham = appointmentResponseList.get(position);
        txName.setText(lichKham.getFullName());
        tvDate.setText(lichKham.getDateAppointment());
        if(lichKham.getStatus().equals("PENDING")){
            tvStatus.setText("Chờ xác nhận.");

        }else if(lichKham.getStatus().equals("ABORT")){
            tvStatus.setText("Đã hủy.");

        }else{
            tvStatus.setText("Đã đặt lịch thành công.");
        }
        Button btnDetails = convertView.findViewById(R.id.detail);

        btnDetails.setOnClickListener(item->{
            Intent intent = new Intent(context, detailsLichHen.class);
            intent.putExtra("infoUser", (Serializable) appointmentResponseList.get(position));
            context.startActivity(intent);
        });

        return convertView;
    }
}
