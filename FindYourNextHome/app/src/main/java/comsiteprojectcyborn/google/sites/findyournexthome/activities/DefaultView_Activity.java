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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
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

    FirebaseUser firebaseUser;
    FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference areadbRef;
    DatabaseReference rentsTypedbRef;
    DatabaseReference rentsdbRef;

    List<String> areas;
    List<String> rentTypeList;
    ArrayList<RentalAds> rentalAdsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defaultview);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        areadbRef = firebaseDatabase.getReference("AreasList");
        rentsTypedbRef = firebaseDatabase.getReference("RentsType");
        rentsdbRef = firebaseDatabase.getReference("RentsList");


        setSharedPreferences(); // creates Sharedpref. and editor instances
        setMyToolbar(); // Toolbar Setter
        navDrawerMaker(); // NavDrawer Maker

        areaSpinner = (Spinner) findViewById(R.id.spin_area);
        categorySpinner = (Spinner) findViewById(R.id.spin_category);

//        List<String> areaList = new ArrayList<>();
//        areaList.add(new String("Adabor"));
//        areaList.add(new String("Agargaon"));
//        areaList.add(new String("Dhanmondi"));
//        areaList.add(new String("Darus Salam"));
//        areaList.add(new String("Gulshan"));
//        areaList.add(new String("Mirpur"));
//        areaList.add(new String("Mohammadpur"));
//        areaList.add(new String("Motijheel"));
//        areaList.add(new String("New Market"));
//
//        for (String area: areaList) {
//            areadbRef.push().setValue(area);
//        }


        rentTypeList = new ArrayList<>();
        rentsTypedbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        rentTypeList.add(snapshot.getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        rentTypeList.add("Apartment");
//        rentTypeList.add("Serviced Apartment");
//        rentTypeList.add("Flat");
//        rentTypeList.add("Room/Sublet");
//        rentTypeList.add("Hostel");
//        rentTypeList.add("House");
//        for (String rentType : rentTypeList) {
//            rentsTypedbRef.push().setValue(rentType);
//        }


        areas = new ArrayList<>();
        areadbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d("Firebase", "onDataChange: ");
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        areas.add(snapshot.getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        ArrayAdapter<String> areaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areas);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);
        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DefaultView_Activity.this, "hello", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rentTypeList);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DefaultView_Activity.this, "hi", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        rentalAdsArrayList = new ArrayList<RentalAds>();
//        rentalAdsArrayList.add(new RentalAds(3, 2, 2, true, true, "Banner", "4th floor", "South", "aqs", "ff", "ff", "ff", firebaseUser.getUid(), "01012017"));
        rentalAdsArrayList.add(new RentalAds());
//
//        for(RentalAds rentalAds:rentalAdsArrayList){
//            rentsdbRef.push().setValue(rentalAds);
//        }

        rentsdbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    rentalAdsArrayList.add(snapshot.getValue(RentalAds.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
//        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        try {

            RentalAdsAdapter rentalAdsAdapter = new RentalAdsAdapter(rentalAdsArrayList, DefaultView_Activity.this);
            recyclerView.setAdapter(rentalAdsAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setSharedPreferences() {
        sharedPreferences = getSharedPreferences(String.valueOf(R.string.MyPreference), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean("loggedin", false);
        editor.commit();
    }

    public void setMyToolbar() {
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void navDrawerMaker() {

        if (firebaseUser != null) {
            headerResult = new AccountHeaderBuilder()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.header)
                    .addProfiles(new ProfileDrawerItem().withName(firebaseUser.getDisplayName())
                            .withEmail(firebaseUser.getEmail())
                            .withIcon(getResources().getDrawable(R.drawable.profile2)))
                    .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                        @Override
                        public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                            Toast.makeText(DefaultView_Activity.this, "hello", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    })
                    .build();
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(myToolbar)
                    .withAccountHeader(headerResult)
                    .inflateMenu(R.menu.drawer_menu_secondary)
                    .build();
        } else {
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

        switch ((int) drawerItem.getIdentifier()) {
            case R.id.menu_signin:
                intent = new Intent(DefaultView_Activity.this, SignIn_activity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.menu_profile:
                intent = new Intent(DefaultView_Activity.this, EditUserProfile.class);
                startActivity(intent);
                finish();
                break;

            case R.id.menu_logout:
                firebaseUser = null;
                break;

            case R.id.menu_add_rental:
                intent = new Intent(DefaultView_Activity.this, CreateRentalAd.class);
                startActivity(intent);
                finish();
        }
        return false;
    }
}
