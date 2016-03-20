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
    private String chooseCategoryString;
    private int chooseIconAnInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_spection_list);

        //Bind Widget
        bindWidget();

        //Show View
        showView();

    }   // Main Method

    private void showView() {

        chooseCategoryString = getIntent().getStringExtra("Title");
        chooseIconAnInt = getIntent().getIntExtra("Icon", R.drawable.build3);

        titleTextView.setText(chooseCategoryString);
        iconImageView.setImageResource(chooseIconAnInt);
    }

    private void bindWidget() {

        iconImageView = (ImageView) findViewById(R.id.imageView3);
        titleTextView = (TextView) findViewById(R.id.textView4);
        inspectorListView = (ListView) findViewById(R.id.listView);

    }

}   // Main Class
