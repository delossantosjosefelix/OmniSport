package com.example.misegundaapp

import android.app.Activity
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.example.misegundaapp.ui.theme.MiSegundaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiSegundaAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavegacion()
                }
            }
        }
    }
}


// CONTROLADOR DE NAVEGACION

@Composable
fun AppNavegacion() {
    var pantallaActual by rememberSaveable {
        mutableStateOf("inicio")
    }


    when (pantallaActual) {

        // Pantalla de bienvenida
        "inicio" -> PantallaInicio(
            onAcceder = { pantallaActual = "menu" }
        )

        // Menu principal con las 4 opciones deportivas
        "menu" -> PantallaMenu(
            onBasketball = { pantallaActual = "basketball" },
            onFutbol     = { pantallaActual = "futbol"     },
            onBaseball   = { pantallaActual = "baseball"   },
            onBoxeo      = { pantallaActual = "boxeo"      }
        )

        // Pantallas de detalle de cada deporte
        "basketball" -> PantallaBasketball(
            onVolver = { pantallaActual = "menu" }
        )
        "futbol" -> PantallaFutbol(
            onVolver = { pantallaActual = "menu" }
        )
        "baseball" -> PantallaBaseball(
            onVolver = { pantallaActual = "menu" }
        )
        "boxeo" -> PantallaBoxeo(
            onVolver = { pantallaActual = "menu" }
        )
    }
}

// PANTALLA DE INICIO

@Composable
fun PantallaInicio(onAcceder: () -> Unit) {

    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo de la aplicacion
        Image(
            painter            = painterResource(id = R.drawable.logo_omnisport),
            contentDescription = "Logo Omni Sport",
            modifier           = Modifier.size(180.dp),
            contentScale       = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Linea decorativa superior estilo periodico
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre principal de la aplicacion
        Text(
            text          = "OMNI SPORT",
            fontSize      = 36.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            textAlign     = TextAlign.Center,
            letterSpacing = 4.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Eslogan de la aplicacion
        Text(
            text       = "El mundo del deporte en tus manos",
            fontSize   = 15.sp,
            color      = colorGris,
            textAlign  = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Linea decorativa inferior estilo periodico
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Boton para acceder al menu principal
        Button(
            onClick  = onAcceder,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorNegro
            )
        ) {
            Text(
                text          = "ACCEDER",
                fontSize      = 16.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Etiqueta inferior decorativa estilo periodico
        Text(
            text          = "EDICION DEPORTIVA",
            fontSize      = 11.sp,
            color         = colorGris,
            letterSpacing = 3.sp
        )
    }
}


// MENU PRINCIPAL

@Composable
fun PantallaMenu(
    onBasketball : () -> Unit,
    onFutbol     : () -> Unit,
    onBaseball   : () -> Unit,
    onBoxeo      : () -> Unit
) {

    // Referencia a la actividad para poder cerrar la app
    val context  = LocalContext.current
    val activity = context as? Activity

    // Paleta de colores
    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter            = painterResource(id = R.drawable.logo_omnisport),
            contentDescription = "Logo Omni Sport",
            modifier           = Modifier.size(100.dp),
            contentScale       = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text          = "SECCIONES DEPORTIVAS",
            fontSize      = 22.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 2.sp,
            textAlign     = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))
        
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(32.dp))


        // CARD BASKETBALL
        CardDeporte(
            titulo   = "BASKETBALL",
            subtitulo = "NBA - Baloncesto Profesional",
            onClick  = onBasketball
        )

        Spacer(modifier = Modifier.height(16.dp))


        // CARD FUTBOL
        CardDeporte(
            titulo    = "FUTBOL",
            subtitulo = "FIFA - Futbol Internacional",
            onClick   = onFutbol
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CARD BASEBALl
        CardDeporte(
            titulo    = "BASEBALL",
            subtitulo = "MLB - Grandes Ligas",
            onClick   = onBaseball
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CARD BOXEO
        CardDeporte(
            titulo    = "BOXEO",
            subtitulo = "Boxeo Profesional Mundial",
            onClick   = onBoxeo
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Boton para cerrar la aplicacion
        Button(
            onClick  = { activity?.finish() },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorRojo
            )
        ) {
            Text(
                text          = "CERRAR APLICACION",
                fontSize      = 14.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}


//CARD DE DEPORTE:
@Composable
fun CardDeporte(
    titulo    : String,
    subtitulo : String,
    onClick   : () -> Unit
) {

    val colorNegro = Color(0xFF1A1A1A)
    val colorGris  = Color(0xFF4A4A4A)

    // Card con borde negro
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorNegro,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Button(
            onClick  = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Nombre del deporte
                Text(
                    text          = titulo,
                    fontSize      = 18.sp,
                    fontWeight    = FontWeight.Bold,
                    color         = colorNegro,
                    letterSpacing = 2.sp
                )
                // Descripcion
                Text(
                    text     = subtitulo,
                    fontSize = 12.sp,
                    color    = colorGris
                )
            }
        }
    }
}






// BASKETBALL
@Composable
fun PantallaBasketball(onVolver: () -> Unit) {

    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Titulo de la seccion
        Text(
            text          = "BASKETBALL",
            fontSize      = 28.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descripcion
        Text(
            text = "El basketball es un deporte de equipo jugado entre dos " +
                    "conjuntos de cinco jugadores. El objetivo es introducir " +
                    "el balon en el aro del equipo contrario. Nacio en 1891 " +
                    "y la NBA es su liga profesional mas importante del mundo.",
            fontSize  = 14.sp,
            color     = colorGris,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text          = "FIGURAS DESTACADAS",
            fontSize      = 13.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Card de Michael Jordan
        CardAtleta(
            nombre       = "MICHAEL JORDAN",
            nacionalidad = "Estados Unidos",
            descripcion  = "Considerado el mejor jugador de todos los tiempos. " +
                    "Gano 6 campeonatos con los Chicago Bulls.",
            stats        = listOf(
                "Puntos por partido" to "30.1",
                "Titulos NBA"        to "6",
                "MVP"                to "5"
            ),
            imagenRes    = R.drawable.img_jordan
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card de Stephen Curry
        CardAtleta(
            nombre       = "STEPHEN CURRY",
            nacionalidad = "Estados Unidos",
            descripcion  = "Revoluciono el basketball moderno con su tiro de " +
                    "tres puntos. Lider de los Golden State Warriors.",
            stats        = listOf(
                "Puntos por partido" to "24.8",
                "Titulos NBA"        to "4",
                "MVP"                to "2"
            ),
            imagenRes    = R.drawable.img_curry
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Boton para regresar al menu
        Button(
            onClick  = onVolver,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorNegro
            )
        ) {
            Text(
                text          = "VOLVER AL MENU",
                fontSize      = 14.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}

// FUTBOL
@Composable
fun PantallaFutbol(onVolver: () -> Unit) {

    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text          = "FUTBOL",
            fontSize      = 28.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "El futbol es el deporte mas popular del mundo con mas de " +
                    "4 mil millones de seguidores. Se juega entre dos equipos " +
                    "de once jugadores. La FIFA organiza el Mundial cada cuatro " +
                    "anos, el torneo mas visto en la historia.",
            fontSize  = 14.sp,
            color     = colorGris,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text          = "FIGURAS DESTACADAS",
            fontSize      = 13.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardAtleta(
            nombre       = "LIONEL MESSI",
            nacionalidad = "Argentina",
            descripcion  = "Campeon del mundo con Argentina en 2022. Gano el " +
                    "Balon de Oro un record de 8 veces en su carrera.",
            stats        = listOf(
                "Goles en carrera" to "800+",
                "Balones de Oro"   to "8",
                "Mundiales"        to "1"
            ),
            imagenRes    = R.drawable.img_messi
        )

        Spacer(modifier = Modifier.height(16.dp))

        CardAtleta(
            nombre       = "CRISTIANO RONALDO",
            nacionalidad = "Portugal",
            descripcion  = "Maximo goleador de la historia del futbol. Campeon " +
                    "de la Eurocopa y multiples ligas europeas.",
            stats        = listOf(
                "Goles en carrera" to "900+",
                "Balones de Oro"   to "5",
                "Eurocopas"        to "1"
            ),
            imagenRes    = R.drawable.img_ronaldo
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick  = onVolver,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorNegro
            )
        ) {
            Text(
                text          = "VOLVER AL MENU",
                fontSize      = 14.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}






// BASEBALL
@Composable
fun PantallaBaseball(onVolver: () -> Unit) {

    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text          = "BASEBALL",
            fontSize      = 28.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "El baseball es un deporte de equipo jugado entre dos " +
                    "conjuntos de nueve jugadores. La MLB es la liga mas " +
                    "importante del mundo. Latinoamerica es una fuente " +
                    "enorme de talento para las Grandes Ligas.",
            fontSize  = 14.sp,
            color     = colorGris,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text          = "FIGURAS DESTACADAS",
            fontSize      = 13.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardAtleta(
            nombre       = "JUAN SOTO",
            nacionalidad = "Republica Dominicana",
            descripcion  = "Uno de los bateadores mas completos de su generacion. " +
                    "Conocido por su disciplina en el plato y alto OBP.",
            stats        = listOf(
                "Promedio"   to ".285",
                "Home Runs"  to "230+",
                "OBP"        to ".420"
            ),
            imagenRes    = R.drawable.img_juansoto
        )

        Spacer(modifier = Modifier.height(16.dp))

        CardAtleta(
            nombre       = "SHOHEI OHTANI",
            nacionalidad = "Japon",
            descripcion  = "El jugador mas unico en la historia del baseball. " +
                    "Destaca tanto como pitcher elite como bateador de poder.",
            stats        = listOf(
                "Home Runs"     to "170+",
                "ERA como P."   to "3.01",
                "MVP"           to "3"
            ),
            imagenRes    = R.drawable.img_ohtani
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick  = onVolver,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorNegro
            )
        ) {
            Text(
                text          = "VOLVER AL MENU",
                fontSize      = 14.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}




// BOXEO
@Composable
fun PantallaBoxeo(onVolver: () -> Unit) {

    val colorFondo = Color(0xFFF5F0E8)
    val colorNegro = Color(0xFF1A1A1A)
    val colorRojo  = Color(0xFFC8102E)
    val colorGris  = Color(0xFF4A4A4A)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text          = "BOXEO",
            fontSize      = 28.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 3.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(3.dp)
                .background(colorRojo)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "El boxeo es un deporte de combate en el que dos " +
                    "competidores intercambian golpes con los punos. " +
                    "Es uno de los deportes mas antiguos del mundo y " +
                    "Latinoamerica ha producido algunos de los mejores " +
                    "campeones de la historia.",
            fontSize  = 14.sp,
            color     = colorGris,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text          = "FIGURAS DESTACADAS",
            fontSize      = 13.sp,
            fontWeight    = FontWeight.Bold,
            color         = colorNegro,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CardAtleta(
            nombre       = "MANNY PACQUIAO",
            nacionalidad = "Filipinas",
            descripcion  = "Unico boxeador en ganar titulos mundiales en " +
                    "ocho divisiones de peso diferentes. Leyenda viviente.",
            stats        = listOf(
                "Peleas ganadas" to "62",
                "Nocauts"        to "39",
                "Titulos"        to "8 divisiones"
            ),
            imagenRes    = R.drawable.img_pacquiao
        )

        Spacer(modifier = Modifier.height(16.dp))

        CardAtleta(
            nombre       = "CANELO ALVAREZ",
            nacionalidad = "Mexico",
            descripcion  = "El boxeador mas completo de su generacion. Campeon " +
                    "unificado en multiple categorias de peso.",
            stats        = listOf(
                "Peleas ganadas" to "61",
                "Nocauts"        to "39",
                "Titulos"        to "4 fajas"
            ),
            imagenRes    = R.drawable.img_canelo
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick  = onVolver,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape  = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorNegro
            )
        ) {
            Text(
                text          = "VOLVER AL MENU",
                fontSize      = 14.sp,
                fontWeight    = FontWeight.Bold,
                color         = Color.White,
                letterSpacing = 2.sp
            )
        }
    }
}


// CARD DE ATLETA
@Composable
fun CardAtleta(
    nombre       : String,
    nacionalidad : String,
    descripcion  : String,
    stats        : List<Pair<String, String>>,
    imagenRes    : Int
) {

    val colorNegro = Color(0xFF1A1A1A)
    val colorGris  = Color(0xFF4A4A4A)
    val colorRojo  = Color(0xFFC8102E)

    // Contenedor
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorNegro,
                shape = RoundedCornerShape(4.dp)
            )
            .background(Color.White, RoundedCornerShape(4.dp))
            .padding(16.dp)
    ) {
        Column {

            //Imagen del Atleta
            Image(
                painter            = painterResource(id = imagenRes),
                contentDescription = nombre,
                modifier           = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre del atleta
            Text(
                text          = nombre,
                fontSize      = 16.sp,
                fontWeight    = FontWeight.Bold,
                color         = colorNegro,
                letterSpacing = 1.sp
            )

            // Nacionalidad del atleta
            Text(
                text     = nacionalidad,
                fontSize = 12.sp,
                color    = colorRojo
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Linea separadora
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFBDBDBD))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripcion breve del atleta
            Text(
                text      = descripcion,
                fontSize  = 13.sp,
                color     = colorGris,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Stats del atleta
            stats.forEach { (etiqueta, valor) ->
                Row(
                    modifier       = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Nombre de la estadistica
                    Text(
                        text     = etiqueta,
                        fontSize = 12.sp,
                        color    = colorGris
                    )
                    // Valor de la estadistica
                    Text(
                        text       = valor,
                        fontSize   = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color      = colorNegro
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

// PREVIEWS
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaInicio() {
    MiSegundaAppTheme {
        PantallaInicio(onAcceder = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaMenu() {
    MiSegundaAppTheme {
        PantallaMenu(
            onBasketball = {},
            onFutbol     = {},
            onBaseball   = {},
            onBoxeo      = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBasketball() {
    MiSegundaAppTheme {
        PantallaBasketball(onVolver = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFutbol() {
    MiSegundaAppTheme {
        PantallaFutbol(onVolver = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBaseball() {
    MiSegundaAppTheme {
        PantallaBaseball(onVolver = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBoxeo() {
    MiSegundaAppTheme {
        PantallaBoxeo(onVolver = {})
    }
}