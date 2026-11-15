package nz.ac.waikato.campuslife;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CampusLife detail screen.
 *
 * <p>The topic to display is identified by the index handed over from
 * {@link MainActivity}. That index is used to look up the matching rows of the
 * three string arrays in arrays.xml (titles, content and image names) and to
 * fill the header, title and body of this screen. Because the index addresses
 * the arrays directly, no if statement or switch case is needed (Part H).</p>
 */
public class DetailActivity extends AppCompatActivity {

    /** Key for the position of the selected topic inside arrays.xml. */
    public static final String EXTRA_TOPIC_INDEX = "nz.ac.waikato.campuslife.extra.TOPIC_INDEX";

    /** Key for the short topic name shown in the header ("Facilities" etc.). */
    public static final String EXTRA_TOPIC_LABEL = "nz.ac.waikato.campuslife.extra.TOPIC_LABEL";

    /** Fallback topic, used only if the activity is opened without an index. */
    private static final int DEFAULT_TOPIC_INDEX = 0;

    /** Name of the drawable folder, used when resolving the icon name from arrays.xml. */
    private static final String DRAWABLE_TYPE = "drawable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int topicIndex = getIntent().getIntExtra(EXTRA_TOPIC_INDEX, DEFAULT_TOPIC_INDEX);
        String topicLabel = getIntent().getStringExtra(EXTRA_TOPIC_LABEL);

        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] imageNames = getResources().getStringArray(R.array.string_array_images);

        TextView header = findViewById(R.id.detail_header);
        TextView title = findViewById(R.id.detail_title);
        TextView content = findViewById(R.id.detail_content);
        ImageView icon = findViewById(R.id.detail_icon);

        // arrays.xml stores short names with surrounding spaces, hence the trims.
        header.setText(topicLabel);
        title.setText(titles[topicIndex].trim());
        content.setText(contents[topicIndex].trim());
        icon.setImageResource(resolveDrawableId(imageNames[topicIndex].trim()));
    }

    /**
     * Turns a drawable name from arrays.xml (for example "img_btn_facilities")
     * into the matching resource id in this application.
     *
     * @param drawableName the drawable name stored in arrays.xml
     * @return the resource id of that drawable
     */
    private int resolveDrawableId(String drawableName) {
        return getResources().getIdentifier(drawableName, DRAWABLE_TYPE, getPackageName());
    }
}
