fun main(){
    val linhas: Int
    var colunas: Int

    print("Insira o numero de colunas: ")
    var read = readLine() ?: "0"
    colunas = read.toIntOrNull() ?: 0

    print("Insira o numero de linhas: ")
    var read2 = readLine() ?: "0"
    linhas = read2.toIntOrNull() ?: 0

    calc(linhas, colunas)
}

fun calc(linhas: Int, colunas: Int){
    val listOfLista: MutableList<MutableList<Int>> = mutableListOf()
    var num: Int
    var const = 1
    for(x in 0 until linhas){
        println("Linha $const")
        var lista: MutableList<Int> = mutableListOf()
        for(i in 0 until colunas){
            print("Insira os numeros: ")
            var read3 = readLine() ?: "0"
            num = read3.toIntOrNull() ?: 0
            lista.add(num)
        }
        listOfLista.add(lista)
        const++
    }
    listOfLista.forEach(::println)
}