package com.vitorota.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vitorota.materialcomponents.util.toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Vitor Ota
 * @since 25/06/2019
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottomAppBar)
        //can be done individually (without setSupportActionBar), using the bottomAppBar methods/listeners
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                NavigationBottomSheetFragment().apply {
                    show(supportFragmentManager, tag)
                }
                true
            }
            else -> {
                toast("Pressed ${item.title}")
                true
            }
        }
    }
}
