package code.anint.edu.com.intentedu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

// 4  add impliments to over ride the onClick button
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePic, dialAnumberButton, toastButton, showLocationButton, openWebPageButton;
    Button viewIntentButton, letsGetProButton, viaPackageManagerButton;

    ImageView imageView;

    // 1. declare all Button edit and view objects here..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_intent_button_linearlayout);

        // 2. get the id handle to the objects by using finViewbyID(....);

        imageView                = (ImageView) findViewById(R.id.imageDisplay);

        takePic                  = (Button) findViewById(R.id.takePhoto);
        dialAnumberButton        = (Button) findViewById(R.id.dialButton);
        toastButton              = (Button) findViewById(R.id.toast);
        showLocationButton       = (Button) findViewById(R.id.showLocation);
        openWebPageButton        = (Button) findViewById(R.id.openWebPage);
        viewIntentButton         = (Button) findViewById(R.id.viewIntent);
        letsGetProButton         = (Button) findViewById(R.id.letsgetpro);
        viaPackageManagerButton  = (Button) findViewById(R.id.viaPackageManager);

        // 3. set the listinears to all the created objects...


        takePic.setOnClickListener(this);
        dialAnumberButton.setOnClickListener(this);
        toastButton.setOnClickListener(this);
        showLocationButton.setOnClickListener(this);
        openWebPageButton.setOnClickListener(this);
        viewIntentButton.setOnClickListener(this);
        letsGetProButton.setOnClickListener(this);
        viaPackageManagerButton.setOnClickListener(this);


    }

    // 5th step
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.takePhoto:
                dispatchTakePictureIntent();
                break;

            case R.id.dialButton:

                DialButton();
                break;

            case R.id.toast:

                Toasta();
                break;

            case R.id.showLocation:

                ShowLocation();
                break;

            case R.id.openWebPage:

                OpenWebPage();
                break;

            case R.id.viewIntent:

                ViewIntent();

                break;

            case R.id.letsgetpro:

                LetsGetPro();
                break;

            case R.id.viaPackageManager:

                ViaPackageManager();
                break;

        } //switch
    } // onClick

    private void ViaPackageManager() {

        PackageManager packageManager = getPackageManager();
        Intent intent= new Intent("code.anint.edu.com.intentedu.demoActivity");
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);

        boolean isIntentSafe = activities.size() > 0;

        if( isIntentSafe) {

            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Sorry PM : Activity not found in Package manager..", Toast.LENGTH_SHORT).show();
        }

        // crash the app
    }

    private void LetsGetPro() {
    }

    private void ViewIntent() {

          // What kind of a componant we are going to create ?????
        // A video Streamer... ????
        // An Audio codec ...???
        // A remote printer...  HP

        // phase 5                                               // 1                    2
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mystreamer:"+"Play the Song from Streamer...\n"));
        intent.putExtra("From","\n This is from Sathya.."); // 3
        startActivity(intent);
    }

    private void OpenWebPage() {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
        startActivity(intent);


    } // GUYS PLEASE WAIT SOON WILL START WHEN I GET SOME PROCESSOR SPACE :

    private void ShowLocation() {

        Intent showLocationIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:12.9986964,77.5898373"));
        startActivity(showLocationIntent);
    }

    private void Toasta() {
       // phase 1.
        //Intent intent = new Intent(this,otherActivityEdureka.class);
       // startActivity(intent);

        // Just calls the activity in our (process - application) otherActivityEdureka

    // phase 2
        // Intent intent = new Intent("code.anint.edu.com.intentedu.otherActivityEdureka");
        // Just calls the activity in our (process - application) otherActivityEdureka

        // same as above....

        // phase 3

//        Intent intent = new Intent("dr");
//        startActivity(intent);


        //  // phase 4
       // Intent intent = new Intent(Intent.ACTION_VIEW);
       // startActivity(intent);
    }

    private void DialButton() {

        // componant..
//        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789") );
//        startActivity(dialIntent);

        // whenever user calls ACTION_DIAL with tel: as Uri our app should receive the controll..


        // phase 5


        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789") );
        startActivity(dialIntent);


        // phase 5

//        Intent dialIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mystreamer:"+"lionelRicheyHEllo.mp3) );// Audio or Video
//        startActivity(dialIntent);
    }

    private void dispatchTakePictureIntent() {

        // MEDIA INTENT...
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // we are waiting for an event...



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }



    }     // MainActivity


