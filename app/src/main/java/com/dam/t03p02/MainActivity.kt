package com.dam.t03p02
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.t03p02.ui.theme.DataSource
import com.dam.t03p02.ui.theme.T03p02Theme
import com.dam.t03p02.ui.theme.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            T03p02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildAGrid()
                }
            }
        }
    }
}

@Composable
private fun BuildAGrid() {
    LazyVerticalGrid(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(DataSource.topics) {
                        CardTopic(
                            modifier = Modifier,
                            topic=it,
                            imagenFija = painterResource(R.drawable.ic_grain)
                        )
            }
        })
}

@Composable
private fun CardTopic(
    modifier: Modifier,
   topic: Topic,
    imagenFija:Painter

) {
    Card {
        Image(modifier=Modifier.size(50.dp),painter = painterResource(id = topic.imagen), contentDescription = null )
    }

    Column {
        Row(modifier=Modifier
            .padding(start = 70.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = topic.title))
        }
        Row (modifier=Modifier
            .padding(start = 70.dp)){
            Image(painter = imagenFija, contentDescription =null )
            Text(text = topic.modelVersion.toString())
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    T03p02Theme {
        BuildAGrid()
    }
}