package com.example.classwork3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recycleViewInit()


    }
    private fun recycleViewInit(){
        adapter = Adapter()
        adapter.setData(listOf(
            ItemData("Edit Profile", R.drawable.ic_baseline_perm_identity_24, R.drawable.ic_baseline_navigate_next_24),
            ItemData("Address", R.drawable.ic_baseline_location_24),
            ItemData("Notification", R.drawable.ic_baseline_notifications_none_24),
            ItemData("Payment", R.drawable.ic_baseline_payments_24),
            ItemData("Security", R.drawable.ic_baseline_security_24),
            ItemData("Language", R.drawable.ic_baseline_language_24, layoutType = 2, secondText = "English(US)"),
            ItemData("Dark mode", R.drawable.ic_baseline_dark_mode_24, R.drawable.ic_baseline_toggle_on_24),
            ItemData("Privacy policy", R.drawable.ic_baseline_lock_24),
            ItemData("Help center", R.drawable.ic_baseline_help_24),
            ItemData("Invite friends", R.drawable.ic_baseline_people_outline_24),
            ItemData("Log out", R.drawable.ic_baseline_logout_24, R.color.black, resources.getColor(R.color.red))

            ))
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}