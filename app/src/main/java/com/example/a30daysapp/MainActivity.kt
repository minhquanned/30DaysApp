package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30daysapp.ui.theme._30DaysAppTheme
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp () {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(),
    )
}

@Composable
fun AffirmationList (affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(0.dp)
            .animateContentSize()
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            }

    ) {
        Card (
            modifier = modifier
        ) {
            Column {
                Text(
                    text = LocalContext.current.getString((affirmation.dayResourcesId)),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp, end = 0.dp, bottom = 0.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = LocalContext.current.getString((affirmation.contentResourcesId)),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 5.dp, end = 16.dp, bottom = 16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Image(
                    painter = painterResource(affirmation.imageResourcesId),
                    contentDescription = stringResource(affirmation.dayResourcesId),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(149.dp),
                    contentScale = ContentScale.Crop
                )
                if (expanded) {
                    Text(
                        text = LocalContext.current.getString(affirmation.descriptionResourcesId),
                        modifier = Modifier
                            .padding(16.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

            }
        }
    }

}

@Preview
@Composable
private fun AffirmationCardPreview () {
    AffirmationCard(Affirmation(R.string.day1, R.string.content_1, R.drawable.image1, R.string.description1))
}