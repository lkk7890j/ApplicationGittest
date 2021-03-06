package idv.tfp10104.williamwang;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static idv.tfp10104.williamwang.Constants.PASSWORD;
import static idv.tfp10104.williamwang.Constants.ACCOUNT;

import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {
    private Activity activity;
    private Button login_Button;
    private EditText editText_Account;
    private TextInputEditText textInputEditText_Password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editText_Account = view.findViewById(R.id.edText_Account);
        textInputEditText_Password = view.findViewById(R.id.InputEditText_Password);
        login_Button = view.findViewById(R.id.Login_button);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textInputEditText_Password.getText();
        handleButton();
    }

    private void handleButton() {
        login_Button.setOnClickListener(view -> {
            final String account= String.valueOf(editText_Account.getText());
            final String password = String.valueOf(textInputEditText_Password.getText());

            if (password.isEmpty()) {
                textInputEditText_Password.setError("Password is required");
                return;
            }
            Bundle bundle = new Bundle();
            // ????????????
            bundle.putString(ACCOUNT, account);
            bundle.putString(PASSWORD, password);
            // ??????NavController??????
            NavController navController = Navigation.findNavController(view);
            // ????????????
            navController.navigate(R.id.action_Login_Fragment_to_result_Fragment,bundle);
        });
    }
}