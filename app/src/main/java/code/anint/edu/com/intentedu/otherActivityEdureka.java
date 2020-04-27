package code.anint.edu.com.intentedu;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class otherActivityEdureka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Toast.makeText(this, "Landed In Other Activity Edureka( LOCAL )", Toast.LENGTH_SHORT).show();


        String outPut = null;

        TextView textView = ( TextView )findViewById(R.id.textView);

        // Streaming path

        Uri uri = getIntent().getData();  // we are trying to retrive the tag: mystreamer:   // 1
                                          //  <data android:scheme="mystreamer"/>


//        Uri uriAction = Uri.parse(getIntent().getAction());
//        Uri uriCat    = Uri.parse(getIntent().getCategories());
//


        // extras..

        Bundle extras = getIntent().getExtras(); // Lets get the data( String ) - streamer - codec

        outPut = uri.toString();

        if( extras != null ){
            outPut = outPut + "From " + extras.getString("From");

        }


        // write the actuall streaming code...
        // or this can be a network dialer...

       /// textView.setText(outPut);
    }
}
