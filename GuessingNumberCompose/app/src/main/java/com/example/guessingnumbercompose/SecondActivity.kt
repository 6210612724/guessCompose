package com.example.guessingnumbercompose
import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guessingnumbercompose.ui.theme.ui.theme.GuessingNumberComposeTheme


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessingNumberComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    result()
                }
            }
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun result() {
        var intro = "Correct"
        var scaffoldState = rememberScaffoldState()

        val data = intent.extras
        val setTime = data!!.getString("times")
        val mainIntent = Intent(this, MainActivity::class.java)
        //val setTime: String = intent.getStringExtra("times").toString()


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = intro,
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(50.dp)
                )

                Text(
                    text = "try $setTime",
                    fontSize = 20.sp,

                    )

                Button(onClick = {
                    startActivity(mainIntent)

                }) {
                    Text("Play again")
                }



            }
        }
    }
}



