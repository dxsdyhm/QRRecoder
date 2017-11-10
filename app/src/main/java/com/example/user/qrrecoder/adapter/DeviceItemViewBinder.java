package com.example.user.qrrecoder.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.qrrecoder.R;
import com.example.user.qrrecoder.data.greendao.DeviceItem;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by USER on 2017/11/10.
 */

public class DeviceItemViewBinder extends ItemViewBinder<DeviceItem, DeviceItemViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_device, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DeviceItem item) {
        holder.textNumber.setText(String.valueOf(holder.getAdapterPosition()+1));
        holder.textDeviceID.setText(item.getName());
        holder.textServerState.setText(getServerStateString(item));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textNumber;
        private TextView textDeviceID;
        private TextView textServerState;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNumber=itemView.findViewById(R.id.tx_number);
            textDeviceID=itemView.findViewById(R.id.tx_deviceid);
            textServerState=itemView.findViewById(R.id.tx_serverstate);
        }
    }

    private String getServerStateString(DeviceItem item){
        if(item.getServerState()==0){
            return "未上传";
        }else if(item.getServerState()==1){
            return "已上传";
        }
        return String.valueOf(item.getServerState());
    }
}
