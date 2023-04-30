enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, var nivel: Nivel = Nivel.BASICO)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos = conteudos.plus(conteudo)
    }
    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
        }
    }
}

fun main() {

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 90)
    val conteudo3 = ConteudoEducacional("Kotlin para Android", 90)
    val conteudo4 = ConteudoEducacional("Introdução a Java", 120)
    val conteudo5 = ConteudoEducacional("Programação Orientada a Objetos com Java", 90)
    val conteudo6 = ConteudoEducacional("Kotlin Avançado", 120)
    val conteudo7 = ConteudoEducacional("Kotlin para Android (Noções Avançadas)", 90)


    val formacao1 = Formacao("Kotlin para iniciantes", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Desenvolvimento de aplicativos móveis com Kotlin", listOf(conteudo1, conteudo2, conteudo3))
    val formacao3 = Formacao("Java para iniciantes", listOf(conteudo4,conteudo5))
    val formacao4 = Formacao("Kotlin e Desenvolvimento de aplicativos móveis avançado", listOf(conteudo6,conteudo7))


    val usuario1 = Usuario("Raul", Nivel.BASICO)
    val usuario2 = Usuario("Ingrid", Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Rocha", Nivel.INTERMEDIARIO)
    val usuario4 = Usuario("Vitor", Nivel.DIFICIL)


    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario3)
    formacao3.matricular(usuario1)
    formacao4.matricular(usuario4)


    println(formacao1.nome)
    formacao1.inscritos.forEach { println(it.nome) }

    println(formacao2.nome)
    formacao2.inscritos.forEach { println(it.nome) }

    println(formacao3.nome)
    formacao3.inscritos.forEach { println(it.nome) }

    println(formacao4.nome)
    formacao4.inscritos.forEach { println(it.nome) }

}