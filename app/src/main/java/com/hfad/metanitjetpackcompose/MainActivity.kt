package com.hfad.metanitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.metanitjetpackcompose.ui.theme.MetanitJetpackComposeTheme

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
        Language("Python", 0xffd35400)
    )

    Column {
        for(lang in languages) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(lang.hexColor))
                )
                Text(
                    text = lang.name,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MetanitJetpackComposeTheme {
        ListLanguages()
    }
}

data class Language(val name: String, val hexColor: Long)