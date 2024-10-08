package com.app.composables

import HomeViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CheckDataOfHome(
    homeViewModel: HomeViewModel
) {
    val resultList = homeViewModel.listUsers.value
    Column(
        modifier = Modifier.wrapContentSize()
    ) {
        if (resultList.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color.Black
                )
            }
        }
        if (resultList.error.isNotBlank()) {
            Text(
                text = resultList.error,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        if (resultList.data.isNotEmpty()) {
            DataUsers(homeViewModel = homeViewModel)
        }
    }

}