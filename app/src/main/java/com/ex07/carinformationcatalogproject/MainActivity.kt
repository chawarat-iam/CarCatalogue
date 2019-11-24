package com.ex07.carinformationcatalogproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //var path:String = bundle.buttonClicked

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        SUVB.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "BMWSuvProfile")
            startActivity(intent)
        }

        SEDANB.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "BMWSedanProfile")
            startActivity(intent)
        }

        COUPEB.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "BMWCoupeProfile")
            startActivity(intent)
        }
        SUVM.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "MercedesSuvProfile")
            startActivity(intent)
        }

        SEDANM.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "MercedesSedanProfile")
            startActivity(intent)
        }

        COUPEM.setOnClickListener {
            val intent = Intent(this, CarList::class.java)
            intent.putExtra("buttonClicked", "MercedesCoupeProfile")
            startActivity(intent)
        }



    }
}
