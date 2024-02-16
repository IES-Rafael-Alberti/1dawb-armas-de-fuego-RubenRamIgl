import kotlin.random.Random

open class ArmaDeFuego protected constructor(
    protected val nombre: String,
    protected var municion: Int,
    protected val municionARestar: Int,
    protected val tipoDeMunicion: String,
    protected val danio: Int,
    protected val radio: String
) {

    companion object {
        var cantidadMunicionExtra: Int = Random.nextInt(5, 16)
    }

    open fun dispara() {
        if (municion >= municionARestar) {
            municion -= municionARestar
            println("$nombre disparada. Munición restante: $municion")
        } else {
            recarga()
        }
    }

    open fun recarga() {
        if (cantidadMunicionExtra >= municionARestar * 2) {
            municion += municionARestar * 2
            cantidadMunicionExtra -= municionARestar * 2
            println("$nombre recargada. Munición actual: $municion")
        } else if (cantidadMunicionExtra >= municionARestar) {
            municion += municionARestar
            cantidadMunicionExtra -= municionARestar
            println("$nombre recargada. Munición actual: $municion")
        } else {
            println("No hay suficiente munición extra para recargar.")
        }
    }

    open fun mostrarInfo() {
        println("Nombre: $nombre, Munición: $municion, Tipo de Munición: $tipoDeMunicion, Daño: $danio, Radio: $radio")
    }
}

class Pistola(danio: Int, radio: String) :
    ArmaDeFuego("Pistola", 6, 1, "9mm", danio, radio) {

    init {
        require(danio in 1..5) { "El daño debe estar entre 1 y 5." }
        require(radio in arrayOf("Reducido", "Corto")) { "El radio debe ser reducido o corto." }
    }
}

class Rifle(danio: Int, radio: String) :
    ArmaDeFuego("Rifle", 8, 2, "7.62mm", danio, radio) {

    init {
        require(danio in 5..10) { "El daño debe estar entre 5 y 10." }
        require(radio in arrayOf("Corto", "Intermedio")) { "El radio debe ser corto o intermedio." }
    }
}

class Bazooka(danio: Int, radio: String) :
    ArmaDeFuego("Bazooka", 10, 3, "60mm", danio, radio) {

    init {
        require(danio in 10..30) { "El daño debe estar entre 10 y 30." }
        require(radio in arrayOf("Intermedio", "Amplio", "Enorme")) { "El radio debe estar entre intermedio y enorme." }
    }
}

class Casa : Disparador {
    override fun disparar() {
        println("La casa disparó confetti.")
    }
}

class Coche : Disparador {
    override fun disparar() {
        println("El coche disparó ráfagas de luz larga.")
    }
}

class Bocadillo : Disparador {
    override fun disparar() {
        println("El bocadillo disparó olor a jamón.")
    }
}

interface Disparador {
    fun disparar()
}

fun main() {
    val armasDeFuego = listOf(
        Pistola(3, "Reducido"),
        Rifle(7, "Corto"),
        Bazooka(20, "Enorme")
    )

    println("\nMunición extra = $ArmaDeFuego.cantidadMunicionExtra... para todas las armas de fuego.\n")

    for (index in 1..12) {
        val (arma, cantidadDisparos) = armasDeFuego.random() to (1..3).random()
        println("*** Comienzo del disparo $index ***")
        repeat(cantidadDisparos) {
            arma.dispara()
            arma.mostrarInfo()
        }
    }

    val otrosDisparadores: List<Disparador> = listOf(Casa(), Coche(), Bocadillo())

    for (index in 1..9) {
        val disparador = otrosDisparadores.random()
        println("*** Comienzo del disparo ${index + 12} ***")
        disparador.disparar()
    }
}



