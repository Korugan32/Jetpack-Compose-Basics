package com.korugan.composebasics.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.korugan.composebasics.ui.theme.ComposeBasicsTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutExample() {
        // FlowRow Bir Satırdaki öğeleri eğer boş yer varsa listeleyen eğer yok ise alt satıra aktaran layouttur.
    FlowRow(modifier = Modifier
        .padding(20.dp)
        .clip(shape = RoundedCornerShape(20.dp)),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            maxItemsInEachRow = 2 // Bir satırdaki Maksimum öğe sayısını sınırlandırır.
            ) {
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(10.dp)
            ) {
                Text(text = "Deneme")
            }
        }
    }

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ItemsWeight(){
    /* Burada Herbiri 1f ağırlığında olan 9 öğemiz var bunlar
      Yükseklik-Genişlik Açısından birbirinin aynısı 9 öğe var,
      her satır için 3f'lik bir ağırlık veriyor eğer 4. satıra 1 öğe
      eklersek bunun ağırlığı 3f olur yani satırı kaplar, eğer
      ikiye çıkartırsak ağırlıkları yarı yarıya(1.5f) olarak paylaşırlar
      kısaca her satır için belirlenmiş 3 eleman(maxItemsInEachRow = rows(3))
      her eleman içinse 1f'lik bir weight'imiz olacaktır.
      */
    val rows = 3
    val columns = 3
    FlowRow(
        modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        maxItemsInEachRow = rows
    ) {
        val itemModifier = Modifier
            .padding(4.dp)
            .height(80.dp)
            .weight(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Red)
        repeat(rows * columns+1) {
            Spacer(modifier = itemModifier)
        }
    }
}

/* FlowColumn ve FlowRow İçin Modifierlar
*
* Modifier.fillMaxColumnWidth = Sutundaki En Büyük elemanın genişliği 3 ise tüm itemlerin genişliğini 3 yapar
* Modifier.fillMaxRowHeight = Satırdaki  En Büyük elemanın yüksekliği 3 ise tüm itemlerin yüksekliğini 3 yapar
*
* eğer bu iki modifier'i de kullanmassak her item kendi yükseklik/genişliğine göre sarmalanır(boyut alır)
* */

@Preview(showBackground = true)
@Composable
fun FlowLayout() {
    ComposeBasicsTheme {
       ItemsWeight()
    }
}