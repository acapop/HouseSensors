package housesensors.iot.housesensors;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editTextTemp)
    EditText editTextTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.send_temp)
    public void onSendTempClicked() {
        Intent intent=new Intent(Constants.ACTION_TEMPERATURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("sender","tempsensor");
        intent.putExtra("type",Constants.TEMPERATURE);
        intent.putExtra("value",editTextTemp.getText());
        sendBroadcast(intent);
    }
}
