package com.vitorota.materialcomponents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation_view.*
import kotlin.concurrent.fixedRateTimer

/**
 * @author Vitor Ota
 * @since 25/06/2019
 */
class BottomNavigationViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_view)

        setupNavigationView()
    }

    private fun setupNavigationView() {

        bottomNavigationView.showBadge(R.id.menu_music)
        bottomNavigationView.showBadge(R.id.menu_favorites).apply {
            number = 1
        }

        fixedRateTimer(initialDelay = 2000, period = 4000) {
            bottomNavigationView.getBadge(R.id.menu_favorites)?.apply {
                number += 1
            }
        }


        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigate(it.title)
            when (it.itemId) {
                R.id.menu_music -> bottomNavigationView.removeBadge(it.itemId)
                R.id.menu_favorites -> bottomNavigationView.getBadge(it.itemId)?.apply {
                    number -= 1
                    if (number == 0) {
                        clearBadgeNumber()
                    }
                }
            }
            true
        }

        var firstLoad = true

        bottomNavigationView.setOnNavigationItemReselectedListener {
            if (firstLoad) {
                navigate(it.title)
                firstLoad = false
            }
            //only do something
            //else do nothing, since the item is alread selected
        }

        //to appropriate handle
        bottomNavigationView.selectedItemId = bottomNavigationView.selectedItemId
    }

    private fun navigate(title: CharSequence) {
        textView.text = title
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, BottomNavigationViewActivity::class.java)
            context.startActivity(intent)
        }
    }
}
