package Adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.dieuhanhxebus.R;

import java.util.List;

import Model.Bus;
import ModelGroup.RouteBus;

/**
 * Created by ADMIN on 10/23/17.
 */

public class AdapterBusList extends ArrayAdapter<RouteBus> {
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<RouteBus> objects;
    public AdapterBusList(@NonNull Activity context, @LayoutRes int resource, @NonNull List<RouteBus> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        View row=layoutInflater.inflate(this.resource,null);
        TextView txtBusId=row.findViewById(R.id.txtbusid);
        TextView txtBusNumber=row.findViewById(R.id.txtbusnumber);
        TextView txttuyen=row.findViewById(R.id.txttuyenxeBus);

        RouteBus bus=this.objects.get(position);
        txtBusId.setText("S? "+String.valueOf(bus.getMaXeBus()));
        txtBusNumber.setText("Xe bus s? : "+String.valueOf(bus.getSoXeBus()));
        txttuyen.setText(bus.getTuyenXe());
        return row;
    }
}
