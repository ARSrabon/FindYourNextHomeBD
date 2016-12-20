package comsiteprojectcyborn.google.sites.findyournexthome.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.List;

import comsiteprojectcyborn.google.sites.findyournexthome.R;
import comsiteprojectcyborn.google.sites.findyournexthome.adapter.RentalAdsAdapter;
import comsiteprojectcyborn.google.sites.findyournexthome.model.RentalAds;

public class DefaultView_Activity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    private RecyclerView recyclerView;

    private Drawer result;
    private AccountHeader headerResult;
    private Toolbar myToolbar;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    Spinner areaSpinner;
    Spinner categorySpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultview);

        setSharedPreferences(); // creates Sharedpref. and editor instances
        setMyToolbar(); // Toolbar Setter
        navDrawerMaker(); // NavDrawer Maker

        areaSpinner = (Spinner) findViewById(R.id.spin_area);
        categorySpinner = (Spinner) findViewById(R.id.spin_category);

        List<String> areaList = new ArrayList<>();

        areaList.add("Mirpur");
        areaList.add("Dhanmondi");
        areaList.add("Mohammadpur");
        areaList.add("Jhigatala");

        ArrayAdapter<String> areaAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,areaList);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);





        ArrayList<RentalAds> rentalAdsArrayList = new ArrayList<RentalAds>();
        rentalAdsArrayList.add(new RentalAds());
        rentalAdsArrayList.add(new RentalAds());

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
//        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        try {

            RentalAdsAdapter rentalAdsAdapter = new RentalAdsAdapter(rentalAdsArrayList,DefaultView_Activity.this);
            recyclerView.setAdapter(rentalAdsAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setSharedPreferences(){
        sharedPreferences = getSharedPreferences(String.valueOf(R.string.MyPreference),MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("loggedin",false);
        editor.commit();
    }
    public void setMyToolbar(){
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void navDrawerMaker(){
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(new ProfileDrawerItem().withName("Sign In / Sign Up")
                        .withEmail("AndroidStudio@gmail.com")
                        .withIcon(getResources().getDrawable(R.drawable.profile2)))
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Toast.makeText(DefaultView_Activity.this, "hello", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();

        Log.d("CheckPref", String.valueOf(sharedPreferences.getBoolean("loggedin",false)));

        if(sharedPreferences.getBoolean("loggedin",false)){
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(myToolbar)
                    .withAccountHeader(headerResult)
                    .inflateMenu(R.menu.drawer_menu_secondary)
                    .build();
        }else {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(myToolbar)
                    .withAccountHeader(headerResult)
                    .inflateMenu(R.menu.drawer_menu)
                    .build();
        }
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        result.setOnDrawerItemClickListener(this);
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

        Intent intent;

        switch ((int) drawerItem.getIdentifier()){
            case R.id.menu_signin : intent = new Intent(DefaultView_Activity.this,SignIn_activity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_profile : intent = new Intent(DefaultView_Activity.this,EditUserProfile.class);
                startActivity(intent);
                finish();
                break;
        }
        return false;
    }
}
