package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityNavBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityParentsNavBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentParentsNavBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.ChooseUserActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.AccountFragment
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.HomeFragment

class ParentsNavActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityParentsNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParentsNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        setSupportActionBar(binding.toolbar)

        val navigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ParentsNavFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        if (savedInstanceState == null) {
            replaceFragment(ParentsNavFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_home -> replaceFragment(ParentsNavFragment())
            R.id.nav_account -> replaceFragment(AccountFragment())
            R.id.nav_logout -> {
                startActivity(Intent(this, ChooseUserActivity::class.java))
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
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