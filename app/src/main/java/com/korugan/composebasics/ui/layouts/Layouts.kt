package com.korugan.composebasics.ui.layouts

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.korugan.composebasics.R
import com.korugan.composebasics.ui.theme.ComposeBasicsTheme


@Composable
fun Layout() {
    Column(modifier = CModifier.columnModifier.mBackground(Color.Blue))
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.avatar_default_svgrepo_com), contentDescription = "avatar")
            Spacer(modifier = Modifier.padding(5.dp))
            Column {
                Text(text = "Albert Hellman")
                Text(text = "3 minutes ago", color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.padding(4.dp))
        ArtistImage()
    }
}

@Composable
fun ArtistImage() {
    Column(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
        Image(painter = painterResource(id = R.drawable.image), contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Layout()
    }
}

// Modifierleri Belli değerlerde saklayarak karmaşayı önleme
private object CModifier {
    val columnModifier = Modifier
        .size(300.dp)
        .padding(20.dp)
}

// Özel Modifier Seçenekleri bu Şekilde oluşturulabilir
@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.mBackground(color: Color) = padding(16.dp)
    .clip(RoundedCornerShape(8.dp))
    .background(color)