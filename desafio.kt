// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        try {
            for (usuario in usuarios) {
                if (inscritos.contains(usuario)) {
                    throw Exception("Usuário '${usuario.nome}' já está cadastrado em '${this.nome}'")
                } else {
                    inscritos.add(usuario)
                    println("Usuário '${usuario.nome}' cadastrado em '${this.nome}'")
                }
            }
        }
        catch (error: Exception) {
            println("Erro: ${error.message}")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Aldair", "info@aldairgc.com")
    val usuario2 = Usuario("Paulo", "info@paulocg.com")
    val usuario3 = Usuario("Pedro", "info@pedrolc.com")
    val usuario4 = Usuario("Joana", "info@joanagg.com")
    val usuario5 = Usuario("Seth", "info@sethn.com")
    
    val cursoKotlinBasico = ConteudoEducacional("Curso Basico de Kotlin")
    val cursoBackendKotlinBasico = ConteudoEducacional("Curso Basico de Kotlin para Backend")
    
    val cursoKotlinIntermediario = ConteudoEducacional("Curso Intermediario de Kotlin", 70)
    val cursoBackendKotlinIntermediario = ConteudoEducacional("Curso Intermediario de Kotlin para Backend", 80)
    
    val cursoKotlinAvancado = ConteudoEducacional("Curso Avancado de Kotlin", 110)
    val cursoBackendKotlinAvancado = ConteudoEducacional("Curso Avancado de Kotlin para Backend", 120)
    
    val formacaoKotlinBasico = Formacao("Formacao Kotlin Basico", Nivel.BASICO, listOf(cursoKotlinBasico, cursoBackendKotlinBasico))
    val formacaoKotlinIntermediario = Formacao("Formacao Kotlin Intermediario", Nivel.INTERMEDIARIO, listOf(cursoKotlinIntermediario, cursoBackendKotlinIntermediario))
    val formacaoKotlinAvancado = Formacao("Formacao Kotlin Avancado", Nivel.AVANCADO, listOf(cursoKotlinAvancado, cursoBackendKotlinAvancado))
    
    formacaoKotlinBasico.matricular(usuario1, usuario2)
    formacaoKotlinIntermediario.matricular(usuario3, usuario4)
    formacaoKotlinAvancado.matricular(usuario3, usuario4, usuario5)
    formacaoKotlinBasico.matricular(usuario1)
    println("Fim de cadastros\n")
    
    println(formacaoKotlinBasico.nome)
    for (inscrito in formacaoKotlinBasico.inscritos) println("- Inscrito: ${inscrito.nome}")
    println()
    println(formacaoKotlinIntermediario.nome)
    for (inscrito in formacaoKotlinIntermediario.inscritos) println("- Inscrito: ${inscrito.nome}")
    println()
    println(formacaoKotlinAvancado.nome)
    for (inscrito in formacaoKotlinAvancado.inscritos) println("- Inscrito: ${inscrito.nome}")
}