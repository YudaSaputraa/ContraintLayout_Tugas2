package com.example.layoutingexample

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layoutingexample.databinding.ActivityMainBinding
import com.example.layoutingexample.model.Catalog
import com.example.layoutingexample.model.Category

// LayoutInflater system

//class MainActivity : AppCompatActivity() {
//
//    private val ivProfile: ImageView by lazy {
//        findViewById(R.id.iv_profile)
//    }
//    private val tvName: TextView by lazy {
//        findViewById(R.id.tv_name)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        setAction()
//        changeProfileIcon()
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//    }
//
//    private fun changeProfileIcon() {
//        ivProfile.setImageResource(R.drawable.img_cat)
//    }
//
//    private fun setAction() {
//        ivProfile.setOnClickListener {
//            Toast.makeText(this, "testing", Toast.LENGTH_SHORT).show()
//        }
//        tvName.text = "Hallo Yuda!"
//    }
//
//
//}


// viewBinding
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = CategoryAdapter()
    private val catalogAdapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListCatalog()
//        changeProfileIcon()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun setListCatalog() {
        val catalogData = listOf(
            Catalog(image = R.drawable.img_fruit, name = "Pisang", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Semangka", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Apel", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Mangga", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Durian", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Alpukat", price = 15000.0),
            Catalog(image = R.drawable.img_fruit, name = "Anggur", price = 15000.0),
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.catalogAdapter
        }
        catalogAdapter.submitData(catalogData)
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_cat, name = "Cat"),
            Category(image = R.drawable.img_cat, name = "Cat"),
            Category(image = R.drawable.img_cat, name = "Cat"),
            Category(image = R.drawable.img_cat, name = "Cat"),
            Category(image = R.drawable.img_cat, name = "Cat"),
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

//    private fun changeProfileIcon() {
//        //  ivProfile.setImageResource(R.drawable.img_cat)
//        binding.layoutHeader.ivProfile.setImageResource(R.drawable.img_cat)
//    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this, "testing", Toast.LENGTH_SHORT).show()
        }
            binding.layoutHeader.tvName.text = "Hallo Yuda!"
        }

    }