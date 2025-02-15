package dev.sebastiano.bundel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val bundel_black = Color(0xFF000000)
private val bundel_white = Color(0xFFFFFFFF)
private val bundel_background_gray = Color(0xFFE5E5E5)
private val bundel_light_gray = Color(0xFFAAAAAA)
private val bundel_green = Color(0xFF4CE062)
private val bundel_green_dark = Color(0xFF1E8F3E)
private val bundel_purple = Color(0xFF4F1D91)
private val bundel_purple_dark = Color(0xFF3C166D)
private val bundel_dark_background_gray = Color(0xFF101010)
private val bundel_dark_green = Color(0xFF33783D)
private val bundel_dark_green_dark = Color(0xFF224D28)
private val bundel_dark_purple = Color(0xFF33135D)
private val bundel_dark_purple_dark = Color(0xFF240E42)

internal val bundelLightColors = lightColors(
    primary = bundel_green,
    secondary = bundel_purple,
    surface = bundel_white,
    onSurface = bundel_black,
    primaryVariant = bundel_green_dark,
    background = bundel_background_gray
)

internal val bundelDarkColors = darkColors(
    primary = bundel_dark_green,
    secondary = bundel_dark_purple,
    surface = bundel_black,
    onSurface = bundel_light_gray,
    primaryVariant = bundel_dark_green_dark,
    background = bundel_dark_background_gray
)

internal val bundelOnboardingLightColors = lightColors(
    primary = bundel_purple,
    onPrimary = bundel_white,
    secondary = bundel_white,
    onSecondary = bundel_black,
    surface = bundel_green,
    onSurface = bundel_white,
    primaryVariant = bundel_purple_dark,
    background = bundel_green,
    onBackground = bundel_white
)

internal val bundelOnboardingDarkColors = darkColors(
    primary = bundel_dark_purple,
    onPrimary = bundel_light_gray,
    secondary = bundel_dark_purple,
    onSecondary = bundel_light_gray,
    surface = bundel_dark_green_dark,
    onSurface = bundel_light_gray,
    primaryVariant = bundel_dark_purple_dark,
    background = bundel_dark_green_dark,
    onBackground = bundel_light_gray
)

private val podkovaBold = Font(R.font.podkova_bold, weight = FontWeight.Bold)
private val podkovaExtraBold = Font(R.font.podkova_extrabold, weight = FontWeight.ExtraBold)
private val podkovaMedium = Font(R.font.podkova_medium, weight = FontWeight.Medium)
private val podkovaRegular = Font(R.font.podkova_regular, weight = FontWeight.Normal)
private val podkovaSemiBold = Font(R.font.podkova_semibold, weight = FontWeight.SemiBold)

private val podkova = FontFamily(
    listOf(
        podkovaBold,
        podkovaExtraBold,
        podkovaMedium,
        podkovaRegular,
        podkovaSemiBold
    )
)

private val interBold = Font(R.font.inter_bold, weight = FontWeight.Bold)
private val interMedium = Font(R.font.inter_medium, weight = FontWeight.Medium)
private val interRegular = Font(R.font.inter_regular, weight = FontWeight.Normal)

private val inter = FontFamily(
    listOf(
        interBold,
        interMedium,
        interRegular,
    )
)

private val bundelTypography = Typography(
    h1 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp
    ),
    h2 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 60.sp
    ),
    h3 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp
    ),
    h4 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = podkova,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

@Composable
internal fun BundelTheme(
    darkModeOverride: Boolean? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(bundelColors(darkModeOverride), bundelTypography) {
        content()
    }
}

@Composable
internal fun BundelOnboardingTheme(
    darkModeOverride: Boolean? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(bundelOnboardingColors(darkModeOverride), bundelTypography) {
        content()
    }
}

@Composable
internal fun bundelColors(darkModeOverride: Boolean? = null): Colors =
    getBundelColors(darkModeOverride ?: isSystemInDarkTheme())

@Composable
internal fun bundelOnboardingColors(darkModeOverride: Boolean? = null): Colors =
    getBundelOnboardingColors(darkModeOverride ?: isSystemInDarkTheme())

internal fun getBundelColors(darkMode: Boolean = false): Colors =
    if (darkMode) bundelDarkColors else bundelLightColors

internal fun getBundelOnboardingColors(darkMode: Boolean = false): Colors =
    if (darkMode) bundelOnboardingDarkColors else bundelOnboardingLightColors

@Composable
internal fun iconSize() = 48.dp

@Composable
internal fun singlePadding() = 8.dp
