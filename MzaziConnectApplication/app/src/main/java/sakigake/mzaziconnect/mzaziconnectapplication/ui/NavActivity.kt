package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityNavBinding

class NavActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityNavBinding
    private lateinit var drawerLayout: DrawerLayout
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.drawable.dots, R.drawable.dots)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AccountFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_account)
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AccountFragment()).commit()

            R.id.nav_switch -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SwitchUserFragment()).commit()
            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}




//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.MenuItem
//import android.widget.Toast
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.appcompat.widget.Toolbar
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import com.google.android.material.navigation.NavigationView
//import sakigake.mzaziconnect.mzaziconnectapplication.R
//import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityNavBinding
//
//class NavActivity : AppCompatActivity(){
//    private lateinit var binding: ActivityNavBinding
//    private lateinit var drawerLayout: DrawerLayout
//    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityNavBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
////        drawerLayout = findViewById(R.id.my_drawer_layout)
//        actionBarDrawerToggle =
//            ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav)
//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()
//
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        // Open the navigation drawer by default
//        drawerLayout.openDrawer(GravityCompat.START)
//
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }
//
//}
//        navigationView.setNavigationItemSelectedListener(this)
//        val toggle = ActionBarDrawerToggle(
//            this,
//            drawerLayout,
//            toolbar,
//            R.string.open_nav,
//            R.string.close_nav
//        )
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()


//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.nav_account -> {
//                // Handle the "Account" menu item click
//                Toast.makeText(this, "Account clicked!", Toast.LENGTH_SHORT).show()
//            }
//            R.id.nav_switch -> {
//                // Handle the "Switch" menu item click
//                Toast.makeText(this, "Switch clicked!", Toast.LENGTH_SHORT).show()
//            }
//            R.id.nav_logout -> {
//                // Handle the "Logout" menu item click
//                Toast.makeText(this, "Logout clicked!", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }





























