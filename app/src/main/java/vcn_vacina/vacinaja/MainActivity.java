package vcn_vacina.vacinaja;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import vcn_vacina.vacinaja.ui.Appointment.AppointmentFragment;
import vcn_vacina.vacinaja.ui.VaccineList.VaccineList;
import vcn_vacina.vacinaja.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {
            HomeFragment home = new HomeFragment();
            fragmentTransaction.add(R.id.nav_host_fragment, home, "home");
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void makeAppointment(Long date, HomeFragment frag) {

        AppointmentFragment apt  = new AppointmentFragment(date, frag);
        replaceFragment(apt, "Appoint");
    }

    public void makeHome(){
        HomeFragment apt = (HomeFragment) fragmentManager.findFragmentByTag("home");

        if (apt == null) {
            apt = new HomeFragment();
        }
        replaceFragment(apt, "home");
    }
    public void makeVacList(){
        VaccineList apt = (VaccineList) fragmentManager.findFragmentByTag("vac");

        if (apt == null) {
            apt = new VaccineList();
        }
        replaceFragment(apt, "vac");
    }
    public void makeConsult(){
        VaccineList apt = (VaccineList) fragmentManager.findFragmentByTag("vac");

        if (apt == null) {
            apt = new VaccineList();
        }
        replaceFragment(apt, "vac");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Context contexto = getApplicationContext();
        int id = menuItem.getItemId();
        Fragment fragment;
        if(id == R.id.vaccineList){
            fragment = fragmentManager.findFragmentByTag("vac");
            if(fragment == null)
                fragment = new VaccineList();
            replaceFragment(fragment, "vac");
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
