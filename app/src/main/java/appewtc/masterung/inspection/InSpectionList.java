package appewtc.masterung.inspection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class InSpectionList extends AppCompatActivity {

    //Explicit
    private ImageView iconImageView;
    private TextView titleTextView;
    private ListView inspectorListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_spection_list);

        //Bind Widget
        bindWidget();

    }   // Main Method

    private void bindWidget() {

    }

}   // Main Class
