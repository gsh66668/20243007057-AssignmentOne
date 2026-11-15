package nz.ac.waikato.campuslife;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CampusLife main screen.
 *
 * <p>Shows the campus banner with the welcome text and the four topic buttons
 * (Facilities, Events, Clubs, Support). Tapping a button currently only shows a
 * confirmation Toast (Part E).</p>
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

    /** Short topic names used by the Toast message. */
    private static final int[] TOPIC_LABEL_IDS = {
            R.string.label_facilities,
            R.string.label_events,
            R.string.label_clubs,
            R.string.label_support};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A single loop attaches the click listener to all four buttons.
        for (int index = 0; index < TOPIC_BUTTON_IDS.length; index++) {
            final String topicLabel = getString(TOPIC_LABEL_IDS[index]);

            ImageButton button = findViewById(TOPIC_BUTTON_IDS[index]);
            button.setOnClickListener(view -> showClickToast(topicLabel));
        }
    }

    /**
     * Confirms the click with a Toast, e.g. "Facilities clicked".
     *
     * @param topicLabel short topic name of the button that was tapped
     */
    private void showClickToast(String topicLabel) {
        Toast.makeText(this, getString(R.string.toast_clicked, topicLabel), Toast.LENGTH_SHORT).show();
    }
}
