package com.app.composables

import UserModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.app.screens.DetailScreen
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import users.composeapp.generated.resources.Res
import users.composeapp.generated.resources.loading

@Composable
fun ItemUserOfCard(
    user: UserModel
) {

    val navigator = LocalNavigator.currentOrThrow
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .clickable {
                navigator.push(DetailScreen(user))
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                val painter = rememberImagePainter(
                    url = user.image,
                    placeholderPainter = { painterResource(Res.drawable.loading) },
                    errorPainter = { painterResource(Res.drawable.loading) })
                Image(
                    painter = painter,
                    contentDescription = "user image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)).padding(all = 5.dp)
                )
                Column(
                    modifier = Modifier.padding(all = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    androidx.compose.material3.Text(
                        text = "${user.firstName} ${user.maidenName} ${user.lastName}",
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = user.email,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}