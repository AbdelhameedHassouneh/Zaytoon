package com.example.avocadoandroid
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProviders
import com.example.avocadoandroid.fragments.CalculateFragment
import com.example.avocadoandroid.fragments.EditFragment
import com.example.avocadoandroid.fragments.ZaytoonFragment
import com.example.avocadoandroid.models.UserSharedViewModel
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewModel: UserSharedViewModel
    private lateinit var drawer:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AvocadoAndroid)
        setContentView(R.layout.activity_drawer)
        viewModel = ViewModelProviders.of(this)[UserSharedViewModel::class.java]

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener (this)

        drawer = findViewById(R.id.drawer_layout)
        val toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportFragmentManager.commit {
            replace<ZaytoonFragment>(R.id.fragment_container)
        }
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.edit_profile_item){
            supportFragmentManager.commit {
                replace<EditFragment>(R.id.fragment_container)
            }
        }else if(item.itemId == R.id.needs_item){
            supportFragmentManager.commit {
                replace<CalculateFragment>(R.id.fragment_container)
            }
        }else if(item.itemId == R.id.zaytoon_item){
            supportFragmentManager.commit {
                replace<ZaytoonFragment>(R.id.fragment_container)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}