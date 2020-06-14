package com.mobilography

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.mobilography.Fragment.*
import com.mobilography.message.item.ChatActivity
import com.mobilography.util.logout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.type_toolbar.*

class Menu : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {

            R.id.nav_course -> {
                val fragmentCourse = FragmentCourse()
                openFragment(fragmentCourse)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_person -> {
                val fragmentUser = FragmentUser()
                createFragmentUser(fragmentUser)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_tour -> {
                val fragmentTour = FragmentTour()
                openFragment(fragmentTour)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_chats -> {
                startActivity(Intent(this, ChatActivity::class.java))
            }

        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item?.itemId == R.id.nav_logout){
          AlertDialog.Builder(this).apply {
                setTitle("Are you sure ?")
                setPositiveButton("Yes"){ _, _ ->

                    FirebaseAuth.getInstance().signOut()
                    logout()
                }
                setNegativeButton("Cancle"){ _, _ ->
                }
            }.create().show()
        }

        if  (item?.itemId == R.id.nav_about) {
            val fragmentAbout = FragmentAbout()
            createFragmentAbout(fragmentAbout)

        }

        if (item?.itemId == R.id.nav_helper) {
            startActivity(Intent(this, HelpActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setSupportActionBar(toolbar)


        val fragmentCourse = FragmentCourse()
        openFragment(fragmentCourse)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    fun createFragmentAbout(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentUser(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun createFragmentHelp(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}


