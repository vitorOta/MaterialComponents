package com.vitorota.materialcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_navigation_bottom_sheet.*

/**
 * @author Vitor Ota
 * @since 25/06/2019
 */
class NavigationBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_navigation_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottomNavigationView -> BottomNavigationViewActivity.startActivity(requireContext())
            }

            dismiss()
            true
        }
    }
}