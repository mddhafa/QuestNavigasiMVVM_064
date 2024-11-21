package com.example.simpleviewmodel.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listGender: List<String>,
    onSubmitClick: (MutableList<String>) -> Unit


) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(
        nama, email, noTelpon, alamat, gender
    )

    Column(
        modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(12.dp))
        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama Anda") }
        )

        Row {
            listGender.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = gender == item,
                    onClick = {
                        gender = item
                    }
                )
                    Text(item) }
            }
        }

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("E-Mail") },
            placeholder = { Text("Masukkan E-Mail Anda") }
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("No Telp") },
            placeholder = { Text("Masukkan No Telpon Anda") }
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat Anda") }
        )

        Button (onClick = {
            onSubmitClick(listData)
        }) {
            Text("Submit")
        }

        }
    }



