package com.app.composables

import HomeViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataUsers(
    homeViewModel: HomeViewModel
) {
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