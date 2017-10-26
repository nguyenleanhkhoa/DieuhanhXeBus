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

import Model.EmployerSchedule;

/**
 * Created by BRUCE on 10/23/2017.
 */

public class AdapterEmloyerSchedule extends ArrayAdapter<EmployerSchedule> {
    @NonNull
    Activity context;
    @LayoutRes
    int resource;
    @NonNull
    List<EmployerSchedule> objects;

    public AdapterEmloyerSchedule(@NonNull Activity context, @LayoutRes int resource, @NonNull List<EmployerSchedule> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater=this.context.getLayoutInflater();
//        View row=layoutInflater.inflate(this.resource,null);
//        TextView txtBusNumber = row.findViewById(R.id.txtBusNumber);
//        TextView txtDate = row.findViewById(R.id.txtNgayLam);
//
//        EmployerSchedule employerSchedule=this.objects.get(position);
//        txtBusNumber.setText(employerSchedule.getSoXeBuyt()+"");
//        txtDate.setText(employerSchedule.getDate());
//
//        return row;
//    }
}
