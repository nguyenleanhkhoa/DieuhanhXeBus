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

import Model.Employer;

/**
 * Created by ADMIN on 10/23/17.
 */

public class AdapterEmployer extends ArrayAdapter<Employer>{
    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Employer> objects;
    public AdapterEmployer(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Employer> objects) {
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
        TextView txtma=row.findViewById(R.id.txtmanhanvien);
        TextView txtten=row.findViewById(R.id.txttennhanvien);
        TextView txtphone=row.findViewById(R.id.txtsodienthoai);

        Employer employer=this.objects.get(position);
        txtten.setText("H? Tên: "+employer.getEml_Name());
        txtphone.setText("S?t: "+employer.getEml_Phone());
        txtma.setText("Mã: "+String.valueOf(employer.getEml_Id()));
        return row;
    }
}
