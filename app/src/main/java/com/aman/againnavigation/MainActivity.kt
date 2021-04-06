package com.aman.againnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*


lateinit var navController: NavController
lateinit var appBarConfiguration: AppBarConfiguration

lateinit var drawerLayout: DrawerLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawerlayout)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.settingFragment,R.id.notificationFragment)
            , drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)


        bottomnavigations.setupWithNavController(navController)

        navigationview.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return  when(item.itemId){

            R.id.item_About_app ->{
                val action = MyNavDirections.actionGlobalAboutAppFragment()
                 navController.navigate(action)
                return true
            }
            else->{

                return  item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
            }
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settingsmenu,menu)
        return super.onCreateOptionsMenu(menu)

    }
}