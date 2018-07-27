package com.hp.sculatask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.hp.sculatask.model.HeaderListItemsAdapter;
import com.hp.sculatask.model.HeaderListNotificationAdapter;
import com.hp.sculatask.model.ItemRecycleHeader;
import com.hp.sculatask.model.NotificationItemRecycleHeader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    FloatingActionButton fab;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageView imageViewBack;
    RecyclerView mRecyclerViewHeaderNotification;
    RecyclerView mRecyclerViewHeaderItems;
    RecyclerView mRecyclerViewHeaderItems2;
    HeaderListNotificationAdapter headerListNotificationAdapter;
    HeaderListItemsAdapter headerListItemsAdapter, headerListItemsAdapter2;
    ImageView imageViewHeader;
    ArrayList<NotificationItemRecycleHeader> headerNotificationArrayList;
    ArrayList<ItemRecycleHeader> itemRecycleHeaders;
    public static DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(toolbar);
        setLightStatusBar(toolbar, MainActivity.this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        imageViewBack = findViewById(R.id.back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(Gravity.START);
            }
        });
        imageViewHeader.setImageResource(R.drawable.imge2);
        displayHeaderNotificationList();
        displayHeaderItemsList();
        displayHeaderItemsList2();

    }

    void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        mRecyclerViewHeaderNotification = findViewById(R.id.recycle_header);
        mRecyclerViewHeaderItems = findViewById(R.id.recycle_header_items);
        mRecyclerViewHeaderItems2 = findViewById(R.id.recycle_header_items2);
        imageViewHeader = findViewById(R.id.imageView);

    }

    void displayHeaderItemsList() {
        itemRecycleHeaders = new ArrayList<>();
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_home, "Home", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_profile, "My Profile", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_events, "Events", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_favorite, "Favorite", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_inbox, "Inbox", "10"));

        headerListItemsAdapter = new HeaderListItemsAdapter(itemRecycleHeaders);
        mRecyclerViewHeaderItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewHeaderItems.setNestedScrollingEnabled(false);
        mRecyclerViewHeaderItems.setAdapter(headerListItemsAdapter);
    }

    void displayHeaderItemsList2() {
        itemRecycleHeaders = new ArrayList<>();
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_contact_us, "Contact Us", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_feed_back, "Feed back", ""));
        itemRecycleHeaders.add(new ItemRecycleHeader(R.mipmap.ic_setting, "Setting", ""));
        headerListItemsAdapter2 = new HeaderListItemsAdapter(itemRecycleHeaders);
        mRecyclerViewHeaderItems2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewHeaderItems2.setNestedScrollingEnabled(false);
        mRecyclerViewHeaderItems2.setAdapter(headerListItemsAdapter2);
    }

    void displayHeaderNotificationList() {
        headerNotificationArrayList = new ArrayList();
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("5", R.drawable.p1));
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("2", R.drawable.p3));
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("3", R.drawable.p2));
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("1", R.drawable.p4));
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("1", R.drawable.p5));
        headerNotificationArrayList.add(new NotificationItemRecycleHeader("1", R.drawable.p6));

        headerListNotificationAdapter = new HeaderListNotificationAdapter(headerNotificationArrayList);
        mRecyclerViewHeaderNotification.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewHeaderNotification.setNestedScrollingEnabled(false);
        mRecyclerViewHeaderNotification.setAdapter(headerListNotificationAdapter);

    }

    public static void setLightStatusBar(View view, Activity activity) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_contact_us) {

        } else if (id == R.id.nav_feedback) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
