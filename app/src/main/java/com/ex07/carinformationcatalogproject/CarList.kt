package com.ex07.carinformationcatalogproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.ex07.carinformationcatalogproject.model.Car
import com.ex07.carinformationcatalogproject.model.CarAdapter
import kotlinx.android.synthetic.main.activity_car_list.*

import com.google.firebase.database.*


class CarList : AppCompatActivity() {
    //var url = "https://egci428-ter.firebaseio.com/userProfile.json"
    lateinit var userList: MutableList<Car>
    lateinit var dataReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var ClickButton: String?
        var bundle = intent.extras


        if (bundle != null) {
            ClickButton = bundle.getString("buttonClicked")
            CarText.text = ClickButton
        }

        userList = mutableListOf()
        dataReference = FirebaseDatabase.getInstance()
            .getReference("CarData")//change to desire directory on firebase
        ///if choose benz SUV dataReferance path = "benzSuv"
        // if choose BMW Coupe dataRaference path = "BMWCoupe"

        //val intent = Intent(this,listaactivity::class.java)
        //intent.putextras("buttonClicked", "BMWSuvProfile")
        //bundle -> var path:String = bundle.buttonClicked
        //next page -> .getReference(path)


        dataReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()) {
                    //write
                    userList.clear()
                    for (i in p0.children) {
                        val message = i.getValue(Car::class.java)
                        userList.add(message!!)
                    }
                    val adapter = CarAdapter(applicationContext, R.layout.activity_car_list, userList)
                    //listview.adapter = adapter
                    //
                }
            }
        })

        // ListView.setOnItemClickListener { parent, view, position, id ->
        //write
        //  val auser = userList.get(position)
        //  displayMap(auser)
        //  }
        //   }

        //private fun displayMap(auser: User) {
        //   val intent = Intent(this, MapsActivity::class.java)
        //  intent.putExtra("selUser", auser.username)
        // intent.putExtra("selLat", auser.latitude)
        // intent.putExtra("selLon", auser.longitude)
        // startActivity(intent)
        //  }

        //override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // menuInflater.inflate(R.menu.menu_userlist, menu)
        //  return true
        //  }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.getItemId()
            if (id == android.R.id.home) {
                finish()
            }
            return super.onOptionsItemSelected(item)
        }
    }
}




