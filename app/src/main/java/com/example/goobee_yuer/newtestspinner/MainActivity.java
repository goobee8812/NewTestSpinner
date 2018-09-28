package com.example.goobee_yuer.newtestspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.inflate;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;

    /*
        * 动态添显示下来菜单的选项，可以动态添加元素
        */
    ArrayList<String> gradeList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_eye_layout_new);
        mSpinner = findViewById(R.id.alilo_sleep_spinner);
        gradeList.add("10分钟");
        gradeList.add("20分钟");
        gradeList.add("30分钟");
        gradeList.add("40分钟");
        gradeList.add("1小时");
        gradeList.add("2小时");
        gradeList.add("3小时");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_checked_text, gradeList) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = inflate(getContext(), R.layout.spinner_item_layout,
                        null);
                TextView label = (TextView) view
                        .findViewById(R.id.spinner_item_label);
                ImageView check = (ImageView) view
                        .findViewById(R.id.spinner_item_checked_image);
                label.setText(gradeList.get(position));

                if (mSpinner.getSelectedItemPosition() == position) {
                    view.setBackgroundColor(getResources().getColor(
                            R.color.spinner_green));
//                    check.setImageResource(R.drawable.check_selected);
                } else {
                    view.setBackgroundColor(getResources().getColor(
                            R.color.spinner_light_green));
//                    check.setImageResource(R.drawable.check_unselect);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.spinner_item_layout);
        mSpinner.setAdapter(adapter);
    }

}
