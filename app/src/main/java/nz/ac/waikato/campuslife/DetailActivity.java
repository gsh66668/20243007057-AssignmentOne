package nz.ac.waikato.campuslife;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CampusLife detail screen.
 *
 * <p>Started with an explicit Intent from {@link MainActivity}. The Intent
 * carries the index of the topic that was tapped plus its short name; the short
 * name is shown in the header straight away. The long title, the body text and
 * the topic icon are filled in from arrays.xml in Part H.</p>
 */
public class DetailActivity extends AppCompatActivity {

    /** Key for the position of the selected topic inside arrays.xml. */
    public static final String EXTRA_TOPIC_INDEX = "nz.ac.waikato.campuslife.extra.TOPIC_INDEX";

    /** Key for the short topic name shown in the header ("Facilities" etc.). */
    public static final String EXTRA_TOPIC_LABEL = "nz.ac.waikato.campuslife.extra.TOPIC_LABEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String topicLabel = getIntent().getStringExtra(EXTRA_TOPIC_LABEL);

        TextView header = findViewById(R.id.detail_header);
        header.setText(topicLabel);
    }
}
