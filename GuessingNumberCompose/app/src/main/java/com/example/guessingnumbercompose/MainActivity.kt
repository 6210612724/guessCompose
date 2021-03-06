package com.example.guessingnumbercompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.guessingnumbercompose.ui.theme.GuessingNumberComposeTheme
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessingNumberComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    playgame()

                }
            }
        }


    }





    var time = 0
    val r = Random()
    var ran = r.nextInt(1000)

    @Preview(showBackground = true)
    @Composable
    fun playgame() {

        var hints = ""
        var intro = "I'm thinking of from 1-1000 try to gruess the number"


        var  scaffoldState = rememberScaffoldState()
        var  textFiledState by remember {
            mutableStateOf("")
        }
        if (textFiledState.isNotEmpty()) {
            var checkInput = Integer.parseInt(textFiledState.toString())

            if (checkInput < ran){
                time++
                hints= "Hints: Try higher"


            }
            if (checkInput > ran){
                time++
                hints = "Hints: Try lower"

            }

            if(checkInput == ran){
                var resultTime = time.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("times", resultTime.toString())
                startActivity(intent)
            }
        }


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {   Text(
                    text = intro,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(50.dp)
                )
                Text(
                text = hints,
                modifier = Modifier
                    .padding(start = 20.dp)
                )
                TextField(
                    value = textFiledState,
                    label = {
                        Text("guess")
                    },
                    onValueChange ={
                         textFiledState = it
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),

                 )



            }
        }




    }


    
}
