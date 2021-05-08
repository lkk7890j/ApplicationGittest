package idv.tfp10104.applicatiocream;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    private String TAG = "TAG_MainActivity";
//    private TextView textView;

//    private ImageView imageView;
//    private static int RQe_1 = 1, RQe_2 =2 ;
//    private File file;
private EditText etUsername, etPassword;
private Button button;
private  SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
        finViews();
        handleEitText();
        handleButton();
        getFile();
//        SharedPreferences sharedPreferences = getSharedPreferences("user_info",MODE_PRIVATE);
//        sharedPreferences.edit()
//                .putInt("age",30)
//                .putString("name","william")
//                .apply();
    }

    private File  getFile() {
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        return new File(dir, "user_info");
    }

    private void handleEitText() {

//       final String username = sharedPreferences.getString("username","");
//       final String password = sharedPreferences.getString("password","");
//        etUsername.setText(username);
//        etPassword.setText(password);


        try (
//             FileInputStream fis = openFileInput("user_info");
//             ObjectInputStream ois = new ObjectInputStream(fis);)
                FileInputStream fis = new FileInputStream(getFile());
                ObjectInputStream ois = new ObjectInputStream(fis))
        {
            final User user = (User) ois.readObject();
            etUsername.setText(user.getUsername());
            etPassword.setText(user.getPassword());

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    private void finViews() {
        etUsername = findViewById(R.id.editTextTextPersonName);
        etPassword = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button);
    }

    private void handleButton() {
        button.setOnClickListener(view -> {
            final String username = String.valueOf(etUsername.getText());
            final String password = String.valueOf(etPassword.getText());
            User user = new User(username,password);
            try (
//                  FileOutputStream fos = openFileOutput("user_info",MODE_PRIVATE);
                    FileOutputStream fos = new FileOutputStream(getFile());
                    ObjectOutputStream oos = new ObjectOutputStream(fos)
            ){
                oos.writeObject(user);
            } catch (Exception e) {
               Log.e(TAG,e.toString());
            }
//            sharedPreferences.edit()
//                    .putString("username",username)
//                    .putString("password",password)
//                    .apply();
        });
}

//
//        AssetManager assetManager = getAssets();
//        textView = findViewById(R.id.textView);
//        try (
//                InputStream is = assetManager.open("Spring.txt");
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader br = new BufferedReader(isr)
//                ){
//                    String line;
//                    StringBuilder text = new StringBuilder();
//                    while ((line = br.readLine())!= null) {
//                        text.append(line).append("\n");
//                    }
//            textView.setText(text);
//        } catch (IOException e) {
//            Log.e(TAG, e.toString());
//        }
//    }
//}
//        imageView = findViewById(R.id.imageView);
//
//
//        findViewById(R.id.buttonGoGO).setOnClickListener(view -> {
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            if (isIntentAvailable(intent)) {
//
//                file = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//                file = new File(file, "20210427picture.jpg");
//                Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".fileProvider", file);
//
//
//
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//                startActivityForResult(intent, RQe_1);
//            }
//            //選圖
////            Intent intent = new Intent(Intent.ACTION_PICK,
////                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
////              startActivityForResult(intent, RQe_2);
//
//
//        });
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.P)
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == RQe_1) {
//            try {
////               Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                ImageDecoder.Source source = ImageDecoder.createSource(file);
//                Bitmap bitmap = ImageDecoder.decodeBitmap(source);
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//
//        }else if (requestCode == RQe_2){
//
//            try {
//                Uri uri = data.getData();
//                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),uri);
//                Bitmap bitmap = ImageDecoder.decodeBitmap(source);
//
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//
//    }
//
//
//    private boolean isIntentAvailable(Intent intent) {
//        PackageManager packageManager = getPackageManager();
//        return intent.resolveActivity(packageManager) != null;
//    }
//    }
}