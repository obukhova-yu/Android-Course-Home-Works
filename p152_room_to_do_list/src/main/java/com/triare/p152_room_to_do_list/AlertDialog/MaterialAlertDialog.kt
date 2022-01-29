package com.triare.p152_room_to_do_list.AlertDialog

import android.content.Context
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.triare.p152_room_to_do_list.R

class MaterialAlertDialog {

    lateinit var m_Text: String

    fun createAlertDialog(context: Context) {

        val builder =
            MaterialAlertDialogBuilder(context, R.style.ThemeOverlay_App_MaterialAlertDialog)

        builder.setTitle(R.string.alert_dialog_add_task_title)
        //.setMessage(resources.getString(R.string.alert_dialog_add_button))

        // Set up the input
        val input = EditText(context)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

            .setNegativeButton(R.string.alert_dialog_add_button) { dialog, which ->
                // Respond to negative button press

                m_Text = input.text.toString()
                Toast.makeText(context, m_Text, Toast.LENGTH_LONG).show()
            }
            .setPositiveButton(R.string.alert_dialog_cancel_button) { dialog, which ->
                // Respond to positive button press
                Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show()
            }
            .show()
    }
}