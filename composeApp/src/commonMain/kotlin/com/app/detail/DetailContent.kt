package com.app.detail

import UserModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter

@Composable
fun DetailContent(
    userModel: UserModel
) {

    val navigator = LocalNavigator.currentOrThrow

    Column {

        Image(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .clickable {
                    navigator.pop()
                },
            imageVector = Icons.Rounded.Home,
            contentDescription = "image home",
            colorFilter = ColorFilter.tint(color = Color.Black)
        )

        Box(
//            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(space = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Card(
//                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                    elevation = 10.dp,
                    contentColor = Color.White,
                ) {
                    val painter = rememberImagePainter(url = userModel.image)
                    Image(
                        painter = painter,
                        contentDescription = "user image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp)).size(150.dp)
                            .padding(all = 5.dp)
                    )
                }
                Text(
                    text = "${userModel.firstName} ${userModel.maidenName} ${userModel.lastName}",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Gender: ${userModel.gender}",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = userModel.email,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Phone: ${userModel.phone}",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Age: ${userModel.age}",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}