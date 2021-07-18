package com.example.fuckbottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.item1->setCurrentFragment(firstFragment)
                R.id.item2->setCurrentFragment(secondFragment)
                R.id.item3->setCurrentFragment(thirdFragment)
            }
            true
        }
        bottomNavigationView.getOrCreateBadge(R.id.item2).apply {
            number = 10
            isVisible = true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}