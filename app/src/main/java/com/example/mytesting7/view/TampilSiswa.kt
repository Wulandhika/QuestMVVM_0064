package com.example.mytesting7.view.uicontroller

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mytesting7.R
import com.example.mytesting7.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), statusUiSiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUiSiswa.gender),
        Pair(stringResource(id = R.string.alamat), statusUiSiswa.alamat)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.detail), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase(), fontSize = 16.sp)
                        Text(text = item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    HorizontalDivider(thickness = dimensionResource(R.dimen.thickness_divider))
                }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    Text(stringResource(R.string.back))
                }
            }
        }
    }
}