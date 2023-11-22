package com.example.searchbasicc

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.searchbasicc.ui.screens.BottomNavigation
import com.example.searchbasicc.ui.screens.CircularElementRow
import com.example.searchbasicc.ui.screens.FavoriteCollectionRow
import com.example.searchbasicc.ui.screens.SearchBar
import com.example.searchbasicc.ui.theme.SearchBasicCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchBasicCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val list = mutableListOf<DummyData>()

                    list.add(DummyData(R.drawable.dummy, "Test 1"))
                    list.add(DummyData(R.drawable.dummy2, "Test 2"))
                    list.add(DummyData(R.drawable.dummy3, "Test 3"))
                    list.add(DummyData(R.drawable.dummy4, "Test 4"))
                    list.add(DummyData(R.drawable.dummy5, "Test 5"))

                    Scaffold(
                        bottomBar = { BottomNavigation(modifier = Modifier) }
                    ) { padding ->
                        HomeScreen(modifier = Modifier.padding(padding), list)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SearchBasicCTheme {
//        Greeting("Android")
//        SearchBar()
//        CircularElement(text = R.string.ab1_inversions,
//            drawable = R.drawable.dummy,
//            modifier = Modifier.padding(8.dp))

//        FavoriteCollectionCard(
//            text = R.string.fc2_nature_meditations,
//            drawable = R.drawable.dummy,
//            modifier = Modifier.padding(8.dp)
//        )

        val list = mutableListOf<DummyData>()

        list.add(DummyData(R.drawable.dummy, "Test 1"))
        list.add(DummyData(R.drawable.dummy2, "Test 2"))
        list.add(DummyData(R.drawable.dummy3, "Test 3"))
        list.add(DummyData(R.drawable.dummy4, "Test 4"))
        list.add(DummyData(R.drawable.dummy5, "Test 5"))

//        CircularElementRow(list = list)
//        FavoriteCollectionRow(list = list)
//        HomeScreen(modifier = Modifier,list)

        Scaffold(
            bottomBar = { BottomNavigation(modifier = Modifier) }
        ) { padding ->
            HomeScreen(modifier = Modifier.padding(padding), list)
        }

    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(modifier: Modifier, list: List<DummyData>) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar()
        HomeSection(title = "Align your body") {
            CircularElementRow(list = list)
        }
        HomeSection(title = "Favourite Collections") {
            FavoriteCollectionRow(list = list)
        }
        Spacer(Modifier.height(16.dp))
    }
}


data class DummyData(val drawable: Int, val txt: String)
