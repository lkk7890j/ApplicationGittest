package idv.tfp10104.williamwang;

import android.app.Activity;
import android.net.sip.SipSession;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.security.PublicKey;

public class All_buttonFragment extends Fragment {
    private Activity activity;
    private RadioGroup radioGroup ;
    private CheckBox checkBox, checkBoxJavase, checkBoxMysql;
    private TextView textView;
    private ToggleButton toggleButton;
    private SwitchCompat switchCompat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_button_blank, container, false);
        findViews(view);
        handleRadioGroup();
        handleCheckBoxes();
        handleToggleButton();
        handleSwitchCompat();
        return view;
    }

    private void handleSwitchCompat() {
        switchCompat.setText("WiFI");
        final CompoundButton.OnCheckedChangeListener listener = (checkBox, isChecked) -> {
            textView.setText("(SwitchCompat) " + switchCompat.getText() + ": " + isChecked);
        };
        switchCompat.setOnCheckedChangeListener(listener);
    }

    private void handleToggleButton() {
        final CompoundButton.OnCheckedChangeListener listener = (checkBox, isChecked) -> {
            textView.setText("(toggleButton) " + toggleButton.getText() + ": " + isChecked);
        };
        toggleButton.setOnCheckedChangeListener(listener);
    }

    private void handleCheckBoxes() {
        final CompoundButton.OnCheckedChangeListener listener = (checkBox, isChecked) -> {
            textView.setText("(CheckBox) " + checkBox.getText() + ": " + isChecked);
        };
        checkBoxJavase.setOnCheckedChangeListener(listener);
        checkBoxMysql.setOnCheckedChangeListener(listener);
    }

    private void handleRadioGroup() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            final RadioButton radioButton = group.findViewById(checkedId);
            textView.setText("(RadioButton) " + radioButton.getText());
        });
    }

    private void findViews(View view) {
        radioGroup = view.findViewById(R.id.radioGroup);
        textView = view.findViewById(R.id.bttextView);
        checkBoxMysql = view.findViewById(R.id.checkBoxMysql);
        checkBoxJavase = view.findViewById(R.id.checkBoxJavaSe);
        toggleButton = view.findViewById(R.id.toggleButton);
        switchCompat = view.findViewById(R.id.switchCompat);

    }
}