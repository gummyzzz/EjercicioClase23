//Ana Sandoval
//92944

//Ejercicio 3
trait Transporte {
    def costo(distancia: Double): Double
}

class Taxi(val tarifaBase: Double, val costoPorKm: Double) extends Transporte {
    def costo(distancia: Double): Double = {
        tarifaBase + (distancia * costoPorKm)
    }
}

class Bus(val tarifaFija: Double) extends Transporte {
    def costo(distancia: Double): Double = {
        tarifaFija
    }
}

def calcularViaje(transporte: Transporte, distancia: Double): Double = {
    transporte.costo(distancia)
}

object Ejercicio3 {
    def main(args: Array[String]): Unit = {
        val miTaxi: Transporte = new Taxi(5.0, 2.5)
        val miBus: Transporte = new Bus(1.5)

        println(s"Costo en Taxi (10 km): ${calcularViaje(miTaxi, 10)} Bs")
        println(s"Costo en Bus (10 km): ${calcularViaje(miBus, 10)} Bs")
    }
}


//Ejercicio 5
trait Notificacion {
    def enviarMensaje(mensaje: String): String
}

class Email(val correo: String) extends Notificacion {
    def enviarMensaje(mensaje: String): String = s"Enviando Email a $correo: $mensaje"
}

class SMS(val numero: String) extends Notificacion {
    def enviarMensaje(mensaje: String): String = s"Enviando SMS a $numero: $mensaje"
}

class NotificacionPush(val dispositivo: String) extends Notificacion {
    def enviarMensaje(mensaje: String): String = s"Enviando Push a $dispositivo: $mensaje"
}

def enviarNotificacion(noti: Notificacion, mensaje: String): String = {
    noti.enviarMensaje(mensaje)
}

object Ejercicio5 {
    def main(args: Array[String]): Unit = {
        val notiEmail: Notificacion = new Email("ana@correo.com")
        val notiSMS: Notificacion = new SMS("77712345")
        val notiPush: Notificacion = new NotificacionPush("iPhone de Ana")

        // Enviamos usando la misma función
        println(enviarNotificacion(notiEmail, "Tu pedido ha sido enviado"))
        println(enviarNotificacion(notiSMS, "Tu codigo de verificacion es 1234"))
        println(enviarNotificacion(notiPush, "Tienes una nueva solicitud de amistad"))
    }
}