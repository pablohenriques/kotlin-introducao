fun main() {
    val contaAlex = Conta("Alex", 1000)
    val contaFran = Conta(numero = 1001, titular = "Fran")

    contaAlex.deposita(200.0)
    contaFran.deposita(300.0)

    println("${contaAlex.titular} - numero: ${contaAlex.numero} - saldo: ${contaAlex.saldo}")
    println("${contaFran.titular} - numero: ${contaFran.numero} - saldo: ${contaFran.saldo}")

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println("depositando na conta da Fran")
    contaFran.deposita(70.0)

    println("${contaAlex.titular} - numero: ${contaAlex.numero} - saldo: ${contaAlex.saldo}")
    println("${contaFran.titular} - numero: ${contaFran.numero} - saldo: ${contaFran.saldo}")

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println("sacando na conta da Fran")
    contaFran.saca(100.0)

    println("${contaAlex.titular} - numero: ${contaAlex.numero} - saldo: ${contaAlex.saldo}")
    println("${contaFran.titular} - numero: ${contaFran.numero} - saldo: ${contaFran.saldo}")

    println("transferência da conta da Fran para o Alex")
    if (contaFran.transfere(300.0, contaAlex)) {
        println("transferência sucedida")
    } else {
        println("falha transferência")
    }

    println("${contaAlex.titular} - numero: ${contaAlex.numero} - saldo: ${contaAlex.saldo}")
    println("${contaFran.titular} - numero: ${contaFran.numero} - saldo: ${contaFran.saldo}")

}

class Conta(val titular: String, val numero: Int) {
//    var titular: String = titular
//    var numero: Int = numero
    var saldo: Double = 0.0
        private set

//    constructor(titular: String, numero: Int) {
//        this.titular = titular
//        this.numero = numero
//    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

//    fun getSaldo(): Double {
//        return this.saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if(valor > 0) {
//            this.saldo = valor
//        }
//    }
}