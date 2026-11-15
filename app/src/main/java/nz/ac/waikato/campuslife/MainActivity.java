package nz.ac.waikato.campuslife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CampusLife main screen.
 *
 * <p>Shows the campus banner with the welcome text and the four topic buttons
 * (Facilities, Events, Clubs, Support). Tapping a button shows a confirmation
 * Toast (Part E) and then opens {@link DetailActivity} with the index of the
 * topic, which is the unique identifier used by the detail screen (Part G).</p>
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The four topic buttons, declared in the same order as the entries in
     * arrays.xml, so the loop index doubles as the topic identifier.
     */
    private static final int[] TOPIC_BUTTON_IDS = {
            R.id.btn_facilities,
            R.id.btn_events,
            R.id.btn_clubs,
            R.id.btn_support};

    /** Short topic names, used for the Toast and for the detail screen header. */
    private static final int[] TOPIC_LABEL_IDS = {
            R.string.label_facilities,
            R.string.label_events,
            R.string.label_clubs,
            R.string.label_support};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A single loop attaches the click listener to all four buttons. The
        // loop index is the identifier that travels to DetailActivity, so the
        // app never needs an if statement or a switch case to tell topics apart.
        for (int index = 0; index < TOPIC_BUTTON_IDS.length; index++) {
            final int topicIndex = index;
            final String topicLabel = getString(TOPIC_LABEL_IDS[index]);

            ImageButton button = findViewById(TOPIC_BUTTON_IDS[index]);
            button.setOnClickListener(view -> openTopic(topicIndex, topicLabel));
        }
    }

    /**
     * Confirms the click with a Toast, then starts the detail screen for that topic.
     *
     * @param topicIndex position of the topic in arrays.xml (0 to 3)
     * @param topicLabel short topic name, e.g. "Facilities"
     */
    private void openTopic(int topicIndex, String topicLabel) {
        Toast.makeText(this, getString(R.string.toast_clicked, topicLabel), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, topicIndex);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_LABEL, topicLabel);
        startActivity(intent);
    }
}
