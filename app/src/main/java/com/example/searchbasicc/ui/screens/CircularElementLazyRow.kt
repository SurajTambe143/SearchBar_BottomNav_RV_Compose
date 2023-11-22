package com.example.searchbasicc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.searchbasicc.DummyData

@Composable
fun CircularElementRow(list: List<DummyData>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(0.dp, 5.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(list) { item ->
            CircularElement(item.drawable, item.txt)
        }
    }
}


@Composable
fun CircularElement(
    drawable: Int = 0,
    text: String = "",
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(drawable),
            modifier = Modifier
                .clip(CircleShape)
                .size(88.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            text = text,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}