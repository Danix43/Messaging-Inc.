package com.danix43.messagingapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.danix43.messagingapp.R

val Baloo2 = FontFamily(
    Font(R.font.baloo)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Baloo2,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    body1 = TextStyle(
        fontFamily = Baloo2,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
//        (
//        displayLarge = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 57.sp,
//            lineHeight = 64.sp,
//            letterSpacing = -0.25.sp,
//        ),
//        displayMedium = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 45.sp,
//            lineHeight = 52.sp,
//            letterSpacing = 0.sp,
//        ),
//        displaySmall = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 36.sp,
//            lineHeight = 44.sp,
//            letterSpacing = 0.sp,
//        ),
//        headlineLarge = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 32.sp,
//            lineHeight = 40.sp,
//            letterSpacing = 0.sp,
//        ),
//        headlineMedium = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 28.sp,
//            lineHeight = 36.sp,
//            letterSpacing = 0.sp,
//        ),
//        headlineSmall = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 24.sp,
//            lineHeight = 32.sp,
//            letterSpacing = 0.sp,
//        ),
//        titleLarge = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 22.sp,
//            lineHeight = 28.sp,
//            letterSpacing = 0.sp,
//        ),
//        titleMedium = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.Medium,
//            fontSize = 16.sp,
//            lineHeight = 24.sp,
//            letterSpacing = 0.1.sp,
//        ),
//        titleSmall = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.Medium,
//            fontSize = 14.sp,
//            lineHeight = 20.sp,
//            letterSpacing = 0.1.sp,
//        ),
//        labelLarge = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.Medium,
//            fontSize = 14.sp,
//            lineHeight = 20.sp,
//            letterSpacing = 0.1.sp,
//        ),
//        bodyLarge = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 16.sp,
//            lineHeight = 24.sp,
//            letterSpacing = 0.5.sp,
//        ),
//        bodyMedium = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 14.sp,
//            lineHeight = 20.sp,
//            letterSpacing = 0.25.sp,
//        ),
//        bodySmall = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.W400,
//            fontSize = 12.sp,
//            lineHeight = 16.sp,
//            letterSpacing = 0.4.sp,
//        ),
//        labelMedium = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.Medium,
//            fontSize = 12.sp,
//            lineHeight = 16.sp,
//            letterSpacing = 0.5.sp,
//        ),
//        labelSmall = TextStyle(
//            fontFamily = Roboto,
//            fontWeight = FontWeight.Medium,
//            fontSize = 11.sp,
//            lineHeight = 16.sp,
//            letterSpacing = 0.5.sp,
//        ),
//    )


/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/