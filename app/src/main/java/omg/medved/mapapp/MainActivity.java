package omg.medved.mapapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    final int MENU_1 = 1;
    final int MENU_2 = 2;
    final int MENU_3 = 3;

    final int MENU_4 = 4;
    final int MENU_5 = 5;
    final int MENU_6 = 6;
    final int MENU_7 = 7;
    final int MENU_8 = 8;

    GoogleMap googleMap;

    private static final LatLng firstCamera = new LatLng(46.841407, 8.322144);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        createMapView();
        addMarker();
    }

    private void createMapView() {
        try {
            if (null == googleMap) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);




                /**
                 * If the map is still null after attempted initialisation,
                 * show an error to the user
                 */
                if (null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception) {
            Log.e("mapApp", exception.toString());
        }
    }


    private void addMarker(){

        /** Make sure that the map has been initialised **/
        if(null != googleMap) {
            Marker davao = googleMap.addMarker(new MarkerOptions().position(firstCamera).title("FIRST CAMERA").snippet("HELLO"));
//            googleMap.addMarker(new MarkerOptions()
//                            .position(new LatLng(46.841407, 8.322144))
//                            .title("Marker")
//                            .draggable(true)
//            );
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstCamera, 15));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, MENU_1, 0, "menu1");
        menu.add(0, MENU_2, 0, "Red");
        menu.add(0, MENU_3, 0, "Red");
        menu.add(0, MENU_4, 0, "Red");
        menu.add(0, MENU_5, 0, "Red");
        menu.add(0, MENU_6, 0, "Red");
        menu.add(0, MENU_7, 0, "Red");
        menu.add(0, MENU_8, 0, "Red");



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();


        return super.onOptionsItemSelected(item);
    }
}
