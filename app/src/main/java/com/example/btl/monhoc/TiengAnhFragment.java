package com.example.btl.monhoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.btl.R;
import com.example.btl.slide.ScreenSlidePagerActivity;

import java.util.ArrayList;


public class TiengAnhFragment extends Fragment {

    Activity content;

    ExamAdapter examAdapter;
    GridView gvExam;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();

    public TiengAnhFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        content = getActivity();
        View root = inflater.inflate(R.layout.fragment_tienganh, container, false);
        return root;


    }
//    private void linkView(){
//        btnDethi= btnDethi.findViewById(R.id.btn_dethi);
//    }

    @SuppressWarnings({"ConstantConditions", "deprecation"})
    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvExam = content.findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Đề số 1"));
        arr_exam.add(new Exam("Đề số 2"));
        arr_exam.add(new Exam("Đề số 3"));
        arr_exam.add(new Exam("Đề số 4"));
        arr_exam.add(new Exam("Đề số 5"));
        arr_exam.add(new Exam("Đề số 6"));
        arr_exam.add(new Exam("Đề số 7"));
        arr_exam.add(new Exam("Đề số 8"));

        examAdapter = new ExamAdapter(content, arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(content, ScreenSlidePagerActivity.class);
                intent.putExtra("num_exam", position + 1);
                intent.putExtra("subject", "anh");
                intent.putExtra("test", "yes");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}