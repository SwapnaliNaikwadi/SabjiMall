package com.example.a.sabjimall.View;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a.sabjimall.Adapter.CGrid;
import com.example.a.sabjimall.Adapter.ImageAdapter;
import com.example.a.sabjimall.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private static ViewPager viewPager;
    int[] IMAGES;
  //  private static final Integer[] IMAGES= {R.drawable.img1,R.drawable.img2,R.drawable.img3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    ImageView slidingimage;
    public int currentimageindex=0;
    private int[] IMAGE_IDS = {
            R.drawable.img1,  R.drawable.img2,R.drawable.img3};


    GridView grid;
    String[] vegetable_name = {"Fresh Fruits","Fresh Vegetables","Today's Offer","Best Seller"} ;
    int[] vegetable_image = {R.drawable.fruits, R.drawable.vegetables, R.drawable.fruits_veg, R.drawable.fruits_and_vegetables};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Handler mHandler=new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();

            }
        };
        int delay = 1000; // delay for 1 sec.

        int period = 2000; // repeat every 2 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        IMAGES = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        // Pass results to ViewPagerAdapter Class
       ImageAdapter adapter1 = new ImageAdapter(Main2Activity.this,IMAGES);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter1);


        CGrid adapter = new CGrid(Main2Activity.this, vegetable_name, vegetable_image);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if(vegetable_name[position].equals("Fresh Fruits")) {
                    // Toast.makeText(Main2Activity.this, "You Clicked at " + power_name[+position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewFruitsActivity.class);
                    intent.putExtra("product", vegetable_name[+position]);
                    startActivity(intent);
                }
                else if(vegetable_name[position].equals("Fresh Vegetables")) {
                    // Toast.makeText(Main2Activity.this, "You Clicked at " + power_name[+position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewVegetablesActivity.class);
                    intent.putExtra("product", vegetable_name[+position]);
                    startActivity(intent);
                }
                else  if(vegetable_name[position].equals("Today's Offer")) {
                    // Toast.makeText(Main2Activity.this, "You Clicked at " + power_name[+position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewTodaysOfferActivity.class);
                    intent.putExtra("product", vegetable_name[+position]);
                    startActivity(intent);
                }
                else  if(vegetable_name[position].equals("Best Seller")) {
                    // Toast.makeText(Main2Activity.this, "You Clicked at " + power_name[+position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ViewBestSellerActivity.class);
                    intent.putExtra("product", vegetable_name[+position]);
                    startActivity(intent);
                }
            }
        });





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);

        getMenuInflater().inflate(R.menu.search_menu,menu);
        final MenuItem searchItem=menu.findItem(R.id.search);
        {
            SearchView searchView=(SearchView) MenuItemCompat.getActionView(searchItem);
            if(searchItem!=null)
                searchView.setOnCloseListener(new SearchView.OnCloseListener()
                {
                    public  boolean onClose()
                    {
                        return true;
                    }
                });
            searchView.setOnSearchClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v)
                                                    {

                                                    }
                                                }

            );
            EditText searchPlate=(EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchPlate.setHint("Search Fresh");
            View searchPlateView=searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
            searchPlateView.setBackgroundColor(ContextCompat.getColor(this,android.R.color.transparent));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                  //  Toast.makeText(context,query, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        }



        return super.onCreateOptionsMenu(menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_fruits) {
            intent=new Intent(getApplicationContext(),ViewFruitsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_vegetables) {
            intent=new Intent(getApplicationContext(),ViewVegetablesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_offer) {
            intent=new Intent(getApplicationContext(),ViewTodaysOfferActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_seller) {
            intent=new Intent(getApplicationContext(),ViewBestSellerActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cart) {

        }
        else if(id==R.id.nav_share)
        {
            String shareBody = "https://play.google.com/store/apps/details?id=com.example.a.sabjimall";

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Fal Sabji Mall (Open it in Google Play Store to Download the Application)");

            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void AnimateandSlideShow() {


        slidingimage = (ImageView)findViewById(R.id.imageSwitcher);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

        currentimageindex++;

       Animation rotateimage = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);


        slidingimage.startAnimation(rotateimage);



    }

}
