package com.example.rxjavaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.rxjavaretrofit.adapter.CustomAdapter;
import com.example.rxjavaretrofit.model.Employee;
import com.example.rxjavaretrofit.model.EmployeeList;
import com.example.rxjavaretrofit.remote.APIService;
import com.example.rxjavaretrofit.remote.RetroClass;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private List<Employee> employeeList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.Listview);
        button = (Button) findViewById(R.id.fetchdata);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    void loadJson()
    {
        APIService apiService = RetroClass.getAPIService();
        Observable<EmployeeList> observable = apiService.getEmployeeList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<EmployeeList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(EmployeeList value) {
                employeeList = new ArrayList<>();
                List<Employee> employees = value.getEmployees();

                for (int i = 0; i <employeeList.size(); i++){
                    Employee employee = new Employee();
                    employee.setFirstName(employees.get(i).getFirstName());
                    employee.setLastName(employees.get(i).getLastName());
                    employeeList.add(employee);

                }

                customAdapter = new CustomAdapter(MainActivity.this, employeeList);
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}