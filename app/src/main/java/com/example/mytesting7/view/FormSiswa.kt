package com.example.mytesting7.view.uicontroller

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytesting7.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                OutlinedTextField(
                    value = txtNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(top = 20.dp),
                    label = { Text(text = "Nama Lengkap") },
                    onValueChange = { txtNama = it }
                )

                HorizontalDivider(
                    modifier = Modifier
                        .padding(12.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
                )

                Row {
                    pilihanJK.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = txtGender == item,
                                onClick = { txtGender = item }
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = txtGender == item,
                                onClick = { txtGender = item }
                            )
                            Text(item)
                        }
                    }
                }

                HorizontalDivider(
                    modifier = Modifier
                        .padding(5.dp)
                        .width(250.dp),
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    color = Color.Blue
                )

                OutlinedTextField(
                    value = txtAlamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(250.dp),
                    label = { Text(text = "Alamat Lengkap") },
                    onValueChange = { txtAlamat = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = txtAlamat.isNotEmpty() && txtNama.isNotEmpty() && txtGender.isNotEmpty(),
                    onClick = {
                        listData[0] = txtNama
                        listData[1] = txtGender
                        listData[2] = txtAlamat
                        onSubmitButtonClicked(listData)
                    }
                ) {
                    Text(stringResource(R.string.submit))
                }
            }
        }
    }
}
//selesai fix formsiswa tambahan