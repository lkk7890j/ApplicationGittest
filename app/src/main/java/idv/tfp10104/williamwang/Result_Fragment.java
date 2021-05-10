package idv.tfp10104.williamwang;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Result_Fragment extends Fragment {
    private Activity activity;
    private TextView tvAccount, tvPassword;
    private Button btBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        return inflater.inflate(R.layout.fragment_result_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvAccount = view.findViewById(R.id.tvAccount);
        tvPassword = view.findViewById(R.id.tvPassword);
        btBack = view.findViewById(R.id.btBack);
        handleTextViews();
        handleBtBack();

    }

    private void handleTextViews() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            // 取出資料
            final String account = bundle.getString("account");
            final String password = bundle.getString("password");

            if ("lkk7890j".equals(account) && "P@ssw0rd".equals(password)) {
                tvAccount.setText(account);
                tvPassword.setText(password);
            } else {
                tvAccount.setText("Username or password incorrect!");
            }
        }
    }

    private void handleBtBack() {

        btBack.setOnClickListener(view ->
                Navigation.findNavController(view).popBackStack(R.id.Login_Fragment, false));
    }
}
