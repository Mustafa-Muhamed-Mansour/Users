package com.app

import HomeViewModel
import UserModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
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
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.app.screens.DetailScreen
import com.app.screens.HomeScreen
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import users.composeapp.generated.resources.Res
import users.composeapp.generated.resources.loading

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            Navigator(screen = HomeScreen)
        }
    }
}

@Composable
fun AppContent(
    homeViewModel: HomeViewModel
) {

    val resultList = homeViewModel.listUsers.value
    homeViewModel.fetchUsers()

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataUsers(homeViewModel: HomeViewModel) {
    val scrollState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        columns = GridCells.Fixed(count = 2),
        state = scrollState
    ) {
        item(span = { GridItemSpan(currentLineSpan = 2) }) {
            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = "",
                active = false,
                onQueryChange = {},
                onActiveChange = {},
                onSearch = {},
                placeholder = {
                    androidx.compose.material3.Text(
                        text = "Search User",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "icon search"
                    )
                }) {
                Spacer(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        top = 10.dp,
                        end = 15.dp,
                        bottom = 20.dp
                    )
                )
            }
        }
        homeViewModel.listUsers?.value?.data?.let {
            items(it) { users ->
                UsersCard(users = users)
            }
        }
    }
}

@Composable
fun UsersCard(users: UserModel) {
    ItemUserOfCard(user = users)
}

@Composable
fun ItemUserOfCard(user: UserModel) {

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