package io.well.myapp

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.well.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MyAppScreen()
            }
        }
    }
}

@Composable
fun MyAppScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MyTopBar()
            MyTopBox()
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    showBackground = true,
    heightDp = 200,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun MyAppScreenPreview() {
    MyAppTheme {
        MyAppScreen()
    }
}

@Composable
fun MyTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Yellow)
        )
        Spacer(
            modifier = Modifier.width(4.dp)
        )
        Text(
            text = "Surprise",
            color = Color.Yellow,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(
            modifier = Modifier
                    .weight(1f)
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Yellow)
        )
    }
}

@Preview
@Composable
fun MyTopBarPreview() {
    MyTopBar()
}

@Composable
fun MyTopBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            AnyElement(
                size = 20.dp
            )
            Spacer(
                modifier = Modifier.width(4.dp)
            )
            Text(
                text = "Surprise",
                color = Color.Yellow,
                fontWeight = FontWeight.ExtraBold
            )
        }
        AnyElement(size = 20.dp, modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun AnyElement(size: Dp, modifier: Modifier = Modifier) {
    Spacer(
        modifier = Modifier
            .size(size)
            .background(Color.Yellow)
            .then(modifier)
    )
}

@Preview
@Composable
fun MyTopBoxPreview() {
    MyTopBox()
}