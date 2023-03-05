package com.example.acomponentsco.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.acomponentsco.ACompApplication

import com.example.acomponentsco.Screens
import com.example.acomponentsco.contentProvider.FileManager
import com.example.acomponentsco.contentProvider.OpenFileDialog
import com.example.acomponentsco.databinding.FragmentStartBinding
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

private const val PERMISSION_READ_CONTACTS_CODE = 2
private const val PERMISSION_READ_EXT_FILES_CODE = 3

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnContacts.setOnClickListener {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_CONTACTS
                    ),
                    PERMISSION_READ_CONTACTS_CODE
                )
            }
            btnMusic.setOnClickListener {

                    requestPermissions(
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        ),
                        PERMISSION_READ_EXT_FILES_CODE
                    )

            }
            btnVacant.setOnClickListener {
                val fileManager=FileManager()
                fileManager.getMusicUri()
               /* val context:Context=activity.

                val fileDialog=OpenFileDialog(activity)
*/

            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_READ_CONTACTS_CODE -> {
                val permIndex = permissions.indexOf(Manifest.permission.READ_CONTACTS)
                if (permIndex != -1) {
                    if (grantResults[permIndex] == PackageManager.PERMISSION_GRANTED) {
                        ACompApplication.INSTANCE.router.navigateTo(Screens.Contacts())
                    } else {
                        Toast.makeText(activity, "Разрешите доступ к контактам", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            PERMISSION_READ_EXT_FILES_CODE->{
                val permIndex = permissions.indexOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                if (permIndex != -1) {
                    if (grantResults[permIndex] == PackageManager.PERMISSION_GRANTED) {
                        ACompApplication.INSTANCE.router.navigateTo(Screens.Music())
                    } else {
                        Toast.makeText(activity, "Разрешите доступ к карте", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    private fun startFragmentWithPermission(
        myPermissionCode:String,
        appPermissionCode:String,
        startingFragment: () -> FragmentScreen,
        toastText:String
        ){

    }


}