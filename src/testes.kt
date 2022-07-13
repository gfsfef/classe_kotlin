    //fun main(){
    //    var map: MutableMap<String, Int> = mutableMapOf()
    //    var lista: MutableList<MutableMap<String, Int>> = mutableListOf()
    //    var cond: String = ""
    //
    //    while(cond != "n"){
    //        var map: MutableMap<String, Int> = mutableMapOf()
    //
    //        print("Insira o nome do usuario: ")
    //        var nome = (readLine() ?: "").toString()
    //
    //        print("Insira a idade do usuario: ")
    //        var idade = (readLine() ?: "0").toIntOrNull() ?: 0
    //
    //        map.put(nome, idade)
    //        lista.add(map)
    //
    //        println(lista)
    //
    //        print("Deseja inserir mais? (y/n)")
    //        cond = (readLine() ?: "").toString()
    //    }
    //
    //}

    fun main(){
        var cond: String = ""
        var lista2: MutableList<MutableList<MutableMap<String, Double>>> = mutableListOf()


        while(cond != "n"){
            var mapTeste: MutableMap<String, Double> = mutableMapOf()
            var lista: MutableList<MutableMap<String, Double>> = mutableListOf()

            print("Insira o nome do usuario: ")
            var nome = (readLine() ?: "").toString()

            print("Insira um numero de usuario: ")
            var idade = (readLine() ?: "0.0").toDoubleOrNull() ?: 0.0

            mapTeste.put(nome, idade)
            lista.add(mapTeste)
            lista2.add(lista)

            println(lista)
            println(lista2)

            print("Deseja inserir mais? (y/n)")
            cond = (readLine() ?: "").toString()
        }
    }