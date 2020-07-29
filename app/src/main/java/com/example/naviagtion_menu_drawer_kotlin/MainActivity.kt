package com.example.naviagtion_menu_drawer_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import fragments.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    lateinit var myProfileFragment: MyProfileFragment
    lateinit var productsFragment: ProductsFragment
    lateinit var servicesFragment: ServicesFragment
    lateinit var notificationsFragment: NotificationsFragment
    lateinit var updateProfileFragment: UpdateProfileFragment
    lateinit var logoutFragment: LogoutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        navView = findViewById(R.id.my_nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        myProfileFragment = MyProfileFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content,myProfileFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuitem: MenuItem): Boolean {
        when(menuitem.itemId){
            R.id.nav_profile ->{
                myProfileFragment = MyProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,myProfileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_products ->{
                productsFragment = ProductsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,productsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_services ->{
                servicesFragment = ServicesFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,servicesFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_notifications ->{
                notificationsFragment = NotificationsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,notificationsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_update ->{
                updateProfileFragment = UpdateProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,updateProfileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_logout ->{
                logoutFragment =LogoutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content,logoutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()


        }
    }
}