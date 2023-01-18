package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.junit.Assert.*;


@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(activity -> {
            activity.findViewById(R.id.btn_one).performClick();
            activity.findViewById(R.id.btn_plus).performClick();
            activity.findViewById(R.id.btn_one).performClick();
            activity.findViewById(R.id.btn_equals).performClick();
            //assertEquals(activity.findViewById(R.id.display).getText(), "2");
            TextView t = activity.findViewById(R.id.display);
            assertEquals(t.getText(), "2");
        });

    }
}
