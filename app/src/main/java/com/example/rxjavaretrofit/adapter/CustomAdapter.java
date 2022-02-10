package com.example.rxjavaretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.model.Employee;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Employee> employeeList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, List<Employee> employeeList){
        this.context = context;
        this.employeeList = employeeList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int i) {
        return employeeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View convertview, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertview == null)
        {
            convertview = layoutInflater.inflate(R.layout.innerlayout,parent, false);
            viewHolder = new ViewHolder();
            viewHolder.firstname = (TextView) convertview.findViewById(R.id.firstname);
            viewHolder.lastname = (TextView) convertview.findViewById(R.id.lastname);
            convertview.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertview.getTag();
        }

        Employee employee = (Employee) getItem(pos);
        viewHolder.firstname.setText(employee.getFirstName());
        viewHolder.lastname.setText(employee.getLastName());
        return convertview;
    }

    class ViewHolder{
        TextView firstname, lastname;
    }
}
