package com.dam.t03p02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.t03p02.ui.theme.DataSource
import com.dam.t03p02.ui.theme.T03p02Theme

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

                }
            }
        }
    }
}

@Composable
private fun BuildAGrid() {
    LazyVerticalGrid(modifier = Modifier
        ,columns = GridCells.Fixed(2), content = {
        items(DataSource.topics) {

            Column {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Row {
                        Image(
                            modifier = Modifier.padding(
//                            horizontal = 68.dp,
//                            vertical = 68.dp
                            ), painter = painterResource(id = it.imagen), contentDescription = null
                        )
                        Text(
                            modifier = Modifier
//                            .padding(
//                                start=16.dp,
//                                bottom = 8.dp,
//                                end=16.dp,
//                                top = 8.dp
//                            )
                            , text = stringResource(id = it.title)
                        )
                    }
                    Row {
                        Image(painter = painterResource(R.drawable.ic_grain), contentDescription = null)

                    }

                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    })
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    T03p02Theme {
        BuildAGrid()
    }
}