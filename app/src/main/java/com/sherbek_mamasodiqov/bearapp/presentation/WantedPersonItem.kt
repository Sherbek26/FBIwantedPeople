package com.sherbek_mamasodiqov.bearapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sherbek_mamasodiqov.bearapp.domain.WantedPerson
import com.sherbek_mamasodiqov.bearapp.ui.theme.BearAppTheme

@Composable
fun WantedPersonItem(
    wantedPerson: WantedPerson,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(model = wantedPerson.imageUrl,
                contentDescription = wantedPerson.title,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
                )
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .weight(3f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = wantedPerson.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                    )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${wantedPerson.ageRange} - ${wantedPerson.gender}",
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = wantedPerson.details,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 5
                )
            }
        }
    }
}

@Preview
@Composable
fun WantedPersonItemPreview(){
    BearAppTheme {
        WantedPersonItem(wantedPerson = WantedPerson(
            id = 1,
            title = "JESUS DE LA CRUZ - LYNN, MASSACHUSETTS",
            ageRange = "6 years old (at time of disappearance)",
            details = "Jesus de la Cruz was last seen on September 28, 1996, walking on Park Street near his residence in Lynn, Massachusetts. He was six years old at the time of his disappearance and has not been seen since. De la Cruz has a scar above his left eye, birthmarks on his left calf and the left side of his forehead, and his left ear is pierced. He was last seen wearing a white t-shirt, blue jeans, and brown and yellow boots.",
            gender = "Male",
            imageUrl = null
        )
        )
    }
}