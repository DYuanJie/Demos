package com.dyjtest.listviewdemo.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.dyjtest.listviewdemo.R;

/**
 * @author dingyj
 * @date 2017/9/29
 */

public class NameDialogFragment extends DialogFragment {
    private EditText mName;
    private Button btnOk;

    //      使用自定义的xml布局文件展示dialog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //去掉title
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_item, null);

        mName = (EditText)view.findViewById(R.id.nameEt);
        btnOk = (Button)view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputListener listener = (InputListener) getActivity();
                listener.inputCallBack(mName.getText().toString());
            }
        });

        return view;
    }

    public interface InputListener {
        void inputCallBack(String name);
    }

//    使用Alert或dialog创建dialog
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view  = inflater.inflate(R.layout.dialog_item1, null);
//        mName = (EditText)view.findViewById(R.id.nameEt);
//        btnOk = (Button)view.findViewById(R.id.btn_ok);
//
//        builder.setView(view)
//                .setPositiveButton("add", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        InputListener listener = (InputListener) getActivity();
//                        listener.inputCallBack(mName.getText().toString());
//                    }
//                }).setNegativeButton("cancel", null);
//
//        return builder.create();
//    }
}
