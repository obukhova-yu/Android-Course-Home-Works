package com.triare.p071module

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        val radio1=findViewById<RadioButton>(R.id.radio_1)
        val radio2=findViewById<RadioButton>(R.id.radio_2)

        menu?.setGroupVisible(R.id.group1,radio1.isChecked())
        menu?.setGroupVisible(R.id.group2,radio2.isChecked())

        return super.onPrepareOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val mainTitle=findViewById<TextView>(R.id.main_title)
        val mainPickture=findViewById<ImageView>(R.id.main_pickture)
        val mainDescr=findViewById<TextView>(R.id.main_description)

        when (item.itemId){
            R.id.i0410-> {
                mainTitle.setText(resources.getString(R.string.geo_0410))
                mainDescr.setText(resources.getString(R.string.descr_geo_0410))
                mainPickture.setImageResource(R.mipmap.ic_geo_0410)
            }
            R.id.i0005-> {
                mainTitle.setText(resources.getString(R.string.geo_0005))
                mainDescr.setText(resources.getString(R.string.descr_geo_0005))
                mainPickture.setImageResource(R.mipmap.ic_geo_0005)
            }
            R.id.i0291-> {
                mainTitle.setText(resources.getString(R.string.geo_0291))
                mainDescr.setText(resources.getString(R.string.descr_geo_0291))
                mainPickture.setImageResource(R.mipmap.ic_geo_0291)
            }
            R.id.i0405-> {
                mainTitle.setText(resources.getString(R.string.star_0405))
                mainDescr.setText(resources.getString(R.string.descr_star_0405))
                mainPickture.setImageResource(R.mipmap.ic_star_0405)
            }
            R.id.i0009-> {
                mainTitle.setText(resources.getString(R.string.star_0009))
                mainDescr.setText(resources.getString(R.string.descr_star_0009))
                mainPickture.setImageResource(R.mipmap.ic_star_0009)
            }
            R.id.i0033-> {
                mainTitle.setText(resources.getString(R.string.star_0033))
                mainDescr.setText(resources.getString(R.string.descr_star_0033))
                mainPickture.setImageResource(R.mipmap.ic_star_0033)
            }
            R.id.i0375-> {
                mainTitle.setText(resources.getString(R.string.mono_abs_0375))
                mainDescr.setText(resources.getString(R.string.descr_mono_abs_0375))
                mainPickture.setImageResource(R.mipmap.ic_mono_abs_0375)
            }
            R.id.i0271-> {
                mainTitle.setText(resources.getString(R.string.mono_abs_0271))
                mainDescr.setText(resources.getString(R.string.descr_mono_abs_0271))
                mainPickture.setImageResource(R.mipmap.ic_mono_abs_0271)
            }
            R.id.i0632-> {
                mainTitle.setText(resources.getString(R.string.mono_abs_0632))
                mainDescr.setText(resources.getString(R.string.descr_mono_abs_0632))
                mainPickture.setImageResource(R.mipmap.ic_mono_abs_0632)
            }
            R.id.i0122-> {
                mainTitle.setText(resources.getString(R.string.col_abs_0122))
                mainDescr.setText(resources.getString(R.string.descr_col_abs_0122))
                mainPickture.setImageResource(R.mipmap.ic_col_abs_0122)
            }
            R.id.i0136-> {
                mainTitle.setText(resources.getString(R.string.col_abs_0136))
                mainDescr.setText(resources.getString(R.string.descr_col_abs_0136))
                mainPickture.setImageResource(R.mipmap.ic_col_abs_0136)
            }
            R.id.i0166-> {
                mainTitle.setText(resources.getString(R.string.col_abs_0166))
                mainDescr.setText(resources.getString(R.string.descr_col_abs_0166))
                mainPickture.setImageResource(R.mipmap.ic_col_abs_0166)
            }
            R.id.i0153-> {
                mainTitle.setText(resources.getString(R.string.on_bb_0153))
                mainDescr.setText(resources.getString(R.string.descr_on_bb_0153))
                mainPickture.setImageResource(R.mipmap.ic_on_bb_0153)
            }
            R.id.i0157-> {
                mainTitle.setText(resources.getString(R.string.on_bb_0157))
                mainDescr.setText(resources.getString(R.string.descr_on_bb_0157))
                mainPickture.setImageResource(R.mipmap.ic_on_bb_0157)
            }
            R.id.i0161-> {
                mainTitle.setText(resources.getString(R.string.on_bb_0161))
                mainDescr.setText(resources.getString(R.string.descr_on_bb_0161))
                mainPickture.setImageResource(R.mipmap.ic_on_bb_0161)
            }
            R.id.i0435-> {
                mainTitle.setText(resources.getString(R.string.col_fill_0435))
                mainDescr.setText(resources.getString(R.string.descr_col_fill_0435))
                mainPickture.setImageResource(R.mipmap.ic_col_fill_0435)
            }
            R.id.i0438-> {
                mainTitle.setText(resources.getString(R.string.col_fill_0438))
                mainDescr.setText(resources.getString(R.string.descr_col_fill_0438))
                mainPickture.setImageResource(R.mipmap.ic_col_fill_0438)
            }
            R.id.i0429-> {
                mainTitle.setText(resources.getString(R.string.col_fill_0429))
                mainDescr.setText(resources.getString(R.string.descr_col_fill_0429))
                mainPickture.setImageResource(R.mipmap.ic_col_fill_0429)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}