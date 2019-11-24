package com.ex07.carinformationcatalogproject.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ex07.carinformationcatalogproject.R

//import kotlinx.android.synthetic.main.CarList.view.*


class CarAdapter (val mContext: Context, val layoutResId: Int, val userList: List<Car>): ArrayAdapter<Car>(mContext, layoutResId, userList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflator: LayoutInflater = LayoutInflater.from(mContext)
        val view:View = layoutInflator.inflate(layoutResId, null)
        val usrTextView = view.findViewById<TextView>(R.id.CarText)


        val usr = userList[position]

        usrTextView.text = usr.carname
        return view
    }
}