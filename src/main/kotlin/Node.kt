package com.example.demo

class Node {
    var valor: Int
    var next: Node?

    constructor(_valor: Int) {
        valor = _valor
        next = null
    }

    constructor(_valor: Int, _next: Node) {
        valor = _valor
        next = _next
    }
}