fun main(){
 val listOfLista: MutableList<MutableList<Int>> = mutableListOf()
 val linhas = 2
 var colunas = 3

 for(x in 0 until linhas){
     listOfLista.add(MutableList(colunas) {x+1})
 }

    listOfLista.forEach(::println)
}