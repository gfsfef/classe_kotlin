import java.util.Calendar

class Alunos(nome: String, dataNasc: Int, matricula: Int, serie: String) {

    //Atributos
    var nome: String = ""
    private var dataNasc: Int = 0
    var dataAtual = Calendar.getInstance().get(Calendar.YEAR)
    private var serie: String = ""
    private var matricula: Int = 0
    private var primeiroBimestre: MutableList<Double> = mutableListOf()
    private var segundoBimestre: MutableList<Double> = mutableListOf()
    private var notas: MutableList<Double> = mutableListOf()
    private var aprovacao: String = ""
    private var listaMutavel: MutableList<MutableMap<String, Double>> = mutableListOf()

    //Constructor
    init{
        this.nome = nome
        this.dataNasc = dataNasc
        this.serie = serie
        this.matricula = matricula
    }

    //Métodos
    fun getDataNasc(): Int {
        return this.dataNasc
    }

    fun getSerie(): String {
        return this.serie
    }

    fun getMatricula(): Int {
        return this.matricula
    }

    fun getPrimeiroBimestre(): MutableList<Double> {
        return this.primeiroBimestre
    }

    fun getSegundoBimestre(): MutableList<Double> {
        return this.segundoBimestre
    }

    fun getNota(): MutableList<Double> {
        return this.notas
    }

    fun getLista(getLista: MutableList<MutableMap<String, Double>> = this.listaMutavel): MutableList<MutableMap<String, Double>>{
        return getLista
    }

    fun setDataNasc(dataNasc: Int) {
        this.dataNasc = dataNasc
    }

    fun setSerie(serie: String) {
        this.serie = serie
    }

    fun setMatricula(matricula: Int) {
        this.matricula = matricula
    }

    fun setNovoNome(novoNome: String = readLine() ?: ""){
        this.nome = novoNome
    }

    fun setPrimeiroBimestre() {
        var nota1: Int = 0
        var const: Int = 1
            while (const <= 2) {
                print("Insira a N${const} do primeiro semestre: ")
                var read = readLine() ?: "0.0"
                var notas = read.toDoubleOrNull() ?: 0.0
                if (notas >= 0 && notas <= 10) {
                    this.primeiroBimestre.add(notas);
                    const++
                } else {
                    print("Nota invalida, digite novamente: ")
                    var read2 = readLine() ?: "0.0"
                    var notas2 = read2.toDoubleOrNull() ?: 0.0
                    this.primeiroBimestre.add(notas2);
                    const++
                }
            }

            this.notas.add((primeiroBimestre[0] + primeiroBimestre[1]) / 2)

            if((primeiroBimestre.sum() / 2) < 7){
                print("Insira a nota de recuperação do aluno no 1 semestre: ")
                var read4 = readLine() ?: "0"
                nota1 = read4.toIntOrNull() ?: 0
                if(nota1 >= 7){
                    this.primeiroBimestre.clear()
                    this.primeiroBimestre.add(nota1.toDouble() * 2)
                    this.notas.removeAt(0)
                    this.notas.add(nota1.toDouble())
                }
            }
    }

    fun setSegundoBimestre() {
        var nota2: Int = 0
        var const2: Int = 1
            while (const2 <= 2) {
                print("Insira a N${const2} do segundo semestre: ")
                var read2 = readLine() ?: "0.0"
                var notas2 = read2.toDoubleOrNull() ?: 0.0
                if (notas2 >= 0 && notas2 <= 10) {
                    this.segundoBimestre.add(notas2);
                    const2++
                } else {
                    print("Nota invalida, digite novamente: ")
                    var read3 = readLine() ?: "0.0"
                    var notas3 = read3.toDoubleOrNull() ?: 0.0
                    this.segundoBimestre.add(notas3);
                    const2++
                }
            }

            this.notas.add(((segundoBimestre[0] + segundoBimestre[1]) * 2) / 2)

            if((segundoBimestre.sum() / 2) < 7) {
                print("Insira a nota de recuperação do aluno no 2 semestre: ")
                var read5 = readLine() ?: "0"
                nota2 = read5.toIntOrNull() ?: 0
                if (nota2 >= 7) {
                    this.segundoBimestre.clear()
                    this.segundoBimestre.add(nota2.toDouble() * 2)
                    this.notas.removeAt(1)
                    this.notas.add(nota2.toDouble() * 2)
                }
            }
    }

    fun media(): Double {
        return this.notas.sum() / 3
    }

    fun aprovar(){
        if(media() < 7){
            this.aprovacao = "Reprovado"
        } else {
            this.aprovacao = "Aprovado"
        }
    }

    fun idade(): Int {
        return (this.dataAtual - this.dataNasc)
    }

    fun dados() {
        println("Nome: ${this.nome}")
        println("Idade: ${idade()}")
        println("Matricula: ${getMatricula()}")
        println("Serie: ${getSerie()}")
        println("Nota Primeiro Semestre: ${getPrimeiroBimestre().sum() / 2}")
        println("Nota Segundo Semestre: ${getSegundoBimestre().sum() / 2}")
        println("Media: ${media()}")
        println("${this.aprovacao}")
    }
}

fun main(){
    //Instanciando]
    var cond: String = ""
    var lista2: MutableList<MutableList<MutableMap<String, Double>>> = mutableListOf()

    while(cond != "n"){
        var listaMutavel: MutableList<MutableMap<String, Double>> = mutableListOf()
        var map: MutableMap<String, Double> = mutableMapOf()

        print("Insira o nome do aluno: ")
        var read = readLine() ?: ""

        print("Insira a data de nascimento do aluno: ")
        var read2 = readLine() ?: "0"

        print("Insira a matricula do aluno: ")
        var read3 = readLine() ?: "0"

        print("Insira a serie do aluno: ")
        var read4 = readLine() ?: "0"

        var aluno1 = Alunos(nome = read.toString(), dataNasc = read2.toIntOrNull() ?: 0, matricula = read3.toIntOrNull() ?: 0, serie = read4.toString())

        aluno1.setPrimeiroBimestre()
        aluno1.setSegundoBimestre()
        println()
        aluno1.aprovar()
        println(aluno1.getNota())
        aluno1.dados()

        map.put(aluno1.nome, aluno1.media())
        listaMutavel.add(map)
        lista2.add(listaMutavel)

        println(lista2)

        print("Deseja inserir mais alunos? (y/n)")
        cond = (readLine() ?: "").toString()
    }
}