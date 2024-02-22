package br.com.fiap.minhaidade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {                              //o MainActivity é a declaração da tela, é onde as funções e interface será rodada
    override fun onCreate(savedInstanceState: Bundle?) {                //onCreate
        super.onCreate(savedInstanceState)
        setContent {                                                    //define qual o conteúdo da tela
            MinhaIdadeTheme {                                           //define a parte visual, dimensões, cores etc
                // A surface container using the 'background' color from the theme
                Surface(                                                //Surface = guarda componentes em si, estiliza outros componentes
                    modifier = Modifier.fillMaxSize(),                  //Modifier modifica comportamento ou visual
                    color = MaterialTheme.colorScheme.background        //ex: o Surface modifica o color, setando como uma cor padrão para o plano de fundo
                ) {
                    MeuComponente()                                     //chamando os componentes para o SetContent e Surface rodar
                }
            }
        }
    }
}

@Composable                                                             //composable =
fun MeuComponente() {

    var idade = 0

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text(
            text = "Qual a sua idade?",
            color = Color.Magenta,
            fontSize = 25.sp,                                            //sp = fonte escalável, onde o usuário pode mudar o tamanho da fonte
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Pressione os botões para informar sua idade!",      //função Text que imprime textos na tela
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(42.dp))
        Text(
            text = "$idade",
            fontSize = 40.sp,
            color = Color.Magenta,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(42.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()) {                                            //Row = alinha os componentes em linhas horizontais
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(74.dp),
                shape = RoundedCornerShape(9.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {     //Button = cria um botão na tela, onClick = função que o botão irá exercer
                Text(text = "-",
                    fontSize = 19.sp,)                                                                          //0xFF88c6a5 = cor hexadecimal
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = {
                             idade++
                Log.i("FIAP", "MeuComponente: $idade")
            },
                modifier = Modifier.size(74.dp),
                shape = RoundedCornerShape(9.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
                Text(text = "+",
                    fontSize = 19.sp,)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeuComponentePreview() {                                            //prévia do visual da nossa tela
    MeuComponente()
}
