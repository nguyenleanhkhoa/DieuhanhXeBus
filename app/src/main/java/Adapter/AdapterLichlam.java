package Adapter;

import android.app.Activity;
import android.content.Context;
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

import Model.Employer;
import Model.EmployerSchedule;

/**
 * Created by ADMIN on 10/25/17.
 */

public class AdapterLichlam extends ArrayAdapter<EmployerSchedule> {
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<EmployerSchedule> objects;
    public AdapterLichlam(@NonNull Activity context, @LayoutRes int resource, @NonNull List<EmployerSchedule> objects) {
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
        TextView txtbusid=row.findViewById(R.id.txtLichBusid);
        TextView txtdate=row.findViewById(R.id.txtLichdate);

        EmployerSchedule employerSchedule=this.objects.get(position);
        txtbusid.setText(" Mã xe bus : "+employerSchedule.getSoXeBuyt());
        txtdate.setText( "Ngày làm : "+employerSchedule.getDate());
        return row;
    }
}
