package mesa.sdccd.calculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mario Velela Fierro on 5/23/2017.
 */

public class feedbackActivity extends Activity {
    EditText et_mail, et_subject, et_message;
    Button b_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        et_mail = (EditText) findViewById(R.id.et_email);
        et_subject = (EditText) findViewById(R.id.et_subject);
        et_message = (EditText) findViewById(R.id.et_message);

        b_send = (Button) findViewById(R.id.b_send);

        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = et_mail.getText().toString();
                String subject =et_subject.getText().toString();
                String message =et_message.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(intent.EXTRA_SUBJECT, subject);
                intent.putExtra(intent.EXTRA_TEXT, message);

                intent.setType("message/mvelela11");

                startActivity(Intent.createChooser(intent, "select email app"));

            }
        });
    }
}
