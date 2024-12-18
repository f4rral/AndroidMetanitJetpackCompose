package com.hfad.metanitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListLanguages()
        }
    }
}

@Composable
fun ListLanguages() {
    val languages = listOf(
        Language("Kotlin", 0xff16a085),
        Language("Java", 0xff2980b9),
        Language("JavaScript", 0xffe74c3c),
        Language("Python", 0xffd35400),
        Language("C++", 0xffa569bd),
        Language("C#", 0xff21618c),
        Language("PHP", 0xff2c3e50),
        Language("TypeScript", 0xffa93226),
        Language("Ruby ", 0xff839192),
        Language("Go ", 0xffd4ac0d),
        Language("Swift", 0xff273746)
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().weight(1f)
        ) {
            items(items = languages) { ColumnLanguage(it) }
        }

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize().weight(1f)
        ) {
            items(items = languages) {
                RowLanguage(it)
            }
        }
    }
}

@Composable
fun ColumnLanguage(lang: Language) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color(lang.hexColor))
        )
        Text(
            text = lang.name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}

@Composable
fun RowLanguage(lang: Language) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color(lang.hexColor))
        )
        Text(
            text = lang.name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    ListLanguages()
}

data class Language(val name: String, val hexColor: Long)