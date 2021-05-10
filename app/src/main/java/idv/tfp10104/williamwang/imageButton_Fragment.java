package idv.tfp10104.williamwang;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class imageButton_Fragment extends Fragment {
    private Activity activity;
    private ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
       View view = inflater.inflate(R.layout.fragment_imagebutton, container, false);
        findViews(view);
        handleOnClick();
        return view;
    }

    private void findViews(View view) {
        imageButton = view.findViewById(R.id.imageButton);
    }

    private void handleOnClick() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "點擊了imageButton", Toast.LENGTH_SHORT).show();
            }
        });
    }

}