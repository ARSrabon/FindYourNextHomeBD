package comsiteprojectcyborn.google.sites.findyournexthome.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import comsiteprojectcyborn.google.sites.findyournexthome.R;

public class DefaultView_Activity extends AppCompatActivity implements Drawer.OnDrawerItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_view_);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        AccountHeader headerResult = new AccountHeaderBuilder()
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

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(myToolbar)
                .withAccountHeader(headerResult)
                .inflateMenu(R.menu.drawer_menu)
                .build();

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
        }
        return false;
    }
}
