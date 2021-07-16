package br.com.joselaine.whatsappclone

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import br.com.joselaine.whatsappclone.databinding.ActivityMainBinding
import br.com.joselaine.whatsappclone.fragments.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import br.com.joselaine.whatsappclone.R as R


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraTamanhoTab()
        binding.tabs.setTabIconTintResource(R.drawable.selector_color_tab)
        configuraViewPager2()


    }

    private fun configuraViewPager2() {
        val tabLayout = binding.tabs
        val pager2 = binding.viewPagerTabs
        val fragmentManager = supportFragmentManager
        val fragmentAdapter = FragmentAdapter(fragmentManager, lifecycle)
        pager2.adapter = fragmentAdapter

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager2.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        pager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }

    private fun configuraTamanhoTab() {
        val layout =
            (binding.tabs.getChildAt(0) as LinearLayout).getChildAt(0) as LinearLayout
        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 0.5f
    }


}