package com.example.ecologic.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecologic.R

data class UserData(
    val username: String,
    val points: Int,
    val ownedImages: List<Int>


) {
    companion object {

        // Create a storage reference from our app
        fun getPlaceholderUserData(): UserData {
            return UserData(
                username = "Sample User",
                points = 600,
                ownedImages = listOf(
                    R.drawable.c1,
                    R.drawable.c2,
                    R.drawable.c3,
                    R.drawable.c4,
                    R.drawable.c5,
                    R.drawable.c6,
                    R.drawable.c7,
                    R.drawable.c8,
                    R.drawable.c9,
                    R.drawable.d1,
                    R.drawable.d2,
                    R.drawable.d3,
                    R.drawable.d4,
                    R.drawable.d5,
                    R.drawable.d6,
                    R.drawable.d7,
                    R.drawable.d8,
                    R.drawable.d9,
                    R.drawable.f1,
                    R.drawable.f2,
                    R.drawable.f3,
                    R.drawable.f4,
                    R.drawable.f5,
                    R.drawable.f6,
                    R.drawable.f7,
                    R.drawable.f8,
                    R.drawable.f9


                )
            )
        }
    }
}

@Composable
fun ProfilePage(
    onNavigateToRoute: () -> Unit,
    modifier: Modifier.Companion = Modifier) {
    val userData = UserData.getPlaceholderUserData() // Using placeholder user data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .fillMaxWidth()
    ) {
        TopAppBar(
            title = { Text(text = "Hi! User") },
            modifier = Modifier.fillMaxWidth().background(Color.White)
        )

        TopAppBar(
            contentColor = Color.Black,
            elevation = 7.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Points: ${userData.points}",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Visible,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(24.dp))
            }
        }
        // End of your existing DestinationBar implementation

        // Show user points
        Text(
            text = "Here are your cute nfts" ,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        // Show owned images or any other user data
        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .horizontalScroll(ScrollState(0), true, null, true)
        ) {
            items(userData.ownedImages) { image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .width(300.dp)
                        .padding(10.dp)
,
                    contentScale = ContentScale.Fit
                )
            }

            // Add other user data components here as needed
        }

        // Logout button
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
        ProfilePage(onNavigateToRoute = { })
}
