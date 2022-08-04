package com.example.demo

object ListaSimples {

    var head: Node? = null
    var count: Int = 0

    fun adicionarPrimeiro(valorNovo: Int) {
        val nodeNovo = Node(valorNovo)

        if (head != null) {
            nodeNovo.next = head
            head = nodeNovo
            count++
        } else {
            head = nodeNovo
            count++
        }
    }

    fun adicionarUltimo(valorNovo: Int) {
        var auxiliar = head
        val nodeNovo = Node(valorNovo)

        if (head != null) {
            while (auxiliar?.next != null) {
                auxiliar = auxiliar.next
            }
            auxiliar?.next = nodeNovo
            count++
        } else {
            head = nodeNovo
            count++
        }
    }

    fun adicionarOrdenado(valor: Int) {
        var auxiliar = head
        val nodeNovo = Node(valor)
        var anterior = head


        //Adicionar no primeiro caso a lista seja vazia
        if (estaVazia()) {
            head = nodeNovo
            count++
            return
        }

        //Adicionar no inínio caso o número seja o menor
        if (auxiliar!!.valor >= nodeNovo.valor) {
            nodeNovo.next = auxiliar
            head = nodeNovo
            return
        }

        //Percorre a lista enquanto não encontrar a posição do número
        while (auxiliar != null && auxiliar.valor < nodeNovo.valor) {
            anterior = auxiliar
            auxiliar = auxiliar.next
        }

        //Adiciona o número na posição devida
        if(auxiliar != null) {
            anterior?.next = nodeNovo
            nodeNovo.next = auxiliar
        } else {
            anterior?.next = nodeNovo
        }


    }

    fun ordenar() {
        if (estaVazia()) {
            return
        } else {
            val vetor = IntArray(count)

            var index = 0
            var auxiliar = head

            while (auxiliar != null) {
                vetor[index] = auxiliar.valor
                index++
                auxiliar = auxiliar.next
            }

            limparLista()

            vetor.sort()

            vetor.forEach {
                adicionarUltimo(it)
            }

        }
    }

    fun encontrarValor(valor: Int): Node? {
        var auxiliar = head

        while (auxiliar != null && auxiliar.valor != valor) {
            auxiliar = auxiliar.next
        }

        return auxiliar
    }

    fun removerValor(valor: Int) {
        if (head != null && head?.valor == valor) {
            head = head?.next
            count--
        } else {
            var auxiliar = head

            while (auxiliar?.next != null && auxiliar.next?.valor != valor) {
                auxiliar = auxiliar.next
            }

            if (auxiliar?.next != null) {
                auxiliar.next = auxiliar.next?.next
                count--
            }

        }
    }

    fun removerPrimeiro() {
        head = head?.next
        count--
    }

    fun removerUltimo() {
        if (head != null && head?.next == null) {
            head = null

        } else {
            var auxiliar = head

            if (auxiliar != null) {
                while (auxiliar?.next?.next != null) {
                    auxiliar = auxiliar.next
                }

                if (auxiliar?.next == null) {
                    auxiliar?.next = null
                    return
                }
                auxiliar.next = null

            }
        }
        count--
    }

    fun limparLista() {
        head = null
        count = 0
    }

    fun printarLista() {
        var auxiliar = head

        while (auxiliar != null) {
            println("[${auxiliar.valor}]")
            auxiliar = auxiliar.next
        }
        println("[null]")
    }

    fun estaVazia(): Boolean {
        return head == null
    }
}